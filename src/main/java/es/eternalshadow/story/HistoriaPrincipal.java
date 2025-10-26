package es.eternalshadow.story;

import org.jline.reader.LineReader;

import es.eternalshadow.entity.Criatura;
import es.eternalshadow.util.Utilidades;

public class HistoriaPrincipal extends Historia {
	
	public HistoriaPrincipal(String titulo) {
	    super(titulo);
	    getCapitulos().add(new Capitulo1());
	    getCapitulos().add(new Capitulo2());
	}

	@Override
	public Criatura iniciar(LineReader reader, Utilidades util) {
	    Criatura criatura = null;
	    for(Capitulo capitulo : getCapitulos()) {
	        criatura = capitulo.ejecutar(criatura, reader);
	    }
	    return criatura;
	}
}
