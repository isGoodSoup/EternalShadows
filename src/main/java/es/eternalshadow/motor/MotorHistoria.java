package es.eternalshadow.motor;
import java.util.Map;

public class MotorHistoria {
    private Escena escenaActual;

    public MotorHistoria(Escena escenaInicial) {
        this.escenaActual = escenaInicial;
    }

    public MotorHistoria(Map<String, Escena> mapa, String string) {
		// TODO Constructor generado automáticamente
	}

	public void mostrarEscena() {
        System.out.println("\n" + escenaActual.getDescripcion() + "\n");

        for (int i = 0; i < escenaActual.getOpciones().size(); i++) {
            System.out.println((i + 1) + ". " + escenaActual.getOpciones().get(i).getTexto());
        }
    }

    public void elegirOpcion(int indice) {
        if (indice < 1 || indice > escenaActual.getOpciones().size()) {
            System.out.println("Opción no válida.");
            return;
        }

        Opcion opcionElegida = escenaActual.getOpciones().get(indice - 1);
        this.escenaActual = opcionElegida.getEscenaDestino();
    }
}