package es.eternalshadow.main;

/*
 * Main para iniciar el programa.
 */

public class Main {
	private Panel panel = new Panel();
	
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
	
	public void run() {
		panel.comenzar();
	}
}
