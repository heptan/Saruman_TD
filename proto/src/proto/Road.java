package proto;

/*
 * Az ut megvalositasara hasznalt osztaly
 */
public class Road extends Tile {
	/*
	 * A terkepre mutato referenciat tarolja
	 */
	private Map map;

	/*
	 * Az ut poziciojat tarolja
	 */
	private Position position;

	/*
	 * Az uton levo akadaly referenciajat tarolja
	 * (ha nincs akadaly, akkor null)
	 */
	private Trap trap;

	/*
	 * Az ellenseg haladasa szerinti kovetkezo utelemet tarolja
	 */
	private Road nextRoad;

	/*
	 * Az uton levo akadaly referenciajanak lekerdezese
	 */
	public Trap getTrap() {
		return trap;
	}
	
	/*
	 * Az uton levo akadaly referenciajanak beallitasa
	 */
	public void setTrap() {
		trap = new Trap();
	}
	
	/*
	 * Az aktualis utelemet koveto utelem lekerdezese
	 */
	public Road getNextRoad() {
		return nextRoad;
	}
	
	/*
	 * Az aktualis utelemet koveto utelem beallitasa
	 */
	public void setNextRoad(Road road) {
		nextRoad = road;
	}
	
	/*
	 * Az akadaly idejet meghosszabbito varazsko hozzaadasa
	 */
	@Override
	public void addPlusTime() {
		trap.addPlusTime();
	}

	/*
	 * A tobbi tipust itt nem hasznalhatjuk, hiba
	 */
	@Override
	public void addAntiHuman() {
		System.out.println("Ezt a kovet csak toronyra lehet tenni");
	}

	@Override
	public void addAntiElf() {
		System.out.println("Ezt a kovet csak toronyra lehet tenni");
	}

	@Override
	public void addAntiDwarf() {
		System.out.println("Ezt a kovet csak toronyra lehet tenni");
	}

	@Override
	public void addAntiHobbit() {
		System.out.println("Ezt a kovet csak toronyra lehet tenni");
	}

	@Override
	public void addPlusFrequency() {
		System.out.println("Ezt a kovet csak toronyra lehet tenni");
	}

	@Override
	public void addPlusRange() {
		System.out.println("Ezt a kovet csak toronyra lehet tenni");
	}
}