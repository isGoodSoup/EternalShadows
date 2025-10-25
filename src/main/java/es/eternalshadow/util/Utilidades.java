package es.eternalshadow.util;

import java.util.Random;
import java.util.Scanner;

import es.eternalshadow.entity.Criatura;
import es.eternalshadow.entity.Demonio;
import es.eternalshadow.entity.Guerrero;
import es.eternalshadow.entity.Mago;
import es.eternalshadow.enums.Clases;

public class Utilidades {
	private static Scanner scan = new Scanner(System.in);
	private static Random r = new Random();
	
	public int toScanInteger(String s) {
		System.out.println(s);
		int num = scan.nextInt();
		scan.nextLine();
		return num;
	}
	
	public String toScan() {
		return scan.nextLine();
	}
	
	public String toScan(String s) {
		System.out.println(s);
		return scan.nextLine();
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
	
	public int crearMenu(String[] menu, String s) {
		for (int i = 0; i < menu.length; i++) {
			System.out.println(i + 1 + ") " + menu[i]);
		}
		int num = toScanInteger(s);
		return num;
	}
	
	public Criatura crearPersonaje() {
		Clases clases = Clases.MAGO;
		Criatura criatura = null;
		int puntos = 0;
		int f, r, v, m;
		
		do {
			f = toScanInteger(q("la fuerza"));
			puntos += f;
			
			r = toScanInteger(q("la resistencia"));
			puntos += r;
			
			v = toScanInteger(q("la velocidad"));
			puntos += v;
			
			m = toScanInteger(q("la magia"));
			puntos += m;
		} while (puntos > 100 || puntos < 100);
		
		String[] menu = {"Mago", "Guerrero", "Demonio"};
		switch(crearMenu(menu, "Selecciona una clase")) {
			case 1 -> { 
				String nombre = toScan("Como quieres llamarte?");
				criatura = new Mago("Mago", nombre, f, r, v, m);
				if(clases != null) clases = Clases.MAGO;
			}
					
			case 2 -> {
				String nombre = toScan("Como quieres llamarte?");
				criatura = new Guerrero("Guerrero", nombre, f, r, v, m);
				if(clases != null) clases = Clases.GUERRERO;
			}
					
			case 3 -> {
				String nombre = toScan("Como quieres llamarte?");
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
	        atributos[i] = r.nextInt(puntosTotal + 1); 
	        puntosTotal -= atributos[i];                    
	    }
	    atributos[3] = puntosTotal; 
	    
	    int fuerza = atributos[0];
	    int resistencia = atributos[1];
	    int velocidad = atributos[2];
	    int magia = atributos[3];

	    String[] razas = {"Mago", "Guerrero", "Demonio"};
	    int numale = r.nextInt(razas.length);
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
	
	public String[] lineas() {
		return new String[] {
			"Cuando la última luz se extinga, los nombres de los vivos serán olvidados…",
			"Solo quedará la sombra eterna.",
			"Capítulo I — Los Ecos de Noxterra",
			"El viento gime sobre las ruinas.",
			"El cielo, teñido de un gris enfermizo, apenas deja pasar los últimos resplandores de un sol moribundo.",
			"Noxterra ha sido llamada muchas cosas a lo largo de los siglos:",
			"cuna de héroes, tumba de dioses, prisión de los condenados.",
			"Ahora no es más que un suspiro al borde del olvido.",
			"Los pueblos han caído uno tras otro, devorados por el silencio.",
			"Las ciudades ya no tienen nombres, solo ecos que murmuran en lenguas muertas.",
			"Y entre esas ruinas… algo se mueve.",
			"Tú.",
			"Despiertas sobre tierra fría, húmeda, cubierta de ceniza.",
			"No recuerdas tu nombre, ni cómo llegaste aquí.",
			"Solo sientes el peso del aire, espeso como la culpa, y el murmullo de algo lejano que te llama,",
			"como si tu alma misma estuviera siendo arrastrada hacia un destino inevitable.",
			"Ante ti, un grabado antiguo tallado en piedra resplandece débilmente.",
			"Sus símbolos arcanos giran, formando tres figuras envueltas en sombras.",
			"Cada una extiende una mano, invitándote a elegir.",
			null,
			"La elección no solo decidirá tu destino…",
			"sino la forma en que Noxterra recordará tu nombre — si es que llega a recordarlo.",
			"Capítulo II — El Despertar",
			"El aire tiembla.",
			"Las sombras del grabado se disuelven",
			"y una de las figuras se desprende de la piedra",
			"tomando forma ante ti. La elección está hecha.",
			
		};
	}
}
