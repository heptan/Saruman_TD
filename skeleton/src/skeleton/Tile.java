package skeleton;

/*
 * A pályaelem megvalósításához használt osztály.
 */
public abstract class Tile {
	/*
	 * A pályaelem pozíciója.
	 */
	private Position position;
	/*
	 * A térképre mutató referencia.
	 */
	private Map map;
	
	/*
	 * A pályaelem pozícióját kérdezi le.
	 */
	public Position getPosition() {
		return position;
	}
	
	/*
	 * A pályaelem pozícióját állítja be.
	 */
	public void setPosition(Position position) {
	
	}
	
	/*
	 * A térképre mutató referenciát állítja be.
	 */
	public void setMap(Map map) {
	
	}
	
	/*
	 * A térképre mutató referenciát kérdezi le.
	 */
	public Map getMap() {
		return map;
	}
	
	/*
	 * Új, az Enemy lépési eseményére való feliratkozás
	 * továbbításához használt metódus.
	 */
	public void addEnemyObserver(EnemyObserver observer) {
	
	}
	
	/*
	 * Új varázskõ hozzáadásához használt metódus.
	 */
	public void addGemStone(String gemstone) {
	
	}
}