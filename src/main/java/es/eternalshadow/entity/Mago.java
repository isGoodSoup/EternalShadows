package es.eternalshadow.entity;

public class Mago extends Criatura {
	private String tipoMago;

	public Mago(String nombre, int fuerza, int resistencia, int velocidad, int magia) {
		super();
	}

	public String getTipoMago() {
		return tipoMago;
	}

	public void setTipoMago(String tipoMago) {
		this.tipoMago = tipoMago;
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		super.atacar();
	}

	@Override
	public void defender() {
		// TODO Auto-generated method stub
		super.defender();
	}
}
