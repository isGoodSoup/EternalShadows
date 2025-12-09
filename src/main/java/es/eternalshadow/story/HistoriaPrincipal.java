package es.eternalshadow.story;

import java.io.IOException;

import org.jline.reader.LineReader;

import es.eternalshadow.entities.Criatura;
import es.eternalshadow.main.Panel;
import es.eternalshadow.util.Codex;

public class HistoriaPrincipal extends Historia {
	private Panel panel;

	public HistoriaPrincipal(String titulo, Panel panel) {
		super(titulo, panel);
		this.panel = panel;
	}

	@Override
	public Criatura iniciar(Criatura criatura, LineReader reader, Codex util) {
		for (int i = 0; i < getCapitulos().size(); i++) {
		    try {
		        Capitulo capitulo = util.cargarCapitulo(
		            "./docs/mq/capitulo" + getCapitulos().get(i).getNumero() + ".txt",
		            panel.getJugador(),
		            criatura
		        );
		        getCapitulos().set(i, capitulo);
		    } catch (IOException e) {
		        Codex.printException(e);
		    }
		}
		return criatura;
	}
}
