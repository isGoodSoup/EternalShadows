package es.eternalshadow.entity;

public abstract class Raza {
	private String tipo;
	private int fuerza;
	private int resistencia;
	private int velocidad;
	private int magia;
	
	public Raza() {}
	
	public Raza(String tipo, int fuerza, int resistencia, int velocidad, int magia) {
		super();
		this.tipo = tipo;
		this.fuerza = fuerza;
		this.resistencia = resistencia;
		this.velocidad = velocidad;
		this.magia = magia;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getFuerza() {
		return fuerza;
	}
	
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	
	public int getResistencia() {
		return resistencia;
	}
	
	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public int getMagia() {
		return magia;
	}
	
	public void setMagia(int magia) {
		this.magia = magia;
	}
}
