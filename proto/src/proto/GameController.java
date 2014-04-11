package proto;

import java.util.List;

/*
 * A j�t�kt�r megval�s�t�s�ra haszn�lt oszt�ly. 
 */
public class GameController {
	private List<Enemy> enemies;
	private List<Road> path;
	private int enemyCounter;
	private Map map;
	public void addEnemyObserver(EnemyObserver observer) {
	
	}
	
	public void removeEnemyObserver(EnemyObserver observer) {
	
	}
	
	public void gameOver() {
		ConsoleUI.writeSeq("-->GameController.gameOver(): void");
		ConsoleUI.writeSeq("<--void");
	}
	
	public void win() {

	}
	
	public List<Enemy> getEnemyList() {
		return enemies;
	}
	
	public void startNewEnemy() {
	
	}
}
