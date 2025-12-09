package es.eternalshadow.pojos;

public abstract class Item {
	private String nombre;
	private String tipo;
	private int cantidad;

	public Item(String nombre, String tipo, int cantidad) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.cantidad = cantidad;
	}

	public Item(String nombre, int cantidad) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
