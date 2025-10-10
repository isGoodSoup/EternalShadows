package es.eternalshadow.entity;

public class Demonio extends Criatura {
	private boolean isCuernos;

	public Demonio(String nombre, int fuerza, int resistencia, int velocidad, int magia) {
		super();
	}
	
	public boolean isCuernos() {
		return isCuernos;
	}

	public void setCuernos(boolean isCuernos) {
		this.isCuernos = isCuernos;
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
