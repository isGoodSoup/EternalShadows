package es.eternalshadow.pojos;

public abstract class Armas extends Item {
	private String nombreArma;
	private String tipoArma;

	public Armas(String nombre, String tipo, int cantidad, String nombreArma,
			String tipoArma) {
		super(nombre, tipo, cantidad);
		this.nombreArma = nombreArma;
		this.tipoArma = tipoArma;
	}

	public String getNombreArma() {
		return nombreArma;
	}

	public void setNombreArma(String nombreArma) {
		this.nombreArma = nombreArma;
	}

	public String getTipoArma() {
		return tipoArma;
	}

	public void setTipoArma(String tipoArma) {
		this.tipoArma = tipoArma;
	}
}
