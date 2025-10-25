package es.eternalshadow.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JPanel;

import es.eternalshadow.entity.Jugador;
import es.eternalshadow.enums.Modo;

public class Panel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	private Jugador jugador = new Jugador(this);
	private Keyboard tecla = new Keyboard(this);
	private boolean isJuegoActivo = true;
	
	private Font tipo;
	private InputStream is;
	
	private Modo estado;
	
	public Panel() {
		this.setPreferredSize(new Dimension(getWidth(), getHeight()));
		this.revalidate();
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(tecla);
		this.setFocusable(true);
		
		try {
			is = getClass().getResourceAsStream("/es/eternalshadow/fonts/Caudex-Bold.ttf");
			tipo = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
        
        if (estado == Modo.MENU) {
            g2.setFont(tipo.deriveFont(Font.PLAIN, 32f));
            g2.setColor(Color.WHITE);

            FontMetrics fm = g2.getFontMetrics();
            int baseY = 400;
            int espacio = 50;

            String[] menu = {"Empezar aventura", "Salir"};
            for (int i = 0; i < menu.length; i++) {
                String texto = menu[i];
                int textoAncho = fm.stringWidth(texto);
                int x = (getWidth() - textoAncho) / 2;
                int y = baseY + (i * espacio);
                g2.drawString(texto, x, y);
                
                
            }
        }
    }
	
	public boolean isJuegoActivo() {
		return isJuegoActivo;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Keyboard getTecla() {
		return tecla;
	}

	public void setTecla(Keyboard tecla) {
		this.tecla = tecla;
	}
}
