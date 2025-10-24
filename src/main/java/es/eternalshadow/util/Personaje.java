package es.eternalshadow.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.eternalshadow.entity.Criatura;
import es.eternalshadow.entity.Demonio;
import es.eternalshadow.entity.Guerrero;
import es.eternalshadow.entity.Mago;
import es.eternalshadow.entity.Raza;
import es.eternalshadow.enums.Clases;

public class Personaje extends Raza {
	private int puntos;
	private List<Criatura> criaturas = new ArrayList<>();
	private Clases clases;
	private static Random r = new Random();
	private static final Logger log = LoggerFactory.getLogger(Personaje.class);	
	
	public Personaje() {}
	
	public Personaje(String tipo, int fuerza, int resistencia, int velocidad, int magia) {
		super(tipo, fuerza, resistencia, velocidad, magia);
		crearPersonaje(fuerza, resistencia, velocidad, magia);
	}
	
	private List<Criatura> crearPersonaje(int f, int r, int v, int m) {
		do {
			f = Input.toScanInteger(q("la fuerza"));
			puntos += f;
			
			r = Input.toScanInteger(q("la resistencia"));
			puntos += r;
			
			v = Input.toScanInteger(q("la velocidad"));
			puntos += v;
			
			m = Input.toScanInteger(q("la magia"));
			puntos += m;
		} while (puntos != 100);
		
		String[] menu = {"Mago", "Guerrero", "Demonio"};
		switch(Input.crearMenu(menu, "Selecciona una clase")) {
			case 1: Criatura c1 = new Mago("Mago", "El Mago", f, r, v, m);
					clases = Clases.MAGO;
					claseSeleccionada(c1);
					criaturas.add(c1);
					break;
					
			case 2: Criatura c2 = new Guerrero("Guerrero", "El Guerrero", f, r, v, m);
					clases = Clases.GUERRERO;
					claseSeleccionada(c2);
					criaturas.add(c2);
					break;
					
			case 3: Criatura c3 = new Demonio("Demonio", "El Demonio", f, r, v, m);
					clases = Clases.DEMONIO;
					claseSeleccionada(c3);
					criaturas.add(c3);
					break;
		}
		return criaturas;
	}
	
	public static  Criatura crearCriaturaAleatoria() {
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
//	    Random ale = new Random();
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
	
	private Criatura claseSeleccionada(Criatura criatura) {
		log.info("Clase seleccionada: " + criatura.getNombre());
		return criatura;
	}

	public Clases getClases() {
		return clases;
	}

	public void setClases(Clases clases) {
		this.clases = clases;
	}
}
