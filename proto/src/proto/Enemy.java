package proto;

import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;

/*
 * Az ellenseget megvalosito absztrakt ososztaly
 */
public abstract class Enemy {
	
	// Az ellenseg pozociojat tarolo attributum
	protected Position position;
	
	// Az ellenseg eleterejet tarolo attributum
	protected int health;
	
	// Az ellenseg aktualis sebesseget tarolo attributum
	protected int speed;
	
	// Az ellenseg hatralevo varakozasi idejet tarolo attributum 
	protected int timeout;
	
	// A feliratkozott megfigyeloket tartalmazo lista
	protected List<EnemyObserver> observers = new ArrayList<EnemyObserver>();
	
	// Az aktualis ut palyaelemre mutato referencia
	protected Road actroad;
	
	// A jatekterre mutato referencia
	protected GameController gameController;
	
	// Temporalis sebzes szamlalo.
	protected List<Integer> damages = new ArrayList<Integer>();
	
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
	
	public void decreaseHealth(int amount) {
		this.health -= health;
		if(this.health <= 0) {
			for(EnemyObserver enemyobserver : observers) {
				enemyobserver.notifyFromEnemy(this);
			}
			
			gameController.removeEnemy(this);
		}
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
		this.timeout = timeout;
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
	public abstract void nextStep();
	
	/*
	 * A feliratkozott observerek ertesitesere hasznalt metodus
	 */
	public void notifyEnemyObservers() {
		for(EnemyObserver enemy_observer : observers) {
			enemy_observer.notifyFromEnemy(this);
		}
	}
	
	/*
	 * Az actRoad attributum getter metodusa
	 */
	public Road getActRoad() {
		return actroad;
	}
	
	/*
	 * Az actRoad attributum setter metodusa
	 */
	public void setActRoad(Road actroad) {
		this.actroad = actroad;
	}
	
	/*
	 * Ha nem rendelkezik a torony semmilyen modositokovel, akkor ez a fugg-
	 *   veny fog meghivodni, igy biztositva, hogy ne fordulhasson elo az, 
	 *   hogy az ellenseget nem eri talalat, mikor a hatosugaron belul van.
	 */
	public void getShot(int damage) {
		damages.add(damage);
	}
	
	public abstract void getShotWithAntiDwarf(int damage);
	
	public abstract void getShotWithAntiElf(int damage);

	public abstract void getShotWithAntiHobbit(int damage);

	public abstract void getShotWithAntiHuman(int damage);

	/*
	 * Ebben a metodusban szamitodik ki a tenyleges sebzes es kerul levonasra
	 *   az eleteropontokbol (health).
	 */
	public void shotEnd() {
		int max = -1;
		if (!damages.isEmpty()){
			max = 0;
		}
		for (int i = 1; i < damages.size(); ++i){
			if (damages.get(i) > damages.get(max)){
				max = i;
			}
		}
		if (max >= 0){
			this.decreaseHealth(damages.get(max));
		}
		damages.clear();
	}
	public abstract void split();
}
