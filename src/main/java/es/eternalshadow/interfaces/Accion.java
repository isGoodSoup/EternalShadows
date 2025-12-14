package es.eternalshadow.interfaces;

import es.eternalshadow.entities.Criatura;
import es.eternalshadow.pojos.Jugador;

@FunctionalInterface
public interface Accion {
	void ejecutar(Jugador jugador, Criatura criatura);
}
