package es.eternalshadow.main;

import java.io.IOException;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.eternalshadow.entity.Criatura;
import es.eternalshadow.util.Utilidades;

public class Panel {
	private Terminal terminal;
	private LineReader reader;
	private Utilidades util = new Utilidades();
	private String[] lineas = util.lineas();
	private int nextLine;
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
	
	public void intro() {
		log.info("Inicio");
		System.out.println(nextLine());
		System.out.println(nextLine());
	}
	
	public void comenzar() {
		intro();
		String[] menu = {"Comenzar Aventura", "Salir"};
		util.toGetString("ETERNAL SHADOWS ⚔️");
		opcion = util.crearMenu(menu, "Introduce tu opción");
		util.toScan();
		do {
			switch(opcion) {
				case 1 -> {
					Criatura criatura = capitulo1();
					capitulo2(criatura);
					capitulo3(criatura);
				}
				case 2 -> { log.info("Salida"); System.exit(0); }
			}
		} while(opcion > 2);
	}
	
	private Criatura capitulo1() {
		String linea;
        while((linea = nextLine()) != null) {
        	System.out.print(linea);
        	reader.readLine();
        }
        log.info("Creando personaje...");
        Criatura criatura = util.crearPersonaje();
        System.out.println("Puntos de " + criatura.getNombre());
        System.out.println(criatura.getFuerza() + ", " + 
        criatura.getResistencia() + ", " + criatura.getVelocidad() + ", " + criatura.getMagia());
        
        log.info("Prosiguiendo con la historia");
        while((linea = nextLine()) != null) {
        	System.out.print(linea);
        	reader.readLine();
        }
        return criatura;
	}
	
	private Criatura capitulo2(Criatura criatura) {
		String linea;
        while((linea = nextLine()) != null) {
        	System.out.print(linea);
        	reader.readLine();
        }
		return criatura;
	}
	
	private Criatura capitulo3(Criatura criatura) {
		String linea;
        while((linea = nextLine()) != null) {
        	System.out.print(linea);
        	reader.readLine();
        }
		return criatura;
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
