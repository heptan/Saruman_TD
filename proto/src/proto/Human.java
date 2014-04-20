package proto;

/*
 * Az ember ellenseget megvalosito osztaly
 */
public class Human extends Enemy {
	
	final int speed = 2;
	
	/*
	 * Ember ellenseg leptetesehez, pozicionalasahoz hasznalt metodus.
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
	 * Ember ellenseget sebzo metodus
	 */
	public void hit(boolean split, Tower tower){
		health -= tower.getDamageHuman();
		if (split) {
			gameController.splitHuman(this);
		}
	}
}
