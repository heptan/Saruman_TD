package proto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * A torony megval�s�t�s�hoz haszn�lt oszt�ly.
 */
public class Tower extends EnemyObserver {
	/*
	 * A torony poz�ci�ja.
	 */
	private Position position;
	/*
	 * A torony hat�t�vols�ga.
	 */
	private double range;
	/*
	 * A toronyhoz tartoz� mez� referenci�ja.
	 */
	private Field field;
	/*
	 * A toronyhoz tartoz� var�zsk�vek.
	 */
	private List<GemStone> gemList;
	/*
	 * A torony hat�sugar�ban l�v� ellens�gek.
	 */
	private  List<Enemy> enemyList = new ArrayList<Enemy>();
	
	/*
	 * Konstruktor
	 */
	public Tower() {
		ConsoleUI.writeSeq("-->new Tower(): Tower");
		ConsoleUI.writeSeq("<--Tower");
	}
	
	/*
	 * Konstruktor tesztel�shez
	 */
	public Tower(boolean test) {
	}
	
	/*
	 * Az ellens�g ezen a met�duson kereszt�l �rtes�ti a feliratkozott objektumokat.
	 */
	@Override
	public void notifyFromEnemy(Enemy enemy) {
		ConsoleUI.writeSeq("-->Tower.notifyFromEnemy(enemy: Enemy): void");
		
		Position pos = enemy.getPosition();
		
		//TODO K�rd�s: addEnenmy vagy removeEnemy kell?
		
		System.out.println("\n   Valasszon egy valaszlehetoseget! \n");
		System.out.println("      0 - |pos-t.position| <= range && !t.enemyList.contain(e)");
		System.out.println("      1 - |pos-t.position| > range");
		String answer = "";
		while(!answer.equals("0") && !answer.equals("1")) {
			System.out.print("\n   Valasz: ");
			answer = "";
			BufferedReader br = new BufferedReader( new InputStreamReader(
					System.in));
			try {
				answer = br.readLine();
			} catch (IOException e) {
				System.out.println("Hiba tortent a beolvasas kozben");
				e.printStackTrace();
			}
		}
		
		if(answer.equals("0")) {
			addEnemy(enemy);
		}
		else {
			enemyList.add(enemy);
			removeEnemy(enemy);
		}
		
		ConsoleUI.writeSeq("<--void");
	}
	
	/*
	 * A torony poz�ci�j�nak lek�rdez�se.
	 */
	public Position getPosition() {
		return position;
	}
	
	/*
	 * A torony poz�ci�j�nak be�ll�t�sa.
	 */
	public void setPosition(Position position) {
	
	}
	
	/*
	 * A torony hat�t�vols�g�nak lek�rdez�se.
	 */
	public double getRange() {
		return range;
	}
	
	/*
	 * A torony hat�t�vols�g�nak be�ll�t�sa.
	 */
	public void setRange(double range) {
	
	}
	
	/*
	 * A toronyhoz tartoz� mez� referenci�j�nak be�ll�t�sa.
	 */
	public void setField(Field field) {
	
	}
	
	/*
	 * �j var�zsk� hozz�ad�sa.
	 */
	public void addGemStone(String gemstone) {
	
	}
	
	/*
	 * A var�zsk�vek list�j�nak lek�rdez�se.
	 */
	public List<GemStone> getGemStoneList() {
		return gemList;
	}
	
	/*
	 * 	Hozz�ad egy ellens�get a list�hoz.
	 */
	public void addEnemy(Enemy e) {
		ConsoleUI.writeSeq("-->addEnemy(e: Enemy): void");
		if(!enemyList.contains(e)) {
			enemyList.add(e);
		}
		ConsoleUI.writeSeq("<--void");
	}
	
	/*
	 * Elt�vol�t egy ellens�get a list�r�l.
	 */
	public void removeEnemy(Enemy e) {
		ConsoleUI.writeSeq("-->removeEnemy(e: Enemy): void");
		if(enemyList.contains(e)) {
			enemyList.remove(e);
		}
		ConsoleUI.writeSeq("<--void");
	}
	
	/*
	 * Torony t�rl�se.
	 */
	public void wipe() {
		ConsoleUI.writeSeq("-->Tower.wipe(): void");
		ConsoleUI.writeSeq("<--void");
	}
}