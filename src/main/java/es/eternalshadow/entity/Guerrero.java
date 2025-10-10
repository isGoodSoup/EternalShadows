package es.eternalshadow.entity;

public class Guerrero extends Criatura {
	private String genero;
	
	public Guerrero(String nombre, int fuerza, int resistencia, int velocidad, int magia) {
		super();
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
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
