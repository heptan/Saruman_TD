package skeleton;

/*
 * A mezõ pályaelemet megvalósító osztály
 */
public class Field extends Tile {
	
	/*
	 * A mezõ pozícóját tároló attribútum
	 */
	private Position position;
	
	/*
	 * A térképre mutató referencia
	 */
	private Map map;
	
	/*
	 * A mezõn található toronyra mutató referencia. Ha nincs ilyen, akkor null.
	 */
	private Tower tower;
	
	/*
	 * A position attribútum getter metódusa
	 */
	public Position getPosition() {
		return position;
	}
	
	/*
	 * A position attribútum setter metódusa
	 */
	public void setPosition(Position position) {
	
	}
	
	/*
	 * A map attribútum setter metódusa
	 */
	public void setMap(Map map) {
	
	}
	
	/*
	 * A map attribútum getter metódusa
	 */
	public Map getMap() {
		return map;
	}
	
	/*
	 * Új Enemy-t megfigyelõ observer
	 */
	public void addEnemyObserver(EnemyObserver observer) {
	
	}
	
	/*
	 * A tower attribútum getter metódusa
	 */
	public Tower getTower() {
		return tower;
	}

	/*
	 * A tower attribútum inicializálásához használt metódus
	 */
	public void setTower() {
		if(tower == null) {
			ConsoleUI.writeSeq("new Tower()");
			tower = new Tower();
			ConsoleUI.writeSeq("new Tower() - return tower");
		}
	}
	
	/*
	 * A mezõn lévõ torony eltávolításához használt metódus
	 */
	public void resetTower() {
		if(tower != null) {
			ConsoleUI.writeSeq("Tower.wipe()");
			tower.wipe();
			ConsoleUI.writeSeq("Tower.wipe() - return");
		}
	}
}
