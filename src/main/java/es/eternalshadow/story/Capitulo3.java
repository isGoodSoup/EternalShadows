package es.eternalshadow.story;

import org.jline.reader.LineReader;

import es.eternalshadow.entity.Criatura;

public class Capitulo3 extends Capitulo {

	public Capitulo3() {
		super("Capitulo III", "La Encrucijada", 1);
		setLineas(lineas());
	}

	@Override
	public Criatura ejecutar(Criatura criatura, LineReader reader) {
		reader.readLine();
		mostrarLinea(reader);
		switch(getRuta()) {
			case ALFA -> { leerDestino(reader, lineas1()); }
			case BETA -> { leerDestino(reader, lineas2()); }
			case OMEGA -> { leerDestino(reader, lineas3()); }
			default -> {}
		}
		return criatura;
	}
	
	@Override
	public String[] lineas() {
		return new String[] {
				"Capítulo III — La Encrucijada",
		};
	}
	
	private String[] lineas1() {
		return new String[] {
		};
	}
	
	private String[] lineas2() {
		return new String[] {
		};
	}
	
	private String[] lineas3() {
		return new String[] {
		};
	}
}
