package es.eternalshadow.motor;

public class Opcion {
	private String texto;
	private String siguienteEscenaId;
	private Runnable accion;

	public Opcion(String texto, String siguienteEscenaId, Runnable accion) {
		this.texto = texto;
		this.siguienteEscenaId = siguienteEscenaId;
		this.accion = accion;
	}

	public String getTexto() {
		return texto;
	}

	public String getSiguienteEscenaId() {
		return siguienteEscenaId;
	}

	public void ejecutarAccion() {
		if (accion != null)
			accion.run();
	}

	public Runnable getAccion() {
		return accion;
	}

	public void setAccion(Runnable accion) {
		this.accion = accion;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setSiguienteEscenaId(String siguienteEscenaId) {
		this.siguienteEscenaId = siguienteEscenaId;
	}

	public Escena getEscenaDestino() {
		// TODO Auto-generated method stub
		return null;
	}
}