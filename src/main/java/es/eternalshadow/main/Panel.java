package es.eternalshadow.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Panel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Keyboard tecla = new Keyboard(this);
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	private boolean isJuegoActivo = true;
	
	private Graphics2D g2;
	
	public Panel() {
		this.setPreferredSize(new Dimension(640, 640));
		this.revalidate();
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(tecla);
		this.setFocusable(true);
	}
	
	public void run() {
		while(isJuegoActivo) {
			draw(g2);
		}
	}
	
	public void draw(Graphics2D g2) {
		g2.setColor(Color.GREEN);
		g2.drawString("", getX(), getY());
	}

	public boolean isJuegoActivo() {
		return isJuegoActivo;
	}
	
	public int getX() {
		return 
	}
	
	public int getY() {
		return 
	}
}
