package es.eternalshadow.entidades;

import es.eternalshadow.interfaces.Accionable;
import es.eternalshadow.pojos.Armas;
import es.eternalshadow.pojos.Escudos;
import es.eternalshadow.pojos.Pocion;

public abstract class Criatura extends Raza implements Accionable {
	private String nombre;
	private int nivel;
	private Escudos[] escudos;
	private Armas[] armas;
	private Pocion pocion;
	private int puntosVida;
	
	public Criatura(String tipo, String nombre, int fuerza, int resistencia, int velocidad, int magia) {
		super(tipo, fuerza, resistencia, velocidad, magia);
		this.nombre = nombre;
	}
	
	public Criatura(String nombre, String tipo, int fuerza, int resistencia, int velocidad, int magia, int nivel,
			Escudos[] escudos, Armas[] armas, Pocion pocion, int puntosVida) {
		super(tipo, fuerza, resistencia, velocidad, magia);
		this.nombre = nombre;
		this.nivel = nivel;
		this.escudos = escudos;
		this.armas = armas;
		this.pocion = pocion;
		this.puntosVida = puntosVida;
	}
	
	@Override
	public void atacar() {
		
	}
	
	@Override
	public void defender() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Escudos[] getEscudos() {
		return escudos;
	}

	public void setEscudos(Escudos[] escudos) {
		this.escudos = escudos;
	}

	public Armas[] getArmas() {
		return armas;
	}

	public void setArmas(Armas[] armas) {
		this.armas = armas;
	}

	public Pocion getPocion() {
		return pocion;
	}

	public void setPocion(Pocion pocion) {
		this.pocion = pocion;
	}

	public int getPuntosVida() {
		return puntosVida;
	}

	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}
}
