package es.eternalshadow.main;

import java.io.IOException;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.eternalshadow.pojos.Jugador;
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
	private Jugador jugador = new Jugador();
	private Dados dados = new Dados(this);
	private Codex util = new Codex(this);
	private int opcion;
	private static final Logger log = LoggerFactory.getLogger(Panel.class);

	public Panel() {
		try {
			terminal = TerminalBuilder.terminal();
			reader = LineReaderBuilder.builder().terminal(terminal).build();
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

	/**
	 * Inicia la historia y muestra el menú principal. Permite comenzar la
	 * aventura o salir de la aplicación.
	 */
	public void comenzar() {
		log.debug("Inicio");
		try {
			int n = 1;
			int total = util.getCapitulosTotales();
			for (int i = 1; i <= total; i++) {
				historia.getCapitulos().add(new Capitulo(i, this, "", null));
			}

			while (n <= util.getCapitulosTotales()) {
				util.toLeerArchivo("./docs/mq/capitulo" + n + ".txt");
				n++;
			}

		} catch (IOException e) {
			Codex.printException(e);
			System.exit(1);
		}
		String[] menu = { "Comenzar Aventura", "Salir" };
		Codex.toGetString(titulo.toUpperCase() + " ⚔️");
		do {
			opcion = util.crearMenu(reader, menu, "Introduce tu opción");
			switch (opcion) {
				case 1 -> {
					historia.iniciar(util.crearPersonaje(reader), reader, util);
				}
				case 2 -> {
					log.debug("Salida");
					System.exit(0);
				}
				case 700 -> { historia.iniciar(util.crearPersonaje(), reader, util); }
			}
		} while (opcion > 2);
	}
}
