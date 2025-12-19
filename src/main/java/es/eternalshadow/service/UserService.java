package es.eternalshadow.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jline.reader.LineReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.eternalshadow.enums.MenuSesiones;
import es.eternalshadow.enums.RolUsuario;
import es.eternalshadow.exception.GameException;
import es.eternalshadow.main.GameContext;
import es.eternalshadow.util.InputHandler;

public class UserService {
    private GameContext context;
    private RolUsuario rol;
    private List<String> credenciales;
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    public UserService(GameContext context) {
        this.context = context;
        this.rol = RolUsuario.JUGADOR;
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
	
	public RolUsuario getRol() {
		return rol;
	}

	public void setRol(RolUsuario rol) {
		this.rol = rol;
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
            int opcion = context.getUtil().getInputHandler().crearMenu(context.getReader(), opciones, "Introduce tu opción");
            MenuSesiones menu = MenuSesiones.fromCodigo(opcion);

            salir = sesionesMenu(menu);
        }
        return credenciales;
    }

    private boolean sesionesMenu(MenuSesiones menu) throws GameException, InterruptedException {
        if (menu == null) {
            context.getUtil().getConsolePrinter().limpiarPantalla();
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
        String usuario = InputHandler.toScan(reader, "Usuario");
        String password = InputHandler.toScan(reader, "Contraseña");
        if(usuario.equals("admin")) {
        	rol = RolUsuario.ADMIN;
        }
        credenciales = new ArrayList<>(List.of(usuario, password));
        return credenciales;
    }

    private List<String> registrarUsuario() {
    	LineReader reader = context.getReader();
    	String email = InputHandler.toScan(reader, "Email");
    	String usuario = InputHandler.toScan(reader, "Usuario");
        String password = InputHandler.toScan(reader, "Contraseña");
        credenciales = new ArrayList<>(List.of(email, usuario, password));
        return credenciales;
    }
}
