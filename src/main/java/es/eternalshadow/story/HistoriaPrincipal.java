package es.eternalshadow.story;

import java.io.IOException;
import java.util.List;

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
	public List<Criatura> iniciar(List<Criatura> criaturas, LineReader reader, Codex util) {
		for (int i = 0; i < getCapitulos().size(); i++) {
		    try {
		        Capitulo capitulo = panel.cargarCapitulo(
		            "./docs/mq/capitulo" + getCapitulos().get(i).getNumero() + ".txt",
		            criaturas,
		            panel.getJugador()
		        );
		        getCapitulos().set(i, capitulo);
		    } catch (IOException e) {
		        Codex.printException(e);
		    }
		}
		return criaturas;
	}
}
