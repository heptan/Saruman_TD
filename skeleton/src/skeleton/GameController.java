package skeleton;

import java.util.List;

/*
 * A játéktér megvalósítására használt osztály. 
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
