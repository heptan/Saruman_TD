package proto;

import java.util.ArrayList;
import java.util.List;

/*
 * Author: VAM
 * Az ellensegek l�trehoz�sa, nyilvantartasa, ha kell, akkor kettobe 
 * vagasa, az EnemyObserverek regisztralasanak kezelese, a palya 
 * letrehozasa, inicializalasa, illetve a jatekvege feltetelek figyelese. 
 */
public class GameController {
	private List<Enemy> enemies = new ArrayList<Enemy>();	// ellenseglista
	private List<Road> path = new ArrayList<Road>();		// valaszthato utelemkbol allo utak
									//   listaja (szerintem folosleges)
	private int enemyCounter = 0;	// az eddig letrehozott ellenseges
									//   egysegeket szamolja
	private Map map = new Map();	// hivatkozas a palyara
	
	// Singleton mintahoz szukseges valtozo
	private static GameController instance = null;

	private GameController() {
		// Igy ezt csak a getInstance es csak egyszer tudja meghivni.
	}
	public static GameController getInstace() {
		if (instance == null){
			instance = new GameController();
		}
		return instance;
	}
	
	/*
	 * Minden ellenseges egyseg observer listajahoz hozzaadja a parameterben
	 *   atadott objektumot.
	 */
	public void addEnemyObserver(EnemyObserver observer) {
		for (Enemy e : enemies)
			e.addObserver(observer);
	}
	
	/*
	 * Minden ellenseges egyszeg observer listajabol eltavolitja a parameterben
	 *   atadott objektumot. Ez a torony, vagy akadaly torlodesenel hivodhat 
	 *   meg.
	 */
	public void removeEnemyObserver(EnemyObserver observer) {
		for (Enemy e : enemies)
			e.removeObserver(observer);
	}
	
	/*
	 * Ha egy ellenseges egyseg eler a Vegzet Hegyehez, akkor meghivodik ez a 
	 *   metodus. Ertesiti a jatekost a nyeresrol, torli az ellenseges
	 *   egysegeket, az akadalyokat, tornyokat, a palyat es a rajta talallhato 
	 *   mezoket.
	 */
	public void gameOver() {
//		ConsoleUI.writeSeq("-->GameController.gameOver(): void");
//		ConsoleUI.writeSeq("<--void");
		System.out.println("A jatek veget ert, az ellenseg elpusztitotta az"
				+ " egy gyurut a vegzet hegyenel.");
		// akadalyok megszuntetese: az endTime valtozo modos�tasa ugy, hogy
		//   azonnal megszunjenek
// TODO
		// lekerjuk a palyaelemeket tartalmazo listat
		List<Tile> temp = map.getTileList();
		// Vegigiteralunk rajta es minden elemnel megnezzuk, hogy ut, vagy
		//   mezo, s ennek megfeleloen toroljuk az opcionalisan rajta levo 
		//   akadalyt, vagy tornyot, majd a referenciat null-ra allitjuk.
		for (Tile t : temp) {
			if (t instanceof Road){
				if (((Road) t).getTrap() != null){
					((Road) t).getTrap().setEndTime(/*...*/0);					
				}
			}
			else {
				if (((Field) t).getTower() != null){
					((Field) t).getTower().wipe();
				}
			}	
		}
// TODO ilyen fuggveny nincs a Map osztalyban
		// toroljuk ki az osszes palyaelemet a Map osztaly listajabol
		//map.clearTiles();
		// majd a palyan levo ellensegeket is
		enemies.clear();
		// vegul az "utakat"
		path.clear();
		enemyCounter = 0;
		map = null;
	}
	
	public void win() {
		if (enemyCounter == 30 && enemies.isEmpty()){
			System.out.println("A jatek veget ert, az osszes ellenseges egyseg "
					+ "elpusztult, Saruman dicsoseges uralkodasa folytatodik!");
// TODO
			// lekerjuk a palyaelemeket tartalmazo listat
			List<Tile> temp = map.getTileList();
			// Vegigiteralunk rajta es minden elemnel megnezzuk, hogy ut, vagy
			//   mezo, s ennek megfeleloen toroljuk az opcionalisan rajta levo 
			//   akadalyt, vagy tornyot, majd a referenciat null-ra allitjuk.
			for (Tile t : temp) {
				if (t instanceof Road){
					if (((Road) t).getTrap() != null){
						((Road) t).getTrap().setEndTime(/*...*/0);					
					}
				}
				else {
					if (((Field) t).getTower() != null){
						((Field) t).getTower().wipe();
					}
				}	
			}
// TODO ilyen fuggveny nincs a Map osztalyban
			// toroljuk ki az osszes palyaelemet a Map osztaly listajabol
			//map.clearTiles();
			// majd a palyan levo ellensegeket is
			enemies.clear();
			// vegul az "utakat"
			path.clear();
			enemyCounter = 0;
		}
		
	}
	
