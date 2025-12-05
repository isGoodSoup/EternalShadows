package es.eternalshadow.interfaces;

import es.eternalshadow.entities.Criatura;

public interface Accionable {
	void atacar();
	void defender();
	int recibirDanio(Criatura jugador);
	boolean isVivo(Criatura jugador);
}
