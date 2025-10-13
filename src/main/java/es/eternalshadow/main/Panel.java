package es.eternalshadow.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	private Keyboard tecla = new Keyboard(this);
	private boolean isJuegoActivo = true;
	
	public Panel() {
		this.setPreferredSize(new Dimension(640, 640));
		this.revalidate();
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(tecla);
		this.setFocusable(true);
	}
	
	@Override
	public void run() {
        while (isJuegoActivo) {
            repaint();
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

    }
	
	public boolean isJuegoActivo() {
		return isJuegoActivo;
	}
}
