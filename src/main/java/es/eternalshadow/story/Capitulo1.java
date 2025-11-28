package es.eternalshadow.story;

import org.jline.reader.LineReader;

import es.eternalshadow.entidades.Criatura;
import es.eternalshadow.util.Codex;

/**
 * Capítulo I: introducción y creación del personaje.
 */

public class Capitulo1 extends Capitulo {

	public Capitulo1() {
		super("Capitulo I", "Los Ecos de Noxterra", 1);
		setLineas(lineas());
	}

	@Override
	public Criatura ejecutar(Criatura criatura, LineReader reader) {
		reader.readLine();
        mostrarLinea(reader);
        Codex util = new Codex();
        criatura = util.crearPersonaje(reader);
     
        return criatura;
	}

	@Override
	public void lineas() {
		
	}
}
