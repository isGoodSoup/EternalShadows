package es.eternalshadow.story;

import java.util.ArrayList;
import java.util.List;

import org.jline.reader.LineReader;

import es.eternalshadow.pojos.Criatura;
import es.eternalshadow.util.Codex;

/**
 * Clase abstracta que representa una historia interactiva.
 * Contiene una lista de capítulos y define el método para iniciar la historia.
 */

public abstract class Historia {
	private String titulo;
	private List<Capitulo> capitulos;
	
	public Historia(String titulo) {
		super();
		this.titulo = titulo;
		this.capitulos = new ArrayList<>();
	}
	
	public abstract Criatura iniciar(Criatura criatura, LineReader reader, Codex util);
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Capitulo> getCapitulos() {
		return capitulos;
	}
}
