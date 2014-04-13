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
	 * ez a függvény hívódik meg az ellenség objektum lépési eseményének elsütésekor. 
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
	 * A torony pozï¿½ciï¿½jï¿½nak lekï¿½rdezï¿½se.
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
	 * A torony pozï¿½ciï¿½jï¿½nak beï¿½llï¿½tï¿½sa.
	 */
	public void setPosition(Position pos) {
		position = pos;
	}
	
	/*
	 * A torony hatï¿½tï¿½volsï¿½gï¿½nak lekï¿½rdezï¿½se.
	 */
	public double getRange() {
		return range;
	}
	
	/*
	 * A torony hatï¿½tï¿½volsï¿½gï¿½nak beï¿½llï¿½tï¿½sa.
	 */
	public void setRange(double ran) {
		range = ran;
	}
	
	/*
	 * A toronyhoz tartozï¿½ mezï¿½ referenciï¿½jï¿½nak beï¿½llï¿½tï¿½sa.
	 */
	public void setField(Field f) {
		field = f;
	}
	
	/*
	 * ï¿½j varï¿½zskï¿½ hozzï¿½adï¿½sa.
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
	 * A varï¿½zskï¿½vek listï¿½jï¿½nak lekï¿½rdezï¿½se.
	 */
	public List<GemStone> getGemStoneList() {
		return gemList;
	}
	
	/*
	 * 	Hozzï¿½ad egy ellensï¿½get a listï¿½hoz.
	 */
	public void addEnemy(Enemy e) {		
		if(!enemyList.contains(e)) {
			enemyList.add(e);
		}		
	}
	
	/*
	 * Eltï¿½volï¿½t egy ellensï¿½get a listï¿½rï¿½l.
	 */
	public void removeEnemy(Enemy e) {		
		if(enemyList.contains(e)) {
			enemyList.remove(e);
		}
	}
	
	/*
	 * Torony tï¿½rlï¿½se.
	 */
	public void wipe() {
		for(Enemy enemy : enemyList){
			enemy.removeObserver(this);
		}
	}
}