package es.eternalshadow.entites;

import es.eternalshadow.pojos.Armas;
import es.eternalshadow.pojos.Escudos;
import es.eternalshadow.pojos.Pocion;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_demonio")
public class Demonio extends Criatura {
	
	public Demonio() {
		super();
	}
	
	public Demonio(String nombre, int nivel, Escudos[] escudos, Armas[] armas, Pocion pocion, int puntosVida) {
		super(nombre, nivel, escudos, armas, pocion, puntosVida);
	}
	

}
