package es.eternalshadow.main;

import es.eternalshadow.util.Utilidades;

public class Panel {
	private Utilidades util = new Utilidades();
	private String[] lineas = util.lineas();
	private int nextLine;
	private int opcion;
	
	public void intro() {
		util.print(nextLine());
		util.print(nextLine());
	}
	
	public void comenzar() {
		intro();
		String[] menu = {"Comenzar Aventura", "Salir"};
		util.toGetString("Eternal Shadows ⚔️");
		opcion = util.crearMenu(menu, "Introduce tu opción");
		util.toScan();
		do {
			switch(opcion) {
				case 1 -> {
					String linea;
			        while((linea = nextLine()) != null) {
			            util.print(linea);
			        }
				}
			}
		} while(opcion > 2);
	}
	
	public String nextLine() {
		if (nextLine >= lineas.length) return null;
        return lineas[nextLine++];
    }
	
	public Utilidades getUtil() {
		return util;
	}

	public void setUtil(Utilidades util) {
		this.util = util;
	}
}
