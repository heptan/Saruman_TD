package skeleton;

/*
 * Az akadály megvalósításához használt osztály.
 */

public class Trap extends EnemyObserver {
	/*
	 * Az akadály megszûnésének ideje.
	 */
	private long endTime;
	/*
	 * Az akadály pozíciója.
	 */
	private Position position;
	/*
	 * Az akadályt tartalmazó útelem referenciája.
	 */
	private Road road;
	/*
	 * Az opcionális varázskõre mutató referencia.
	 */
	private GemStone gem;
	
	/*
	 * Konstruktor
	 */
	public Trap() {
		ConsoleUI.writeSeq("-->new Trap(): Trap");
		ConsoleUI.writeSeq("<--Trap");
	}
	
	/*
	 * Konstruktor, teszteléshez
	 */
	public Trap(boolean f) {
	}
	
	/*
	 * Az ellenség ezen a metóduson keresztül értesíti a feliratkozott objektumokat.
	 */
	@Override
	public void notifyFromEnemy(Enemy enemy) {
	
	}
	
	/*
	 * A megszûnés idejének lekérdezése.
	 */
	public long getEndTime() {
		return endTime;
	}
	
	/*
	 * A megszûnés idejének beállítása.
	 */
	public void setEndTime(long endtime) {
	
	}
	
	/*
	 * A pozíció lekérdezése.
	 */
	public Position getPosition() {
		return position;
	}
	
	/*
	 * A pozíció beállítása.
	 */
	public void setPosition(Position position) {
	
	}
	
	/*
	 * Az akadályt tartalmazó útelem beállítása.
	 */
	public void setRoad(Road road) {
	
	}
	
	/*
	 * Varázskõ hozzáadása.
	 */
	public void addGemStone(String gemstone) {
		ConsoleUI.writeSeq("-->Trap.addGemStone(\"PlusTime\": String): void");
		GemStone g = new plusTime();
		ConsoleUI.writeSeq("<--void");
	}
	
	/*
	 * Varázskõ létezésének lekérdezése.
	 */
	public boolean isGemStoned() {
		//TODO
		return false;
	}

	/*
	 * Az akadály értesül róla, hogy egy ellenséges egység lépett rá,
	 * és meg tudja tenni a szükséges lépéseket.
	 */
	public void enemyHasSteppedOn(Enemy e) {
		ConsoleUI.writeSeq("-->Trap.enemyHasSteppedOn(e: Enemy): void");
		e.setSpeed(0);
		ConsoleUI.writeSeq("<--void");
	}
}
