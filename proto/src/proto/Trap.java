package proto;

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
	public Trap() {
		ConsoleUI.writeSeq("-->new Trap(): Trap");
		ConsoleUI.writeSeq("<--Trap");
	}
	
	/*
	 * Konstruktor, tesztel�shez
	 */
	public Trap(boolean f) {
	}
	
	/*
	 * Az ellens�g ezen a met�duson kereszt�l �rtes�ti a feliratkozott objektumokat.
	 */
	@Override
	public void notifyFromEnemy(Enemy enemy) {
	
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
	public void setPosition(Position position) {
	
	}
	
	/*
	 * Az akad�lyt tartalmaz� �telem be�ll�t�sa.
	 */
	public void setRoad(Road road) {
	
	}
	
	/*
	 * Var�zsk� hozz�ad�sa.
	 */
	public void addGemStone(String gemstone) {
		ConsoleUI.writeSeq("-->Trap.addGemStone(\"PlusTime\": String): void");
		GemStone g = new plusTime();
		ConsoleUI.writeSeq("<--void");
	}
	
	/*
	 * Var�zsk� l�tez�s�nek lek�rdez�se.
	 */
	public boolean isGemStoned() {
		//TODO
		return false;
	}

	/*
	 * Az akad�ly �rtes�l r�la, hogy egy ellens�ges egys�g l�pett r�,
	 * �s meg tudja tenni a sz�ks�ges l�p�seket.
	 */
	public void enemyHasSteppedOn(Enemy e) {
		ConsoleUI.writeSeq("-->Trap.enemyHasSteppedOn(e: Enemy): void");
		e.setSpeed(0);
		ConsoleUI.writeSeq("<--void");
	}
}
