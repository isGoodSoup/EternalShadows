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
import es.eternalshadow.main.Panel;

public class MenuService {
	private Panel panel;
	private static final Logger log = LoggerFactory
			.getLogger(MenuService.class);

	public MenuService(Panel panel) {
		super();
		this.panel = panel;
	}

	/**
	 * Procesa el menu principal y lo desglosa en 4 partes
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws GameException
	 */
	public void menuPrincipal(List<String> credenciales)
			throws IOException, InterruptedException, GameException {
		boolean salir = false;

		String[] opciones = Arrays.stream(Menu.values()).map(Menu::getTexto)
				.toArray(String[]::new);

		while (!salir) {
			panel.pintarLogo("./docs/logo.txt");
			panel.setOpcion(panel.getUtil().crearMenu(panel.getReader(), opciones, "Introduce tu opción"));
			panel.setMenu(Menu.fromCodigo(panel.getOpcion()));

			salir = opcionesMenu(panel.getMenu());
		}
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
	private boolean opcionesMenu(Menu menu)
			throws GameException, InterruptedException {
		if (menu == null) {
			panel.getUtil().limpiarPantalla();
			return false;
		}

		switch (menu) {
		case COMENZAR -> panel.getGameService().iniciarPartida();
		case OPCIONES -> menuOpciones();
		case SALIR -> {
			log.debug("Salida");
			return true;
		}
		case DEBUG -> modoDebug();
		}
		return false;
	}

	/**
	 * 
	 * @throws GameException
	 * @throws InterruptedException
	 */
	private void menuOpciones() throws GameException, InterruptedException {
		boolean volver = false;

		String[] opciones = Arrays.stream(MenuOpciones.values())
				.map(MenuOpciones::getTexto).toArray(String[]::new);

		while (!volver) {
			panel.setOpcion(panel.getUtil().crearMenu(panel.getReader(),
					opciones, "Opciones"));
			MenuOpciones seleccion = MenuOpciones.fromCodigo(panel.getOpcion());

			volver = menuOpciones(seleccion);
		}
	}

	/**
	 * 
	 * @param menu
	 * @return
	 * @throws GameException
	 */
	private boolean menuOpciones(MenuOpciones menu) throws GameException {

		if (menu == null) {
			panel.getUtil().limpiarPantalla();
			return false;
		}

		switch (menu) {
		case DIFICULTAD -> {
			switch (panel.getDificultad()) {
				case FACIL -> {
					panel.setDificultad(Dificultad.FACIL);
					log.debug("Dificultad: " + Dificultad.values()[0].toString());
					return true;
				}
	
				case NORMAL -> {
					panel.setDificultad(Dificultad.NORMAL);
					log.debug("Dificultad: " + Dificultad.values()[1].toString());
					return true;
				}
	
				case DIFICIL -> {
					panel.setDificultad(Dificultad.DIFICIL);
					log.debug("Dificultad: " + Dificultad.values()[2].toString());
					return true;
				}
			}
		}
		case STATS -> stats();
		case VOLVER -> {
			return true;
		}
		}
		return false;
	}

	/**
	 * Método para iniciar la partida si se ha elegido la constante Menu.SALIR
	 */
	private void modoDebug() {
		log.debug("Dev mode");
		panel.getHistoria().iniciar(panel.getUtil().crearPersonaje(),
				panel.getReader(), panel.getUtil());
	}

	private void stats() {
		// TODO Stats
	}
}
