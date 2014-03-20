package skeleton;

import java.util.List;

/*
 * A t�rk�pet megval�s�t� oszt�ly.
 */
public class Map {
	/*
	 * A p�lyaelemeket tartalmaz� lista.
	 */
	private List<Tile> tileList;
	/*
	 * A j�t�kt�rre mutat� referenci�t tartalmaz� attrib�tum.
	 */
	private GameController gameController;
	/*
	 * A j�t�kt�rre mutat� referencia be�ll�t�s�hoz haszn�lt met�dus.
	 */
	public void setGameController(GameController gamecontroller) {
	
	}
	
	/*
	 * A p�lyaelemeket tartalmaz� lista lek�rdez�s�hez haszn�lt
	 * met�dus
	 */
	public List<Tile> getTileList() {
		return tileList;
	}
	
	/*
	 * Adott (x, y) koordin�t�val rendelkez� p�lyaelem
	 * referenci�j�nak lek�rdez�s�hez haszn�lt met�dus.
	 */
	public Tile getTile(Position position) {
		//TODO
		return null;
	}
	
	/*
	 * �j, az Enemy l�p�si esem�ny�re val� feliratkoz�s
	 * tov�bb�t�s�hoz haszn�lt met�dus.
	 */
	public void addEnemyObserver(EnemyObserver observer) {
	
	}
	
	/*
	 * �j var�zsk� hozz�ad�s�hoz haszn�lt met�dus; param�terk�nt van
	 * megadva az �j var�zsk� t�pusa, illetve azon p�lyaelem (x, y)
	 * koordin�t�ja, amely a var�zsk� hely��l kiv�laszt�sra ker�lt
	 */
	public void addGemstone(String type, Position position) {
	
	}
	
	/*
	 * �j, az Enemy l�p�si esem�ny�r�l val� leiratkoz�s
	 * tov�bb�t�s�hoz haszn�lt met�dus.
	 */
	public void removeEnemyObserver(EnemyObserver observer) {
	
	}
	
	/*
	 * Torony l�trehoz�sa (x, y) pontban.
	 */
	public void addTower(Position pos) {
	
	}
	
	/*
	 * Akad�ly l�trehoz�sa (x, y) pontban.
	 */
	public void addTrap(Position pos) {
	
	}
	
	/*
	 * Torony t�rl�se (x, y) pontb�l.
	 */
	public void removeTower(Position pos) {
	
	}
}
