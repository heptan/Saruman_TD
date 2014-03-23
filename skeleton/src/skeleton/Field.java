package skeleton;

/*
 * A mez� p�lyaelemet megval�s�t� oszt�ly
 */
public class Field extends Tile {
	
	/*
	 * A mez� poz�c�j�t t�rol� attrib�tum
	 */
	private Position position;
	
	/*
	 * A t�rk�pre mutat� referencia
	 */
	private Map map;
	
	/*
	 * A mez�n tal�lhat� toronyra mutat� referencia. Ha nincs ilyen, akkor null.
	 */
	private Tower tower;
	
	/*
	 * A position attrib�tum getter met�dusa
	 */
	public Position getPosition() {
		return position;
	}
	
	/*
	 * A position attrib�tum setter met�dusa
	 */
	public void setPosition(Position position) {
	
	}
	
	/*
	 * A map attrib�tum setter met�dusa
	 */
	public void setMap(Map map) {
	
	}
	
	/*
	 * A map attrib�tum getter met�dusa
	 */
	public Map getMap() {
		return map;
	}
	
	/*
	 * �j Enemy-t megfigyel� observer
	 */
	public void addEnemyObserver(EnemyObserver observer) {
	
	}
	
	/*
	 * A tower attrib�tum getter met�dusa
	 */
	public Tower getTower() {
		ConsoleUI.writeSeq("-->Field.getTower()");
		ConsoleUI.writeSeq("<--null");
		return null;
	}

	/*
	 * A tower attrib�tum inicializ�l�s�hoz haszn�lt met�dus
	 */
	public void setTower() {
		ConsoleUI.writeSeq("-->Field.setTower()");
		tower = new Tower();
		ConsoleUI.writeSeq("<--void");
	}
	
	/*
	 * A mez�n l�v� torony elt�vol�t�s�hoz haszn�lt met�dus
	 */
	public void resetTower() {
		ConsoleUI.writeSeq("-->Field.resetTower()");
		if(tower != null) {
			tower.wipe();
		}
		ConsoleUI.writeSeq("<--void");
	}
}
