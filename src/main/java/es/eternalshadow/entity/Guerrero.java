package es.eternalshadow.entity;

import es.eternalshadow.main.Noxterra;
import es.eternalshadow.objects.Armas;
import es.eternalshadow.objects.Escudos;
import es.eternalshadow.objects.Pocion;

public class Guerrero extends Criatura {
	private Noxterra nox;
	private String genero;
	
	public Guerrero(String tipo, int fuerza, int resistencia, int velocidad, int magia, String nombre, int nivel,
			Escudos[] escudos, Armas[] armas, Pocion pocion, int puntosVida, Noxterra nox, String genero) {
		super(tipo, fuerza, resistencia, velocidad, magia, nombre, nivel, escudos, armas, pocion, puntosVida);
		this.nox = nox;
		this.genero = genero;
	}
	
	public Guerrero(String nombre, int fuerza, int resistencia, int velocidad, int magia) {
		super();
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		nox.atacar();
	}

	@Override
	public void defender() {
		// TODO Auto-generated method stub
		nox.defender();
	}
}
