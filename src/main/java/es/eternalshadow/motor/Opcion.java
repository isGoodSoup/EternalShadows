package es.eternalshadow.motor;
public class Opcion {
    private String texto;
    private String siguienteEscenaId;
    private Runnable accion; // esto se ejecuta al elegir la opción

    public Opcion(String texto, String siguienteEscenaId, Runnable accion) {
        this.texto = texto;
        this.siguienteEscenaId = siguienteEscenaId;
        this.accion = accion;
    }

    public String getTexto() { return texto; }
    public String getSiguienteEscenaId() { return siguienteEscenaId; }

    public void ejecutarAccion() {
        if (accion != null) accion.run();
    }
}


