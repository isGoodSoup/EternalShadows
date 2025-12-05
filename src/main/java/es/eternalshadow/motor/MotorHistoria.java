package es.eternalshadow.motor;
import java.util.Map;

public class MotorHistoria {
    private Map<String, Escena> escenas;
    private Escena escenaActual;

    public MotorHistoria(Map<String, Escena> escenas, String escenaInicial) {
        this.escenas = escenas;
        this.escenaActual = escenas.get(escenaInicial);
    }

    public Escena getEscenaActual() { return escenaActual; }

    public void elegirOpcion(int index) {
        Opcion seleccionada = escenaActual.getOpciones().get(index);
        seleccionada.ejecutarAccion();
        escenaActual = escenas.get(seleccionada.getSiguienteEscenaId());
    }
}
