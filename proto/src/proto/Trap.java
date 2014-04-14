package proto;

import java.util.ArrayList;
import java.util.List;

/*
 * Az akad�ly megval�s�t�s�hoz haszn�lt oszt�ly.
 */

public class Trap extends EnemyObserver {
	/*
	 * Az akad�ly megsz�n�s�nek ideje.
	 */
	private long endTime;
	/*
	 * Az akad�ly poz�ci�ja.
	 */
	private Position position;
	/*
	 * Az akad�lyt tartalmaz� �telem referenci�ja.
	 */
	private Road road;
	/*
	 * Az opcion�lis var�zsk�re mutat� referencia.
	 */
	private GemStone gem;
	
	/*
	 * Konstruktor
	 */
	private List<Enemy> enemyList;
	
	public Trap(){
		endTime = 10;		
		road = null;
		position = null;
		gem = null;
		enemyList = new ArrayList<Enemy>();
	}
	public Trap(Road r) {
		endTime = 10;		
		road = r;
		position = r.getPosition();
		gem = null;
		enemyList = new ArrayList<Enemy>();
	}	
	/*
	 * Az ellens�g ezen a met�duson kereszt�l �rtes�ti a feliratkozott objektumokat.
	 */
	@Override
	public void notifyFromEnemy(Enemy enemy) {
		Position enemyPosition = enemy.getPosition();
		if(enemyPosition == position){
			addEnemy(enemy);
		}
		else{
			removeEnemy(enemy);
		}
	
	}
	/*
	 * 	ellenseg hozzaadasa a listahoz
	 */
	public void addEnemy(Enemy enemy) {		
		if(!enemyList.contains(enemy)) {
			enemyList.add(enemy);
			int speed = enemy.getSpeed();			
			enemy.setSpeed(speed -5);
		}		
	}
	
	/*
	 * ellenseg eltavolitasa a listabol
	 */
	public void removeEnemy(Enemy enemy) {		
		if(enemyList.contains(enemy)) {			
			int speed = enemy.getSpeed();			
			enemy.setSpeed(speed +5);
			enemyList.remove(enemy);
		}
	}
	/*
	 * A megsz�n�s idej�nek lek�rdez�se.
	 */
	public long getEndTime() {
		return endTime;
	}
	
	/*
	 * A megsz�n�s idej�nek be�ll�t�sa.
	 */
	public void setEndTime(long endtime) {
		endTime = endtime;	
	}
	
	/*
	 * A poz�ci� lek�rdez�se.
	 */
	public Position getPosition() {
		return position;
	}
	
	/*
	 * A poz�ci� be�ll�t�sa.
	 */
	public void setPosition(Position pos) {
		position = pos;	
	}
	
	/*
	 * Az akad�lyt tartalmaz� �telem be�ll�t�sa.
	 */
	public void setRoad(Road r) {
		road = r;	
	}
	
	/*
	 * Var�zsk� hozz�ad�sa.
	 */
	public void addPlusTime(String gemstone) {
		gem = new plusTime();	
		gem.setEffect(this);
	}
	
	/*
	 * Var�zsk� l�tez�s�nek lek�rdez�se.
	 */
	public boolean isGemStoned() {
		if (gem == null){
			return false;
		}else{
			return true;
		}		
	}	
}
