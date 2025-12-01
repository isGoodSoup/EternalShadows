package es.eternalshadow.story;

import java.util.ArrayList;
import java.util.List;

import org.jline.reader.LineReader;

import es.eternalshadow.enums.Ruta;
import es.eternalshadow.interfaces.Capitulable;
import es.eternalshadow.pojos.Criatura;
import es.eternalshadow.util.Codex;

/*
 * Clase que representa un capítulo de la historia.
 * Define métodos para mostrar líneas de texto y leer destinos según decisiones.
 */
public class Capitulo implements Capitulable {
	private String nombre;
	private int numero;
	private List<String> lineas = new ArrayList<>();
	private Ruta ruta;
	private Codex util = new Codex();

	public Capitulo(String nombre, int numero) {
		super();
		this.nombre = nombre;
		this.numero = numero;
	}
	
	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public List<String> getLineas() {
		return lineas;
	}

	public void setLineas(List<String> lineas) {
		this.lineas = lineas;
	}
	
	public Codex getUtil() {
		return util;
	}

	public void setUtil(Codex util) {
		this.util = util;
	}

	public void mostrarLineas(LineReader reader) {
		for (String linea : lineas) {
	        System.out.println(linea);
	        reader.readLine();
	    }
	}

	@Override
	public Criatura ejecutar(Criatura criatura, LineReader reader, Codex util) {
		return null;
	}
}
