package skeleton;

public class Trap extends EnemyObserver {
	private long endTime;
	private Position position;
	private Road road;
	private GemStone gem;
	public void notifyFromEnemy(Enemy enemy) {
	
	}
	
	public long getEndTime() {
		return endTime;
	}
	
	public void setEndTime(long endtime) {
	
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
	
	}
	
	public void setRoad(Road road) {
	
	}
	
	public void addGemStone(String gemstone) {
	
	}
	
	public boolean isGemStoned() {
		//TODO
		return false;
	}
	
	public void enemyHasSteppedOn(Object e) {
	
	}
}
