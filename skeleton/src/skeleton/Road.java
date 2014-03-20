package skeleton;

/*
 * Az �t megval�s�t�s�ra haszn�lt oszt�ly.
 */
public class Road extends Tile {
	/*
	 * Az �t poz�ci�j�t t�rolja.
	 */
	private Position position;
	/*
	 * A t�rk�pre mutat� referenci�t t�rolja.
	 */
	private Map map;
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
	 * Az �t poz�ci�j�nak lek�rdez�s�hez haszn�lt met�dus.
	 */
	@Override
	public Position getPosition() {
		ConsoleUI.writeSeq("Position.getPosition()");
		ConsoleUI.writeSeq("Position.getPosition()");
		return position;
	}
	
	/*
	 * Az �t poz�ci�j�nak be�ll�t�s�hoz haszn�lt met�dus.
	 */
	@Override
	public void setPosition(Position position) {
	
	}
	
	/*
	 * A t�rk�pre mutat� referencia lek�rdez�s�hez haszn�lt met�dus.
	 */
	@Override
	public Map getMap() {
		return map;
	}
	
	/*
	 * A t�rk�pre mutat� referencia be�ll�t�s�hoz haszn�lt met�dus.
	 */
	@Override
	public void setMap(Map map) {
	
	}
	
	/*
	 * �j, az Enemy l�p�si esem�ny�re val� feliratkoz�s
	 * tov�bb�t�s�hoz haszn�lt met�dus.
	 */
	@Override
	public void addEnemyObserver(EnemyObserver observer) {
	
	}
	
	/*
	 * Az �ton l�v� opcion�lis akad�ly referenci�j�nak lek�rdez�s�hez
	 * haszn�lt met�dus.
	 */
	public Trap getTrap() {
		ConsoleUI.writeSeq("Road.getTrap()");
		ConsoleUI.writeSeq("Road.getTrap()");
		return trap;
	}
	
	/*
	 * Az �ton l�v� opcion�lis akad�ly referenci�j�nak be�ll�t�s�hoz
	 * haszn�lt met�dus.
	 */
	public void setTrap() {
		ConsoleUI.writeSeq("Road.setTrap()");
		if(trap == null) {
			trap = new Trap();
		}
		ConsoleUI.writeSeq("Road.setTrap()");
	}
	
	/*
	 * Az aktu�lis �telemet k�vet� �telem lek�rdez�s�hez sz�ks�ges
	 * met�dus.
	 */
	public Road getNextRoad() {
		ConsoleUI.writeSeq("Road.getNextRoad()");
		ConsoleUI.writeSeq("Road.getNextRoad()");
		return nextRoad;
	}
	
	/*
	 * Az �telem �rtes�l r�la, hogy egy ellens�ges egys�g l�pett r�,
	 * �s meg tudja tenni a sz�ks�ges l�p�seket.
	 */
	public void enemyHasSteppedOn(Enemy e) {
	
	}
}