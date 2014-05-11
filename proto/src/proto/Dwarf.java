package proto;

import java.awt.Graphics;

/**
 * A torpe ellenseget megvalosito osztaly
 */
public class Dwarf extends Enemy {

	/**
	 * A rajzolo objektumra mutato refe
	 */
	private DrawDwarf dwarfDrawer = new DrawDwarf();

	/**
	 * Az dwarf sebessege
	 */
	final int speed = Constants.SPEED_DWARF;

	/**
	 * Torpe ellenseg leptetesehez, pozicionalasahoz hasznalt metodus.
	 */
	public void nextStep() {
		if (timeout <= 0) {
			Road nextroad = actroad.getNextRoad();
			if (nextroad == null) {
				gamecontroller.gameOver();
				return;
			}

			this.position = nextroad.getPosition();
			actroad = nextroad;
			timeout = speed;

			notifyEnemyObservers();
		} else {
			timeout--;
		}
	}

	/**
	 * Torpe ellenseget sebzo metodus
	 * 
	 * @param split
	 *            Igaz, ha a loves kettevago loves
	 * @param tower
	 *            A torony, amelyiktol erkezett a sebzes
	 */
	public void hit(boolean split, Tower tower) {
		health -= tower.getDamageDwarf();
		if (split) {
			gamecontroller.splitDwarf(this);
		}
	}

	/**
	 * Az osztalyra nem vonatkozo hivasnal nem csinal semmit. Eredetileg ugy
	 * volt, hogy ilyenkor majd meghivja a default sebzes fuggvenyt, de semmi
	 * ertelme. Tobbet kell keresni a damages-ben, tobb fv hihas, tobb
	 * hozzaadas, stb...
	 * 
	 * @see proto.Enemy#getShotWithAntiDwarf(int)
	 * @param damage
	 *            Sebzes merteke
	 */
	@Override
	public void getShotWithAntiDwarf(int damage) {
		this.damages.add(damage);
	}

	/**
	 * @see proto.Enemy#getShotWithAntiElf(int)
	 */
	@Override
	public void getShotWithAntiElf(int damage) {
		// ... Ez nem vonatkozik erre az osztalyra.
	}

	/**
	 * @see proto.Enemy#getShotWithAntiHobbit(int)
	 */
	@Override
	public void getShotWithAntiHobbit(int damage) {
		// ... Ez nem vonatkozik erre az osztalyra.
	}

	/**
	 * @see proto.Enemy#getShotWithAntiHuman(int)
	 */
	@Override
	public void getShotWithAntiHuman(int damage) {
		// ... Ez nem vonatkozik erre az osztalyra.
	}

	/**
	 * Felezeshez hasznalt metodus
	 * 
	 * @see proto.Enemy#split()
	 */
	@Override
	public void split() {
		this.gamecontroller.splitDwarf(this);

	}

	/**
	 * A Dwarf rajzolasa ezen metodus hivasaval tortenik
	 * 
	 * @see proto.Enemy#draw(java.awt.Graphics)
	 */
	public void draw(Graphics g) {
		dwarfDrawer.draw(this, g);
	}
}
