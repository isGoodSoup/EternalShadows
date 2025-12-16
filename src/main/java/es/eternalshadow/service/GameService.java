package es.eternalshadow.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.eternalshadow.exception.GameException;
import es.eternalshadow.exception.LimiteCombateException;
import es.eternalshadow.main.Panel;
import es.eternalshadow.util.Codex;

public class GameService {
	private Panel panel;
	private static final Logger log = LoggerFactory.getLogger(GameService.class);

	public GameService(Panel panel) {
		super();
		this.panel = panel;
	}
	
	/**
	 * Método para iniciar la partida si se ha elegido la constante
	 * Menu.COMENZAR
	 */
	public void iniciarPartida() {
		panel.getCriaturas().clear();
		int tope = 0;
		boolean isTope = false;

		do {
			tope = Codex.toScanInteger(panel.getReader(),
					"Inserta el número de jugadores (máx 5)");
			isTope = tope < 2 || tope > 5;
			if (isTope) {
				try {
					throw new GameException(
							"El número de jugadores es inválido: " + tope);
				} catch (GameException e) {
					Codex.printException(e);
				}
			}
		} while (isTope);

		log.debug("Numero de jugadores elegido: " + tope);

		for (int i = 1; i <= tope; i++) {
			log.debug("Jugador " + i);
			try {
				panel.setJugador(panel.getUtil().crearPersonaje(panel.getReader()));
			} catch (LimiteCombateException e) {
				Codex.printException(e);
			}
			log.debug("Nueva criatura creada");
			panel.getCriaturas().add(panel.getJugador());
		}
		panel.getHistoria().iniciar(panel.getCriaturas(), panel.getReader(), panel.getUtil());
	}
}
