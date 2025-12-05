package es.eternalshadow.story;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jline.reader.LineReader;

import es.eternalshadow.entities.Criatura;
import es.eternalshadow.entities.Usuario;
import es.eternalshadow.entities.Pocion;
import es.eternalshadow.motor.Combate;
import es.eternalshadow.motor.Escena;
import es.eternalshadow.motor.MotorHistoria;
import es.eternalshadow.motor.Opcion;
import es.eternalshadow.util.Codex;

public abstract class Historia {
	
	public abstract Criatura iniciar(Criatura criatura, LineReader reader, Codex util); 
	
	private static Object comprarObjetoMercader(Usuario user, String string, int i) {
		// TODO Auto-generated method stub
		return null;
	}
}