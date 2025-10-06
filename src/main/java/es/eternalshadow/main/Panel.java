package es.eternalshadow.main;

import es.eternalshadow.util.Personaje;

public class Panel {
	private Personaje persona;
	
	public Panel() {
		
	}
	
	public void run() {
		persona.crearPersonaje(0, 0, 0, 0);
	}
	
	public Personaje getPersona() {
		return persona;
	}

	public void setPersona(Personaje persona) {
		this.persona = persona;
	}
}
