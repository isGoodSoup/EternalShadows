package es.eternalshadow.story;

import java.util.ArrayList;
import java.util.List;

import org.jline.reader.LineReader;

import es.eternalshadow.entity.Criatura;
import es.eternalshadow.util.Utilidades;

public abstract class Historia {
	private String titulo;
	private List<Capitulo> capitulos;
	
	public Historia(String titulo) {
		super();
		this.titulo = titulo;
		this.capitulos = new ArrayList<>();
	}
	
	public abstract Criatura iniciar(LineReader reader, Utilidades util);
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Capitulo> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}
}
