package es.eternalshadow.story;

public abstract class Historia {
	private String titulo;
	private Capitulo[] capitulos;
	
	public Historia(String titulo, Capitulo[] capitulos) {
		super();
		this.titulo = titulo;
		this.capitulos = capitulos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Capitulo[] getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(Capitulo[] capitulos) {
		this.capitulos = capitulos;
	}
}
