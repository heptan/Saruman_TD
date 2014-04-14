package proto;

import java.util.List;

/*
 * Az ellenseget megvalosito absztrakt ososztaly
 */
public abstract class Enemy {
	
	/*
	 * Az ellenseg pozociojat tarolo attributum
	 */
	private Position position;
	
	/*
	 * Az ellenseg eleterejet tarolo attributum
	 */
	private int health;
	
	/*
	 * Az ellenseg aktualis sebesseget tarolo attributum
	 */
	private int speed;
	
	/*
	 * Az ellenseg hatralevo varakozasi idejet tarolo attributum 
	 */
	private int timeout;
	
	/*
	 * Az ellenseg maximalis varakozasi idejet tarolo attributum
	 */
	private int maxtimeout;
	
	/*
	 * A feliratkozott megfigyeloket tartalmazo lista
	 */
	private List<EnemyObserver> observers;
	
	/*
	 * Az aktualis ut palyaelemre mutato referencia
	 */
	private Road actRoad;
	
	/*
	 * A jatekterre mutato referencia
	 */
	private GameController gameController;
	
	/*
	 * A position attributum getter metodusa
	 */
	public Position getPosition() {
		return position;
	}
	
	/*
	 * A position attributum setter metodusa
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	
	/*
	 * A health attributum getter metodusa
	 */
	public int getHealth() {
		return health;
	}
	
	/*
	 * A health attributum setter metodusa
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	
	/*
	 * A timeout attributum getter metodusa
	 */
	public int getTimeout() {
		return timeout;
	}
	
	/*
	 * A timeout attributum setter metodusa
	 */
	public void setTimeout(int timeout) {
	
	}
	
	/*
	 * A timeout attributum novelesehez hasznalt metodus 
	 */
	public void decTimeout(int dec) {
		this.timeout += dec;
	}
	
	/*
	 * Az speed attributum getter metodusa
	 */
	public int getSpeed() {
		return speed;
	}
	
	/*
	 * A speed attributum setter metodusa
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	/*
	 * Az ellensegnel feliratkozott observereket tartalmazo lista inicializalasahoz hasznalt metodus.
	 */
	public void setObservers(List<EnemyObserver> observers) {
		if(observers != null) {
			this.observers = observers;
		}
	}
	
	/*
	 * Uj observer regisztralasahoz hasznalt metodus
	 */
	public void addObserver(EnemyObserver observer) {
		if(observer != null && !observers.contains(observer)) {
			observers.add(observer);
		}
	}
	
	/*
	 * Feliratkozott observer kiregisztralasahoz hasznalt metodus.
	 */
	public void removeObserver(EnemyObserver observer) {
		if(observer != null && observers.contains(observer)) {
			observers.remove(observer);
		}
	}
	
	/*
	 * Az ellenseg leptetesehez hasznalt metodus
	 */
	public void nextStep(int from) {	
		
	}
	
	/*
	 * A feliratkozott observerek ertesitesere hasznalt metodus
	 */
	public void notifyEnemyObservers() {
		for(EnemyObserver eo : observers) {
			eo.notifyFromEnemy(this);
		}
	}
	
	/*
	 * Az actRoad attributum getter metodusa
	 */
	public Road getActRoad() {
		return actRoad;
	}
	
	/*
	 * Az actRoad attributum setter metodusa
	 */
	public void setActRoad(Road road) {
		actRoad = road;
	}
}
