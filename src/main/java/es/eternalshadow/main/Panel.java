package es.eternalshadow.main;

import es.eternalshadow.util.Utilidades;

public class Panel {
	private Utilidades util = new Utilidades();
	
	public void intro() {
		System.out.println("Cuando la última luz se extinga, los nombres de los vivos serán olvidados…");
		System.out.println("Solo quedará la sombra eterna.");
	}
	
	public void comenzar() {
		intro();
		String[] menu = {"Comenzar", "Salir"};
		util.toGetString("Eternal Shadows ⚔️");
		do {
			
		} while(util.crearMenu(menu, "Introduce tu opción") > 2);
		
		
	}
}
