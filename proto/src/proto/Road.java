package proto;

/*
 * Az �t megval�s�t�s�ra haszn�lt oszt�ly.
 */
public class Road extends Tile {
	/*
	 * A t�rk�pre mutat� referenci�t t�rolja.
	 */
	private Map map;

	/*
	 * Az �t poz�ci�j�t t�rolja.
	 */
	private Position position;

	/*
	 * Az �ton l�v� opcion�lis akad�ly referenci�j�t t�rolja
	 * (ha nincs akad�ly, akkor null).
	 */
	private Trap trap;

	/*
	 * Az ellens�g halad�sa szerinti k�vetkez� �telemet t�rolja.
	 */
	private Road nextRoad;

	/*
	 * Az �ton l�v� opcion�lis akad�ly referenci�j�nak lek�rdez�s�hez
	 * haszn�lt met�dus.
	 */
	public Trap getTrap() {
		return trap;
	}
	
	/*
	 * Az �ton l�v� opcion�lis akad�ly referenci�j�nak be�ll�t�s�hoz
	 * haszn�lt met�dus.
	 */
	public void setTrap() {
		trap = new Trap();
	}
	
	/*
	 * Az aktu�lis �telemet k�vet� �telem lek�rdez�s�hez sz�ks�ges
	 * met�dus.
	 */
	public Road getNextRoad() {
		return nextRoad;
	}
	
	/*
	 * Az aktu�lis �telemet k�vet� �telem be�ll�t�s�hoz sz�ks�ges
	 * met�dus.
	 */
	public void setNextRoad(Road road) {
		nextRoad = road;
	}
	
	@Override
	public void addPlusTime() {
		trap.addPlusTime();
	}

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