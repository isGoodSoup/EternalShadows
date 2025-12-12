package es.eternalshadow.pojos;

import java.util.HashMap;
import java.util.Map;

import es.eternalshadow.entities.Criatura;
import es.eternalshadow.main.Panel;

public class Jugador extends Criatura {
	private Panel panel;
	private int moral;
	private int ataque;
	private int oro;
	private Map<String, Item> inventario;

	public Jugador() {}

	public Jugador(String tipo, String nombre, int fuerza, int resistencia,
			int velocidad, int magia, int puntosVida, int moral, int ataque, Panel panel) {
		super(tipo, nombre, fuerza, resistencia, velocidad, magia, puntosVida);
		this.panel = panel;
		this.moral = moral;
		this.ataque = ataque;
		this.oro = 0;
		this.inventario = new HashMap<>();
		this.getArmas().get(0).setArma(panel.getUtil().toGenArma());
		this.getEscudos().get(0).setEscudo(panel.getUtil().toGenEscudo());
	}
	
	public Panel getPanel() {
		return panel;
	}

	public void setPanel(Panel panel) {
		this.panel = panel;
	}

	public int getMoral() {
		return moral;
	}

	public void setMoral(int moral) {
		this.moral = moral;
	}

	public void modMoral(int moral) {
		this.moral += moral;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getOro() {
		return oro;
	}

	public void setOro(int oro) {
		this.oro = oro;
	}

	public void modOro(int precio) {
		this.oro += precio;
	}
	
	public Map<String, Item> getInventario() {
		return inventario;
	}

	public void setInventario(Map<String, Item> inventario) {
		this.inventario = inventario;
	}

	public void luchar(Jugador user, Criatura lobo) {
		// TODO Luchar
	}

	public void huir(Jugador user) {
		System.out.println(user.getNombre() + " está huyendo!");
	}

	@Override
	public int recibirDanio(int i) {
		return super.recibirDanio(i);
	}

	@Override
	public boolean isVivo(Criatura criatura) {
		return super.isVivo(criatura);
	}

}
