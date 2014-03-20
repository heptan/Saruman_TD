package skeleton;

public class Road extends Tile {
	private Position position;
	private Map map;
	private Trap trap;
	public Road nextRoad;
	public Position getPosition() {
		ConsoleUI.writeSeq("--> Position.getPosition()");
		ConsoleUI.writeSeq("<-- Position");
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
		ConsoleUI.writeSeq("--> Road.getTrap()");
		ConsoleUI.writeSeq("<-- Trap");
		return trap;
	}
	
	public void setTrap() {
		ConsoleUI.writeSeq("--> Road.setTrap()");
		if(trap == null) {
			trap = new Trap();
		}
		ConsoleUI.writeSeq("<-- void");
	}
	
	public Road getNextRoad() {
		ConsoleUI.writeSeq("--> Road.getNextRoad()");
		ConsoleUI.writeSeq("<-- Road");
		return nextRoad;
	}
	
	public void enemyHasSteppedOn(Enemy e) {
	
	}
}
