package es.eternalshadow.entity;

import es.eternalshadow.main.Noxterra;
import es.eternalshadow.objects.Armas;
import es.eternalshadow.objects.Escudos;
import es.eternalshadow.objects.Pocion;

public class Demonio extends Criatura {
	private Noxterra nox;
	private boolean isCuernos;

	public Demonio(String tipo, int fuerza, int resistencia, int velocidad, int magia, String nombre, int nivel,
			Escudos[] escudos, Armas[] armas, Pocion pocion, int puntosVida, Noxterra nox, boolean isCuernos) {
		super(tipo, fuerza, resistencia, velocidad, magia, nombre, nivel, escudos, armas, pocion, puntosVida);
		this.nox = nox;
		this.isCuernos = isCuernos;
	}

	public boolean isCuernos() {
		return isCuernos;
	}

	public void setCuernos(boolean isCuernos) {
		this.isCuernos = isCuernos;
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
