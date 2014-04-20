package proto;

/*
 * A tunde ellenseget megvalosito osztaly
 */
public class Elf extends Enemy {
	
	final int speed = 1;
	
	/*
	 * Tunde ellenseg leptetesehez, pozicionalasahoz hasznalt metodus.
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
	 * Tunde ellenseget sebzo metodus
	 */
	public void hit(boolean split, Tower tower){
		health -= tower.getDamageElf();
		if (split) {
			gameController.splitElf(this);
		}
	}
}
