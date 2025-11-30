package es.eternalshadow.main;

import java.io.IOException;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.eternalshadow.story.Historia;
import es.eternalshadow.story.HistoriaPrincipal;
import es.eternalshadow.util.Codex;

/**
 * Clase principal que representa el panel de control de la aplicación.
 * Se encarga de inicializar el terminal, manejar la entrada del usuario
 * y comenzar la historia.
 */

public class Panel {
	private Terminal terminal;
	private LineReader reader;
	private Historia historia = new HistoriaPrincipal("Eternal Shadows");
	private Codex util = new Codex();
	private int opcion;
	private static final Logger log = LoggerFactory.getLogger(Panel.class);
	
	public Panel() {
        try {
            terminal = TerminalBuilder.terminal();
            reader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
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
	
	private void intro() {
		System.out.println("Cuando la última luz se extinga, los nombres de los vivos serán olvidados...");
		System.out.println("Solo quedará la sombra eterna.");
	}
	
	/**
     * Inicia la historia y muestra el menú principal.
     * Permite comenzar la aventura o salir de la aplicación.
     */
	public void comenzar() {
		log.info("Inicio");
		intro();
		try {
	        historia.setCapitulos(util.toLeerArchivo("campaña.txt"));
	    } catch (IOException e) {
	        Codex.printException(e);
	        System.exit(1);
	    }
		
		String[] menu = {"Comenzar Aventura", "Salir"};
		Codex.toGetString("ETERNAL SHADOWS ⚔️");
		opcion = util.crearMenu(reader, menu, "Introduce tu opción");
		do {
			switch(opcion) {
				case 1 -> { historia.iniciar(reader, util); }
				case 2 -> { log.info("Salida"); System.exit(0); }
			}
		} while(opcion > 2);
	}
}
