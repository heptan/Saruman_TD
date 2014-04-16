package proto;

/*
 * Az ellenseg esemenyeire feliratkozott osztalyok ososztalya
 */
public abstract class EnemyObserver {
	
	/*
	 * Az ellenseg ezen a metoduson keresztul ertesiti a feliratkozott objektumokat.
	 */
	public abstract void notifyFromEnemy(Enemy enemy);
}
