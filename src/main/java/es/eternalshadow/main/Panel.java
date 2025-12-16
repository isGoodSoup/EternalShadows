package es.eternalshadow.main;

import java.io.IOException;
import java.util.ArrayList;
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
import es.eternalshadow.enums.Dificultad;
import es.eternalshadow.enums.Eula;
import es.eternalshadow.enums.Menu;
import es.eternalshadow.exception.GameException;
import es.eternalshadow.interfaces.Accion;
import es.eternalshadow.motor.Opcion;
import es.eternalshadow.pojos.Jugador;
import es.eternalshadow.service.CapitulosLoader;
import es.eternalshadow.service.EULAService;
import es.eternalshadow.service.GameService;
import es.eternalshadow.service.MenuService;
import es.eternalshadow.service.UserService;
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
	private EULAService eulaService = new EULAService("./docs/eula.txt");
	private UserService userService = new UserService(this);
	private MenuService menuService = new MenuService(this);
	private GameService gameService = new GameService(this);
	private CapitulosLoader cloader = new CapitulosLoader(this);
	private List<String> credenciales;
	private List<Criatura> criaturas = new ArrayList<>();
	private Jugador jugador;
	private Dados dados = new Dados(this);
	private Codex util = new Codex(this);
	private List<Opcion> opciones;
	private final Map<String, Accion> acciones = new HashMap<>();
	private Dificultad dificultad;
	private Menu menu;
	private Eula eula;
	private int opcion;
	private static final Logger log = LoggerFactory.getLogger(Panel.class);

	public Panel() {
		try {
			terminal = TerminalBuilder.terminal();
			reader = LineReaderBuilder.builder().terminal(terminal).build();
			cloader.startAcciones();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public Historia getHistoria() {
		return historia;
	}

	public void setHistoria(Historia historia) {
		this.historia = historia;
	}

	public EULAService getEulaService() {
		return eulaService;
	}

	public void setEulaService(EULAService eulaService) {
		this.eulaService = eulaService;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
	public GameService getGameService() {
		return gameService;
	}

	public void setGameService(GameService gameService) {
		this.gameService = gameService;
	}

	public CapitulosLoader getCLoader() {
		return cloader;
	}

	public void setCLoader(CapitulosLoader cloader) {
		this.cloader = cloader;
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

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Dados getDados() {
		return dados;
	}

	public void setDados(Dados dados) {
		this.dados = dados;
	}

	public Codex getUtil() {
		return util;
	}

	public void setUtil(Codex util) {
		this.util = util;
	}

	public List<Opcion> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<Opcion> opciones) {
		this.opciones = opciones;
	}

	public Dificultad getDificultad() {
		return dificultad;
	}

	public void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
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

	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}

	public Map<String, Accion> getAcciones() {
		return acciones;
	}

	/**
	 * Método para el handling entero del EULA
	 * 
	 * @return boolean
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws GameException
	 */
	private boolean aceptarEULA()
			throws IOException, InterruptedException, GameException {

		if (!eulaService.isExiste()) {
			log.error("No se encuentra el archivo del EULA");
			System.exit(0);
		}
		if (eulaService.isAceptado()) {
			log.debug("EULA ya aceptado");
			return true;
		}

		pintarLogo("./docs/logo.txt");
		for (String linea : eulaService.leerTexto()) {
			System.out.println(linea);
			Thread.sleep(50);
		}

		String[] menu = { "SI", "NO" };
		int eulaConf = util.crearMenu(reader, menu,
				"¿Aceptas estas condiciones?");
		switch (eulaConf) {
			case 1 -> {
				eula = Eula.CONFIRMACION;
				eulaService.guardar(true);
				return true;
			}
			
			case 2 -> {
				eula = Eula.NEGACION;
				eulaService.guardar(false);
				return false;
			}
			
			default -> throw new GameException("Opción de EULA inválida");
			}
	}

	/**
	 * Inicia la historia y muestra el menú principal. Permite comenzar la
	 * aventura o salir de la aplicación.
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws GameException
	 */
	public void comenzar()
			throws InterruptedException, IOException, GameException {
		boolean isEula = aceptarEULA();
		if (isEula) {
			log.debug("EULA confirmado, saltando...");
		}
		
		if (!isEula) {
			log.error("Negación del EULA, saliendo...");
			System.exit(0);
		}

		List<String> credenciales = userService.panelDeInicio();

		cloader.cargarCapitulos();
		menuService.menuPrincipal(credenciales);
	}

	/**
	 * Método para pintar el logo elegido por parte de un archivo
	 * 
	 * @param ruta
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void pintarLogo(String ruta)
			throws IOException, InterruptedException {
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
}
