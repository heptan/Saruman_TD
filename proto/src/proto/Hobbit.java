package proto;

/*
 * A hobbit ellenseget megvalosito osztaly.
 */
public class Hobbit extends Enemy {
	
	final int speed = 3;
	
	/*
	 * Hobbit ellenseg leptetesehez, pozicionalasahoz hasznalt metodus.
	 */
	public void nextStep() {
		if(timeout <= 0) {
			this.position = actroad.getNextRoad().getPosition();
			timeout = speed;
			
			notifyEnemyObservers();
		}
		else {
			timeout--;
		}
	}
	/*
	 * Hobbit ellenseget sebzo metodus
	 */
	public void hit(boolean split, Tower tower){
		health -= tower.getDamageHobbit();
		if (split) {
			gameController.splitHobbit(this);
		}
	}
}
