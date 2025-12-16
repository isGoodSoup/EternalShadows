package es.eternalshadow.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Clase service para leer, guardar y checar si existe el 
 * archivo de EULA para las condiciones de uso del juego
 */
public class EULAService {
    private final Path rutaEula;

    public EULAService(String ruta) {
        this.rutaEula = Path.of(ruta);
    }

    public boolean isExiste() {
        return Files.exists(rutaEula);
    }
    
    public boolean isAceptado() throws IOException {
        List<String> lineas = Files.readAllLines(rutaEula);
        if (lineas.isEmpty()) return false;
        return Boolean.parseBoolean(lineas.get(0));
    }

    public List<String> leerTexto() throws IOException {
        List<String> lineas = Files.readAllLines(rutaEula);

        if (!lineas.isEmpty() &&
            (lineas.get(0).equalsIgnoreCase("true") ||
             lineas.get(0).equalsIgnoreCase("false"))) {
            lineas.remove(0);
        }
        return lineas;
    }
    
    public void guardar(boolean aceptado) throws IOException {
        List<String> texto = leerTexto();
        texto.add(0, String.valueOf(aceptado));
        Files.write(rutaEula, texto);
    }
}

