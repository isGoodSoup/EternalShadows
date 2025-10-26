package es.eternalshadow.story;

import org.jline.reader.LineReader;

import es.eternalshadow.interfaces.Capitulable;

public abstract class Capitulo extends Historia implements Capitulable {
	private String nombre;
	private int numero;
	private String[] lineas;

	public Capitulo(String titulo, String nombre, int numero) {
		super(titulo);
		this.nombre = nombre;
		this.numero = numero;
	}
	
	public void mostrarLinea(LineReader reader) {
		for (String linea : getLineas()) {
            if (linea == null) break;
            System.out.print(linea);
            reader.readLine();
        }
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

	public String[] getLineas() {
		return lineas;
	}

	public void setLineas(String[] lineas) {
		this.lineas = lineas;
	}
}
