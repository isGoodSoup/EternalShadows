package es.eternalshadow.entities;

import java.util.ArrayList;

import es.eternalshadow.pojos.Armas;
import es.eternalshadow.pojos.Escudos;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_criatura")
public abstract class Criatura extends Raza {
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	@Column(name = "nivel", nullable = false)
	private int nivel;
	@Column(name = "escudos")
	private ArrayList<Escudos> escudos;

	@Column(name = "armas")
	private ArrayList<Armas> armas;
	@Column(name = "pocion")
	private String pocion;

	@Column(name = "puntos_vida", nullable = false)
	private int puntosVida;

	public Criatura() {

	}

	public Criatura(String nombre, int nivel, ArrayList<Escudos> escudos, ArrayList<Armas> armas, String pocion,
			int puntosVida) {
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

	public ArrayList<Escudos> getEscudos() {
		return escudos;
	}

	public void setEscudos(ArrayList<Escudos> escudos) {
		this.escudos = escudos;
	}

	public ArrayList<Armas> getArmas() {
		return armas;
	}

	public void setArmas(ArrayList<Armas> armas) {
		this.armas = armas;
	}

	public String getPocion() {
		return pocion;
	}

	public void setPocion(String pocion) {
		this.pocion = pocion;
	}

	public int getPuntosVida() {
		return puntosVida;
	}

	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}

	@Override

	public String toString() {
		return "Criatura [nombre=" + nombre + ", nivel=" + nivel + ", escudos=" + escudos + ", armas=" + armas
				+ ", pocion=" + pocion + ", puntosVida=" + puntosVida + "]";
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void defender() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isVivo(Criatura criatura) {
		return puntosVida < 0;
	}

	@Override
	public void recibirDanio(int danio) {
	    this.puntosVida -= danio;
	    if (this.puntosVida < 0) {
	        this.puntosVida = 0;
	    }
	}
	@Override
	public void recibirDanio(Criatura atacante) {
	    int danio = calcularDanio(atacante);  // Método auxiliar
	    this.puntosVida -= danio;
	    if (this.puntosVida < 0) {
	        this.puntosVida = 0;
	}
}
