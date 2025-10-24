package es.eternalshadow.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import es.eternalshadow.enums.Modo;
import es.eternalshadow.util.Personaje;

public class Panel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	private Personaje p = new Personaje();
	private Keyboard tecla = new Keyboard(this);
	private boolean isJuegoActivo = true;
	private Thread juego;
	
	private Modo estado;
	
	public Panel() {
		this.setPreferredSize(new Dimension(640, 640));
		this.revalidate();
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(tecla);
		this.setFocusable(true);
		
		this.estado = Modo.MENU;
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
        
        if(estado == Modo.MENU) {
        	g2.setFont(new Font("Arial", Font.BOLD, 25));
            g2.setColor(Color.white);
            g2.drawString("EternalShadows", (int) (getWidth()/2.8f), getHeight()/2);
            
        }
    }
	
	
	public void iniciarJuego() {
		isJuegoActivo = true;
	}
	
	public boolean isJuegoActivo() {
		return isJuegoActivo;
	}

	public Thread getJuego() {
		return juego;
	}

	public void setJuego(Thread juego) {
		this.juego = juego;
	}

	public Personaje getP() {
		return p;
	}

	public void setP(Personaje p) {
		this.p = p;
	}
}
