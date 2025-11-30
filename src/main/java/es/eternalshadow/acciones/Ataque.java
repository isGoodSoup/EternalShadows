package es.eternalshadow.acciones;

import org.jline.reader.LineReader;

import es.eternalshadow.interfaces.Capitulable;
import es.eternalshadow.pojos.Criatura;
import es.eternalshadow.util.Codex;

public class Ataque implements Capitulable {
	private int puntosDeDaño;
	
	public Ataque(int puntosDeDaño) {
		super();
		this.puntosDeDaño = puntosDeDaño;
	}
	
	public int getPuntosDeDaño() {
		return puntosDeDaño;
	}

	public void setPuntosDeDaño(int puntosDeDaño) {
		this.puntosDeDaño = puntosDeDaño;
	}

	@Override
	public Criatura ejecutar(Criatura criatura, LineReader reader, Codex util) {
		if (criatura != null) {
            int vidaActual = criatura.getPuntosVida();
            criatura.setPuntosVida(vidaActual - puntosDeDaño);
            System.out.println("¡Has recibido " + puntosDeDaño + "/" + criatura.getPuntosVida());
        }
		return criatura;
	}
}
