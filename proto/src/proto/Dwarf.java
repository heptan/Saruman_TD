package proto;

/*
 * A torpe ellenseget megvalosito osztaly
 */
public class Dwarf extends Enemy {
	
	final int speed = 4;
	
	/*
	 * Torpe ellenseg leptetesehez, pozicionalasahoz hasznalt metodus.
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
