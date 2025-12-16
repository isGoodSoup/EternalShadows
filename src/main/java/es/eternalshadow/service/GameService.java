package es.eternalshadow.service;

import es.eternalshadow.exception.GameException;
import es.eternalshadow.exception.LimiteCombateException;
import es.eternalshadow.main.GameContext;
import es.eternalshadow.util.Codex;

public class GameService {
	private final GameContext context;

	public GameService(GameContext context) {
		this.context = context;
	}

	public void iniciarPartida() {
		context.getCriaturas().clear();
		int tope;
		boolean isTope;

		do {
			tope = Codex.toScanInteger(context.getReader(),
					"Inserta el número de jugadores (máx 5)");
			isTope = tope < 2 || tope > 5;
			if (isTope) {
				try {
					throw new GameException(
							"Número de jugadores inválido: " + tope);
				} catch (GameException e) {
					Codex.printException(e);
				}
			}
		} while (isTope);

		for (int i = 1; i <= tope; i++) {
			try {
				context.setJugador(
						context.getUtil().crearPersonaje(context.getReader()));
			} catch (LimiteCombateException e) {
				Codex.printException(e);
			}
			context.getCriaturas().add(context.getJugador());
		}
		context.getHistoria().iniciar(context.getCriaturas(),
				context.getReader(), context.getUtil());
	}
}
