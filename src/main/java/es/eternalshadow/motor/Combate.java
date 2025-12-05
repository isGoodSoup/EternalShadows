package es.eternalshadow.motor;

import es.eternalshadow.entities.Criatura;
import es.eternalshadow.entities.Jugador;
import es.eternalshadow.entities.Usuario;
import es.eternalshadow.pojos.Enemigo;

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

	public void iniciar() {
		System.out.println("¡Comienza el combate contra " + enemigo.getClass().getSimpleName() + "!");

		while (jugador.estaVivo() && enemigo.isVivo()) {

			System.out.println("\n--- Turno del jugador ---");
			enemigo.recibirDanio(jugador.getAtaque());
			System.out.println("Golpeas al enemigo. Vida del enemigo: " + enemigo.getVida());

			if (!enemigo.isVivo())
				break;

			System.out.println("\n--- Turno del enemigo ---");
			jugador.recibirDanio(enemigo.getAtaque());
			System.out.println("El enemigo te golpea. Tu vida: " + jugador.getVida());
		}

		if (jugador.estaVivo()) {
			System.out.println("\n🏆 ¡Has ganado el combate!");
		} else {
			System.out.println("\n💀 Has sido derrotado...");
		}
	}

	public static Object luchar(Usuario user, es.eternalshadow.pojos.Criatura lobo) {
		// TODO Auto-generated method stub
		return null;
	}
}
