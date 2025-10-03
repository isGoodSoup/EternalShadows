package es.eternalshadow.objects;

public abstract class Escudos {
	private String nombre;
	private String tipo;
	private String calidad;
	
	public Escudos(String nombre, String tipo, String calidad) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.calidad = calidad;
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

	public String getCalidad() {
		return calidad;
	}

	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}
}
