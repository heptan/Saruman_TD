package skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	private  List<Enemy> enemyList = new ArrayList<Enemy>();
	
	/*
	 * Konstruktor
	 */
	public Tower() {
		ConsoleUI.writeSeq("-->new Tower()");
		ConsoleUI.writeSeq("<--Tower");
	}
	
	/*
	 * Konstruktor teszteléshez
	 */
	public Tower(boolean test) {
	}
	
	/*
	 * Az ellenség ezen a metóduson keresztül értesíti a feliratkozott objektumokat.
	 */
	@Override
	public void notifyFromEnemy(Enemy enemy) {
		ConsoleUI.writeSeq("-->Tower.notifyFromEnemy(enemy: Enemy)");
		
		Position pos = enemy.getPosition();
		
		//TODO Kérdés: addEnenmy vagy removeEnemy kell?
		
		System.out.println("\n   Valasszon egy valaszlehetoseget! ");
		System.out.println("      0 - |pos-t.position| <= range && !t.enemyList.contain(e)");
		System.out.println("      1 - |pos-t.position| > range");
		System.out.print("   Valasz: ");
		String answer = "";
		while(!answer.equals("0") && !answer.equals("1")) {
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