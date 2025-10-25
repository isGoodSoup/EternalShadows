package es.eternalshadow.main;

import java.io.IOException;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import es.eternalshadow.util.Utilidades;

public class Panel {
	private Terminal terminal;
	private LineReader reader;
	private Utilidades util = new Utilidades();
	private String[] lineas = util.lineas();
	private int nextLine;
	private int opcion;
	
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
	
	public void intro() {
		System.out.println(nextLine());
		System.out.println(nextLine());
	}
	
	public void comenzar() {
		intro();
		String[] menu = {"Comenzar Aventura", "Salir"};
		util.toGetString("⌛ Eternal Shadows ⚔️");
		opcion = util.crearMenu(menu, "Introduce tu opción");
		util.toScan();
		do {
			switch(opcion) {
				case 1 -> {
					String linea;
			        while((linea = nextLine()) != null) {
			        	System.out.print(linea);
			        	reader.readLine();
			        }
				}
				case 2 -> System.exit(0);
			}
		} while(opcion > 2);
	}
	
	private String nextLine() {
		if (nextLine >= lineas.length) return null;
        return lineas[nextLine++];
    }
	
	public Utilidades getUtil() {
		return util;
	}

	public void setUtil(Utilidades util) {
		this.util = util;
	}
}
