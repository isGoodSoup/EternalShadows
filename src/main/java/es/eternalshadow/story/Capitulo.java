package es.eternalshadow.story;

public abstract class Capitulo extends Historia {
	private String nombre;
	private int numero;

	public Capitulo(String titulo, Capitulo[] capitulos, String nombre, int numero) {
		super(titulo, capitulos);
		this.nombre = nombre;
		this.numero = numero;
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
}
