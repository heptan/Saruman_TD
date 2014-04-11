package skeleton;

import java.util.List;

/*
 * Az ellenséget megvalósító absztrakt õsosztály
 * TODO Ennek abstract-nak kéne lennie
 */
public class Enemy {
	
	/*
	 * Az ellenség pozícióját tároló attribútum
	 */
	private Position position;
	
	/*
	 * Az ellenség életerejét tároló attribútum
	 */
	private int health;
	
	/*
	 * Az ellenség aktuális sebességét tároló attribútum
	 */
	private int speed;
	
	/*
	 * Az ellenség hátralévõ várakozási idejét tároló attribútum 
	 */
	private int timeout;
	
	/*
	 * Az ellenség maximális várakozási idejét tároló attribútum
	 */
	private int maxtimeout;
	
	/*
	 * A feliratkozott megfigyelõket tartalmazó lista
	 */
	private List<EnemyObserver> observers;
	
	/*
	 * Az aktuális út pályaelemre mutató referencia
	 */
	private Road actRoad;
	
	/*
	 * A játéktérre mutató referencia
	 */
	private GameController gameController;
	
	/*
	 * A position attribútum getter metódusa
	 */
	public Position getPosition() {
		ConsoleUI.writeSeq("-->Enemy.getPosition(): Position");
		ConsoleUI.writeSeq("<--Position");
		return position;
	}
	
	/*
	 * A position attribútum setter metódusa
	 */
	public void setPosition(Position position) {
		ConsoleUI.writeSeq("-->Enemy.setPosition(position: Position)");
		this.position = position;
		ConsoleUI.writeSeq("<--void");
	}
	
	/*
	 * A health attribútum getter metódusa
	 */
	public int getHealth() {
		return health;
	}
	
	/*
	 * A health attribútum setter metódusa
	 */
	public void setHealth(int health) {
	
	}
	
	/*
	 * A timeout attribútum getter metódusa
	 */
	public int getTimeout() {
		return timeout;
	}
	
	/*
	 * A timeout attribútum setter metódusa
	 */
	public void setTimeout(int timeout) {
	
	}
	
	/*
	 * A timeout attribútum 
	 */
	public void decTimeout(int dec) {
	}
	
	/*
	 * Az speed attribútum getter metódusa
	 */
	public int getSpeed() {
		return speed;
	}
	
	/*
	 * A speed attribútum setter metódusa
	 */
	public void setSpeed(double speed) {
		ConsoleUI.writeSeq("-->Enemy.setSpeed(multiplier: double): void");
		ConsoleUI.writeSeq("<--void");
	}
	
	/*
	 * Az ellenségnél feliratkozott observereket tartalmazó lista inicializálához használt metódus.
	 */
	public void setObservers(List<EnemyObserver> observers) {
	
	}
	
	/*
	 * Új observer regisztrálásához használt metódus
	 */
	public void addObserver(EnemyObserver observer) {
	
	}
	
	/*
	 * Feliratkozott observer kiregisztrálásához használt metódus.
	 */
	public void removeObserver(EnemyObserver observer) {
	
	}
	
	/*
	 * Az ellenség léptetéséhez használt metódus
	 */
	public void nextStep(int from) {	
		ConsoleUI.writeSeq("-->Enemy.nextStep(): void");
		if(from == 1) {
			Road nextr = actRoad.getNextRoad();
			Position nextr_pos = nextr.getPosition();
			this.setPosition(nextr_pos);
		}
		else {
			Road r = new Road();
			r.enemyHasSteppedOn(this);
		}
		
		ConsoleUI.writeSeq("<--void");
	}
	
	/*
	 * A feliratkozott observerek értesítésére használt metódus
	 */
	public void notifyEnemyObservers() {
	
	}
	
	/*
	 * Az actRoad attribútum getter metódusa
	 */
	public Road getActRoad() {
		ConsoleUI.writeSeq("-->Enemy.getActRoad(): Road");
		ConsoleUI.writeSeq("<--Road");
		return actRoad;
	}
	
	/*
	 * Az actRoad attribútum setter metódusa
	 */
	public void setActRoad(Road road) {
		actRoad = road;
	}
	
	/*
	 * Skeleton teszteléshez
	 */
	public void EllensegToronyHatosugaraban() {
		Tower t = new Tower(false);
		
		t.notifyFromEnemy(this);
	}
	
	/*
	 * Skeleton teszteléshez
	 */
	public void gameOverLose() {
		gameController = new GameController();
		gameController.gameOver();
	}
}
