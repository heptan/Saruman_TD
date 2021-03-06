package proto;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * Az akadalyt megvalosito osztaly
 */

public class Trap extends EnemyObserver {
	/**
	 * Rajzolo objektum
	 */
	private DrawTrap trapDrawer = new DrawTrap();
	/**
	 * Az akadaly megszuneseig hatralevo ido
	 */
	private long endTime;
	/**
	 * Az akadaly pozicioja
	 */
	private Position position;
	/**
	 * Az ut, amin az akadaly van
	 */
	private Road road;
	/**
	 * Az opcionalis varazsko
	 */
	private GemStone gem;

	/**
	 * Az akadalyon tartozkodo ellensegek listaja
	 */
	private List<Enemy> enemyList;

	/**
	 * Default konstruktor
	 */
	public Trap() {
		endTime = Constants.TRAP_ENDTIME;
		road = null;
		position = null;
		gem = null;
		enemyList = new ArrayList<Enemy>();
	}

	/**
	 * Konstruktor ami az utat varja parameternek
	 */
	public Trap(Road r) {
		endTime = 10;
		road = r;
		position = r.getPosition();
		gem = null;
		enemyList = new ArrayList<Enemy>();
	}

	/**
	 * Az ellenseg ertesitese a lepesrol
	 * @see proto.EnemyObserver#notifyFromEnemy(proto.Enemy)
	 */
	@Override
	public void notifyFromEnemy(Enemy enemy) {
		Position enemyPosition = enemy.getPosition();
		if (enemyPosition == position) {
			addEnemy(enemy);
		} else {
			removeEnemy(enemy);
		}

	}

	/**
	 * ellenseg hozzaadasa a listahoz
	 */
	public void addEnemy(Enemy enemy) {
		if (!enemyList.contains(enemy)) {
			enemyList.add(enemy);
			int timeout = enemy.getTimeout();
			enemy.setTimeout(timeout + 1);
		}
	}

	/**
	 * ellenseg eltavolitasa a listabol
	 */
	public void removeEnemy(Enemy enemy) {
		if (enemyList.contains(enemy)) {
			enemyList.remove(enemy);
		}
	}

	/**
	 * A megszunes idejenek lekerdezese
	 */
	public long getEndTime() {
		return endTime;
	}

	/**
	 * A megszunes idejenek beallitasa
	 */
	public void setEndTime(long endtime) {
		endTime = endtime;
	}

	/**
	 * A pozicio lekerdezese
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * A pozicio bellitasa
	 */
	public void setPosition(Position pos) {
		position = pos;
	}

	/**
	 * Az akadalyt tartalmazo ut beallitasa
	 */
	public void setRoad(Road r) {
		road = r;
	}

	/**
	 * Varazsko hozzaadasa
	 */
	public void addPlusTime() {
		if(gem == null){
			gem = new PlusTime();
			gem.setEffect(this);
			gem.setPosition(position);// beallitjuk a poziciojat
		}
	}

	/**
	 * Varazsko letenek lekerdezese
	 */
	public boolean isGemStoned() {
		if (gem == null) {
			return false;
		} else {
			return true;
		}
	}
	/**
	 * Rajzolas kezdemenyezese
	 */
	public void draw(Graphics g) {
		trapDrawer.draw(this, g);
		if(gem!= null){
			gem.draw(g);
		}
	}
}
