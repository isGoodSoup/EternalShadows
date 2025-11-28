package es.eternalshadow.story;

import org.jline.reader.LineReader;

import es.eternalshadow.entidades.Criatura;
import es.eternalshadow.enums.Ruta;
import es.eternalshadow.util.Codex;

/**
 * Capítulo II: continuación de la historia y elección
 * del camino.
 */

public class Capitulo2 extends Capitulo {

	public Capitulo2() {
		super("Capitulo II", "El Sendero de los Condenados", 1);
		setLineas(lineas());
	}

	@Override
	public Criatura ejecutar(Criatura criatura, LineReader reader) {
		reader.readLine();
		mostrarLinea(reader);
		String[] menu = {"El pueblo abandonado", "La cueva oscura", "El templo"};
		Codex util = new Codex();
		int opcion = util.crearMenu(reader, menu, "Elige tu camino");
		do {
			switch(opcion) {
				case 1 -> { setRuta(Ruta.ALFA); leerDestino(reader, lineas1()); }
				case 2 -> { setRuta(Ruta.BETA); leerDestino(reader, lineas2()); }
				case 3 -> { setRuta(Ruta.OMEGA); leerDestino(reader, lineas3()); }
			}
		} while(opcion > 3);
		return criatura;
	}
	
	@Override
	public void lineas() {
		
	}
}
