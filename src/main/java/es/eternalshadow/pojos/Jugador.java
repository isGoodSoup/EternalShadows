package es.eternalshadow.pojos;

import es.eternalshadow.entities.Criatura;

public class Jugador extends Criatura {
	private String nombre;
	private int moral;
	private int ataque;

	public Jugador(String nombre, int vida, int moral, int ataque) {
		super();
		this.nombre = nombre;
		this.moral = moral;
		this.ataque = ataque;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMoral() {
		return moral;
	}

	public void setMoral(int moral) {
		this.moral = moral;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getOro() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void reducirOro(int precio) {
		// TODO Auto-generated method stub

	}

	public void addArtefacto(String objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public int recibirDanio(Criatura criatura) {
		return super.recibirDanio(criatura);
	}

	@Override
	public boolean isVivo(Criatura criatura) {
		return super.isVivo(criatura);
	}

}
