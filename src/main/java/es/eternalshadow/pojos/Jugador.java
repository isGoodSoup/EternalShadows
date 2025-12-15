package es.eternalshadow.pojos;

import java.util.HashMap;
import java.util.Map;

import es.eternalshadow.entities.Criatura;
import es.eternalshadow.enums.Armamento;
import es.eternalshadow.enums.Escuderia;
import es.eternalshadow.main.Panel;

public class Jugador extends Criatura {
	private Panel panel;
	private int moral;
	private int ataque;
	private int defensa;
	private Arma arma;
	private Escudo escudo;
	private int oro;
	private Map<String, Item> inventario;

	public Jugador() {}
	
	public Jugador(String tipo, String nombre, int fuerza, int resistencia,
			int velocidad, int magia, int puntosVida, int moral, int ataque,
			int defensa, Panel panel) {
		super(tipo, nombre, fuerza, resistencia, velocidad, magia, puntosVida);
		this.panel = panel;
		this.moral = moral;
		this.ataque = ataque;
		this.defensa = defensa;
		this.oro = 0;
		this.inventario = new HashMap<>();
		
		Armamento arma = panel.getUtil().toGenArma();
		Escuderia escudo = panel.getUtil().toGenEscudo();
		
		this.arma = new Arma(arma.toString(), 1, arma);
		this.escudo = new Escudo(escudo.toString(), 1, escudo);
		
		this.inventario.put(arma.toString(), this.arma);
		this.inventario.put(escudo.toString(), this.escudo);
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
	
	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	
	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public Escudo getEscudo() {
		return escudo;
	}

	public void setEscudo(Escudo escudo) {
		this.escudo = escudo;
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
	
	@Override
	public String toString() {
		return "Jugador [moral=" + moral + ", ataque=" + ataque + ", defensa="
				+ defensa + ", arma=" + arma + ", escudo=" + escudo + ", oro="
				+ oro + ", inventario=" + inventario + ", getNombre()="
				+ getNombre() + ", getNivel()=" + getNivel()
				+ ", getPuntosVida()=" + getPuntosVida() + ", getFuerza()="
				+ getFuerza() + ", getResistencia()=" + getResistencia()
				+ ", getVelocidad()=" + getVelocidad() + ", getMagia()="
				+ getMagia() + "]";
	}

	@Override
	public int atacar(Criatura criatura) {
		return super.atacar(criatura);
	}

	@Override
	public int defender() {
		return super.defender();
	}

	public void luchar(Jugador user, Criatura lobo) {
		// TODO Luchar
	}

	public void huir(Jugador jugador) {
		System.out.println(jugador.getNombre() + " está huyendo!");
		modMoral(-5);
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
