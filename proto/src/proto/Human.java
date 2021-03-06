package proto;

import java.awt.Graphics;

/*
 * Az ember ellenseget megvalosito osztaly
 */
public class Human extends Enemy {
	private DrawHuman humanDrawer = new DrawHuman();
	final int speed = Constants.SPEED_HUMAN;
	
	/*
	 * Ember ellenseg leptetesehez, pozicionalasahoz hasznalt metodus.
	 */
	public void nextStep() {
		if(timeout <= 0) {
			Road nextroad = actroad.getNextRoad();
			if(nextroad == null) {
				gamecontroller.gameOver();
				return;
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
	 * Ember ellenseget sebzo metodus
	 */
	public void hit(boolean split, Tower tower){
		health -= tower.getDamageHuman();
		if (split) {
			gamecontroller.splitHuman(this);
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
		// ... Ez nem vonatkozik erre az osztalyra.
	}
	@Override
	public void getShotWithAntiHuman(int damage) {
		this.damages.add(damage);			
	}
	@Override
	public void split() {
		this.gamecontroller.splitHuman(this);
	}
	/**
	 * Rajzolas kezdemenyezese
	 */
	public void draw(Graphics g) {
		humanDrawer.draw(this, g);
	}
}
