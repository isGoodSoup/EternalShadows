package es.eternalshadow.main;

import es.eternalshadow.interfaces.Iniciable;

public class Main implements Iniciable {
	private Panel panel = new Panel();
	
	public static void main(String[] args) {
		Main main = new Main();
		main.init();
	}
	
	@Override
	public void init() {
		panel.comenzar();
	}
}
