package es.eternalshadow.interfaces;

import org.jline.reader.LineReader;

import es.eternalshadow.entidades.Criatura;

public interface Capitulable {
	Criatura ejecutar(Criatura criatura, LineReader reader);
	void lineas();
}
