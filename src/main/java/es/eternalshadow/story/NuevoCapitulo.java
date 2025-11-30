package es.eternalshadow.story;

import java.util.ArrayList;
import java.util.List;

import org.jline.reader.LineReader;

import es.eternalshadow.interfaces.Capitulable;
import es.eternalshadow.pojos.Criatura;
import es.eternalshadow.util.Codex;

public class NuevoCapitulo extends Capitulo {
	private List<Capitulable> acciones = new ArrayList<>();
	
	public NuevoCapitulo(String titulo, String nombre, int numero, List<String> lineas) {
        super(titulo, nombre, numero);
        setLineas(lineas);
    }
	
	public List<Capitulable> getAcciones() {
	    return acciones;
	}

	@Override
    public Criatura ejecutar(Criatura criatura, LineReader reader, Codex util) {
        for (Capitulable accion : acciones) {
            accion.ejecutar(criatura, reader, util);
        }
        if (util.getProximoCapitulo() == getNumero()) {
            util.setProximoCapitulo(getNumero() + 1);
        }
        return criatura;
    }

}