	public List<Enemy> getEnemyList() {
		return enemies;
	}
	
	/*
	 * Uj ellenseges egyseg felvetele az enemies listaba, observer listajank
	 *   beallitasa, illetve az enemyCounter novelese.
	 */
	public void startNewEnemy() {
		// Az enemies listahoz hozzaadunk egy uj ellenseget,
		//   az inicializalasa az Enemy osztalyban tortenik meg, viszont
		//   be kell allitani az observer listajat.
		//TODO
		//enemies.add(new Enemy());
// TODO ujonnan hozzaadott enemy observer listajanak feltoltese, 
//      illetve javitasa, ha lehetseges egy tower listara a map osztalyban
		for (Tile t : map.getTileList()){
			if (t instanceof Field){
				if (((Field) t).getTower() != null)
					enemies.get(enemies.size()).addObserver(((Field) t).getTower());
			}
			else {
				if (((Road) t).getTrap() != null){
					enemies.get(enemies.size()).addObserver(((Road) t).getTrap());
				}
			}
		}
		++enemyCounter;
	}
	
	void splitDwarf(Dwarf d){
		enemies.add(new Dwarf());
		enemies.get(enemies.size()).setActRoad(d.getActRoad());
		enemies.get(enemies.size()).setHealth(d.getHealth());
		enemies.get(enemies.size()).setPosition(d.getPosition());
		enemies.get(enemies.size()).setSpeed(d.getSpeed());
		enemies.get(enemies.size()).setTimeout(d.getTimeout());
		for (Tile t : map.getTileList()){
			if (t instanceof Field){
				if (((Field) t).getTower() != null)
					enemies.get(enemies.size()).addObserver(((Field) t).getTower());
			}
			else {
				if (((Road) t).getTrap() != null){
					enemies.get(enemies.size()).addObserver(((Road) t).getTrap());
				}
			}
		}
		++enemyCounter;
	}
	
	void splitElf(Elf e){
		enemies.add(new Elf());
		enemies.get(enemies.size()).setActRoad(e.getActRoad());
		enemies.get(enemies.size()).setHealth(e.getHealth());
		enemies.get(enemies.size()).setPosition(e.getPosition());
		enemies.get(enemies.size()).setSpeed(e.getSpeed());
		enemies.get(enemies.size()).setTimeout(e.getTimeout());
		for (Tile t : map.getTileList()){
			if (t instanceof Field){
				if (((Field) t).getTower() != null)
					enemies.get(enemies.size()).addObserver(((Field) t).getTower());
			}
			else {
				if (((Road) t).getTrap() != null){
					enemies.get(enemies.size()).addObserver(((Road) t).getTrap());
				}
			}
		}
		++enemyCounter;
	}
	
	void splitHobbit(Hobbit h){
		enemies.add(new Hobbit());
		enemies.get(enemies.size()).setActRoad(h.getActRoad());
		enemies.get(enemies.size()).setHealth(h.getHealth());
		enemies.get(enemies.size()).setPosition(h.getPosition());
		enemies.get(enemies.size()).setSpeed(h.getSpeed());
		enemies.get(enemies.size()).setTimeout(h.getTimeout());
		for (Tile t : map.getTileList()){
			if (t instanceof Field){
				if (((Field) t).getTower() != null)
					enemies.get(enemies.size()).addObserver(((Field) t).getTower());
			}
			else {
				if (((Road) t).getTrap() != null){
					enemies.get(enemies.size()).addObserver(((Road) t).getTrap());
				}
			}
		}
		++enemyCounter;
	}
	
	void splitHuman(Human h){
		enemies.add(new Human());
		enemies.get(enemies.size()).setActRoad(h.getActRoad());
		enemies.get(enemies.size()).setHealth(h.getHealth());
		enemies.get(enemies.size()).setPosition(h.getPosition());
		enemies.get(enemies.size()).setSpeed(h.getSpeed());
		enemies.get(enemies.size()).setTimeout(h.getTimeout());
		for (Tile t : map.getTileList()){
			if (t instanceof Field){
				if (((Field) t).getTower() != null)
					enemies.get(enemies.size()).addObserver(((Field) t).getTower());
			}
			else {
				if (((Road) t).getTrap() != null){
					enemies.get(enemies.size()).addObserver(((Road) t).getTrap());
				}
			}
		}
		++enemyCounter;
	}

	public void removeEnemy(Enemy enemy) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * A terkep lekerdezesehez hasznalt metodus, a prototipus kepernyore kiirato fuggvenyei hivjak
	 */
	public Map getMap() {
		return this.map;
	}
	
	/*
	 * A terkep beallitasahoz hasznalt metodus, a prototipus inicializalasakor hivodik
	 */
	public void setMap(Map map) {
		this.map = map;
	}
	
}
