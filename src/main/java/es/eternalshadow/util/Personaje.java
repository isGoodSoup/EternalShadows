package es.eternalshadow.util;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.eternalshadow.entity.Criatura;
import es.eternalshadow.entity.Demonio;
import es.eternalshadow.entity.Raza;

public class Personaje extends Raza {
	private int puntos;
	private static final Scanner scan = new Scanner(System.in);
	private static final Logger log = LoggerFactory.getLogger(Personaje.class);	
	
	public Personaje(String tipo, int fuerza, int resistencia, int velocidad, int magia) {
		super(tipo, fuerza, resistencia, velocidad, magia);
		crearPersonaje(fuerza, resistencia, velocidad, magia);
	}
	
	public void crearPersonaje(int f, int r, int v, int m) {
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
		
		Criatura criatura = new Demonio(f, r, v, m);
	}
	
	public void q(String s) {
		log.info("Introduce el valor de " + s);
	}
}
