package es.eternalshadow.story;

import java.util.ArrayList;
import java.util.List;

import es.eternalshadow.main.Panel;
import es.eternalshadow.motor.Escena;
import es.eternalshadow.util.Codex;

public class Capitulo {
	private Panel panel;
	private String nombre;
	private int numero;
	private List<String> lineas = new ArrayList<>();
	private Codex util;
	private Escena escena;
	
	public Capitulo() {}

	public Capitulo(int numero, Panel panel, String nombre, Escena escena) {
		this.panel = panel;
		this.numero = numero;
		this.nombre = nombre;
		this.escena = escena;
		this.util = new Codex(panel);
	}

	public Panel getPanel() {
		return panel;
	}

	public void setPanel(Panel panel) {
		this.panel = panel;
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

	public Escena getEscena() {
		return escena;
	}

	public void setEscena(Escena escena) {
		this.escena = escena;
	}
}
