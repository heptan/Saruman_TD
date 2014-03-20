package skeleton;

/*
 * A p�lyaelem megval�s�t�s�hoz haszn�lt oszt�ly.
 */
public abstract class Tile {
	private Position position;
	private Map map;
	
	/*
	 * A position attrib�tum getter met�dusa
	 */
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
	
	}
	
	public void setMap(Map map) {
	
	}
	
	public Map getMap() {
		return map;
	}
	
	public void addEnemyObserver(EnemyObserver observer) {
	
	}
	
	public void addGemStone(String gemstone) {
	
	}
}