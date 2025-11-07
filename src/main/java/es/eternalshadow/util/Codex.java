package es.eternalshadow.util;

import java.util.Arrays;
import java.util.Random;

import org.jline.reader.LineReader;

import es.eternalshadow.entidades.Criatura;
import es.eternalshadow.entidades.Demonio;
import es.eternalshadow.entidades.Guerrero;
import es.eternalshadow.entidades.Mago;
import es.eternalshadow.enums.Clases;

public class Codex {
	private static Random random = new Random();
	
	public int crearMenu(LineReader reader, String[] menu, String s) {
		for (int i = 0; i < menu.length; i++) {
			System.out.println(i + 1 + ") " + menu[i]);
		}
		int num = Codex.toScanInteger(reader, s);
		return num;
	}
	
	public static void printException(Exception e) {
		System.err.println(e.getClass().getSimpleName() + " at line " 
						+ e.getStackTrace()[e.getStackTrace().length - 3]
						.getLineNumber() + ": " + e.getMessage());
	}
	
	public static String toScan(LineReader reader, String s) {
		String line = "";
		do {
    		System.out.print(s + ": ");
    		line = reader.readLine().trim();
    	} while(line.isEmpty());
		return line;
    }
	
	public static int toScanInteger(LineReader reader, String s) {
		String line = "";
	    while (true) {
	        try {
	        	do {
	        		System.out.print(s + ": ");
	        		line = reader.readLine().trim();
	        	} while(line.isEmpty());
	        	
	            int num = Integer.parseInt(line);
	            return num;
	        } catch (Exception e) {
	            printException(e);
	        }
	    }
	}
	
	public int[] tirarDados() {
		int[] num = {random.nextInt(21), random.nextInt(21)};
		System.out.println(Arrays.asList(num));
		return num;
	}
	
	public Criatura crearPersonaje(LineReader reader) {
		Clases clases = Clases.MAGO;
		Criatura criatura = null;
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
		} while (puntos != 100);
		
		String[] menu = {"Mago", "Guerrero", "Demonio"};
		switch(crearMenu(reader, menu, "Selecciona una clase")) {
			case 1 -> { 
				String nombre = Codex.toScan(reader, "Como quieres llamarte?");
				criatura = new Mago("Mago", nombre, f, r, v, m);
				if(clases != null) clases = Clases.MAGO;
			}
					
			case 2 -> {
				String nombre = Codex.toScan(reader, "Como quieres llamarte?");
				criatura = new Guerrero("Guerrero", nombre, f, r, v, m);
				if(clases != null) clases = Clases.GUERRERO;
			}
					
			case 3 -> {
				String nombre = Codex.toScan(reader, "Como quieres llamarte?");
				criatura = new Demonio("Demonio", nombre, f, r, v, m);
				if(clases != null) clases = Clases.DEMONIO;
			}
		}
		return criatura;
	}
	
	public static Criatura crearCriaturaAleatoria() {
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

	    String[] razas = {"Mago", "Guerrero", "Demonio"};
	    int numale = random.nextInt(razas.length);
	    String tipo = razas[numale];
	    
	    Criatura c= null;
	    System.out.println("Se va a crear la criatura del tipo " + tipo);
	    switch (tipo) {
	        case "Mago":
	        	c= new Mago("Mago", "Mago", fuerza, resistencia, velocidad, magia);
	            break;
	        case "Guerrero":
	        	c= new Guerrero("Guerrero", "Guerrero", fuerza, resistencia, velocidad, magia);
	            break;
	        case "Demonio":
	        	c = new Demonio("Demonio", "Demonio", fuerza, resistencia, velocidad, magia);
	            break;
	        
	    }
	    
	    if (c != null) {
	    	System.out.println("Criatura enemiga creada: " + c.getNombre() + " con atributos: "
	             + "Fuerza: " + fuerza + ", Resistencia: " + resistencia + ", Velocidad: " + velocidad + ", Magia: " + magia);
	    }
	    return c;
	}

	private String q(String s) {
		return "Introduce el valor de " + s;
	}
	
	public static double toGetDouble(int min, int max) {
		double d = random.nextInt(min, max)/100.0;
		return d;
	}
	
	public static boolean toGetBoolean() {
		return random.nextBoolean();
	}
	
	public static void toGetString(String s) {
		for (int i = 0; i < s.length(); i++) {
			System.out.print("=");
		}
		System.out.print(" " + s + " ");
		
		for (int i = 0; i < s.length(); i++) {
			System.out.print("=");
		}
		System.out.println();
	}

	public static String toGetString(String[] s) {
		return s[random.nextInt(s.length)];
	}
	
	public static int toGetInteger() {
		return random.nextInt();
	}
	
	public static int toGetInteger(int[] i) {
		return i[random.nextInt(i.length)];
	}
	
	public static int toGetInteger(int min, int max) {
		return random.nextInt(min, max);
	}
	
	public static long toGetLong(long min, long max) {
		return random.nextLong(min, max);
	}
	
	public long toTime(Runnable task) {
        long start = System.currentTimeMillis();
        task.run();
        return System.currentTimeMillis() - start;
    }
}
