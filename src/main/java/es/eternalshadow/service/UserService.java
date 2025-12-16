package es.eternalshadow.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jline.reader.LineReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.eternalshadow.enums.MenuSesiones;
import es.eternalshadow.exception.GameException;
import es.eternalshadow.main.GameContext;
import es.eternalshadow.util.Codex;

public class UserService {
    private GameContext context;
    private List<String> credenciales;
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    public UserService(GameContext context) {
        this.context = context;
    }
    
	public List<String> getCredenciales() {
		return credenciales;
	}

	public void setCredenciales(List<String> credenciales) {
		this.credenciales = credenciales;
	}
	
    public GameContext getContext() {
		return context;
	}

	public void setContext(GameContext context) {
		this.context = context;
	}

	/**
     * Panel de inicio de sesión entre otras, registrar y salir del 
     * programa
     * @return
     * @throws IOException
     * @throws InterruptedException
     * @throws GameException
     */
    public List<String> panelDeInicio() throws IOException, InterruptedException, GameException {
        boolean salir = false;

        String[] opciones = Arrays.stream(MenuSesiones.values())
                .map(MenuSesiones::getTexto)
                .toArray(String[]::new);

        while (!salir) {
            context.getServices().getMenuService().pintarLogo("docs/logo.txt");
            int opcion = context.getUtil().crearMenu(context.getReader(), opciones, "Introduce tu opción");
            MenuSesiones menu = MenuSesiones.fromCodigo(opcion);

            salir = sesionesMenu(menu);
        }
        return credenciales;
    }

    private boolean sesionesMenu(MenuSesiones menu) throws GameException, InterruptedException {
        if (menu == null) {
            context.getUtil().limpiarPantalla();
            return false;
        }

        switch (menu) {
            case INICIAR_SESION -> {
                iniciarSesion();
                return true;
            }
            case REGISTRAR -> {
                registrarUsuario();
                return true;
            }
            case SALIR -> {
                log.debug("Salida");
                return true;
            }
        }
        return false;
    }

    private List<String> iniciarSesion() {
        LineReader reader = context.getReader();
        String usuario = Codex.toScan(reader, "Usuario");
        String password = Codex.toScan(reader, "Contraseña");
        credenciales = new ArrayList<>(List.of(usuario, password));
        return credenciales;
    }

    private List<String> registrarUsuario() {
        // TODO Registrar
        return null;
    }
}
