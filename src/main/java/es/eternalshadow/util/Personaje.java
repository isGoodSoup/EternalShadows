package es.eternalshadow.util;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.eternalshadow.entity.Criatura;
import es.eternalshadow.entity.Demonio;
import es.eternalshadow.entity.Guerrero;
import es.eternalshadow.entity.Mago;
import es.eternalshadow.entity.Raza;

public class Personaje extends Raza {
	private int puntos;
	private Criatura[] criaturas = new Criatura[2];
	private static final Scanner scan = new Scanner(System.in);
	private static final Logger log = LoggerFactory.getLogger(Personaje.class);	
	
	public Personaje(String tipo, int fuerza, int resistencia, int velocidad, int magia) {
		super(tipo, fuerza, resistencia, velocidad, magia);
		crearPersonaje(fuerza, resistencia, velocidad, magia);
	}
	
	public Criatura[] crearPersonaje(int f, int r, int v, int m) {
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
		} while (puntos == 100);
		
		String[] menu = {"Mago", "Guerrero", "Demonio"};
		crearMenu(menu);
		log.info("Selecciona una clase");
		int opcion = scan.nextInt();
		
		switch(opcion) {
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
	
	public void q(String s) {
		log.info("Introduce el valor de " + s);
	}
	
	public void crearMenu(String[] menu) {
		for (int i = 0; i < menu.length; i++) {
			System.out.println(i + ") " + menu[i]);
		}
		System.out.println("Introduce una opción");
	}
	
	public Criatura claseSeleccionada(Criatura criatura) {
		log.info("Clase seleccionada: " + criatura.getNombre());
		return criatura;
	}
}
