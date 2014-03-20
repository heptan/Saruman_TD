package skeleton;

import java.util.List;

/*
 * Az ellens�get megval�s�t� absztrakt �soszt�ly
 * TODO Ennek abstract-nak k�ne lennie
 */
public class Enemy {
	
	/*
	 * Az ellens�g poz�ci�j�t t�rol� attrib�tum
	 */
	private Position position;
	
	/*
	 * Az ellens�g �leterej�t t�rol� attrib�tum
	 */
	private int health;
	
	/*
	 * Az ellens�g aktu�lis sebess�g�t t�rol� attrib�tum
	 */
	private int speed;
	
	/*
	 * Az ellens�g h�tral�v� v�rakoz�si idej�t t�rol� attrib�tum 
	 */
	private int timeout;
	
	/*
	 * Az ellens�g maxim�lis v�rakoz�si idej�t t�rol� attrib�tum
	 */
	private int maxtimeout;
	
	/*
	 * A feliratkozott megfigyel�ket tartalmaz� lista
	 */
	private List<EnemyObserver> observers;
	
	/*
	 * Az aktu�lis �t p�lyaelemre mutat� referencia
	 */
	private Road actRoad;
	
	/*
	 * A j�t�kt�rre mutat� referencia
	 */
	private GameController gameController;
	
	/*
	 * A position attrib�tum getter met�dusa
	 */
	public Position getPosition() {
		return position;
	}
	
	/*
	 * A position attrib�tum setter met�dusa
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	
	/*
	 * A health attrib�tum getter met�dusa
	 */
	public int getHealth() {
		return health;
	}
	
	/*
	 * A health attrib�tum setter met�dusa
	 */
	public void setHealth(int health) {
	
	}
	
	/*
	 * A timeout attrib�tum getter met�dusa
	 */
	public int getTimeout() {
		return timeout;
	}
	
	/*
	 * A timeout attrib�tum setter met�dusa
	 */
	public void setTimeout(int timeout) {
	
	}
	
	/*
	 * A timeout attrib�tum 
	 */
	public void decTimeout(int dec) {
	}
	
	/*
	 * Az speed attrib�tum getter met�dusa
	 */
	public int getSpeed() {
		return speed;
	}
	
	/*
	 * A speed attrib�tum setter met�dusa
	 */
	public void setSpeed(double speed) {
	
	}
	
	/*
	 * Az ellens�gn�l feliratkozott observereket tartalmaz� lista inicializ�l�hoz haszn�lt met�dus.
	 */
	public void setObservers(List<EnemyObserver> observers) {
	
	}
	
	/*
	 * �j observer regisztr�l�s�hoz haszn�lt met�dus
	 */
	public void addObserver(EnemyObserver observer) {
	
	}
	
	/*
	 * Feliratkozott observer kiregisztr�l�s�hoz haszn�lt met�dus.
	 */
	public void removeObserver(EnemyObserver observer) {
	
	}
	
	/*
	 * Az ellens�g l�ptet�s�hez haszn�lt met�dus
	 */
	public void nextStep() {		
		ConsoleUI.writeSeq("Road.getNextRoad()");
		Road nextr = actRoad.getNextRoad();
		ConsoleUI.writeSeq("Road.getNextRoad() - return nextr");
		
		ConsoleUI.writeSeq("Position.getPosition()");
		Position nextr_pos = nextr.getPosition();
		ConsoleUI.writeSeq("Position.getPosition() - return nextr_pos");
		
		ConsoleUI.writeSeq("Enemy.setPosition(nextr_pos)");
		this.setPosition(nextr_pos);
		ConsoleUI.writeSeq("Enemy.setPosition(nextr_pos) - return");
	}
	
	/*
	 * A feliratkozott observerek �rtes�t�s�re haszn�lt met�dus
	 */
	public void notifyEnemyObservers() {
	
	}
	
	/*
	 * Az actRoad attrib�tum getter met�dusa
	 */
	public Road getActRoad() {
		return actRoad;
	}
	
	/*
	 * Az actRoad attrib�tum setter met�dusa
	 */
	public void setActRoad(Road ar) {
	
	}
}
