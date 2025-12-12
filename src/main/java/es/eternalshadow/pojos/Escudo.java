package es.eternalshadow.pojos;

import es.eternalshadow.enums.Escuderia;

public class Escudo extends Item {
	private Escuderia escudo;

	public Escudo(String nombre, int cantidad, Escuderia escudo) {
		super(nombre, cantidad);
		this.escudo = escudo;
	}

	public Escuderia getEscudo() {
		return escudo;
	}

	public void setEscudo(Escuderia escudo) {
		this.escudo = escudo;
	}
}
