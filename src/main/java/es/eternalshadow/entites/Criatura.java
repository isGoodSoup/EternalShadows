package es.eternalshadow.entites;



import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
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

	@Column(name = "defensa")
	private int defensa;

	@Column(name = "armas")
	@ElementCollection
	private ArrayList<Armas> armas;

	@Column(name = "pocion")
	private String pocion;

	@Column(name = "puntos_vida", nullable = false)
	private int puntosVida;

	public Criatura() {

	}
	
	public Criatura(String nombre, int nivel, int defensa, ArrayList<Armas> armas, String pocion,
			int puntosVida) {
		super();
		this.nombre = nombre;
		this.nivel = nivel;
		this.defensa = defensa;
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
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
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
	
	public String toString() {
		return "Criatura [nombre=" + nombre + ", nivel=" + nivel + ", defensa=" + defensa + ", armas=" + armas
				+ ", pocion=" + pocion + ", puntosVida=" + puntosVida + "]";
	}

	

	
	
}
