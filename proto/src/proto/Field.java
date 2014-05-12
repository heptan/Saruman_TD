package proto;

import java.awt.Graphics;

/**
 * A mezo palyaelemet megvalosito osztaly
 */
public class Field extends Tile {

	/**
	 * A rajzolo objektumra mutato referencia
	 */
	private DrawField fieldDrawer = new DrawField();

	/**
	 * A terkepre mutato referencia
	 */
	private Map map;

	/**
	 * A mezo pozicojat tarolo attributum
	 */
	private Position position;

	/**
	 * A mezon talalhato toronyra mutato referencia
	 */
	private Tower tower;

	/**
	 * A map attributum getter metodusa
	 * 
	 * @return Az mezohoz tartozo Map objektum
	 */
	public Map getMap() {
		return map;
	}

	/**
	 * A map attributum setter metodusa
	 * 
	 * @param map
	 *            A beallitando Map objektum
	 */
	public void setMap(Map map) {
		this.map = map;
	}

	/**
	 * A position attributum getter metodusa
	 * 
	 * @return Az mezo Position objektuma, a mezo pozicioja
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * A position attributum setter metodusa
	 * 
	 * @param position
	 *            Az uj pozicio, a beallitando position objektum
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * A tower attributum getter metodusa
	 * 
	 * @return A mezon levo levo torony, ha nincs, akkor null erteket ad vissza.
	 */
	public Tower getTower() {
		return tower;
	}

	/**
	 * Ez a metodus ebben az osztalyban nincs hasznalatban
	 * 
	 * @see proto.Tile#getTrap()
	 */
	@Override
	public Trap getTrap() {
		return null;
	}

	/**
	 * Uj torony letrehozasa a mezon
	 */
	public void setTower() {
		tower = new Tower(this);
		tower.setPosition(this.position);
		for (Enemy e : map.getGameController().getEnemyList()) {
			e.addObserver(tower);
		}
	}

	/**
	 * A mezon levo torony eltavolitasahoz hasznalt metodus
	 */
	public void resetTower() {
		tower.wipe();
		tower = null;
	}

	/**
	 * A mezon levo torony hatosugarat allitja a kod szerint
	 * 
	 * @param mist
	 *            Ha igaz, akkor kod van. Ilyenkor a kod eseten alkalmazando
	 *            latotavolsag lesz beallitva
	 */
	public void setRange(boolean mist) {
		if (tower == null) {
			return;
		}

		if (mist) {
			tower.setRange((-1) * Constants.TOWER_DEFAULT_RANGE);
		} else {
			tower.setRange(Constants.TOWER_DEFAULT_RANGE);
		}
	}

	/**
	 * AntiHuman varazsko hozzaadasa a toronyhoz
	 * 
	 * @see proto.Tile#addAntiHuman()
	 */
	@Override
	public void addAntiHuman() {
		if (tower != null) {
			tower.addAntiHuman();
		}
	}

	/**
	 * AntiElf varazsko hozzaadasa a toronyhoz
	 * 
	 * @see proto.Tile#addAntiElf()
	 */
	@Override
	public void addAntiElf() {
		if (tower != null) {
			tower.addAntiElf();
		}
	}

	/**
	 * AntiDwarf varazsko hozzaadasa a toronyhoz
	 * 
	 * @see proto.Tile#addAntiDwarf()
	 */
	@Override
	public void addAntiDwarf() {
		if (tower != null) {
			tower.addAntiDwarf();
		}
	}

	/**
	 * AntiHobbit varazsko hozzaadasa a toronyhoz
	 * 
	 * @see proto.Tile#addAntiHobbit()
	 */
	@Override
	public void addAntiHobbit() {
		if (tower != null) {
			tower.addAntiHobbit();
		}
	}

	/**
	 * PlusFrequency varazskovek hozzaadasa a toronyhoz
	 * 
	 * @see proto.Tile#addPlusFrequency()
	 */
	@Override
	public void addPlusFrequency() {
		if (tower != null) {
			tower.addPlusFrequency();
		}
	}

	/**
	 * PlusRange varazskovek hozzaadasa a toronyhoz
	 * 
	 * @see proto.Tile#addPlusRange()
	 */
	@Override
	public void addPlusRange() {
		if (tower != null) {
			tower.addPlusRange();
		}
	}

	/**
	 * Ez a tipus nem adhato hozza, hibauzenet
	 */
	@Override
	public void addPlusTime() {
		System.out.println("Ezt a kovet csak akadalyra lehet tenni");
	}

	/**
	 * A mezo kirajzolasahoz hasznalt metodus
	 * 
	 * @see proto.Tile#draw(java.awt.Graphics)
	 * @param g
	 *            A graphics objektum, amire rajzolni kell
	 */
	public void draw(Graphics g) {
		fieldDrawer.draw(this, g);
		if (tower != null) {
			tower.draw(g);
		}
	}
}
