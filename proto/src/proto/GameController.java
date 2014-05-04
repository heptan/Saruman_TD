package proto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Author: VAM
 * Az ellensegek letrehozasa, nyilvantartasa, ha kell, akkor kettobe 
 * vagasa, az EnemyObserverek regisztralasanak kezelese, a palya 
 * letrehozasa, inicializalasa, illetve a jatekvege feltetelek figyelese. 
 */
public class GameController {
	private boolean gameover = false;
	private boolean win = false;
	private List<Enemy> enemies = new ArrayList<Enemy>(); // ellenseglista
	private List<Road> path = new ArrayList<Road>(); // valaszthato utelemkbol
														// allo utak
	// listaja (szerintem folosleges)
	private int enemyCounter = 0; // az eddig letrehozott ellenseges
									// egysegeket szamolja
	private Map map = new Map(); // hivatkozas a palyara

	// Singleton mintahoz szukseges valtozo
	private static GameController instance = null;

	// Veletlenszeru viselkedes megvalositasahoz szukseges, jelzi, hogy be-e van
	// kapcsolva a veletlenszeru viselkedes
	private boolean israndomized = true;

	private GameTimer gametimer;
	public void setGameTimer(GameTimer gt) {
		this.gametimer = gt;
	}
	
	public GameController() {
		// Igy ezt csak a getInstance es csak egyszer tudja meghivni.
	}

	public static GameController getInstace() {
		if (instance == null) {
			instance = new GameController();
		}
		return instance;
	}

	/*
	 * Minden ellenseges egyseg observer listajahoz hozzaadja a parameterben
	 * atadott objektumot.
	 */
	public void addEnemyObserver(EnemyObserver observer) {
		for (Enemy e : enemies)
			e.addObserver(observer);
	}

	/*
	 * Minden ellenseges egyszeg observer listajabol eltavolitja a parameterben
	 * atadott objektumot. Ez a torony, vagy akadaly torlodesenel hivodhat meg.
	 */
	public void removeEnemyObserver(EnemyObserver observer) {
		for (Enemy e : enemies)
			e.removeObserver(observer);
	}

	/*
	 * Ha egy ellenseges egyseg eler a Vegzet Hegyehez, akkor meghivodik ez a
	 * metodus. Ertesiti a jatekost a nyeresrol, torli az ellenseges egysegeket,
	 * az akadalyokat, tornyokat, a palyat es a rajta talallhato mezoket.
	 */
	public void gameOver() {
		this.gametimer.pause();
		// ConsoleUI.writeSeq("-->GameController.gameOver(): void");
		// ConsoleUI.writeSeq("<--void");
		System.out.println("A jatek elveszitve!");
		// akadalyok megszuntetese: az endTime valtozo modositasa ugy, hogy
		// azonnal megszunjenek
		// TODO
		// lekerjuk a palyaelemeket tartalmazo listat
		List<Tile> temp = map.getTileList();
		// Vegigiteralunk rajta es minden elemnel megnezzuk, hogy ut, vagy
		// mezo, s ennek megfeleloen toroljuk az opcionalisan rajta levo
		// akadalyt, vagy tornyot, majd a referenciat null-ra allitjuk.
		for (Tile t : temp) {
			if (t instanceof Road) {
				if (((Road) t).getTrap() != null) {
					((Road) t).getTrap().setEndTime(/* ... */0);
				}
			} else {
				if (((Field) t).getTower() != null) {
					((Field) t).getTower().wipe();
				}
			}
		}
		// toroljuk ki az osszes palyaelemet a Map osztaly listajabol
		map.clearTiles();
		// majd a palyan levo ellensegeket is
		enemies.clear();
		// vegul az "utakat"
		path.clear();
		enemyCounter = 0;
		gameover = true;
	}

