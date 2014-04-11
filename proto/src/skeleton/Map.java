package skeleton;

import java.util.List;

/*
 * A térképet megvalósító osztály.
 */
public class Map {
	/*
	 * A pályaelemeket tartalmazó lista.
	 */
	private List<Tile> tileList;
	/*
	 * A játéktérre mutató referenciát tartalmazó attribútum.
	 */
	private GameController gameController;
	/*
	 * A játéktérre mutató referencia beállításához használt metódus.
	 */
	public void setGameController(GameController gamecontroller) {
	
	}
	
	/*
	 * A pályaelemeket tartalmazó lista lekérdezéséhez használt
	 * metódus
	 */
	public List<Tile> getTileList() {
		return tileList;
	}
	
	/*
	 * Adott (x, y) koordinátával rendelkezõ pályaelem
	 * referenciájának lekérdezéséhez használt metódus.
	 */
	public Tile getTile(Position position) {
		//TODO
		return null;
	}
	
	/*
	 * Új, az Enemy lépési eseményére való feliratkozás
	 * továbbításához használt metódus.
	 */
	public void addEnemyObserver(EnemyObserver observer) {
	
	}
	
	/*
	 * Új varázskõ hozzáadásához használt metódus; paraméterként van
	 * megadva az új varázskõ típusa, illetve azon pályaelem (x, y)
	 * koordinátája, amely a varázskõ helyéül kiválasztásra került
	 */
	public void addGemstone(String type, Position position) {
	
	}
	
	/*
	 * Új, az Enemy lépési eseményérõl való leiratkozás
	 * továbbításához használt metódus.
	 */
	public void removeEnemyObserver(EnemyObserver observer) {
	
	}
	
	/*
	 * Torony létrehozása (x, y) pontban.
	 */
	public void addTower(Position pos) {
		ConsoleUI.writeSeq("-->Map.addTower(pos: Position): void");
		
		Field f = new Field();
		f.getTower();
		f.setTower();
		
		ConsoleUI.writeSeq("<--void");
	}
	
	/*
	 * Akadály létrehozása (x, y) pontban.
	 */
	public void addTrap(Position pos) {
		ConsoleUI.writeSeq("-->Map.addTrap(pos: Position): void");
	
		Road r = new Road();
		r.getTrap();
		
		r.setTrap();
		
		ConsoleUI.writeSeq("<--void");
	}
	
	/*
	 * Torony törlése (x, y) pontból.
	 */
	public void removeTower(Position pos) {
		ConsoleUI.writeSeq("-->Map.removeTower(pos: Position): void");
		
		Field f = new Field();
		f.resetTower();
		
		ConsoleUI.writeSeq("<--void");
	}
}
