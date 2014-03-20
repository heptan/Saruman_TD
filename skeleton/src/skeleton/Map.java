package skeleton;

import java.util.List;

/*
 * A térképet megvalósító osztály.
 */
public class Map {
	private List<Tile> tileList;
	private GameController gameController;
	public void setGameController(GameController gamecontroller) {
	
	}
	
	public List<Tile> getTileList() {
		return tileList;
	}
	
	public Tile getTile(Position position) {
		//TODO
		return null;
	}
	
	public void addEnemyObserver(EnemyObserver observer) {
	
	}
	
	public void addGemstone(String type, Position position) {
	
	}
	
	public void removeEnemyObserver(EnemyObserver observer) {
	
	}
	
	public void addTower(Position pos) {
	
	}
	
	public void addTrap(Position pos) {
	
	}
	
	public void removeTower(Position pos) {
	
	}
}
