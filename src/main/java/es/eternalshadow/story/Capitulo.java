package es.eternalshadow.story;

import java.util.ArrayList;
import java.util.List;

import org.jline.reader.LineReader;

import es.eternalshadow.entities.Criatura;
import es.eternalshadow.enums.Ruta;
import es.eternalshadow.interfaces.Capitulable;
import es.eternalshadow.main.Panel;
import es.eternalshadow.motor.Escena;
import es.eternalshadow.motor.Opcion;
import es.eternalshadow.util.Codex;

public class Capitulo implements Capitulable {
	private Panel panel;
	private String nombre;
	private int numero;
	private Ruta ruta;
	private List<String> lineas = new ArrayList<>();
	private Codex util = new Codex(panel);
	private Escena escena;

	public Capitulo(String nombre, int numero, Escena escena, Panel panel) {
		this.panel = panel;
		this.nombre = nombre;
		this.numero = numero;
		this.escena = escena;
	}

	public Panel getPanel() {
		return panel;
	}

	public void setPanel(Panel panel) {
		this.panel = panel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public List<String> getLineas() {
		return lineas;
	}

	public void setLineas(List<String> lineas) {
		this.lineas = lineas;
	}

	public Codex getUtil() {
		return util;
	}

	public void setUtil(Codex util) {
		this.util = util;
	}

	public Escena getEscena() {
		return escena;
	}

	public void setEscena(Escena escena) {
		this.escena = escena;
	}

	public void mostrarLineas(LineReader reader) {
		for (String linea : lineas) {
			System.out.println(linea);
			reader.readLine();
		}
	}

	@Override
	public Criatura ejecutar(Criatura criatura, LineReader reader, Codex util) {
		mostrarLineas(reader);
		if (escena == null) {
			return criatura;
		}
		Escena actual = escena;
		while (actual != null) {
			System.out.println("\n" + actual.getDescripcion() + "\n");
			List<Opcion> opciones = actual.getOpciones();
			for (int i = 0; i < opciones.size(); i++) {
				System.out.println((i + 1) + ". " + opciones.get(i).getTexto());
			}

			int indiceElegido;
			try {
				String input = reader.readLine("\nElige opción > ");
				indiceElegido = Integer.parseInt(input) - 1;
			} catch (Exception e) {
				System.out.println("Entrada inválida.");
				continue;
			}
			if (indiceElegido < 0 || indiceElegido >= opciones.size()) {
				System.out.println("Opción no válida.");
				continue;
			}
			Opcion opcionElegida = opciones.get(indiceElegido);
			opcionElegida.ejecutarAccion();
			actual = opcionElegida.getEscenaDestino();
		}
		return criatura;
	}
}
