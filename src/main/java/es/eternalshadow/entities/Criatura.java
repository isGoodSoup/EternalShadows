package es.eternalshadow.entities;

import es.eternalshadow.pojos.Armas;
import es.eternalshadow.pojos.Escudos;
import es.eternalshadow.pojos.Pocion;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_criatura")
public class Criatura extends Raza {

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "nivel", nullable = false)
	private int nivel;

	@Column(name = "escudos")
	private Escudos[] escudos;

	@Column(name = "armas")
	private Armas[] armas;

	@Column(name = "pocion")
	private Pocion pocion;

	@Column(name = "puntos_vida", nullable = false)
	private int puntosVida;

	public Criatura() {

	}

	public Criatura(String nombre, int nivel, Escudos[] escudos, Armas[] armas, Pocion pocion, int puntosVida) {
		super();
		this.nombre = nombre;
		this.nivel = nivel;
		this.escudos = escudos;
		this.armas = armas;
		this.pocion = pocion;
		this.puntosVida = puntosVida;
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

	public String toString() {
		return "Criatura [nombre=" + nombre + ", nivel=" + nivel + ", escudos=" + escudos + ", armas=" + armas
				+ ", pocion=" + pocion + ", puntosVida=" + puntosVida + "]";
	}
	
	
}
