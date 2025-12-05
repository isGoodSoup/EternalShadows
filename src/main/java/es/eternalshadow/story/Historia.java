package es.eternalshadow.story;

import java.util.ArrayList;
import java.util.List;

import org.jline.reader.LineReader;

import es.eternalshadow.entities.Criatura;
import es.eternalshadow.main.Panel;
import es.eternalshadow.util.Codex;

public abstract class Historia {
	private String titulo;
	private Panel panel;
	private Codex util = new Codex(panel);
	private List<Capitulo> capitulos;

	public Historia(String titulo, Panel panel) {
		super();
		this.titulo = titulo;
		this.panel = panel;
		this.capitulos = new ArrayList<>();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Panel getPanel() {
		return panel;
	}

	public void setPanel(Panel panel) {
		this.panel = panel;
	}

	public Codex getUtil() {
		return util;
	}

	public void setUtil(Codex util) {
		this.util = util;
	}

	public List<Capitulo> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}

	public abstract Criatura iniciar(Criatura crearPersonaje, LineReader reader, Codex util);
}