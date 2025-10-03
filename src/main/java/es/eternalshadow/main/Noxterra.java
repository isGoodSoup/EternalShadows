package es.eternalshadow.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.eternalshadow.interfaces.Accionable;

public class Noxterra implements Accionable {
	private static final Logger log = LoggerFactory.getLogger(Noxterra.class);
	
	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		log.info("Atacando");
	}

	@Override
	public void defender() {
		// TODO Auto-generated method stub
		log.info("Defendiendo");
	}
	
}
