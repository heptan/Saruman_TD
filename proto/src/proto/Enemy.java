package proto;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * Az ellenseget megvalosito absztrakt ososztaly
 */
public abstract class Enemy {

	/**
	 * Az ellenseg pozociojat tarolo attributum
	 */
	protected Position position;

	/**
	 * Az ellenseg eleterejet tarolo attributum
	 */
	protected int health;

	/**
	 * Az ellenseg aktualis sebesseget tarolo attributum
	 */
	protected int speed;

	/**
	 * Az ellenseg hatralevo varakozasi idejet tarolo attributum
	 */
	protected int timeout;

	/**
	 * A feliratkozott megfigyeloket tartalmazo lista
	 */
	protected List<EnemyObserver> observers = new ArrayList<EnemyObserver>();

	/**
	 * Az aktualis ut palyaelemre mutato referencia
	 */
	protected Road actroad;

	/**
	 * A jatekterre mutato referencia
	 */
	protected GameController gamecontroller;

	/**
	 * Temporalis sebzes szamlalo.
	 */
	protected List<Integer> damages = new ArrayList<Integer>();

	/**
	 * A position attributum getter metodusa
	 * 
	 * @return Az aktulis poziciot tartalmazo objektum
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * A position attributum setter metodusa
	 * 
	 * @param position
	 *            Az uj position objektum
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * A health attributum getter metodusa
	 * 
	 * @return Az aktualis eletero
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * A health attributum setter metodusa
	 * 
	 * @param health
	 *            A uj eletero
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * Eletero csokkentese a megadott mertekkel
	 * 
	 * @param amount
	 *            Ennyivel csokkentendo az aktualis eletero
	 */
	public void decreaseHealth(int amount) {
		this.health -= amount;
		if (this.health <= 0) {
			for (EnemyObserver enemyobserver : observers) {
				enemyobserver.notifyFromEnemy(this);
			}
			gamecontroller.removeEnemy(this);
		}
	}

	/**
	 * A timeout attributum getter metodusa
	 * 
	 * @return A timeout aktualis erteke
	 */
	public int getTimeout() {
		return timeout;
	}

	/**
	 * A timeout attributum setter metodusa
	 * 
	 * @param timeout
	 *            A beallitando varakozasi ido
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	/**
	 * Az speed attributum getter metodusa
	 * 
	 * @return Az aktualis sebessegertek
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * A speed attributum setter metodusa
	 * 
	 * @param speed
	 *            Az uj sebessegertek
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * Az ellensegnel feliratkozott observereket tartalmazo lista
	 * inicializalasahoz hasznalt metodus.
	 * 
	 * @param observers
	 *            Az uj, feliratkozni kivant observereket tartalmazo lista
	 */
	public void setObservers(List<EnemyObserver> observers) {
		if (observers != null) {
			this.observers = observers;
		}
	}

	/**
	 * Az ellensegnel feliratkozott observereket tartalmazo lista lekerdezesehez
	 * hasznalt metodus.
	 * 
	 * @return Az observerek aktualis listaja
	 */
	public List<EnemyObserver> getObservers() {
		return this.observers;
	}

	/**
	 * Uj observer regisztralasahoz hasznalt metodus
	 * 
	 * @param observer
	 *            Az uj, feliratkozni kivant observer
	 */
	public void addObserver(EnemyObserver observer) {
		if (observer != null && !observers.contains(observer)) {
			observers.add(observer);
		}
	}

	/**
	 * Feliratkozott observer kiregisztralasahoz hasznalt metodus.
	 * 
	 * @param observer
	 *            Az eltavolitani kivant observer
	 */
	public void removeObserver(EnemyObserver observer) {
		if (observer != null && observers.contains(observer)) {
			observers.remove(observer);
		}
	}

	/**
	 * Az ellenseg leptetesehez hasznalt metodus
	 */
	public abstract void nextStep();

	/**
	 * A feliratkozott observerek ertesitesere hasznalt metodus
	 */
	public void notifyEnemyObservers() {
		for (EnemyObserver enemy_observer : observers) {
			enemy_observer.notifyFromEnemy(this);
		}
	}

	/**
	 * Az actRoad attributum getter metodusa
	 * 
	 * @return Az aktualis Road objektum, amin az ellenseg eppen tartozkodik
	 */
	public Road getActRoad() {
		return actroad;
	}

	/**
	 * Az actRoad attributum setter metodusa
	 * 
	 * @param actroad
	 *            Az uj aktulis Road objektum
	 */
	public void setActRoad(Road actroad) {
		this.actroad = actroad;
	}

	/**
	 * Ha nem rendelkezik a torony semmilyen modositokovel, akkor ez a fugg-
	 * veny fog meghivodni, igy biztositva, hogy ne fordulhasson elo az, hogy az
	 * ellenseget nem eri talalat, mikor a hatosugaron belul van.
	 * 
	 * @param damage
	 *            A sebzes merteke
	 */
	public void getShot(int damage) {
		damages.add(damage);
	}

	/**
	 * Loves AntiDward varazskovel ellatott toronytol
	 * 
	 * @param damage
	 *            A sebzes merteke
	 */
	public abstract void getShotWithAntiDwarf(int damage);

	/**
	 * Loves AntiElf varazskovel ellatott toronytol
	 * 
	 * @param damage
	 *            A sebzes merteke
	 */
	public abstract void getShotWithAntiElf(int damage);

	/**
	 * Loves AntiHobbit varazskovel ellatott toronytol
	 * 
	 * @param damage
	 *            A sebzes merteke
	 */
	public abstract void getShotWithAntiHobbit(int damage);

	/**
	 * Loves AntiHuman varazskovel ellatott toronytol
	 * 
	 * @param damage
	 *            A sebzes merteke
	 */
	public abstract void getShotWithAntiHuman(int damage);

	/**
	 * Kettevago lovedektol erkezett loves
	 */
	public abstract void split();

	/**
	 * Ebben a metodusban szamitodik ki a tenyleges sebzes es kerul levonasra az
	 * eleteropontokbol (health).
	 */
	public void shotEnd() {
		int max = -1;
		if (!damages.isEmpty()) {
			max = 0;
		}
		for (int i = 1; i < damages.size(); ++i) {
			if (damages.get(i) > damages.get(max)) {
				max = i;
			}
		}
		if (max >= 0) {
			this.decreaseHealth(damages.get(max));
		}
		damages.clear();
	}

	/**
	 * GameController beallitasa
	 * 
	 * @param gamecontroller
	 *            A GameControlerre mutato referencia
	 */
	public void setGameController(GameController gamecontroller) {
		this.gamecontroller = gamecontroller;
	}

	/**
	 * GameController lekerdezese
	 * 
	 * @return Az aktualis GameController objektumra mutato referencia
	 */
	public GameController getGameController() {
		return gamecontroller;
	}

	/**
	 * kirajzolo fuggveny, az osszes enemy megvalositja
	 * 
	 * @param g
	 *            Graphics objektum, amire rajzolni kell.
	 */
	public abstract void draw(Graphics g);
}
