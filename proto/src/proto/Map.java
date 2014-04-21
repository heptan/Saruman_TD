package proto;

import java.util.ArrayList;
import java.util.List;

/*
 * Author: VAM
 * A terkepet megvalosito osztaly.
 */
public class Map {
	private List<Tile> tilelist = new ArrayList<Tile>();
	private GameController gameController;
	private boolean mist;
	
	
	/*
	 * A jatekterre mutato referencia beallitasahoz hasznalt metodus.
	 */
	public void setGameController(GameController gamecontroller) {
		gameController = gamecontroller;
	}
	
	/*
	 * A palyaelemeket tartalmazo lista lekerdezesehez hasznalt
	 * metodus
	 */
	public List<Tile> getTileList() {
		return tilelist;
	}
	
	/*
	 * Uj palyaelem hozzadasa a terkephez
	 */
	public void addTile(Tile tile) {
		tilelist.add(tile);
	}
	
	/*
	 * Palyaelem lista beallitasahoz hasznalt metodus
	 */
	public void setTileList(List<Tile> tilelist) {
		this.tilelist = tilelist;
	}
	
	/*
	 * Adott (x, y) koordinataval rendelkezo palyaelem
	 * referenciajanak lekerdezesehez hasznalt metodus.
	 */
	public Tile getTile(double x, double y) {
		// Mivel nem taroltuk el a palya meretet, ezert egyesevel vegig
		// kell nezni minden elemet...
		// ja, es nem kell == operatort irni Position osztalynak
		int match = tilelist.size();
		for (int i = 0; i < tilelist.size(); ++i){
			if (tilelist.get(i).getPosition().getX() == x &&
				tilelist.get(i).getPosition().getY() == y){
				match = i;
				break;
			}
		}
		if (match < tilelist.size())
			return tilelist.get(match);
		else
			return null;
	}
	
	/*
	 * Uj, az Enemy lepesi esemenyere valo feliratkozast kezelo
	 * tovabbitasahoz hasznalt metodus.
	 */
	public void addEnemyObserver(EnemyObserver observer) {
		gameController.addEnemyObserver(observer);
	}
	
	/*
	 * Uj varazsko hozzaadasahoz hasznalt metodus;
	 * parameterkent van megadva az uj varazsko tipusa, illetve azon palyaelem (x, y)
	 * koordinataja, amely a varazsko helyeul kivalasztasra kerult
	 */
	public void addGemstone(String type, Position position) {
		int x = (int) position.getX(), y = (int) position.getY();
		int match = tilelist.size();
		for (int i = 0; i < tilelist.size(); ++i){
			if (tilelist.get(i).getPosition().getX() == x &&
				tilelist.get(i).getPosition().getY() == y){
				match = i;
				break;
			}
		}
		if (match == tilelist.size()){
			return;
		}
		else {
			if (tilelist.get(match) instanceof Road){
				if (((Road) tilelist.get(match)).getTrap() != null){
					((Road) tilelist.get(match)).getTrap().addPlusTime();
				}
			}
			else{
				if (((Field) tilelist.get(match)).getTower() != null){
					//TODO Kulon gemstone-ok szerint, kulon metodus hivas!
					//((Field) tileList.get(match)).getTower().addGemStone(type);
				}
			}
		}
	}
	
	/*
	 * Az Enemy lepesi esemenyerol valo leiratkozas tovabbitasahoz hasznalt metodus
	 */
	public void removeEnemyObserver(EnemyObserver observer) {
		gameController.removeEnemyObserver(observer);
	}
	
	/*
	 * Torony letrehozasa (x, y) pontban.
	 */
	public void addTower(Position pos) {
		int x = (int) pos.getX(), y = (int) pos.getY();
		int match = tilelist.size();
		for (int i = 0; i < tilelist.size(); ++i){
			if (tilelist.get(i).getPosition().getX() == x &&
				tilelist.get(i).getPosition().getY() == y){
				match = i;
				break;
			}
		}
		if (match == tilelist.size()){
			return;
		}
		else{
			if (tilelist.get(match) instanceof Road){
				return;
			}
			else{
				if (((Field) tilelist.get(match)).getTower() != null){
					return;
				}
				else{
					((Field) tilelist.get(match)).setTower();
				}
			}
		}
	}
	
