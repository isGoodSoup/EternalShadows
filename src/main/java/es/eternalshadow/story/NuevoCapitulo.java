package es.eternalshadow.story;

import java.util.List;

import org.jline.reader.LineReader;

import es.eternalshadow.entidades.Criatura;

public class NuevoCapitulo extends Capitulo {
	
	public NuevoCapitulo(String nombre, int numero, List<String> lineas) {
        super(nombre, nombre, numero);
        setLineas(lineas);
    }
	
	@Override
	public Criatura ejecutar(Criatura criatura, LineReader reader) {
		mostrarLineas(reader);
		return criatura;
	}

	@Override
	public void cargarLineas() {
		// TODO Auto-generated method stub

	}

}
