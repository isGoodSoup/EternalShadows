package es.eternalshadow.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.eternalshadow.entities.Criatura;
import es.eternalshadow.enums.Eula;
import es.eternalshadow.enums.Menu;
import es.eternalshadow.enums.MenuOpciones;
import es.eternalshadow.enums.MenuSesiones;
import es.eternalshadow.enums.ParsingKeys;
import es.eternalshadow.exception.GameException;
import es.eternalshadow.exception.LimiteCombateException;
import es.eternalshadow.interfaces.Accion;
import es.eternalshadow.motor.Escena;
import es.eternalshadow.motor.Opcion;
import es.eternalshadow.pojos.Jugador;
import es.eternalshadow.pojos.Pocion;
import es.eternalshadow.story.Capitulo;
import es.eternalshadow.story.Historia;
import es.eternalshadow.story.HistoriaPrincipal;
import es.eternalshadow.util.Codex;
import es.eternalshadow.util.Dados;

/**
 * Clase principal que representa el panel de control de la aplicación. Se
 * encarga de inicializar el terminal, manejar la entrada del usuario y comenzar
 * la historia.
 */

public class Panel {
	private String titulo = "Eternal Shadows";
	private Terminal terminal;
	private LineReader reader;
	private Historia historia = new HistoriaPrincipal(titulo, this);
	private List<String> credenciales = new ArrayList<>();
	private List<Criatura> criaturas = new ArrayList<>();
	private Jugador jugador;
	private Dados dados = new Dados(this);
	private Codex util = new Codex(this);
	private List<Opcion> opciones;
	private final Map<String, Accion> acciones = new HashMap<>();
	private Menu menu;
	private Eula eula;
	private int opcion;
	private static final Logger log = LoggerFactory.getLogger(Panel.class);

