package proto;

/*
 * A mezo palyaelemet megvalosito osztaly
 */
public class Field extends Tile {
	/*
	 * A terkepre mutato referencia
	 */
	private Map map;
	
	/*
	 * A mezo pozicojat tarolo attributum
	 */
	private Position position;
	
	/*
	 * A mezon talalhato toronyra mutato referencia
	 */
	private Tower tower;
	
	/*
	 * A map attributum getter metodusa
	 */
	public Map getMap() {
		return map;
	}
	
	/*
	 * A map attributum setter metodusa
	 */
	public void setMap(Map map) {
		this.map = map;
	}
	
	/*
	 * A position attributum getter metodusa
	 */
	public Position getPosition() {
		return position;
	}
	
	/*
	 * A position attributum setter metodusa
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	
	/*
	 * A tower attributum getter metodusa
	 */
	public Tower getTower() {
		return tower;
	}

	/*
	 * A tower attributum inicializalasahoz hasznalt metodus
	 */
	public void setTower() {
		tower = new Tower();
		tower.setField(this);
		tower.setPosition(this.position);
		tower.setRange(Constants.DEFAULT_TOWER_RANGE);
	}
	
	/*
	 * A mezon levo torony eltavolitasahoz hasznalt metodus
	 */
	public void resetTower() {
		tower.wipe();
		tower = null;
	}
	
	/*
	 * A mezon levo torony hatosugarat allitja a kod szerint
	 */
	public void setRange(boolean mist){
		// TODO 
		if(mist) tower.setRange((-1) * Constants.DEFAULT_TOWER_RANGE);
		else tower.setRange(Constants.DEFAULT_TOWER_RANGE);
	}
	
	/*
	 * Kulonbozo varazskovek hozzaadasa a toronyhoz
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
	 * Ez a tipus nem adhato hozza, hibauzenet
	 */
	@Override
	public void addPlusTime() {
		System.out.println("Ezt a kovet csak akadalyra lehet tenni");
	}
}
