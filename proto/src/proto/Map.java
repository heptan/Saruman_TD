package skeleton;

import java.util.ArrayList;
import java.util.List;

/*
 * A t�rk�pet megval�s�t� oszt�ly.
 */
public class Map {
	private List<Tile> tileList = new ArrayList<Tile>();
	private GameController gameController;
	private boolean mist;
	
	
	/*
	 * A j�t�kt�rre mutat� referencia be�ll�t�s�hoz haszn�lt met�dus.
	 */
	public void setGameController(GameController gamecontroller) {
		gameController = gamecontroller;
	}
	
	/*
	 * A p�lyaelemeket tartalmaz� lista lek�rdez�s�hez haszn�lt
	 * met�dus
	 */
	public List<Tile> getTileList() {
		return tileList;
	}
	
	/*
	 * Adott (x, y) koordin�t�val rendelkez� p�lyaelem
	 * referenci�j�nak lek�rdez�s�hez haszn�lt met�dus.
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
	 * �j, az Enemy l�p�si esem�ny�re val� feliratkoz�s
	 * tov�bb�t�s�hoz haszn�lt met�dus.
	 */
	public void addEnemyObserver(EnemyObserver observer) {
		gameController.addEnemyObserver(observer);
	}
	
	/*
	 * �j var�zsk� hozz�ad�s�hoz haszn�lt met�dus; param�terk�nt van
	 * megadva az �j var�zsk� t�pusa, illetve azon p�lyaelem (x, y)
	 * koordin�t�ja, amely a var�zsk� hely��l kiv�laszt�sra ker�lt
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
			return;
		}
		else {
			if (tileList.get(match) instanceof Road){
				if (((Road) tileList.get(match)).getTrap() != null){
					((Road) tileList.get(match)).getTrap().addPlusTime("");
				}
			}
			else{
				if (((Field) tileList.get(match)).getTower() != null){
					//TODO Kulon gemstone-ok szerint, kulon metodus hivas!
					((Field) tileList.get(match)).getTower().addGemStone(type);
				}
			}
		}
	}
	
	/*
	 * �j, az Enemy l�p�si esem�ny�r�l val� leiratkoz�s
	 * tov�bb�t�s�hoz haszn�lt met�dus.
	 */
	public void removeEnemyObserver(EnemyObserver observer) {
		gameController.removeEnemyObserver(observer);
	}
	
	/*
	 * Torony l�trehoz�sa (x, y) pontban.
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
			return;
		}
		else{
			if (tileList.get(match) instanceof Road){
				return;
			}
			else{
				if (((Field) tileList.get(match)).getTower() != null){
					return;
				}
				else{
					((Field) tileList.get(match)).setTower();
				}
			}
		}
	}
	
	/*
	 * Akad�ly l�trehoz�sa (x, y) pontban.
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
			return;
		}
		else{
			if (tileList.get(match) instanceof Field){
				return;
			}
			else{
				if (((Road) tileList.get(match)).getTrap() != null){
					return;
				}
				else{
					((Road) tileList.get(match)).setTrap();
				}
			}
		}
	}
	
	/*
	 * Torony t�rl�se (x, y) pontb�l.
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
			return;
		}
		else{
			// ezeket azert hagyom benne, hogy ha valami difi lenne a pos
			//   atadasanal, akkor itt kiderulhessen, amugy ez jozan esszel
			//   atgondolva nem kovetkezhet be, hiszen csak letezo toronyra
			//   hivodhat meg ez
			if (tileList.get(match) instanceof Road){
				return;
			}
			else{
				if (((Field) tileList.get(match)).getTower() != null){
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
