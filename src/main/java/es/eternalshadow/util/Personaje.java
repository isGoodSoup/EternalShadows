package es.eternalshadow.util;

import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.eternalshadow.entity.Criatura;
import es.eternalshadow.entity.Demonio;
import es.eternalshadow.entity.Guerrero;
import es.eternalshadow.entity.Mago;
import es.eternalshadow.entity.Raza;
import es.eternalshadow.main.Main;

public class Personaje extends Raza {
	private int puntos;
	private Criatura[] criaturas = new Criatura[2];
	private static final Scanner scan = new Scanner(System.in);
	private static final Logger log = LoggerFactory.getLogger(Personaje.class);	
	
	public Personaje() {}
	
	public Personaje(String tipo, int fuerza, int resistencia, int velocidad, int magia) {
		super(tipo, fuerza, resistencia, velocidad, magia);
		crearPersonaje(fuerza, resistencia, velocidad, magia);
	}
	
	private Criatura[] crearPersonaje(int f, int r, int v, int m) {
		do {
			q("la fuerza");
			f = scan.nextInt();
			puntos += f;
			scan.nextLine();
			
			q("la resistencia");
			r = scan.nextInt();
			puntos += r;
			scan.nextLine();
			
			q("la velocidad");
			v = scan.nextInt();
			puntos += v;
			scan.nextLine();
			
			q("la magia");
			m = scan.nextInt();
			puntos += m;
			scan.nextLine();
		} while (puntos != 100);
		
		String[] menu = {"Mago", "Guerrero", "Demonio"};
		switch(Input.crearMenu(menu, "Selecciona una clase")) {
			case 1: Criatura c1 = new Mago("El Mago", f, r, v, m);
					claseSeleccionada(c1);
					criaturas[0] = c1;
					break;
					
			case 2: Criatura c2 = new Guerrero("El Guerrero", f, r, v, m);
					claseSeleccionada(c2);
					criaturas[0] = c2;
					break;
					
			case 3: Criatura c3 = new Demonio("El Demonio", f, r, v, m);
					claseSeleccionada(c3);
					criaturas[0] = c3;
					break;
		}
		return criaturas;
	}
	
	
	public static  Criatura crearCriaturaAleatoria() {
		Random r = new Random();
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
	    Random ale = new Random();
	    int numale = ale.nextInt(razas.length);
	    String tipo = razas[numale];
	    
	    
	    Criatura c=null;
	    switch (tipo) {
	   
	        case "Mago":
	        	c= new Mago("Mago enemigo", fuerza, resistencia, velocidad, magia);
	            break;
	        case "Guerrero":
	        	c= new Guerrero("Guerrero enemigo", fuerza, resistencia, velocidad, magia);
	            break;
	        case "Demonio":
	        	c = new Demonio("Demonio enemigo", fuerza, resistencia, velocidad, magia);
	            break;
	        
	    }
	    if (c != null) {

	   System.out.println("Criatura enemiga creada: " + c.getNombre() + " con atributos: "
	             + "Fuerza: " + fuerza + ", Resistencia: " + resistencia + ", Velocidad: " + velocidad + ", Magia: " + magia);

	   
	    }
	    return c;
	    
	}


	
	
	private void q(String s) {
		log.info("Introduce el valor de " + s);
	}
	
	private Criatura claseSeleccionada(Criatura criatura) {
		log.info("Clase seleccionada: " + criatura.getNombre());
		return criatura;
	}
	

}
