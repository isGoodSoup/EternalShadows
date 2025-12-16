package es.eternalshadow.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.eternalshadow.enums.Dificultad;
import es.eternalshadow.enums.Menu;
import es.eternalshadow.enums.MenuOpciones;
import es.eternalshadow.exception.GameException;
import es.eternalshadow.main.GameContext;

public class MenuService {
    private final GameContext context;
    private static final Logger log = LoggerFactory.getLogger(MenuService.class);

    public MenuService(GameContext context) {
        super();
        this.context = context;
    }

    /**
     * Procesa el menu principal y lo desglosa en 4 partes
     */
    public void menuPrincipal(List<String> credenciales)
            throws IOException, InterruptedException, GameException {
        boolean salir = false;

        String[] opciones = Arrays.stream(Menu.values())
                .map(Menu::getTexto)
                .toArray(String[]::new);

        while (!salir) {
            pintarLogo("./docs/logo.txt");
            int opcion = context.getUtil().crearMenu(context.getReader(), opciones, "Introduce tu opción");
            Menu menuSeleccionado = Menu.fromCodigo(opcion);

            salir = opcionesMenu(menuSeleccionado);
        }
    }

    private boolean opcionesMenu(Menu menu) throws GameException, InterruptedException {
        if (menu == null) return false;

        switch (menu) {
            case COMENZAR -> context.getServices().getGameService().iniciarPartida();
            case OPCIONES -> menuOpciones();
            case SALIR -> {
                log.debug("Salida");
                return true;
            }
            case DEBUG -> modoDebug();
        }
        return false;
    }

    private void menuOpciones() throws GameException, InterruptedException {
        boolean volver = false;

        String[] opciones = Arrays.stream(MenuOpciones.values())
                .map(MenuOpciones::getTexto)
                .toArray(String[]::new);

        while (!volver) {
            int opcion = context.getUtil().crearMenu(context.getReader(), opciones, "Opciones");
            MenuOpciones seleccion = MenuOpciones.fromCodigo(opcion);

            volver = menuOpciones(seleccion);
        }
    }

    private boolean menuOpciones(MenuOpciones menu) throws GameException {
        if (menu == null) return false;

        switch (menu) {
            case DIFICULTAD -> {
                Dificultad nueva = Dificultad.NORMAL;
                log.debug("Dificultad seleccionada: " + nueva);
                return true;
            }
            case STATS -> stats();
            case VOLVER -> {
                return true;
            }
        }
        return false;
    }

    private void modoDebug() {
        log.debug("Dev mode");
        context.getHistoria().iniciar(context.getUtil().crearPersonaje(), context.getReader(), context.getUtil());
    }

    private void stats() {
        // TODO Stats
    }

    private void pintarLogo(String ruta) throws IOException, InterruptedException {
    	System.out.println();
        for (String linea : context.getUtil().toLeerArchivo(ruta)) {
            System.out.println(linea);
            Thread.sleep(50);
        }
        System.out.println();
    }
}
