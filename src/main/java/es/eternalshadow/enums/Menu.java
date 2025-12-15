package es.eternalshadow.enums;

public enum Menu {
	COMENZAR(1), SALIR(2), DEBUG(700);

	private final int codigo;

	Menu(int codigo) {
		this.codigo = codigo;
	}

	public static Menu fromCodigo(int codigo) {
		for (Menu m : values()) {
			if (m.codigo == codigo) {
				return m;
			}
		}
		return null;
	}
}
