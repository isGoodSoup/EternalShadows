package es.eternalshadow.motor;

import es.eternalshadow.entities.Criatura;
import es.eternalshadow.pojos.Enemigo;
import es.eternalshadow.pojos.Jugador;

public class Combate {
	private Jugador jugador;
	private Criatura criatura;
	private Enemigo enemigo;

	public Combate(Jugador jugador, Criatura criatura, Enemigo enemigo) {
		super();
		this.jugador = jugador;
		this.criatura = criatura;
		this.enemigo = enemigo;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Criatura getCriatura() {
		return criatura;
	}

	public void setCriatura(Criatura criatura) {
		this.criatura = criatura;
	}

	public Enemigo getEnemigo() {
		return enemigo;
	}

	public void setEnemigo(Enemigo enemigo) {
		this.enemigo = enemigo;
	}

	public void iniciar() {
		System.out.println("¡Comienza el combate contra "
				+ enemigo.getClass().getSimpleName() + "!");

		while (criatura.isVivo(jugador) && enemigo.isVivo()) {

			System.out.println("\n--- Turno del jugador ---");
			criatura.recibirDanio(jugador);
			System.out.println("Golpeas al enemigo. Vida del enemigo: "
					+ enemigo.getVida());

			if (!enemigo.isVivo())
				break;

			System.out.println("\n--- Turno del enemigo ---");
			criatura.recibirDanio(enemigo);
			System.out.println("El enemigo te golpea. Tu vida: "
					+ jugador.getPuntosVida());
		}

		if (criatura.isVivo(jugador)) {
			System.out.println("\n🏆 ¡Has ganado el combate!");
		} else {
			System.out.println("\n💀 Has sido derrotado...");
		}
	}
}
