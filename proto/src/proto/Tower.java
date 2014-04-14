package proto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * A tornyot megvalosito osztaly. 
 */
public class Tower extends EnemyObserver {
	/*
	 * a torony pozicioja
	 */
	private Position position;
	/*
	 * A torony hatotavolsaga.
	 */
	private double range;
	/*
	 * A toronyhoz tartozo mezo referenciaja
	 */
	private Field field;
	/*
	 * A toronyhoz tartozo varazskovek
	 */
	private List<GemStone> gemList;
	/*
	 * A torony hatosugaraban levo ellensegek
	 */
	private  List<Enemy> enemyList;
	/*
	 * A torony tundek elleni sebzese
	 */
	private int damageElf;
	/*
	 * A torony emberek elleni sebzese
	 */
	private int damageHuman;
	/*
	 * A torony torpok elleni sebzese
	 */
	private int damageDwarf;
	/*
	 * A torony hobbitok elleni sebzese
	 */
	private int damageHobbit;
	/*
	 * A torony lovesi frekvenciaja
	 */
	private int frequency;
	
	/*
	 * Konstruktor
	 */
	public Tower(Field place, Position pos) {
		gemList = new ArrayList<GemStone>();
		enemyList = new ArrayList<Enemy>();
		damageElf = 10;
		damageHuman = 10;
		damageDwarf = 10;
		damageHobbit = 10;
		frequency = 1;
		range = 2;
		field = place;
		position = pos;
	}
	
	/*
	 * ez a f�ggv�ny h�v�dik meg az ellens�g objektum l�p�si esem�ny�nek els�t�sekor. 
	 */
	@Override
	public void notifyFromEnemy(Enemy enemy) {		
		Position enemyPosition = enemy.getPosition();
		int distance = enemyPosition.getDistance(position);
		if (distance < range){
			addEnemy(enemy);
		}else{
			removeEnemy(enemy);
		}		
	}
	
	/*
	 * A torony poz�ci�j�nak lek�rdez�se.
	 */
	public void shoot(){
		for(Enemy enemy : enemyList ){
			for(int i < frequency){
				int health = enemy.getHealth();
				
				enemy.setHealth(health-something);
			}			
		}
	}
	
	public Position getPosition() {
		return position;
	}
	
	/*
	 * A torony poz�ci�j�nak be�ll�t�sa.
	 */
	public void setPosition(Position pos) {
		position = pos;
	}
	
	/*
	 * A torony hat�t�vols�g�nak lek�rdez�se.
	 */
	public double getRange() {
		return range;
	}
	
	/*
	 * A torony hat�t�vols�g�nak be�ll�t�sa.
	 */
	public void setRange(double ran) {
		range = ran;
	}
	
	/*
	 * A toronyhoz tartoz� mez� referenci�j�nak be�ll�t�sa.
	 */
	public void setField(Field f) {
		field = f;
	}
	
	/*
	 * �j var�zsk� hozz�ad�sa.
	 */
	public void addAntiHuman() {
		if(gemList.size()<4){
			anti = new antiHuman();
			gemList.add(anti);
			anti.setEffect(this);
		}
	}
	public void addAntiElf() {
		if(gemList.size()<4){
			anti = new antiElf();
			gemList.add(anti);
			anti.setEffect(this);
		}
	}
	public void addAntiDwarf() {
		if(gemList.size()<4){
			anti = new antiDwarf();
			gemList.add(anti);
			anti.setEffect(this);
		}
	}
	public void addAntiHobbit() {
		if(gemList.size()<4){
			anti = new antiHobbit();
			gemList.add(anti);
			anti.setEffect(this);
		}
	}
	/*
	 * A var�zsk�vek list�j�nak lek�rdez�se.
	 */
	public List<GemStone> getGemStoneList() {
		return gemList;
	}
	
	/*
	 * 	Hozz�ad egy ellens�get a list�hoz.
	 */
	public void addEnemy(Enemy e) {		
		if(!enemyList.contains(e)) {
			enemyList.add(e);
		}		
	}
	
	/*
	 * Elt�vol�t egy ellens�get a list�r�l.
	 */
	public void removeEnemy(Enemy e) {		
		if(enemyList.contains(e)) {
			enemyList.remove(e);
		}
	}
	
	/*
	 * Torony t�rl�se.
	 */
	public void wipe() {
		for(Enemy enemy : enemyList){
			enemy.removeObserver(this);
		}
	}
}