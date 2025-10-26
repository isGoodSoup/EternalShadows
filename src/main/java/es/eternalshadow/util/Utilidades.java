package es.eternalshadow.util;

import java.util.Arrays;
import java.util.Random;

import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.UserInterruptException;

import es.eternalshadow.entity.Criatura;
import es.eternalshadow.entity.Demonio;
import es.eternalshadow.entity.Guerrero;
import es.eternalshadow.entity.Mago;
import es.eternalshadow.enums.Clases;

public class Utilidades {
	private static Random random = new Random();
	
	public String toScan(LineReader reader) {
		return reader.readLine();
	}
	
	public String toScan(LineReader reader, String prompt) {
		System.out.println(prompt);
		return reader.readLine();
	}
	
	public int toScanInteger(LineReader reader, String prompt) {
		while (true) {
            try {
                String line = reader.readLine(prompt + ": ");
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.err.println("Por favor introduce un número válido.");
            } catch (UserInterruptException | EndOfFileException e) {
                System.exit(0);
            }
        }
	}
	
	public void toGetString(String s) {
		for (int i = 0; i < s.length(); i++) {
			System.out.print("=");
		}
		System.out.print(" " + s + " ");
		
		for (int i = 0; i < s.length(); i++) {
			System.out.print("=");
		}
		System.out.println();
	}
	
	public int crearMenu(LineReader reader, String[] menu, String s) {
		for (int i = 0; i < menu.length; i++) {
			System.out.println(i + 1 + ") " + menu[i]);
		}
		int num = toScanInteger(reader, s);
		return num;
	}
	
	public int[] tirarDados() {
		int[] num = {random.nextInt(21), random.nextInt(21)};
		System.out.println(Arrays.toString(num));
		return num;
	}
	
	public Criatura crearPersonaje(LineReader reader) {
		Clases clases = Clases.MAGO;
		Criatura criatura = null;
		int puntos;
		int f, r, v, m;
		do {
		    puntos = 0;
		    f = toScanInteger(reader, q("la fuerza"));
		    puntos += f;
		    r = toScanInteger(reader, q("la resistencia"));
		    puntos += r;
		    v = toScanInteger(reader, q("la velocidad"));
		    puntos += v;
		    m = toScanInteger(reader, q("la magia"));
		    puntos += m;
		} while (puntos != 100);
		
		String[] menu = {"Mago", "Guerrero", "Demonio"};
		switch(crearMenu(reader, menu, "Selecciona una clase")) {
			case 1 -> { 
				String nombre = toScan(reader, "Como quieres llamarte?");
				criatura = new Mago("Mago", nombre, f, r, v, m);
				if(clases != null) clases = Clases.MAGO;
			}
					
			case 2 -> {
				String nombre = toScan(reader, "Como quieres llamarte?");
				criatura = new Guerrero("Guerrero", nombre, f, r, v, m);
				if(clases != null) clases = Clases.GUERRERO;
			}
					
			case 3 -> {
				String nombre = toScan(reader, "Como quieres llamarte?");
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
}
