package es.eternalshadow.pojos;

public abstract class Escudos extends Item {
	private String nombreEscudo;
	private String tipoEscudo;

	public Escudos(String nombre, String tipo, int cantidad,
			String nombreEscudo, String tipoEscudo) {
		super(nombre, tipo, cantidad);
		this.nombreEscudo = nombreEscudo;
		this.tipoEscudo = tipoEscudo;
	}

	public String getNombreEscudo() {
		return nombreEscudo;
	}

	public void setNombreEscudo(String nombreEscudo) {
		this.nombreEscudo = nombreEscudo;
	}

	public String getTipoEscudo() {
		return tipoEscudo;
	}

	public void setTipoEscudo(String tipoEscudo) {
		this.tipoEscudo = tipoEscudo;
	}
}
