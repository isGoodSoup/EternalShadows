package es.eternalshadow.acciones;

import org.jline.reader.LineReader;

import es.eternalshadow.enums.Ruta;
import es.eternalshadow.interfaces.Capitulable;
import es.eternalshadow.pojos.Criatura;
import es.eternalshadow.util.Codex;

public class Opciones implements Capitulable {
	private String texto;
    private int capituloDestino;
    private Ruta ruta;

    public Opciones(String texto, int capituloDestino, String rutaStr) {
        this.texto = texto;
        this.capituloDestino = capituloDestino;
        this.ruta = Ruta.valueOf(rutaStr.toUpperCase());
    }
    
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getCapituloDestino() {
		return capituloDestino;
	}

	public void setCapituloDestino(int capituloDestino) {
		this.capituloDestino = capituloDestino;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	@Override
    public Criatura ejecutar(Criatura criatura, LineReader reader, Codex util) {
        System.out.println(texto);
        int eleccion = Codex.toScanInteger(reader, "Elige esta opción? (1 para sí, 0 para no)");
        if (eleccion == 1) {
            util.setProximoCapitulo(capituloDestino);
            util.setRuta(ruta);
        }
        return criatura;
    }
}
