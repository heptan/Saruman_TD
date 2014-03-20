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
		ConsoleUI.writeSeq("Map.addTower(pos: Position)");
		
		Field f = null;
		for(Tile t : tileList) {
			if(t.getPosition().getX() == pos.getX() &&
			   t.getPosition().getY() == pos.getY() &&
			   t.getClass().equals(f.getClass())) {
					f = (Field)t;
			}
		}
		
		if(f != null) {
			Tower t = f.getTower();
			if(t == null) {
				f.setTower();
			}
		}
		
		ConsoleUI.writeSeq("Map.addTower(pos: Position)");
	}
	
	public void addTrap(Position pos) {
		Road r = null;
		for(Tile t : tileList) {
			if(t.getPosition().getX() == pos.getX() &&
			   t.getPosition().getY() == pos.getY() &&
			   t.getClass().equals(Road.class)) {
					r = (Road)t;
			}
		}
		
		r.getTrap();
		r.setTrap();
		
	}
	
	public void removeTower(Position pos) {
		Field f = null;
		for(Tile t : tileList) {
			if(t.getPosition().getX() == pos.getX() &&
			   t.getPosition().getY() == pos.getY() &&
			   t.getClass().equals(Field.class)) {
					f = (Field)t;
			}
		}
		
		f.resetTower();
	}
	
}
