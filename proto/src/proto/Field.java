package proto;

/*
 * A mez� p�lyaelemet megval�s�t� oszt�ly
 * (.)  (.)
 *  |    |
 *  |    |
 *  |    |
 *    ()
 */
public class Field extends Tile {
	/*
	 * A t�rk�pre mutat� referencia
	 */
	private Map map = null;
	
	/*
	 * A mez� poz�c�j�t t�rol� attrib�tum
	 */
	private Position position = null;
	
	/*
	 * A mez�n tal�lhat� toronyra mutat� referencia. Ha nincs ilyen, akkor null.
	 */
	private Tower tower = null;
	
	/*
	 * A map attrib�tum getter met�dusa
	 */
	public Map getMap() {
		return map;
	}
	
	/*
	 * A map attrib�tum setter met�dusa
	 */
	public void setMap(Map map) {
		this.map = map;
	}
	
	/*
	 * A position attrib�tum getter met�dusa
	 */
	public Position getPosition() {
		return position;
	}
	
	/*
	 * A position attrib�tum setter met�dusa
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	
	/*
	 * A tower attrib�tum getter met�dusa
	 */
	public Tower getTower() {
		return tower;
	}

	/*
	 * A tower attrib�tum inicializ�l�s�hoz haszn�lt met�dus
	 */
	public void setTower() {
		
	}
	
	/*
	 * A mez�n l�v� torony elt�vol�t�s�hoz haszn�lt met�dus
	 */
	public void resetTower() {
		ConsoleUI.writeSeq("-->Field.resetTower(): void");
		tower = new Tower(true);
		tower.wipe();
		
		ConsoleUI.writeSeq("<--void");
	}
	
	/*
	 * A mez�n l�v� torony hat�sugar�t �ll�tja a k�d szerint
	 */
	public void setRange(boolean mist){
		
	}

	/*
	 * �j Enemy-t megfigyel� observer
	 */
	public void addEnemyObserver(EnemyObserver observer) {
	
	}
	
	@Override
	public void addAntiHuman() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAntiElf() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAntiDwarf() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAntiHobbit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPlusFrequency() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPlusRange() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPlusTime() {
	}
}
