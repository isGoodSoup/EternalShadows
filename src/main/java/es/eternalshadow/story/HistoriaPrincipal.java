package es.eternalshadow.story;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jline.reader.LineReader;

import es.eternalshadow.entities.Criatura;
import es.eternalshadow.main.Panel;
import es.eternalshadow.pojos.Jugador;
import es.eternalshadow.util.Codex;

public class HistoriaPrincipal extends Historia {
	private Panel panel;
	private Codex util = new Codex(panel);

	public HistoriaPrincipal(String titulo, Panel panel) {
		super(titulo, panel);
		this.panel = panel;
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
			for (String linea : lineas) {
				System.out.println(linea);
				reader.readLine();
			}
		}
		util.tirarDados();
		return criatura;
	}

	public static void comprarObjetoMercader(Jugador user, String objeto, int precio) {
		if (user.getOro() >= precio) {
			user.reducirOro(precio);
			user.addArtefacto(objeto);
			System.out.println("\nHas obtenido: " + objeto);
		} else {
			System.out.println("\nNo tienes suficiente oro...");
		}
	}
}
