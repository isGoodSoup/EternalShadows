package es.eternalshadow.entity;

import es.eternalshadow.objects.Armas;
import es.eternalshadow.objects.Escudos;
import es.eternalshadow.objects.Pocion;

public abstract class Criatura extends Raza {
	private String nombre;
	private int nivel;
	private Escudos[] escudos;
	private Armas[] armas;
	private Pocion pocion;
	private int puntosVida;
	
	public Criatura(String tipo, int fuerza, int resistencia, int velocidad, int magia, String nombre, int nivel,
			Escudos[] escudos, Armas[] armas, Pocion pocion, int puntosVida) {
		super(tipo, fuerza, resistencia, velocidad, magia);
		this.nombre = nombre;
		this.nivel = nivel;
		this.escudos = escudos;
		this.armas = armas;
		this.pocion = pocion;
		this.puntosVida = puntosVida;
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
