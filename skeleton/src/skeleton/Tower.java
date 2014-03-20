package skeleton;

import java.util.List;

/*
 * A torony megval�s�t�s�hoz haszn�lt oszt�ly.
 */
public class Tower extends EnemyObserver {
	private Position position;
	private double range;
	private Field field;
	private List<GemStone> gemList;
	private  List<Enemy> enemyList;
	
	public Tower() {
		ConsoleUI.writeSeq("new Tower()");
		ConsoleUI.writeSeq("new Tower()");
	}
	
	/*
	 * Az ellens�g ezen a met�duson kereszt�l �rtes�ti a feliratkozott objektumokat.
	 */
	@Override
	public void notifyFromEnemy(Enemy enemy) {
		ConsoleUI.writeSeq("Tower.notifyFromEnemy(enemy: Enemy)");
		
		Position pos = enemy.getPosition();
		
		//TODO K�rd�s: addEnenmy vagy removeEnemy kell?
		
		if(true) {
			addEnemy(enemy);
		}
		else {
			removeEnemy(enemy);
		}
		
		ConsoleUI.writeSeq("Tower.notifyFromEnemy(enemy: Enemy)");
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
	
	}
	
	public double getRange() {
		return range;
	}
	
	public void setRange(double range) {
	
	}
	
	public void setField(Field field) {
	
	}
	
	public void addGemStone(String gemstone) {
	
	}
	
	public List<GemStone> getGemStoneList() {
		return gemList;
	}
	
	public void addEnemy(Enemy e) {
		ConsoleUI.writeSeq("addEnemy(e: Enemy)");
		if(!enemyList.contains(e)) {
			enemyList.add(e);
		}
		ConsoleUI.writeSeq("addEnemy(e: Enemy)");
	}
	
	public void removeEnemy(Enemy e) {
		ConsoleUI.writeSeq("removeEnemy(e: Enemy)");
		if(enemyList.contains(e)) {
			enemyList.remove(e);
		}
		ConsoleUI.writeSeq("removeEnemy(e: Enemy)");
	}
	
	public void wipe() {
		ConsoleUI.writeSeq("Tower.wipe()");
		ConsoleUI.writeSeq("Tower.wipe()");
	}
}