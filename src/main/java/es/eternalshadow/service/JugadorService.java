package es.eternalshadow.service;

import java.util.List;

import es.eternalshadow.dao.JugadorDAOImpl;
import es.eternalshadow.dao.interfaces.JugadorDAO;
import es.eternalshadow.dto.JugadorDTO;
import es.eternalshadow.entities.Jugador;

public class JugadorService {
    private JugadorDAO jugadorDAO;

    public JugadorService() {
        this.jugadorDAO = new JugadorDAOImpl();
    }

    public void crearJugador(JugadorDTO dto) {
        Jugador jugador = new Jugador(
            dto.getNombre(),
            dto.getTipo(),
            dto.getNivel(),
            dto.getPuntosVida(),
            dto.getMoral(),
            dto.getArmas(),
            dto.getEscudos(),
            dto.getInventario()
        );
        jugadorDAO.guardar(jugador);
    }
    
    public void eliminarJugador(Long id) {
        jugadorDAO.eliminar(id);
    }

    public void actualizarJugador(JugadorDTO dto) {
        Jugador jugador = (Jugador) jugadorDAO.obtenerPorId(dto.getId());
        if (jugador != null) {
            jugador.setNombre(dto.getNombre());
            jugador.setTipo(dto.getTipo());
            jugador.setNivel(dto.getNivel());
            jugador.setPuntosVida(dto.getPuntosVida());
            jugador.setMoral(dto.getMoral());
            jugador.setArmas(dto.getArmas());
            jugador.setEscudos(dto.getEscudos());
            jugador.setInventario(dto.getInventario());

            jugadorDAO.actualizar(jugador);
        }
    }

    public JugadorDTO obtenerJugador(Long id) {
        Jugador jugador = (Jugador) jugadorDAO.obtenerPorId(id);
        if (jugador != null) {
            return new JugadorDTO(
                jugador.getNombre(),
                jugador.getTipo(),
                jugador.getNivel(),
                jugador.getPuntosVida(),
                jugador.getMoral(),
                jugador.getArmas(),
                jugador.getEscudos(),
                jugador.getInventario()
            );
        }
        return null;
    }

    public List<Jugador> obtenerTodosLosJugadores() {
        return jugadorDAO.obtenerTodosLosJugadores();
    }
}