package es.eternalshadow.pojos;

public class Demonio extends Criatura {
	
	public Demonio() {}

	public Demonio (int id, String nombre, String tipo, int fuerza, int resistencia, int velocidad,
			int magia) {
		super(id, tipo, fuerza, resistencia, velocidad, magia);
	}

	@Override
	public void atacar() {
		super.atacar();
	}

	@Override
	public void defender() {
		super.defender();
	}
}
