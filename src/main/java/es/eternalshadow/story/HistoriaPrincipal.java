package es.eternalshadow.story;

import java.io.IOException;
import java.util.List;

import org.jline.reader.LineReader;

import es.eternalshadow.entities.Criatura;
import es.eternalshadow.main.GameContext;
import es.eternalshadow.main.Panel;
import es.eternalshadow.util.Codex;

public class HistoriaPrincipal extends Historia {
	private final GameContext context;
	
	public HistoriaPrincipal(String titulo, Panel panel, GameContext context) {
		super(titulo, panel);
		this.context = context;
	}

	@Override
	public List<Criatura> iniciar(List<Criatura> criaturas, LineReader reader, Codex util) {
		for (int i = 0; i < getCapitulos().size(); i++) {
		    try {
		        Capitulo capitulo = context.getServices().getCapitulosLoader().cargarCapitulo(
		            "./docs/mq/capitulo" + getCapitulos().get(i).getNumero() + ".txt",
		            criaturas,
		            context.getJugador()
		        );
		        getCapitulos().set(i, capitulo);
		    } catch (IOException e) {
		        Codex.printException(e);
		    }
		}
		return criaturas;
	}
}
