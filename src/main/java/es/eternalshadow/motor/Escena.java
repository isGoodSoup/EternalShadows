package es.eternalshadow.motor;
import java.util.List;
public class Escena {
	    private String texto;
	    private List<Opcion> opciones; // Opciones disponibles

	    public Escena(String texto, List<Opcion> opciones) {
	        this.texto = texto;
	        this.opciones = opciones;
	    }

	    public String getTexto() { return texto; }
	    public List<Opcion> getOpciones() { return opciones; }
	}