	public void win() {
		win = true;
		this.gametimer.pause();
		if (enemyCounter >= Constants.ENEMY_COUNTER_MAX && enemies.isEmpty()) {
			// majd a palyan levo ellensegeket is
			enemies.clear();
			// vegul az "utakat"
			path.clear();
			enemyCounter = 0;

			MapPrinter.printMap(this);

			// lekerjuk a palyaelemeket tartalmazo listat
			List<Tile> temp = map.getTileList();
			// Vegigiteralunk rajta es minden elemnel megnezzuk, hogy ut, vagy
			// mezo, s ennek megfeleloen toroljuk az opcionalisan rajta levo
			// akadalyt, vagy tornyot, majd a referenciat null-ra allitjuk.
			for (Tile t : temp) {
				if (t instanceof Road) {
					if (((Road) t).getTrap() != null) {
						((Road) t).getTrap().setEndTime(/* ... */0);
					}
				} else {
					if (((Field) t).getTower() != null) {
						((Field) t).getTower().wipe();
					}
				}
			}
			// toroljuk ki az osszes palyaelemet a Map osztaly listajabol
			map.clearTiles();

			System.out.println("A jatek megnyerve!");
		}

	}

	public List<Enemy> getEnemyList() {
		return enemies;
	}

	/*
	 * Uj ellenseges egyseg felvetele az enemies listaba, observer listajank
	 * beallitasa, illetve az enemyCounter novelese.
	 */
	public void startNewEnemy(double posx, double posy, String type) {
		// Az enemies listahoz hozzaadunk egy uj ellenseget,
		// az inicializalasa az Enemy osztalyban tortenik meg, viszont
		// be kell allitani az observer listajat.
		if (map.getTile(posx, posy).getClass() != Road.class) {
			System.out.println("Ellenseget csak utra lehet rakni!");
			return;
		}
		switch (type) {
		case "dwarf":
			enemies.add(new Dwarf());
			break;
		case "elf":
			enemies.add(new Elf());
			break;
		case "hobbit":
			enemies.add(new Hobbit());
			break;
		case "human":
			enemies.add(new Human());
			break;
		}
		enemies.get(enemies.size() - 1).setPosition(new Position(posx, posy));
		enemies.get(enemies.size() - 1).setHealth(Constants.ENEMY_MAX_HEALTH);
		enemies.get(enemies.size() - 1).setActRoad(
				(Road) map.getTile(posx, posy));
		enemies.get(enemies.size() - 1).setGameController(this);
		// ujonnan hozzaadott enemy observer listajanak feltoltese,
		// illetve javitasa, ha lehetseges egy tower listara a map osztalyban
		for (Tile t : map.getTileList()) {
			if (t instanceof Field) {
				if (((Field) t).getTower() != null)
					enemies.get(enemies.size() - 1).addObserver(
							((Field) t).getTower());
			} else {
				if (((Road) t).getTrap() != null) {
					enemies.get(enemies.size() - 1).addObserver(
							((Road) t).getTrap());
				}
			}
		}
		++enemyCounter;
	}

	/*
	 * Dwarf szetvagasa
	 */
	void splitDwarf(Dwarf d) {
		enemies.add(new Dwarf());
		splitCommonSetup(d);
	}

	/*
	 * Elf szetvagasa
	 */
	void splitElf(Elf e) {
		enemies.add(new Elf());
		splitCommonSetup(e);
	}

	/*
	 * Hobbit szetvagasa
	 */
	void splitHobbit(Hobbit h) {
		enemies.add(new Hobbit());
		splitCommonSetup(h);
	}

	/*
	 * Human szetvagasa
	 */
	void splitHuman(Human h) {
		enemies.add(new Human());
		splitCommonSetup(h);
	}

	/*
	 * Enemy szetvagasanak klonozasa
	 */
	void splitCommonSetup(Enemy e) {
		enemies.get(enemies.size() - 1).setActRoad(e.getActRoad());
		enemies.get(enemies.size() - 1).setHealth(e.getHealth());
		enemies.get(enemies.size() - 1).setPosition(e.getPosition());
		enemies.get(enemies.size() - 1).setSpeed(e.getSpeed());
		enemies.get(enemies.size() - 1).setTimeout(e.getTimeout());
		enemies.get(enemies.size() - 1)
				.setGameController(e.getGameController());
		for (Tile t : map.getTileList()) {
			if (t instanceof Field) {
				if (((Field) t).getTower() != null)
					enemies.get(enemies.size() - 1).addObserver(
							((Field) t).getTower());
			} else {
				if (((Road) t).getTrap() != null) {
					enemies.get(enemies.size() - 1).addObserver(
							((Road) t).getTrap());
				}
			}
		}
		++enemyCounter;
	}

