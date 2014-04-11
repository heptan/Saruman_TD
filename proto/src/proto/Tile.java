package proto;

/*
 * A p�lyaelem megval�s�t�s�hoz haszn�lt oszt�ly.
 */
public abstract class Tile {
	/*
	 * A t�rk�pre mutat� referencia.
	 */
	protected Map map;
	
	/*
	 * A p�lyaelem poz�ci�ja.
	 */
	protected Position position;

	/*
	 * A t�rk�pre mutat� referenci�t k�rdezi le.
	 */
	public Map getMap() {
		return map;
	}
	
	/*
	 * A t�rk�pre mutat� referenci�t �ll�tja be.
	 */
	public void setMap(Map map) {
		this.map = map;
	}
	
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
		this.position = position;
	}
	
	/*
	 * �j, az Enemy l�p�si esem�ny�re val� feliratkoz�s
	 * tov�bb�t�s�hoz haszn�lt met�dus.
	 */
	public abstract void addEnemyObserver(EnemyObserver observer);
	
	/*
	 * �j var�zsk� hozz�ad�s�hoz haszn�lt met�dusok.
	 */
	public abstract void addAntiHuman();
	public abstract void addAntiElf();
	public abstract void addAntiDwarf();
	public abstract void addAntiHobbit();
	public abstract void addPlusFrequency();
	public abstract void addPlusRange();
	public abstract void addPlusTime();
}