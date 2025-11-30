package es.eternalshadow.acciones;

import org.jline.reader.LineReader;

import es.eternalshadow.interfaces.Capitulable;
import es.eternalshadow.pojos.Criatura;
import es.eternalshadow.util.Codex;

public class CrearCriatura implements Capitulable {

	public CrearCriatura() {
		super();
	}

	@Override
	public Criatura ejecutar(Criatura criatura, LineReader reader, Codex util) {
		return util.crearPersonaje(reader);
	}
}
