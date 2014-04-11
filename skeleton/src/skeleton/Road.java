package skeleton;

/*
 * Az út megvalósítására használt osztály.
 */
public class Road extends Tile {
	/*
	 * Az út pozícióját tárolja.
	 */
	private Position position;
	/*
	 * A térképre mutató referenciát tárolja.
	 */
	private Map map;
	/*
	 * Az úton lévõ opcionális akadály referenciáját tárolja
	 * (ha nincs akadály, akkor null).
	 */
	private Trap trap = new Trap(false);
	/*
	 * Az ellenség haladása szerinti következõ útelemet tárolja.
	 */
	private Road nextRoad;

	/*
	 * Az út pozíciójának lekérdezéséhez használt metódus.
	 */
	@Override
	public Position getPosition() {
		ConsoleUI.writeSeq("-->Road.getPosition(): Position");
		ConsoleUI.writeSeq("<--Position");
		return position;
	}
	
	/*
	 * Az út pozíciójának beállításához használt metódus.
	 */
	@Override
	public void setPosition(Position position) {
	
	}
	
	/*
	 * A térképre mutató referencia lekérdezéséhez használt metódus.
	 */
	@Override
	public Map getMap() {
		return map;
	}
	
	/*
	 * A térképre mutató referencia beállításához használt metódus.
	 */
	@Override
	public void setMap(Map map) {
	
	}
	
	/*
	 * Új, az Enemy lépési eseményére való feliratkozás
	 * továbbításához használt metódus.
	 */
	@Override
	public void addEnemyObserver(EnemyObserver observer) {
	
	}
	
	/*
	 * Az úton lévõ opcionális akadály referenciájának lekérdezéséhez
	 * használt metódus.
	 */
	public Trap getTrap() {
		ConsoleUI.writeSeq("-->Road.getTrap(): Trap");
		ConsoleUI.writeSeq("<--null");
		return null;
	}
	
	/*
	 * Az úton lévõ opcionális akadály referenciájának beállításához
	 * használt metódus.
	 */
	public void setTrap() {
		ConsoleUI.writeSeq("-->Road.setTrap(): void");
		
		trap = new Trap();
		
		ConsoleUI.writeSeq("<--void");
	}
	
	/*
	 * Az aktuális útelemet követõ útelem lekérdezéséhez szükséges
	 * metódus.
	 */
	public Road getNextRoad() {
		ConsoleUI.writeSeq("-->Road.getNextRoad(): Road");
		ConsoleUI.writeSeq("<--Road");
		return nextRoad;
	}
	
	/*
	 * Az aktuális útelemet követõ útelem beállításához szükséges
	 * metódus.
	 */
	public void setNextRoad(Road road) {
		nextRoad = road;
	}
	
	/*
	 * Az útelem értesül róla, hogy egy ellenséges egység lépett rá,
	 * és meg tudja tenni a szükséges lépéseket.
	 */
	public void enemyHasSteppedOn(Enemy e) {
		ConsoleUI.writeSeq("-->Road.enemyHasSteppedOn(e: Enemy): void");
		trap.enemyHasSteppedOn(e);
		ConsoleUI.writeSeq("<--void");
	}
	
	/*
	 * Skeleton teszteléshez
	 */
	public void gemDeployment() {
		trap = new Trap(false);
		trap.addGemStone("PlusTime");
	}
}
