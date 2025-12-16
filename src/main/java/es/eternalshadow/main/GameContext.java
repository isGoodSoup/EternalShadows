package es.eternalshadow.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jline.reader.LineReader;

import es.eternalshadow.entities.Criatura;
import es.eternalshadow.interfaces.Accion;
import es.eternalshadow.pojos.Jugador;
import es.eternalshadow.service.ServiceFactory;
import es.eternalshadow.story.Historia;
import es.eternalshadow.util.Codex;

public class GameContext {
	private final ServiceFactory services;
	private Historia historia;
	private Jugador jugador;
	private final LineReader reader;
	private final Codex util;
	private List<Criatura> criaturas;
	private final Map<String, Accion> acciones;

	public GameContext(Historia historia, Jugador jugador, LineReader reader,
			Codex util, Map<String, Accion> acciones, ServiceFactory services) {
		super();
		this.services = services;
		this.historia = historia;
		this.jugador = jugador;
		this.reader = reader;
		this.util = util;
		this.acciones = new HashMap<>(acciones);
		this.criaturas = new ArrayList<>();
	}

	public ServiceFactory getServices() {
		return services;
	}

	public Historia getHistoria() {
		return historia;
	}
	
	public void setHistoria(Historia historia) {
		this.historia = historia;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public LineReader getReader() {
		return reader;
	}

	public Codex getUtil() {
		return util;
	}

	public List<Criatura> getCriaturas() {
		return criaturas;
	}

	public void setCriaturas(List<Criatura> criaturas) {
		this.criaturas = criaturas;
	}

	public Map<String, Accion> getAcciones() {
		return acciones;
	}
}
