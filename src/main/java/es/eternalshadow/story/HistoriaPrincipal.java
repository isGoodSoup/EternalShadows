package es.eternalshadow.story;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jline.reader.LineReader;

import es.eternalshadow.pojos.Criatura;
import es.eternalshadow.util.Codex;

public class HistoriaPrincipal extends Historia {
	
	public HistoriaPrincipal(String titulo) {
	    super(titulo);
	    nuevoCapitulo("Los Ecos de Noxterra", 1);
	    nuevoCapitulo("El Sendero de los Condenados", 2);
	}

	@Override
	public Criatura iniciar(Criatura criatura, LineReader reader, Codex util) {
		for (Capitulo capitulo : getCapitulos()) {
			List<String> lineas = new ArrayList<>();
			try {
				lineas = util.toLeerArchivo("./docs/mq/capitulo" + capitulo.getNumero() + ".txt");
			} catch (IOException e) {
				Codex.printException(e);
			}
			for(String linea : lineas) {
				System.out.println(linea);
				reader.readLine();
			}
		}
		return criatura;
	}
	
	public Capitulo nuevoCapitulo(String titulo, int numero) {
		Capitulo c = new Capitulo(titulo, numero);
		getCapitulos().add(c);
		return c;
	}
}