	/*
	 * Ellenseg eltavolitasa az ellenseglistabol
	 */
	public void removeEnemy(Enemy enemy) {
		enemies.remove(enemy);
	}

	/*
	 * A terkep lekerdezesehez hasznalt metodus, a prototipus kepernyore kiirato
	 * fuggvenyei hivjak
	 */
	public Map getMap() {
		return this.map;
	}

	/*
	 * A terkep beallitasahoz hasznalt metodus, a prototipus inicializalasakor
	 * hivodik
	 */
	public void setMap(Map map) {
		this.map = map;
	}

	/*
	 * Egyet lep a jatekbeli kor szamlalo.
	 */
	void nextStep() {
		if(gameover == true || win == true) {
			return;
		}
		// Ellensegek automatikus letrehozasa
		if (enemies.size() < 2) {
			for (int i = 0;i < (enemyCounter/2 + 1) && 
						   enemyCounter	< Constants.ENEMY_COUNTER_MAX; ++i){
				Random rndGen = new Random();
				int rndType = rndGen.nextInt(4);
				String type[] = {"dwarf", "elf", "hobbit", "human"};
				this.startNewEnemy(0, 0, type[rndType]);
			}
		}
		boolean mist = false;
		if (isRandomized()) {
			Random randomGenerator = new Random();
			// Veletlenszam 0 es 9 kozott
			int randomInt = randomGenerator.nextInt(10);
			// ha a kapott veletlen szam 1, lesz kod
			mist = randomInt == 1 ? true : false;
		} else {
			System.out.println("\nLegyen kod? {i|n}\n");

			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			try {
				String inputtext = br.readLine();
				if (inputtext.trim().equals("i")) {
					mist = true;
				} else if (inputtext.trim().equals("n")) {
					mist = false;
				} else {
					System.out.println("Nem ervenyes bemenet, nem lesz kod!");
				}
			} catch (Exception e) {
				System.out
						.println("Hiba a bemenet beolvasasakor, nem lesz kod!");
			}
		}

		// Ha kod van, akkor csokkentjuk a tornyok hatosugarat
		for (Tile t : map.getTileList()) {
			if (t instanceof Field) {
				if (((Field) t).getTower() != null) {
					if ((mist && !map.isMisty()) || (!mist && map.isMisty())) {
						((Field) t).setRange(mist);
					}
				}
			}
		}
		map.setMist(mist);

		if (enemies.size() == 0 && enemyCounter >= Constants.ENEMY_COUNTER_MAX) {
			win();
			return;
		}
		for (int i = 0; i < enemies.size() && !gameover; ++i) {
			enemies.get(i).nextStep();
		}
		for (Tile t : map.getTileList()) {
			if (t == null) {
				return;
			}
			if (t instanceof Field) {
				if (((Field) t).getTower() != null) {
					((Field) t).getTower().shoot();
					if (map.getTileList() == null
							|| map.getTileList().size() == 0) {
						break;
					}
				}
			} else {
				if (((Road) t).getTrap() != null) {
					// hoho! ide nem is kell semmi, mert az ellenseg, ha
					// notify-olja a trap-et, akkor az lassitja, ha meg
					// mar nincs azon az uton ahol a trap, akkor hanyagolja!
					Trap trap = ((Road) t).getTrap();
					trap.setEndTime(trap.getEndTime() - 1);
				}
			}
		}
		if (enemies.size() == 0 && enemyCounter >= Constants.ENEMY_COUNTER_MAX) {
			win();
		}
	}

	/*
	 * Veltenlenszeru viselkedes allapotanak lekerdezese
	 */
	public boolean isRandomized() {
		return israndomized;
	}

	/*
	 * Veltenlenszeru viselkedes beallitasa
	 */
	public void setRandomized(boolean israndomized) {
		this.israndomized = israndomized;
	}

	/*
	 * Terkep meretenek lekerdezese
	 */
	public Position getMapSize() {
		if (map != null) {
			return map.getSize();
		}
		return null;
	}
}
