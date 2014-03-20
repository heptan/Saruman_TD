<<<<<<< HEAD
package skeleton;

public class Road extends Tile {
	private Position position;
	private Map map;
	private Trap trap;
	public Road nextRoad;
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
	
	}
	
	public Map getMap() {
		return map;
	}
	
	public void setMap(Map map) {
	
	}
	
	public void addEnemyObserver(EnemyObserver observer) {
	
	}
	
	public Trap getTrap() {
		return trap;
	}
	
	public void setTrap() {
		if(trap == null) {
			ConsoleUI.writeSeq("new Trap()");
			trap = new Trap();
			ConsoleUI.writeSeq("new Trap() - return trap");
		}
	}
	
	public Road getNextRoad() {
		return nextRoad;
	}
	
	public void enemyHasSteppedOn(Enemy e) {
	
	}
}
=======
package skeleton;

/*
 * Az út megvalósítására használt osztály.
 */
public class Road extends Tile {
	private Position position;
	private Map map;
	private Trap trap;
	private Road nextRoad;

	@Override
	public Position getPosition() {
		return position;
	}
	
	@Override
	public void setPosition(Position position) {
	
	}
	
	@Override
	public Map getMap() {
		return map;
	}
	
	@Override
	public void setMap(Map map) {
	
	}
	
	@Override
	public void addEnemyObserver(EnemyObserver observer) {
	
	}
	
	public Trap getTrap() {
		return trap;
	}
	
	public void setTrap() {
	
	}
	
	public Road getNextRoad() {
		return nextRoad;
	}
	
	public void enemyHasSteppedOn(Enemy e) {
	
	}
}
>>>>>>> 7ad8b3e754d245696f8ecb467c59163a68839b04
