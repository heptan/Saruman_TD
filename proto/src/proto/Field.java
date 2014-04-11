package proto;

/*
 * A mező pályaelemet megvalósító osztály
 */
public class Field extends Tile {
	/*
	 * A térképre mutató referencia
	 */
	private Map map;
	
	/*
	 * A mező pozícóját tároló attribútum
	 */
	private Position position;
	
	/*
	 * A mezőn található toronyra mutató referencia
	 */
	private Tower tower;
	
	/*
	 * A map attribútum getter metódusa
	 */
	public Map getMap() {
		return map;
	}
	
	/*
	 * A map attribútum setter metódusa
	 */
	public void setMap(Map map) {
		this.map = map;
	}
	
	/*
	 * A position attribútum getter metódusa
	 */
	public Position getPosition() {
		return position;
	}
	
	/*
	 * A position attribútum setter metódusa
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	
	/*
	 * A tower attribútum getter metódusa
	 */
	public Tower getTower() {
		return tower;
	}

	/*
	 * A tower attribútum inicializálásához használt metódus
	 */
	public void setTower() {
		tower = new Tower();
	}
	
	/*
	 * A mezőn lévő torony eltávolításához használt metódus
	 */
	public void resetTower() {
		tower.wipe();
		tower = null;
	}
	
	/*
	 * A mezőn lévő torony hatósugarát állítja a köd szerint
	 */
	public void setRange(boolean mist){
		// TODO 
		if(mist) tower.setRange((-1) * Constants.DEFAULT_TOWER_RANGE);
		else tower.setRange(Constants.DEFAULT_TOWER_RANGE);
	}
	
	/*
	 * Különböző varázskövek hozzáadása a toronyhoz
	 */
	@Override
	public void addAntiHuman() {
		tower.addAntiHuman();
	}

	@Override
	public void addAntiElf() {
		tower.addAntiElf();
	}

	@Override
	public void addAntiDwarf() {
		tower.addAntiDwarf();
	}

	@Override
	public void addAntiHobbit() {
		tower.addAntiHobbit();
	}

	@Override
	public void addPlusFrequency() {
		tower.addPlusFrequency();
	}

	@Override
	public void addPlusRange() {
		tower.addPlusRange();
	}

	/*
	 * Ez a típus nem adható hozzá, hibaüzenet
	 */
	@Override
	public void addPlusTime() {
		System.out.println("Ezt a követ csak akadályra lehet tenni");
	}
}
