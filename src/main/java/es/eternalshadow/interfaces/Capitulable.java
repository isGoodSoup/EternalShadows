package es.eternalshadow.interfaces;

import org.jline.reader.LineReader;

import es.eternalshadow.pojos.Criatura;
import es.eternalshadow.util.Codex;

public interface Capitulable {
	/**
     * Ejecuta la acción sobre la criatura y puede modificar el flujo del juego.
     * @param criatura El jugador actual.
     * @param reader Para recibir entradas.
     * @param util Utilidades de Codex.
	 * @return 
     */
	Criatura ejecutar(Criatura criatura, LineReader reader, Codex util);
}
