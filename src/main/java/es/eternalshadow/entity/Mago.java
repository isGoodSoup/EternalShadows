package es.eternalshadow.entity;

import es.eternalshadow.main.Noxterra;
import es.eternalshadow.objects.Armas;
import es.eternalshadow.objects.Escudos;
import es.eternalshadow.objects.Pocion;

public class Mago extends Criatura {
	private Noxterra nox;
	private String tipoMago;

	public Mago(String tipo, int fuerza, int resistencia, int velocidad, int magia, String nombre, int nivel,
			Escudos[] escudos, Armas[] armas, Pocion pocion, int puntosVida, Noxterra nox, String tipoMago) {
		super(tipo, fuerza, resistencia, velocidad, magia, nombre, nivel, escudos, armas, pocion, puntosVida);
		this.nox = nox;
		this.tipoMago = tipoMago;
	}
	
	public Mago(String nombre, int fuerza, int resistencia, int velocidad, int magia) {
		super();
	}

	public String getTipoMago() {
		return tipoMago;
	}

	public void setTipoMago(String tipoMago) {
		this.tipoMago = tipoMago;
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
