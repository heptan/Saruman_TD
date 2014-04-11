package proto;

/*
 * A pályaelem megvalósításához használt osztály
 */
public abstract class Tile {
	/*
	 * A térképre mutató referencia
	 */
	protected Map map;
	
	/*
	 * A pályaelem pozíciója
	 */
	protected Position position;

	/*
	 * A térképre mutató referenciát kérdezi le
	 */
	public Map getMap() {
		return map;
	}
	
	/*
	 * A térképre mutató referenciát állítja be
	 */
	public void setMap(Map map) {
		this.map = map;
	}
	
	/*
	 * A pályaelem pozícióját kérdezi le
	 */
	public Position getPosition() {
		return position;
	}
	
	/*
	 * A pályaelem pozícióját állítja be
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	
	/*
	 * Új, az Enemy lépési eseményére való feliratkozás
	 * továbbításához használt metódus
	 */
	public void addEnemyObserver(EnemyObserver observer) {
		map.addEnemyObserver(observer);
	}
	
	/*
	 * Új varázskő hozzáadásához használt metódusok
	 */
	public abstract void addAntiHuman();
	public abstract void addAntiElf();
	public abstract void addAntiDwarf();
	public abstract void addAntiHobbit();
	public abstract void addPlusFrequency();
	public abstract void addPlusRange();
	public abstract void addPlusTime();
}