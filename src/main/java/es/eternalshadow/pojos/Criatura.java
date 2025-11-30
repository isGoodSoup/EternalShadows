package es.eternalshadow.pojos;

import es.eternalshadow.interfaces.Accionable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CRIATURA")
public abstract class Criatura extends Raza implements Accionable {
	private String nombre;
	private int nivel;
	private Escudos[] escudos;
	private Armas[] armas;
	private Pocion pocion;
	private int puntosVida;
	
	public Criatura() {}
	
	public Criatura(String nombre, int nivel, Escudos[] escudos, Armas[] armas,
			Pocion pocion, int puntosVida) {
		super();
		this.nombre = nombre;
		this.nivel = nivel;
		this.escudos = escudos;
		this.armas = armas;
		this.pocion = pocion;
		this.puntosVida = puntosVida;
	}
	
	public Criatura(int id, String tipo, int fuerza, int resistencia,
			int velocidad, int magia) {
		super(id, tipo, fuerza, resistencia, velocidad, magia);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Escudos[] getEscudos() {
		return escudos;
	}

	public void setEscudos(Escudos[] escudos) {
		this.escudos = escudos;
	}

	public Armas[] getArmas() {
		return armas;
	}

	public void setArmas(Armas[] armas) {
		this.armas = armas;
	}

	public Pocion getPocion() {
		return pocion;
	}

	public void setPocion(Pocion pocion) {
		this.pocion = pocion;
	}

	public int getPuntosVida() {
		return puntosVida;
	}

	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}

	@Override
	public void atacar() {
		
	}
	
	@Override
	public void defender() {
		
	}
}
