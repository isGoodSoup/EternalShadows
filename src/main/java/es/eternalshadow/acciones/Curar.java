package es.eternalshadow.acciones;

import org.jline.reader.LineReader;

import es.eternalshadow.interfaces.Capitulable;
import es.eternalshadow.pojos.Criatura;
import es.eternalshadow.util.Codex;

public class Curar implements Capitulable {
	private int cantidad;
	
	public Curar(int cantidad) {
		super();
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public Criatura ejecutar(Criatura criatura, LineReader reader, Codex util) {
		if (criatura != null) {
            criatura.setPuntosVida(criatura.getPuntosVida() + cantidad);
            System.out.println("¡Te has curado " + cantidad + " puntos de vida!");
        }
		return criatura;
	}
}
