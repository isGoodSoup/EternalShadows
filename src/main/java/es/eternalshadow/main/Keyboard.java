package es.eternalshadow.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
	private Panel panel;
	private int tecla;
	private boolean isAbajo, isArriba, isIzquierda, isDerecha;
	
	public Keyboard(Panel panel) {
		this.setPanel(panel);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(tecla == KeyEvent.VK_DOWN) {
			
		}
		
		if(tecla == KeyEvent.VK_UP) {
			
		}
		
		if(tecla == KeyEvent.VK_LEFT) {
			
		}
		
		if(tecla == KeyEvent.VK_RIGHT) {
			
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(tecla == KeyEvent.VK_DOWN) {
			
		}
		
		if(tecla == KeyEvent.VK_UP) {
			
		}
		
		if(tecla == KeyEvent.VK_LEFT) {
			
		}
		
		if(tecla == KeyEvent.VK_RIGHT) {
			
		}
	}

	public Panel getPanel() {
		return panel;
	}

	public void setPanel(Panel panel) {
		this.panel = panel;
	}

	public int getTecla() {
		return tecla;
	}

	public void setTecla(int tecla) {
		this.tecla = tecla;
	}

	public boolean isAbajo() {
		return isAbajo;
	}

	public boolean isArriba() {
		return isArriba;
	}

	public boolean isIzquierda() {
		return isIzquierda;
	}

	public boolean isDerecha() {
		return isDerecha;
	}
}
