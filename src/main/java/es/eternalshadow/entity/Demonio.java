package es.eternalshadow.entity;

import es.eternalshadow.main.Noxterra;
import es.eternalshadow.objects.Armas;
import es.eternalshadow.objects.Escudos;
import es.eternalshadow.objects.Pocion;

public class Demonio extends Criatura {
	private Noxterra nox;
	private String nombre;
	private boolean isCuernos;
	
	public Demonio(String tipo, int fuerza, int resistencia, int velocidad, int magia, String nombre, int nivel,
			Escudos[] escudos, Armas[] armas, Pocion pocion, int puntosVida, String nombre2, boolean isCuernos) {
		super(tipo, fuerza, resistencia, velocidad, magia, nombre, nivel, escudos, armas, pocion, puntosVida);
		nombre = nombre2;
		this.isCuernos = isCuernos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
