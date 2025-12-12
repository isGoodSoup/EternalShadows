package es.eternalshadow.pojos;

import es.eternalshadow.enums.Armamento;

public class Arma extends Item {
	private Armamento arma;

	public Arma(String nombre, int cantidad, Armamento arma) {
		super(nombre, cantidad);
		this.arma = arma;
	}

	public Armamento getArma() {
		return arma;
	}

	public void setArma(Armamento arma) {
		this.arma = arma;
	}
}
