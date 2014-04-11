package proto;

/*
 * A p�lyaelem megval�s�t�s�hoz haszn�lt oszt�ly.
 */
public abstract class Tile {
	/*
	 * A p�lyaelem poz�ci�ja.
	 */
	private Position position;
	/*
	 * A t�rk�pre mutat� referencia.
	 */
	private Map map;
	
	/*
	 * A p�lyaelem poz�ci�j�t k�rdezi le.
	 */
	public Position getPosition() {
		return position;
	}
	
	/*
	 * A p�lyaelem poz�ci�j�t �ll�tja be.
	 */
	public void setPosition(Position position) {
	
	}
	
	/*
	 * A t�rk�pre mutat� referenci�t �ll�tja be.
	 */
	public void setMap(Map map) {
	
	}
	
	/*
	 * A t�rk�pre mutat� referenci�t k�rdezi le.
	 */
	public Map getMap() {
		return map;
	}
	
	/*
	 * �j, az Enemy l�p�si esem�ny�re val� feliratkoz�s
	 * tov�bb�t�s�hoz haszn�lt met�dus.
	 */
	public void addEnemyObserver(EnemyObserver observer) {
	
	}
	
	/*
	 * �j var�zsk� hozz�ad�s�hoz haszn�lt met�dus.
	 */
	public void addGemStone(String gemstone) {
	
	}
}