package es.eternalshadow.story;

import org.jline.reader.LineReader;

import es.eternalshadow.enums.Ruta;
import es.eternalshadow.interfaces.Capitulable;

public abstract class Capitulo implements Capitulable {
	private String nombre;
	private int numero;
	private String[] lineas;
	private Ruta ruta;

	public Capitulo(String titulo, String nombre, int numero) {
		super();
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
	
	public void leerDestino(LineReader reader, String[] lineas) {
		for (String linea : lineas) {
            if (linea == null) break;
            System.out.print(linea);
            reader.readLine();
        }
	}
	
	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
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
