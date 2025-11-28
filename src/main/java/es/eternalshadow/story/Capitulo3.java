package es.eternalshadow.story;

import org.jline.reader.LineReader;

import es.eternalshadow.entidades.Criatura;

/**
 * Capítulo III: muestra líneas finales según la ruta elegida 
 * y prepara la lógica de combate
 */

public class Capitulo3 extends Capitulo {

	public Capitulo3() {
		super("Capitulo III", "La Encrucijada", 1);
		setLineas(lineas());
	}

	@Override
	public Criatura ejecutar(Criatura criatura, LineReader reader) {
		reader.readLine();
		mostrarLinea(reader);
		
		/*
		 * Logica de combate siempre después de mostrarLinea(reader),
		 * y antes de el switch de getRuta().
		 */
		switch(getRuta()) {
			case ALFA -> { leerDestino(reader, lineas1()); }
			case BETA -> { leerDestino(reader, lineas2()); }
			case OMEGA -> { leerDestino(reader, lineas3()); }
			default -> {}
		}
		return criatura;
	}
}
