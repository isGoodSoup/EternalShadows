package es.eternalshadow.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.jline.reader.LineReader;

import es.eternalshadow.entities.Criatura;
import es.eternalshadow.enums.Armamento;
import es.eternalshadow.enums.Escuderia;
import es.eternalshadow.enums.ParsingKeys;
import es.eternalshadow.interfaces.Accion;
import es.eternalshadow.main.Panel;
import es.eternalshadow.motor.Escena;
import es.eternalshadow.motor.Opcion;
import es.eternalshadow.pojos.Jugador;
import es.eternalshadow.story.Capitulo;

/**
 * Clase de utilidades para el juego "Eternal Shadows". Proporciona métodos
 * para:
 * <ul>
 * <li>Crear menús y leer entradas del usuario.</li>
 * <li>Generar personajes y criaturas aleatorias.</li>
 * <li>Generar valores aleatorios (enteros, doubles, booleanos, cadenas).</li>
 * <li>Medir el tiempo de ejecución de tareas.</li>
 * </ul>
 */

public class Codex {
	private Panel panel;
	private static Random random = new Random();

	public Codex(Panel panel) {
		super();
		this.panel = panel;
	}

	public List<Opcion> getOpciones() {
		return panel.getOpciones();
	}

	public void setOpciones(List<Opcion> opciones) {
		panel.setOpciones(opciones);
	}

	/**
	 * Muestra un menú y obtiene la opción seleccionada por el usuario.
	 *
	 * @param reader Lector de líneas para recibir la entrada del usuario.
	 * @param menu   Opciones del menú como arreglo de strings.
	 * @param s      Mensaje para solicitar la opción.
	 * @return La opción seleccionada como entero.
	 */
	public int crearMenu(LineReader reader, String[] menu, String s) {
		for (int i = 0; i < menu.length; i++) {
			System.out.println(i + 1 + ") " + menu[i]);
		}
		int num = Codex.toScanInteger(reader, s);
		return num;
	}

	/**
	 * Imprime información detallada de una excepción.
	 *
	 * @param e Excepción a imprimir.
	 */
	public static void printException(Exception e) {
		System.err.println(e.getClass().getSimpleName() + " at line "
				+ e.getStackTrace()[e.getStackTrace().length - 3].getLineNumber() + ": " + e.getMessage());
	}

	/**
	 * Solicita una entrada de texto al usuario hasta que sea no vacía.
	 *
	 * @param reader Lector de líneas.
	 * @param s      Mensaje de solicitud.
	 * @return Cadena ingresada por el usuario.
	 */
	public static String toScan(LineReader reader, String s) {
		String line = "";
		do {
			System.out.print(s + ": ");
			line = reader.readLine().trim();
		} while (line.isEmpty());
		return line;
	}

	/**
	 * Solicita al usuario un número entero válido.
	 *
	 * @param reader Lector de líneas.
	 * @param s      Mensaje de solicitud.
	 * @return Número entero ingresado por el usuario.
	 */
	public static int toScanInteger(LineReader reader, String s) {
		String line = "";
		while (true) {
			try {
				do {
					System.out.print(s + ": ");
					line = reader.readLine().trim();
				} while (line.isEmpty());
				int num = Integer.parseInt(line);
				return num;
			} catch (Exception e) {
				printException(e);
			}
		}
	}

	/**
	 * Lee un archivo y devuelve su contenido como una lista de líneas.
	 * 
	 * @param archivo Ruta del archivo a leer.
	 * @return Lista de líneas del archivo.
	 * @throws IOException Si ocurre un error al leer el archivo.
	 */
	public List<String> toLeerArchivo(String archivo) throws IOException {
		String contenido = Files.readString(Paths.get(archivo));
		return contenido.lines().toList();
	}

