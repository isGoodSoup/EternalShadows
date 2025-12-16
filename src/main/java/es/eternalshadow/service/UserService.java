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
import es.eternalshadow.main.Panel;
import es.eternalshadow.util.Codex;

public class UserService {
	private Panel panel;
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
	public UserService(Panel panel) {
		super();
		this.panel = panel;
	}

	/**
	 * Pantalla de inicio de sesión de usuarios ya registrados 
	 * y registro de usuarios nuevos
	 * @return List<String>
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws GameException
	 */
	public List<String> panelDeInicio() throws IOException, 
		InterruptedException, GameException {
		boolean salir = false;

		String[] opciones = Arrays.stream(MenuSesiones.values())
                .map(MenuSesiones::getTexto)
                .toArray(String[]::new);

	    while (!salir) {
	        panel.pintarLogo("./docs/logo.txt");
	        panel.setOpcion(panel.getUtil().crearMenu(panel.getReader(), opciones, "Introduce tu opción"));
	        MenuSesiones menu = MenuSesiones.fromCodigo(panel.getOpcion());
	        
	        salir = sesionesMenu(menu);
	    }
		return panel.getCredenciales();
	}
	
	/**
	 * Se le introduce un parámetro de tipo Enum y se pasa entre las opciones
	 * del switch
	 * 
	 * @param menu
	 * @return boolean
	 * @throws GameException
	 * @throws InterruptedException
	 */
	private boolean sesionesMenu(MenuSesiones menu)
			throws GameException, InterruptedException {
		if (menu == null) {
			panel.getUtil().limpiarPantalla();
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
	
	/**
	 * Inicio de sesión de usuarios
	 * 
	 * @return List<String>
	 */
	private List<String> iniciarSesion() {
		LineReader reader = panel.getReader();
		String usuario = Codex.toScan(reader, "Usuario");
		String password = Codex.toScan(reader, "Contraseña");
		panel.setCredenciales(new ArrayList<>(List.of(usuario, password)));
		return panel.getCredenciales();
	}

	/**
	 * Registro de usuarios
	 * 
	 * @return List<String>
	 */
	private List<String> registrarUsuario() {
		// TODO Registrar
		return null;
	}
}
