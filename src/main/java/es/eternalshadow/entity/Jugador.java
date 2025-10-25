package es.eternalshadow.entity;

import es.eternalshadow.main.Panel;

public class Jugador {
	private Panel panel;

	public Jugador(Panel panel) {
		super();
		this.panel = panel;
	}

	public Panel getPanel() {
		return panel;
	}

	public void setPanel(Panel panel) {
		this.panel = panel;
	}
}