	public Panel() {
		try {
			terminal = TerminalBuilder.terminal();
			reader = LineReaderBuilder.builder().terminal(terminal).build();
			startAcciones();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Historia getHistoria() {
		return historia;
	}

	public void setHistoria(Historia historia) {
		this.historia = historia;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	public LineReader getReader() {
		return reader;
	}

	public void setReader(LineReader reader) {
		this.reader = reader;
	}

	public Dados getDados() {
		return dados;
	}

	public void setDados(Dados dados) {
		this.dados = dados;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Opcion> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<Opcion> opciones) {
		this.opciones = opciones;
	}

	public Map<String, Accion> getAcciones() {
		return acciones;
	}
	
	public List<String> getCredenciales() {
		return credenciales;
	}

	public void setCredenciales(List<String> credenciales) {
		this.credenciales = credenciales;
	}

	public List<Criatura> getCriaturas() {
		return criaturas;
	}

	public void setCriaturas(List<Criatura> criaturas) {
		this.criaturas = criaturas;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Eula getEula() {
		return eula;
	}

	public void setEula(Eula eula) {
		this.eula = eula;
	}

	public Codex getUtil() {
		return util;
	}

	public void setUtil(Codex util) {
		this.util = util;
	}
	
	/**
	 * Método para el handling entero del EULA
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws GameException 
	 */
	private boolean aceptarEULA() throws IOException, 
		InterruptedException, GameException {
		List<String> eulaArchivo = util.toLeerArchivo("./docs/eula.txt");
		
		for (String linea : eulaArchivo) {
			System.out.println(linea);
			Thread.sleep(50);
		}
		
		boolean isValido = false;
		
		String[] menu = {"SI", "NO"};
		while (!isValido) {
			int eulaConf = util.crearMenu(reader, menu, "Aceptas estas condiciones?");
			switch(eulaConf) {
				case 1 -> { isValido = true; eula = Eula.CONFIRMACION; return true; }
				case 2 -> { isValido = true;  eula = Eula.NEGACION; return false; }
				default -> { throw new GameException("No se admite otra opción"); }
			}
		}
		return false;
	}
	
	/**
	 * Pantalla de inicio de sesión de usuarios ya registrados 
	 * y registro de usuarios nuevos
	 * @return List<String>
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws GameException
	 */
	private List<String> pantallaUsuarios() throws IOException, 
		InterruptedException, GameException {
		boolean salir = false;

		String[] opciones = Arrays.stream(MenuSesiones.values())
                .map(MenuSesiones::getTexto)
                .toArray(String[]::new);

	    while (!salir) {
	        pintarLogo("./docs/logo.txt");
	        opcion = util.crearMenu(reader, opciones, "Introduce tu opción");
	        MenuSesiones menu = MenuSesiones.fromCodigo(opcion);
	        
	        salir = sesionesMenu(menu);
	        if(salir) { System.exit(0); } 
	    }
		return credenciales;
	}
	
	/**
	 * Inicia la historia y muestra el menú principal. Permite comenzar la
	 * aventura o salir de la aplicación.
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws GameException 
	 */
	public void comenzar() throws InterruptedException,
		IOException, GameException {
		pintarLogo("./docs/logo.txt");
		boolean isEula = aceptarEULA();
		if(!isEula) { log.error("Negación del EULA, saliendo..."); System.exit(0); }
		
		List<String> credenciales = pantallaUsuarios();
		
		cargarCapitulos();
		menuPrincipal(credenciales);
	}
	
	/**
	 * Método para pintar el logo elegido por parte de un 
	 * archivo
	 * @param ruta
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void pintarLogo(String ruta) throws IOException, InterruptedException {
		System.out.println();
		try {
			for (String linea : util.toLeerArchivo(ruta)) {
				System.out.println(linea);
				Thread.sleep(50);
			}
		} catch (IOException e) {
			Codex.printException(e);
		}
		System.out.println();
	}
	
	/**
	 * Procesa el menu principal y lo desglosa en 4 partes
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws GameException 
	 */
	private void menuPrincipal(List<String> credenciales) throws IOException, 
		InterruptedException, GameException {
		boolean salir = false;
	    
		String[] opciones = Arrays.stream(Menu.values())
                .map(Menu::getTexto)
                .toArray(String[]::new);

	    while (!salir) {
	        pintarLogo("./docs/logo.txt");
	        opcion = util.crearMenu(reader, opciones, "Introduce tu opción");
	        menu = Menu.fromCodigo(opcion);
	        
	        salir = opcionesMenu(menu);
	    }
	}
	
	/**
	 * Se le introduce un parámetro de tipo Enum y se pasa entre las 
	 * opciones del switch
	 * @param menu
	 * @return boolean
	 * @throws GameException 
	 * @throws InterruptedException 
	 */
	private boolean opcionesMenu(Menu menu) throws GameException, InterruptedException {
	    if (menu == null) { util.limpiarPantalla(); return false; }
	    
	    switch (menu) {
	        case COMENZAR -> iniciarPartida();
	        case OPCIONES -> menuOpciones();
	        case SALIR 	  -> { log.debug("Salida"); return true; }
	        case DEBUG 	  -> modoDebug();
	    }
	    return false;
	}
	
	/**
	 * Se le introduce un parámetro de tipo Enum y se pasa entre las 
	 * opciones del switch
	 * @param menu
	 * @return boolean
	 * @throws GameException 
	 * @throws InterruptedException 
	 */
	private boolean sesionesMenu(MenuSesiones menu) throws GameException, InterruptedException {
	    if (menu == null) { util.limpiarPantalla(); return false; }
	    
	    switch (menu) {
	        case INICIAR_SESION -> iniciarSesion();
	        case REGISTRAR -> registrarUsuario();
	        case SALIR 	  -> { log.debug("Salida"); return true; }
	    }
	    return false;
	}
	
	/**
	 * Inicio de sesión de usuarios
	 * @return List<String>
	 */
	private List<String> iniciarSesion() {
		// TODO Iniciar sesion
		return null;
	}
	
	/**
	 * Registro de usuarios
	 * @return List<String>
	 */
	private List<String> registrarUsuario() {
		// TODO Registrar
		return null;
	}
	
	/**
	 * Método para iniciar la partida si se ha elegido 
	 * la constante Menu.COMENZAR
	 */
	private void iniciarPartida() {
	    criaturas.clear();
	    int tope = 0;
	    boolean isTope = false;
	    
	    do {
	    	tope = Codex.toScanInteger(reader, "Inserta el número de jugadores (máx 5)");
	    	isTope = tope < 2 || tope > 5;
		    if(isTope) {
		    	try {
					throw new GameException("El número de jugadores es inválido: " + tope);
				} catch (GameException e) {
					Codex.printException(e);
				}
		    }
	    } while (isTope);
	    
	    log.debug("Numero de jugadores elegido: " + tope);
	    
	    for (int i = 1; i <= tope; i++) {
	        log.debug("Jugador " + i);
	        try {
				jugador = util.crearPersonaje(reader);
			} catch (LimiteCombateException e) {
				Codex.printException(e);
			}
	        log.debug("Nueva criatura creada");
	        criaturas.add(jugador);
	    }
	    historia.iniciar(criaturas, reader, util);
	}
	
	private void menuOpciones() throws GameException, InterruptedException {
	    boolean volver = false;

	    String[] opciones = Arrays.stream(MenuOpciones.values())
	                              .map(MenuOpciones::getTexto)
	                              .toArray(String[]::new);

	    while (!volver) {
	        opcion = util.crearMenu(reader, opciones, "Opciones");
	        MenuOpciones seleccion = MenuOpciones.fromCodigo(opcion);
	        
	        volver = menuOpciones(seleccion);
	    }
	}
	
	private boolean menuOpciones(MenuOpciones menu)
	        throws GameException {

	    if (menu == null) {
	        util.limpiarPantalla();
	        return false;
	    }

	    switch (menu) {
	        case DIFICULTAD -> dificultad();
	        case STATS -> stats();
	        case VOLVER -> { return true; }
	    }
	    return false;
	}

	
	/**
	 * Método para iniciar la partida si se ha elegido 
	 * la constante Menu.SALIR
	 */
	private void modoDebug() {
		log.debug("Dev mode");
	    historia.iniciar(util.crearPersonaje(), reader, util);
	}
	
	private void dificultad() {
		// TODO Dificultad
	}
	
	private void stats() {
		// TODO Dificultad
	}
	
	/**
	 * Se encarga de cargar los Capitulos 1:1 y añadirlos
	 * a un ArrayList de Capitulos.
	 */
	private void cargarCapitulos() {
	    try {
	        int total = util.getCapitulosTotales();
	        for (int i = 1; i <= total; i++) {
	            historia.getCapitulos()
	                    .add(new Capitulo(i, this, "", null));
	            util.toLeerArchivo("./docs/mq/capitulo" + i + ".txt");
	        }
	    } catch (IOException e) {
	        Codex.printException(e);
	    }
	}
	
	/**
	 * Se parsea el archivo y los jugadores junto con una criatura y 
	 * se devuelve el capitulo finalmente
	 * @param ruta
	 * @param jugadores
	 * @param criatura
	 * @return
	 * @throws IOException
	 */
	public Capitulo cargarCapitulo(String ruta, List<Criatura> jugadores,
			Criatura criatura) throws IOException {
		List<String> lineas = util.toLeerArchivo(ruta);
		Map<String, Escena> escenas = new HashMap<>();

		Escena escenaActual = null;
		List<Opcion> opcionesActuales = null;

		LineReader reader = getReader();
		String nombre = "";
		int numero = 0;

		for (int i = 0; i < lineas.size(); i++) {
			String linea = lineas.get(i).trim();

			if (linea.startsWith("#FIN")) {
				break;
			}

			ParsingKeys key = util.getParsingKey(linea);
			if (key == null) {
				System.out.print(linea);
				reader.readLine();
				continue;
			}
			switch (key) {
				case JUGADOR:
					String textoJugador = linea
							.replace("#JUGADOR", jugador.getNombre())
							.trim();
					System.out.print(textoJugador);
					reader.readLine();
					break;
	
				case NOMBRE:
					nombre = linea.replace("#NOMBRE", "").trim();
					break;
	
				case CAPITULO:
					numero = Integer
							.parseInt(linea.replace("#CAPITULO", "").trim());
					break;
	
				case ESCENA:
					String id = linea.replace("#ESCENA", "").trim();
					escenaActual = new Escena(id, new ArrayList<>());
					escenas.put(id, escenaActual);
					opcionesActuales = escenaActual.getOpciones();
					break;
	
				case OPCION:
					String texto = linea.replace("#OPCION", "").trim();
					Opcion opcion = new Opcion(texto);
	
					while (++i < lineas.size()) {
						String sub = lineas.get(i).trim();
						if (sub.startsWith("#") || sub.isEmpty()) {
							i--;
							break;
						}
						if (sub.startsWith("ACCION:")) {
							opcion.setAccion(() -> ejecutarAccion(
									sub.substring(7).trim(), jugadores, criatura));
						} else if (sub.startsWith("DESTINO:")) {
							opcion.setSiguienteEscenaId(sub.substring(8).trim());
						}
					}
					opcionesActuales.add(opcion);
					break;
	
				case COMBATE:
	
					break;
	
				default:
					System.out.println(linea);
					reader.readLine();
					break;
			}

			for (Escena escena : escenas.values()) {
				for (Opcion opcion : escena.getOpciones()) {
					String destinoId = opcion.getSiguienteEscenaId();
					if (destinoId != null) {
						Escena destino = escenas.get(destinoId);
						if (destino == null) {
							System.err.println(
									"ERROR: Escena destino no encontrada: "
											+ destinoId);
						} else {
							opcion.setEscenaDestino(destino);
						}
					}
				}
			}
		}
		return new Capitulo(numero, this, nombre, escenaActual);
	}

	/**
	 * Ejecuta las acciones que se parsean por #OPCION
	 * @param el nombre de la accion String
	 * @param el jugador parseado
	 * @param la criatura pasada
	 */
	public void ejecutarAccion(String nombreAccion, List<Criatura> jugadores,
			Criatura criatura) {
		Accion accion = getAcciones().get(nombreAccion);
		if (accion == null) {
			System.err.println("ERROR: Acción desconocida: " + nombreAccion);
			return;
		}
		accion.ejecutar(jugadores, criatura);
	}
	
	/**
	 * Inicializa las acciones de la historia
	 */
	private void startAcciones() {
		acciones.put("addPocion",
				(jugadores, criatura) -> jugador.getInventario().put(
						"Pocion de Sanación",
						new Pocion("Pocion de Curacion", 1)));
		acciones.put("aumentarMoral",
				(jugadores, criatura) -> jugador.modMoral(1));
		acciones.put("luchar",
				(jugadores, criatura) -> jugador.luchar(jugador, criatura));
		acciones.put("huir", (jugadores, criatura) -> jugador.huir(jugador));
	}
}
