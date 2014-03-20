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
	
	}
	
	public Road getNextRoad() {
		return nextRoad;
	}
	
	public void enemyHasSteppedOn(Enemy e) {
	
	}
}
