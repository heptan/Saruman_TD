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
}
