package proto;

import java.awt.Graphics;

/*
 * A palyaelem megvalositasahoz hasznalt osztaly
 */
public abstract class Tile {
	/*
	 * A terkepre mutato referencia
	 */
	protected Map map;
	
	/*
	 * A palyaelem pozicioja
	 */
	protected Position position;

	/*
	 * A terkepre mutato referenciat kerdezi le
	 */
	public Map getMap() {
		return map;
	}
	
	/*
	 * A terkepre mutato referenciat allitja be
	 */
	public void setMap(Map map) {
		this.map = map;
	}
	
	/*
	 * A palyaelem poziciojat kerdezi le
	 */
	public Position getPosition() {
		return position;
	}
	
	/*
	 * A palyaelem poziciojat allitja be
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	
	/*
	 * Uj, az Enemy lepesi esemenyere valo feliratkozas
	 * tovabbitasahoz hasznalt metodus
	 */
	public void addEnemyObserver(EnemyObserver observer) {
		map.addEnemyObserver(observer);
	}
	
	/**
	 * A palyaelemen levo torony lekrdezese
	 */
	public abstract Tower getTower();
	/**
	 * A palyaelemen levo akadaly lekrdezese
	 */
	public abstract Trap getTrap();
	
	/*
	 * Uj varazsko hozzaadasahoz hasznalt metodusok
	 */
	public abstract void addAntiHuman();
	public abstract void addAntiElf();
	public abstract void addAntiDwarf();
	public abstract void addAntiHobbit();
	public abstract void addPlusFrequency();
	public abstract void addPlusRange();
	public abstract void addPlusTime();
	public abstract void draw(Graphics g);
}