	/*
	 * Carga el capítulo, lo parsea dependiendo del formato de la línea
	 * y devuelve el capítulo procesado
	 * 
	 */
	public Capitulo cargarCapitulo(String ruta, Jugador jugador, Criatura criatura) throws IOException {
	    List<String> lineas = toLeerArchivo(ruta);
	    Map<String, Escena> escenas = new HashMap<>();

	    Escena escenaActual = null;
	    List<Opcion> opcionesActuales = null;

	    LineReader reader = panel.getReader();
	    String nombre = "";
	    int numero = 0;

	    for (int i = 0; i < lineas.size(); i++) {
	        String linea = lineas.get(i).trim();
	        
	        if (linea.startsWith("#FIN")) { break; }
	        
	        ParsingKeys key = getParsingKey(linea);
	        if (key == null) {
	            System.out.print(linea);
	            reader.readLine();
	            continue;
	        }
	        switch (key) {
		        case JUGADOR:
		            String textoJugador = linea.replace("#JUGADOR", panel.getJugador().getNombre()).trim();
		            System.out.print(textoJugador);
		            reader.readLine();
		            break;

	            case NOMBRE:
	                nombre = linea.replace("#NOMBRE", "").trim();
	                break;

	            case CAPITULO:
	                numero = Integer.parseInt(linea.replace("#CAPITULO", "").trim());
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
	                    	opcion.setAccion(() -> ejecutarAccion(sub.substring(7).trim(), jugador, criatura));
	                    }
	                    else if (sub.startsWith("DESTINO:")) {
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
	                        System.err.println("ERROR: Escena destino no encontrada: " + destinoId);
	                    } else {
	                        opcion.setEscenaDestino(destino);
	                    }
	                }
	            }
	        }
	    }
	    return new Capitulo(numero, panel, nombre, escenaActual);
	}
	
	/**
	 * Ejecuta las acciones que se parsean por #OPCION
	 * @param el nombre de la accion String
	 * @param el jugador parseado
	 * @param la criatura pasada
	 */
	public void ejecutarAccion(String nombreAccion, Jugador jugador, Criatura criatura) {
	    Accion accion = panel.getAcciones().get(nombreAccion);
	    if (accion == null) {
	        System.err.println("ERROR: Acción desconocida: " + nombreAccion);
	        return;
	    }
	    accion.ejecutar(jugador, criatura);
	}


	/**
	 * Permite al usuario crear un personaje personalizado eligiendo clase y
	 * atributos.
	 * @param reader Lector de líneas.
	 * @return Objeto {@link Criatura} creado.
	 */
	public Jugador crearPersonaje(LineReader reader) {
		int puntos;
		int f, r, v, m;
		do {
			puntos = 0;
			f = Codex.toScanInteger(reader, q("la fuerza"));
			puntos += f;
			r = Codex.toScanInteger(reader, q("la resistencia"));
			puntos += r;
			v = Codex.toScanInteger(reader, q("la velocidad"));
			puntos += v;
			m = Codex.toScanInteger(reader, q("la magia"));
			puntos += m;
		} while (puntos != 80);

		String tipo = toScan(reader, "Elige tu raza");
		String nombre = toScan(reader, "Introduce tu nombre");
		Jugador jugador = new Jugador(tipo, nombre, f, r, v, m, 
				100, 50, 10, 10, panel);
		return jugador;
	}
	
	/**
	 * Crea una criatura default con valores default con el objetivo de 
	 * testeo más eficiente.
	 * @return Objeto {@link Criatura} creado.
	 */
	public Jugador crearPersonaje() {
		int f = 20, r = 20, v = 20, m = 20;
		String tipo = "Elfo";
		String nombre = "Galandriel";
		Jugador jugador = new Jugador(tipo, nombre, f, r, v, m, 
				100, 50, panel.getDados().tirarDados(), panel.getDados().tirarDados(), panel);
		return jugador;
	}

	/**
	 * Crea una criatura aleatoria con atributos que suman 100 y clase aleatoria.
	 * @return Criatura aleatoria creada.
	 */
	public Criatura crearCriaturaAleatoria() {
		int[] atributos = new int[4];
		int puntosTotal = 100;
		for (int i = 0; i < 3; i++) {
			atributos[i] = random.nextInt(puntosTotal + 1);
			puntosTotal -= atributos[i];
		}
		atributos[3] = puntosTotal;

		int fuerza = atributos[0];
		int resistencia = atributos[1];
		int velocidad = atributos[2];
		int magia = atributos[3];

		String[] razas = { "Mago", "Guerrero", "Demonio", "Elfo Oscuro", "Enano", "Elfo" };
		int numale = random.nextInt(razas.length);
		String tipo = razas[numale];

		// TODO Nombre
		Criatura c = new Criatura(tipo, null, fuerza, resistencia, velocidad, magia, panel.getJugador().getPuntosVida());
		if (c != null) {
			System.out.println("Criatura enemiga creada: " + c.getNombre() + " con atributos: " + "Fuerza: " + fuerza
					+ ", Resistencia: " + resistencia + ", Velocidad: " + velocidad + ", Magia: " + magia);
		}
		insertarRegistros(c);
		return c;
	}

	/**
	 * Formatea un mensaje para solicitar un atributo.
	 * 
	 * @param s Nombre del atributo.
	 * @return Mensaje formateado.
	 */
	private String q(String s) {
		return "Introduce el valor de " + s;
	}

	/**
	 * Crea una conexión a la base de datos Oracle.
	 * 
	 * @return Objeto Connection o null si falla la conexión.
	 */
	public static Connection crearConexion() {
		String url_oracle2 = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
		String username = "getafe";
		String password = "password";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url_oracle2, username, password);
		} catch (SQLException e) {
			System.err.println("Error crear la sesión" + e.getMessage());
		}

		return connection;
	}

	/**
	 * Ejecuta una consulta definida en la constante CONSULTA y procesa los
	 * resultados obtenidos. Este método crea su propia conexión, ejecuta la
	 * consulta y cierra los recursos al finalizar.
	 */
	public static void consultaRaza() {
		String consultaRaza = "SELECT ID, NOMBRE, TIPO, FUERZA, VELOCIDAD, MAGIA FROM TB_RAZA";
		String separador = " | ";
		try (Connection conexion = crearConexion();
				Statement st = conexion.createStatement();
				ResultSet rs = st.executeQuery(consultaRaza)) {
			StringBuilder sb = new StringBuilder();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String tipo = rs.getString("TIPO");
				int fuerza = rs.getInt("FUERZA");
				int velocidad = rs.getInt("VELOCIDAD");
				int magia = rs.getInt("MAGIA");
				System.out.println(sb.append("ID:" + id + separador + "TIPO:" + tipo + separador + "FUERZA:" + fuerza
						+ separador + "VELOCIDAD:" + velocidad + separador + "MAGIA:" + magia));
			}

		} catch (SQLException e) {
			System.out.println("Error " + e.getMessage());
		}
		System.out.println("TERMINA");
	}

	/**
	 * Inserta un registro de criatura en la tabla TB_RAZAS.
	 * 
	 * @param c Objeto Criatura a insertar.
	 */
	public static void insertarRegistros(Criatura c) {
		int id = c.getId();
		String nombre = c.getNombre();
		String tipo = c.getTipo();
		int fuerza = c.getFuerza();
		int velocidad = c.getVelocidad();
		int magia = c.getMagia();

		String sql = "INSERT INTO TB_RAZAS (ID,NOMBRE,TIPO, FUERZA, VELOCIDAD, MAGIA) VALUES (?, ?, ?, ?, ?)";
		try (Connection conexion = crearConexion(); PreparedStatement ps = conexion.prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.setString(2, nombre);
			ps.setString(3, tipo);
			ps.setInt(4, fuerza);
			ps.setInt(5, velocidad);
			ps.setInt(6, magia);
			int filas = ps.executeUpdate();
			System.out.println("Registros insertados: " + filas);
		} catch (SQLException e) {
			printException(e);
		}
	}

	/**
	 * Genera un número decimal aleatorio entre min y max dividido por 100.
	 * 
	 * @param min Valor mínimo.
	 * @param max Valor máximo.
	 * @return Número decimal aleatorio.
	 */
	public static double toGetDouble(int min, int max) {
		double d = random.nextInt(min, max) / 100.0;
		return d;
	}

	/**
	 * Genera un valor booleano aleatorio.
	 * 
	 * @return true o false de forma aleatoria.
	 */
	public static boolean toGetBoolean() {
		return random.nextBoolean();
	}

	/**
	 * Imprime un título decorativo en consola.
	 * 
	 * @param s Texto del título.
	 */
	public static void toGetString(String s) {
		for (int i = 0; i < s.length(); i++)
			System.out.print("=");
		System.out.print(" " + s + " ");
		for (int i = 0; i < s.length(); i++)
			System.out.print("=");
		System.out.println();
	}

	/**
	 * Devuelve un elemento aleatorio de un arreglo de cadenas.
	 * @param s Arreglo de cadenas.
	 * @return Cadena aleatoria del arreglo.
	 */
	public static String toGetString(String[] s) {
		return s[random.nextInt(s.length)];
	}

	/**
	 * Devuelve un número entero aleatorio.
	 * @return Número aleatorio.
	 */
	public static int toGetInteger() {
		return random.nextInt();
	}

	/**
	 * Devuelve un número aleatorio de un arreglo de enteros.
	 * @param i Arreglo de enteros.
	 * @return Entero aleatorio del arreglo.
	 */
	public static int toGetInteger(int[] i) {
		return i[random.nextInt(i.length)];
	}

	/**
	 * Devuelve un número entero aleatorio dentro de un rango.
	 * @param min Valor mínimo.
	 * @param max Valor máximo.
	 * @return Número aleatorio entre min y max.
	 */
	public static int toGetInteger(int min, int max) {
		return random.nextInt(min, max);
	}

	/**
	 * Devuelve un número largo aleatorio dentro de un rango.
	 * @param min Valor mínimo.
	 * @param max Valor máximo.
	 * @return Número largo aleatorio entre min y max.
	 */
	public static long toGetLong(long min, long max) {
		return random.nextLong(min, max);
	}

	/**
	 * Mide el tiempo de ejecución de una tarea.
	 * @param task Tarea a ejecutar.
	 * @return Tiempo transcurrido en milisegundos.
	 */
	public long toTime(Runnable task) {
		long start = System.currentTimeMillis();
		task.run();
		return System.currentTimeMillis() - start;
	}
	
	/**
	 * Escoge un arma aleatoria del enum Armamento y la devuelve
	 * @return Armamento
	 */
	public Armamento toGenArma() {
		Armamento[] armas = Armamento.values();
		return armas[random.nextInt(armas.length)];
	}
	
	public Escuderia toGenEscudo() {
		Escuderia[] escudos = Escuderia.values();
		return escudos[random.nextInt(0, 1)];
	}

	/**
	 * Devuelve el número total de capítulos en la historia.
	 * @return Número total de capítulos.
	 */
	public int getCapitulosTotales() {
		try {
			return Files.list(Paths.get("./docs/mq")).filter(f -> f.getFileName().toString().startsWith("capitulo"))
					.toArray().length;
		} catch (IOException e) {
			printException(e);
		}
		return 0;
	}
	
	/**
	 * Genera un enum dependiendo del tipo de parsing de la línea
	 * @param linea
	 * @return
	 */
	private ParsingKeys getParsingKey(String linea) {
	    if (linea.startsWith("#NOMBRE")) return ParsingKeys.NOMBRE;
	    if (linea.startsWith("#CAPITULO")) return ParsingKeys.CAPITULO;
	    if (linea.startsWith("#ESCENA")) return ParsingKeys.ESCENA;
	    if (linea.startsWith("#OPCION")) return ParsingKeys.OPCION;
	    return null;
	}

	public static void comprarObjetoMercader(Jugador jugador, String objeto, int precio) {
		// TODO SistemaCompras
	}
}
