package skeleton;

import java.util.List;

public class Enemy {
	private Position position;
	private int health;
	private int speed;
	private int timeout;
	private int maxtimeout;
	private List<EnemyObserver> observers;
	private Road actRoad;
	private GameController gameController;
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
	
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
	
	}
	
	public int getTimeout() {
		return timeout;
	}
	
	public void setTimeout(int timeout) {
	
	}
	
	public void decTimeout(int dec) {
	}
	
	public int getSpeed() { //A sebességét adja vissza
		return speed;
	}
	
	public void setSpeed(double speed) {
	
	}
	
	public void setObservers(List<EnemyObserver> observers) {
	
	}
	
	public void addObserver(EnemyObserver observer) {
	
	}
	
	public void removeObserver(EnemyObserver observer) {
	
	}
	
	public void nextStep() {
	
	}
	
	public void notifyEnemyObservers() {
	
	}
	
	public Road getActRoad() {
		return actRoad;
	}
	
	public void setActRoad(Road ar) {
	
	}
}
