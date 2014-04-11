package proto;

/*
 * Az út megvalósítására használt osztály
 */
public class Road extends Tile {
	/*
	 * A térképre mutató referenciát tárolja
	 */
	private Map map;

	/*
	 * Az út pozícióját tárolja
	 */
	private Position position;

	/*
	 * Az úton lévő akadály referenciáját tárolja
	 * (ha nincs akadály, akkor null)
	 */
	private Trap trap;

	/*
	 * Az ellenség haladása szerinti következő útelemet tárolja
	 */
	private Road nextRoad;

	/*
	 * Az úton lévő akadály referenciájának lekérdezése
	 */
	public Trap getTrap() {
		return trap;
	}
	
	/*
	 * Az úton lévő akadály referenciájának beállítása
	 */
	public void setTrap() {
		trap = new Trap();
	}
	
	/*
	 * Az aktuális útelemet követő útelem lekérdezése
	 */
	public Road getNextRoad() {
		return nextRoad;
	}
	
	/*
	 * Az aktuális útelemet követő útelem beállítása
	 */
	public void setNextRoad(Road road) {
		nextRoad = road;
	}
	
	/*
	 * Az akadály idejét meghosszabbító varázskő hozzáadása
	 */
	@Override
	public void addPlusTime() {
		trap.addPlusTime();
	}

	/*
	 * A többi típust itt nem használhatjuk, hiba
	 */
	@Override
	public void addAntiHuman() {
		System.out.println("Ezt a követ csak toronyra lehet tenni");
	}

	@Override
	public void addAntiElf() {
		System.out.println("Ezt a követ csak toronyra lehet tenni");
	}

	@Override
	public void addAntiDwarf() {
		System.out.println("Ezt a követ csak toronyra lehet tenni");
	}

	@Override
	public void addAntiHobbit() {
		System.out.println("Ezt a követ csak toronyra lehet tenni");
	}

	@Override
	public void addPlusFrequency() {
		System.out.println("Ezt a követ csak toronyra lehet tenni");
	}

	@Override
	public void addPlusRange() {
		System.out.println("Ezt a követ csak toronyra lehet tenni");
	}
}