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
	
	/*
	 * Az ellens�g ezen a met�duson kereszt�l �rtes�ti a feliratkozott objektumokat.
	 */
	@Override
	public void notifyFromEnemy(Enemy enemy) {
		ConsoleUI.writeSeq("Enemy.getPosition()");
		Position pos = enemy.getPosition();
		ConsoleUI.writeSeq("Enemy.getPosition() - return pos");
		
		//TODO K�rd�s: addEnenmy vagy removeEnemy kell?
		
		if(true) {
			ConsoleUI.writeSeq("addEnemy(enemy)");
			addEnemy(enemy);
			ConsoleUI.writeSeq("addEnemy(enemy) - return");
		}
		else {
			ConsoleUI.writeSeq("removeEnemy(enemy)");
			removeEnemy(enemy);
			ConsoleUI.writeSeq("removeEnemy(enemy) - return");
		}
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
		if(!enemyList.contains(e)) {
			enemyList.add(e);
		}
	}
	
	public void removeEnemy(Enemy e) {
		if(enemyList.contains(e)) {
			enemyList.remove(e);
		}
	}
	
	public void wipe() {
	
	}
}