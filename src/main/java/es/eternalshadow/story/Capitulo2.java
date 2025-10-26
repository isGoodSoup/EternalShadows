package es.eternalshadow.story;

import org.jline.reader.LineReader;

import es.eternalshadow.entity.Criatura;
import es.eternalshadow.util.Utilidades;

public class Capitulo2 extends Capitulo {

	public Capitulo2() {
		super("Capitulo II", "La Tierra Abatida", 1);
		setLineas(lineas());
	}

	@Override
	public Criatura iniciar(LineReader reader, Utilidades util) {
        mostrarLinea(reader);
        Criatura criatura = util.crearPersonaje();
        return criatura;
	}

	@Override
	public String[] lineas() {
		return new String[] {
				"Capítulo II — El Sendero de los Condenados",
				null
		};
	}
}
