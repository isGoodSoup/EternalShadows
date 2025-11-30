package es.eternalshadow.story;

import org.jline.reader.LineReader;

import es.eternalshadow.pojos.Criatura;
import es.eternalshadow.util.Codex;

public class HistoriaPrincipal extends Historia {
	
	public HistoriaPrincipal(String titulo) {
	    super(titulo);
	}

	@Override
	public Criatura iniciar(LineReader reader, Codex util) {
		Criatura criatura = null;
	    int actual = 1;
	    while (actual <= getCapitulos().size()) {
	        Capitulo cap = getCapitulos().get(actual - 1);
	        util.setProximoCapitulo(actual + 1);
	        criatura = cap.ejecutar(criatura, reader, util);
	        actual = util.getProximoCapitulo();
	    }
	    return criatura;
	}
}
