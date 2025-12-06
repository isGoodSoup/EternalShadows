package es.eternalshadow.util;

import java.util.Random;

import es.eternalshadow.main.Panel;

/**
 * Simula el lanzamiento de dos dados de 20 caras.
 * 
 * @return Arreglo con los resultados de los dos dados.
 */
public class Dados {
	private Panel panel;
	private static Random random = new Random();

	public Dados(Panel panel) {
		super();
		this.panel = panel;
	}

	public Panel getPanel() {
		return panel;
	}

	public void setPanel(Panel panel) {
		this.panel = panel;
	}

	public int lanzar() {
		return random.nextInt(21) + 1;
	}

	public int tirarDados() {
		for (int i = 0; i < 5; i++) {
			int resultado = lanzar();
			System.out.println("Lanzamiento " + (i + 1) + ": " + resultado);
		}
		return 0;
	}
}