	/*
	 * Akadaly letrehozasa (x, y) pontban.
	 */
	public void addTrap(Position pos) {
		int x = (int) pos.getX(), y = (int) pos.getY();
		int match = tilelist.size();
		for (int i = 0; i < tilelist.size(); ++i){
			if (tilelist.get(i).getPosition().getX() == x &&
				tilelist.get(i).getPosition().getY() == y){
				match = i;
				break;
			}
		}
		if (match == tilelist.size()){
			return;
		}
		else{
			if (tilelist.get(match) instanceof Field){
				return;
			}
			else{
				if (((Road) tilelist.get(match)).getTrap() != null){
					return;
				}
				else{
					((Road) tilelist.get(match)).setTrap();
				}
			}
		}
	}
	
	/*
	 * Torony torlese (x, y) pontbol.
	 */
	public void removeTower(Position pos) {
		int x = (int) pos.getX(), y = (int) pos.getY();
		int match = tilelist.size();
		for (int i = 0; i < tilelist.size(); ++i){
			if (tilelist.get(i).getPosition().getX() == x &&
				tilelist.get(i).getPosition().getY() == y){
				match = i;
				break;
			}
		}
		if (match == tilelist.size()){
			return;
		}
		else{
			// ezeket azert hagyom benne, hogy ha valami difi lenne a pos
			// atadasanal, akkor itt kiderulhessen, amugy ez jozan esszel
			// atgondolva nem kovetkezhet be, hiszen csak letezo toronyra
			// hivodhat meg ez
			if (tilelist.get(match) instanceof Road){
				return;
			}
			else{
				if (((Field) tilelist.get(match)).getTower() != null){
					return;
				}
				else{
					((Field) tilelist.get(match)).resetTower();
				}
			}
		}
	}
	
	/*
	 * Kod aktualis allapotanak lekerdezesehez hasznalt metodus
	 */
	boolean isMisty(){
		return mist == true ? true : false;
	}
	
	/*
	 * Kod aktualis allapotanak beallitasahoz hasznalt metodus
	 */
	void setMist(boolean m){
		mist = m;
	}
	
	/*
	 * Terkep meretenek lekerdezesehez hasznalt metodus
	 */
	public Position getSize() {
		double max_x = 0, max_y = 0;
		for(Tile t : tilelist) {
			if(t.getPosition().getX() > max_x) {
				max_x = t.getPosition().getX();
			}
			if(t.getPosition().getY() > max_y) {
				max_y = t.getPosition().getY();
			}
		}
		
		return new Position(max_x, max_y);
	}
	
	/*
	 * Adott ut palyaelem ut szomszedjait adja vissza
	 */
	public List<Road> getRoadNeighbours(double x, double y) {
		List<Road> roads = new ArrayList<Road>();
		
		Road up = null;
		for(Tile t : tilelist) {
			Position pos = t.getPosition();
			if(pos.getX() == x && pos.getY() == y - 1 && t.getClass() == Road.class) {
				up = (Road)t;
			}
		}
		if(up != null) {
			roads.add(up);
		}
		
		Road down = null;
		for(Tile t : tilelist) {
			Position pos = t.getPosition();
			if(pos.getX() == x && pos.getY() == y + 1 && t.getClass() == Road.class) {
				down = (Road)t;
			}
		}
		if(down != null) {
			roads.add(down);
		}
		
		Road left = null;
		for(Tile t : tilelist) {
			Position pos = t.getPosition();
			if(pos.getX() == x - 1 && pos.getY() == y && t.getClass() == Road.class) {
				left = (Road)t;
			}
		}
		if(left != null) {
			roads.add(left);
		}
		
		Road right = null;
		for(Tile t : tilelist) {
			Position pos = t.getPosition();
			if(pos.getX() == x + 1 && pos.getY() == y && t.getClass() == Road.class) {
				right = (Road)t;
			}
		}
		if(right != null) {
			roads.add(right);
		}
		
		return roads;
	}
	
	void clearTiles() {
		tilelist.clear();
	}
}
