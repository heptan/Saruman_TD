package skeleton;

import java.util.ArrayList;
import java.util.List;

/*
 * A térképet megvalósító osztály.
 */
public class Map {
	private List<Tile> tileList = new ArrayList<Tile>();
	private GameController gameController;
	private boolean mist;
	
	
	/*
	 * A játéktérre mutató referencia beállításához használt metódus.
	 */
	public void setGameController(GameController gamecontroller) {
		gameController = gamecontroller;
	}
	
	/*
	 * A pályaelemeket tartalmazó lista lekérdezéséhez használt
	 * metódus
	 */
	public List<Tile> getTileList() {
		return tileList;
	}
	
	/*
	 * Adott (x, y) koordinátával rendelkezõ pályaelem
	 * referenciájának lekérdezéséhez használt metódus.
	 */
	public Tile getTile(Position position) {
		// Mivel nem taroltuk el a palya meretet, ezert egyesevel vegig
		//   kell nezni minden elemet...
		// ja, es nem kell == operatort irni Position osztalynak
		int x = (int) position.getX(), y = (int) position.getY();
		int match = tileList.size();
		for (int i = 0; i < tileList.size(); ++i){
			if (tileList.get(i).getPosition().getX() == x &&
				tileList.get(i).getPosition().getY() == y){
				match = i;
				break;
			}
		}
		if (match < tileList.size())
			return tileList.get(match);
		else
			return null;
	}
	
	/*
	 * Új, az Enemy lépési eseményére való feliratkozás
	 * továbbításához használt metódus.
	 */
	public void addEnemyObserver(EnemyObserver observer) {
		gameController.addEnemyObserver(observer);
	}
	
	/*
	 * Új varázskõ hozzáadásához használt metódus; paraméterként van
	 * megadva az új varázskõ típusa, illetve azon pályaelem (x, y)
	 * koordinátája, amely a varázskõ helyéül kiválasztásra került
	 */
	public void addGemstone(String type, Position position) {
		int x = (int) position.getX(), y = (int) position.getY();
		int match = tileList.size();
		for (int i = 0; i < tileList.size(); ++i){
			if (tileList.get(i).getPosition().getX() == x &&
				tileList.get(i).getPosition().getY() == y){
				match = i;
				break;
			}
		}
		if (match == tileList.size()){
			ConsoleUI.writeSimple("Nem letezo pozicio.");
			return;
		}
		else {
			if (tileList.get(match) instanceof Road){
				if (((Road) tileList.get(match)).getTrap() != null){
					((Road) tileList.get(match)).getTrap().addGemStone(type);
				}
			}
			else{
				if (((Field) tileList.get(match)).getTower() != null){
					((Field) tileList.get(match)).getTower().addGemStone(type);
				}
			}
		}
	}
	
	/*
	 * Új, az Enemy lépési eseményérõl való leiratkozás
	 * továbbításához használt metódus.
	 */
	public void removeEnemyObserver(EnemyObserver observer) {
		gameController.removeEnemyObserver(observer);
	}
	
	/*
	 * Torony létrehozása (x, y) pontban.
	 */
	public void addTower(Position pos) {
		int x = (int) pos.getX(), y = (int) pos.getY();
		int match = tileList.size();
		for (int i = 0; i < tileList.size(); ++i){
			if (tileList.get(i).getPosition().getX() == x &&
				tileList.get(i).getPosition().getY() == y){
				match = i;
				break;
			}
		}
		if (match == tileList.size()){
			ConsoleUI.writeSimple("Nem letezo pozicio.");
			return;
		}
		else{
			if (tileList.get(match) instanceof Road){
				ConsoleUI.writeSimple("Utra nem helyezhet tornyot.");
				return;
			}
			else{
				if (((Field) tileList.get(match)).getTower() != null){
					ConsoleUI.writeSimple("Itt mar van torony");
					return;
				}
				else{
					((Field) tileList.get(match)).setTower();
				}
			}
		}
	}
	
	/*
	 * Akadály létrehozása (x, y) pontban.
	 */
	public void addTrap(Position pos) {
		int x = (int) pos.getX(), y = (int) pos.getY();
		int match = tileList.size();
		for (int i = 0; i < tileList.size(); ++i){
			if (tileList.get(i).getPosition().getX() == x &&
				tileList.get(i).getPosition().getY() == y){
				match = i;
				break;
			}
		}
		if (match == tileList.size()){
			ConsoleUI.writeSimple("Nem letezo pozicio.");
			return;
		}
		else{
			if (tileList.get(match) instanceof Field){
				ConsoleUI.writeSimple("Mezore nem helyezhet akadalyt.");
				return;
			}
			else{
				if (((Road) tileList.get(match)).getTrap() != null){
					ConsoleUI.writeSimple("Itt mar van akadaly");
					return;
				}
				else{
					((Road) tileList.get(match)).setTrap();
				}
			}
		}
	}
	
	/*
	 * Torony törlése (x, y) pontból.
	 */
	public void removeTower(Position pos) {
		int x = (int) pos.getX(), y = (int) pos.getY();
		int match = tileList.size();
		for (int i = 0; i < tileList.size(); ++i){
			if (tileList.get(i).getPosition().getX() == x &&
				tileList.get(i).getPosition().getY() == y){
				match = i;
				break;
			}
		}
		if (match == tileList.size()){
			ConsoleUI.writeSimple("Nem letezo pozicio.");
			return;
		}
		else{
			// ezeket azert hagyom benne, hogy ha valami difi lenne a pos
			//   atadasanal, akkor itt kiderulhessen, amugy ez jozan esszel
			//   atgondolva nem kovetkezhet be, hiszen csak letezo toronyra
			//   hivodhat meg ez
			if (tileList.get(match) instanceof Road){
				ConsoleUI.writeSimple("Utrol nem torolhet tornyot.");
				return;
			}
			else{
				if (((Field) tileList.get(match)).getTower() != null){
					ConsoleUI.writeSimple("Itt nincs is torony!");
					return;
				}
				else{
					((Field) tileList.get(match)).resetTower();
				}
			}
		}
	}
	
	boolean isMisty(){
		return mist == true ? true : false;
	}
	
	void setMist(boolean m){
		mist = m;
	}
}
