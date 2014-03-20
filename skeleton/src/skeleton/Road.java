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
