package es.eternalshadow.pojos;

import es.eternalshadow.entities.Criatura;

public class Mago extends Criatura {

	public Mago() {}

	public Mago(String nombre, int nivel, java.util.ArrayList<es.eternalshadow.pojos.Escudos> escudos,
			java.util.ArrayList<es.eternalshadow.pojos.Armas> armas, String pocion, int puntosVida) {
		super(nombre, nivel, escudos, armas, pocion, puntosVida);
	}

	@Override
	public void atacar() {
		super.atacar();
	}

	@Override
	public void defender() {
		super.defender();
	}
}
