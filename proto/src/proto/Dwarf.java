package proto;

/*
 * A torpe ellenseget megvalosito osztaly
 */
public class Dwarf extends Enemy {
	
	final int speed = Constants.SPEED_DWARF;
	
	/*
	 * Torpe ellenseg leptetesehez, pozicionalasahoz hasznalt metodus.
	 */
	public void nextStep() {
		if(timeout <= 0) {
			Road nextroad = actroad.getNextRoad();
			if(nextroad == null) {
				gamecontroller.gameOver();
			}
			
			this.position = nextroad.getPosition();
			actroad = nextroad;
			timeout = speed;
			
			notifyEnemyObservers();
		}
		else {
			timeout--;
		}
	}
	/*
	 * Torpe ellenseget sebzo metodus
	 */
	public void hit(boolean split, Tower tower){
		health -= tower.getDamageDwarf();
		if (split) {
			gamecontroller.splitDwarf(this);
		}
	}
	/*
	 * Az osztalyra nem vonatkozo hivasnal nem csinal semmit. Eredetileg ugy volt,
	 *   hogy ilyenkor majd meghivja a default sebzes fuggvenyt, de semmi ertelme.
	 *   Tobbet kell keresni a damages-ben, tobb fv hihas, tobb hozzaadas, stb...
	 */
	@Override
	public void getShotWithAntiDwarf(int damage) {
		this.damages.add(damage);
	}
	@Override
	public void getShotWithAntiElf(int damage) {
		// ... Ez nem vonatkozik erre az osztalyra.
	}
	@Override
	public void getShotWithAntiHobbit(int damage) {
		// ... Ez nem vonatkozik erre az osztalyra.
		
	}
	@Override
	public void getShotWithAntiHuman(int damage) {
		// ... Ez nem vonatkozik erre az osztalyra.
		
	}
	@Override
	public void split() {
		this.gamecontroller.splitDwarf(this);
		
	}
}
