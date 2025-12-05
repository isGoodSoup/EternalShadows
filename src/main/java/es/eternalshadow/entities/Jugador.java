package es.eternalshadow.entities;

import es.eternalshadow.pojos.Criatura;

public class Jugador extends Criatura {

	private String nombre;
	private int vida;
	private int moral;
	private int ataque;

	public Jugador(String nombre, int vida, int moral, int ataque) {
		super();
		this.nombre = nombre;
		this.vida = vida;
		this.moral = moral;
		this.ataque = ataque;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
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

	public boolean estaVivo() {
		return vida > 0;
	}

	public void recibirDanio(int cantidad) {
		super.recibirDanio(cantidad);
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

}
