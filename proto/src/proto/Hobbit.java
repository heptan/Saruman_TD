package proto;

/*
 * A hobbit ellenseget megvalosito osztaly.
 */
public class Hobbit extends Enemy {
	
	final int speed = Constants.SPEED_HOBBIT;
	
	/*
	 * Hobbit ellenseg leptetesehez, pozicionalasahoz hasznalt metodus.
	 */
	public void nextStep() {
		if(timeout <= 0) {
			if(actroad.getNextRoad() == null) {
				gamecontroller.gameOver();
			}
			
			this.position = actroad.getNextRoad().getPosition();
			actroad = actroad.getNextRoad();
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
			gamecontroller.splitHobbit(this);
		}
	}
	/*
	 * Az osztalyra nem vonatkozo hivasnal nem csinal semmit. Eredetileg ugy volt,
	 *   hogy ilyenkor majd meghivja a default sebzes fuggvenyt, de semmi ertelme.
	 *   Tobbet kell keresni a damages-ben, tobb fv hihas, tobb hozzaadas, stb...
	 */
	@Override
	public void getShotWithAntiDwarf(int damage) {
		// ... Ez nem vonatkozik erre az osztalyra.
	}
	@Override
	public void getShotWithAntiElf(int damage) {
		// ... Ez nem vonatkozik erre az osztalyra.		
	}
	@Override
	public void getShotWithAntiHobbit(int damage) {
		this.damages.add(damage);
	}
	@Override
	public void getShotWithAntiHuman(int damage) {
		// ... Ez nem vonatkozik erre az osztalyra.
		
	}
	@Override
	public void split() {
		this.gamecontroller.splitHobbit(this);
		
	}
}
