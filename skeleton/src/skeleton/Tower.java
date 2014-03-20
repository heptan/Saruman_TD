package skeleton;

import java.util.List;

/*
 * A torony megvalósításához használt osztály.
 */
public class Tower extends EnemyObserver {
	/*
	 * A torony pozíciója.
	 */
	private Position position;
	/*
	 * A torony hatótávolsága.
	 */
	private double range;
	/*
	 * A toronyhoz tartozó mezõ referenciája.
	 */
	private Field field;
	/*
	 * A toronyhoz tartozó varázskövek.
	 */
	private List<GemStone> gemList;
	/*
	 * A torony hatósugarában lévõ ellenségek.
	 */
	private  List<Enemy> enemyList;
	
	/*
	 * Konstruktor.
	 */
	public Tower() {
		ConsoleUI.writeSeq("-->new Tower()");
		ConsoleUI.writeSeq("<--Tower");
	}
	
	/*
	 * Az ellenség ezen a metóduson keresztül értesíti a feliratkozott objektumokat.
	 */
	@Override
	public void notifyFromEnemy(Enemy enemy) {
		ConsoleUI.writeSeq("-->Tower.notifyFromEnemy(enemy: Enemy)");
		
		Position pos = enemy.getPosition();
		
		//TODO Kérdés: addEnenmy vagy removeEnemy kell?
		
		if(true) {
			addEnemy(enemy);
		}
		else {
			removeEnemy(enemy);
		}
		
		ConsoleUI.writeSeq("<--void");
	}
	
	/*
	 * A torony pozíciójának lekérdezése.
	 */
	public Position getPosition() {
		return position;
	}
	
	/*
	 * A torony pozíciójának beállítása.
	 */
	public void setPosition(Position position) {
	
	}
	
	/*
	 * A torony hatótávolságának lekérdezése.
	 */
	public double getRange() {
		return range;
	}
	
	/*
	 * A torony hatótávolságának beállítása.
	 */
	public void setRange(double range) {
	
	}
	
	/*
	 * A toronyhoz tartozó mezõ referenciájának beállítása.
	 */
	public void setField(Field field) {
	
	}
	
	/*
	 * Új varázskõ hozzáadása.
	 */
	public void addGemStone(String gemstone) {
	
	}
	
	/*
	 * A varázskövek listájának lekérdezése.
	 */
	public List<GemStone> getGemStoneList() {
		return gemList;
	}
	
	/*
	 * 	Hozzáad egy ellenséget a listához.
	 */
	public void addEnemy(Enemy e) {
		ConsoleUI.writeSeq("-->addEnemy(e: Enemy)");
		if(!enemyList.contains(e)) {
			enemyList.add(e);
		}
		ConsoleUI.writeSeq("<--void");
	}
	
	/*
	 * Eltávolít egy ellenséget a listáról.
	 */
	public void removeEnemy(Enemy e) {
		ConsoleUI.writeSeq("-->removeEnemy(e: Enemy)");
		if(enemyList.contains(e)) {
			enemyList.remove(e);
		}
		ConsoleUI.writeSeq("<--void");
	}
	
	/*
	 * Torony törlése.
	 */
	public void wipe() {
		ConsoleUI.writeSeq("-->Tower.wipe()");
		ConsoleUI.writeSeq("<--void");
	}
}