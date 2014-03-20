<<<<<<< HEAD
package skeleton;

import java.util.List;

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
		Field f = null;
		for(Tile t : tileList) {
			if(t.getPosition().getX() == pos.getX() &&
			   t.getPosition().getY() == pos.getY() &&
			   t.getClass().equals(f.getClass())) {
					f = (Field)t;
			}
		}
		
		if(f != null) {
			ConsoleUI.writeSeq("Field.getTower()");
			Tower t = f.getTower();
			ConsoleUI.writeSeq("Field.getTower() - return t");
			if(t == null) {
				ConsoleUI.writeSeq("Field.setTower()");
				f.setTower();
				ConsoleUI.writeSeq("Field.setTower() - return");
			}
		}
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
		
		ConsoleUI.writeSeq("Road.getTrap()");
		r.getTrap();
		ConsoleUI.writeSeq("Road.getTrap() - return");
		
		ConsoleUI.writeSeq("Road.setTrap()");
		r.setTrap();
		ConsoleUI.writeSeq("Road.setTrap() - return");
		
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
		
		ConsoleUI.writeSeq("Field.resetTower()");
		f.resetTower();
		ConsoleUI.writeSeq("Field.resetTower() - return");
	}
	
}
=======
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
>>>>>>> 7ad8b3e754d245696f8ecb467c59163a68839b04
