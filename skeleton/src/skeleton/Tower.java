package skeleton;

import java.util.List;

/*
 * A torony megvalósításához használt osztály.
 */
public class Tower extends EnemyObserver {
	private Position position;
	private double range;
	private Field field;
	private List<GemStone> gemList;
	private List<Enemy> enemyList;
	public void notifyFromEnemy(Enemy enemy) {
	
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
	
	}
	
	public double getRange() {
		return range;
	}
	
	public void setRange(double range) {
	
	}
	
	public void setField(Field field) {
	
	}
	
	public void addGemStone(String gemstone) {
	
	}
	
	public List<GemStone> getGemStoneList() {
		return gemList;
	}
	
	public void addEnemy(Enemy e) {
	
	}
	
	public void removeEnemy(Enemy e) {
	
	}
	
	public void wipe() {
	
	}
}
