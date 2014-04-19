package proto;

import java.io.BufferedReader;
import java.util.Random;
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
	 * Default konstruktor
	 */
	public Tower(){
		gemList = new ArrayList<GemStone>();
		enemyList = new ArrayList<Enemy>();
		damageElf = 10;
		damageHuman = 10;
		damageDwarf = 10;
		damageHobbit = 10;
		frequency = 1;
		range = 2;
		field = null;
		position = null;

		/*
		 * Konstruktor, parametere a mezo, ami a torony van
		 */
		public Tower(Field place) {
		gemList = new ArrayList<GemStone>();
		enemyList = new ArrayList<Enemy>();
		damageElf = 10;
		damageHuman = 10;
		damageDwarf = 10;
		damageHobbit = 10;
		frequency = 1;
		range = 2;
		field = place;
		position = place.getPosition();
	}
	
	/*
	 * ez a fuggveny hivodik meg amikor az ellenseg lep
	 */
	@Override
	public void notifyFromEnemy(Enemy enemy) {		
		Position enemyPosition = enemy.getPosition();			//az ellenseg poziciojanak lekerese
		double distance = enemyPosition.getDistance(position);	//a tavolsag kiszamitasa
		if (distance < range){									//ha tavolsagon belul van, felvetel a listaba
			addEnemy(enemy);
		}else{													//ha a hatotavolsagon kivul van, akkor torles a listabol
			removeEnemy(enemy);
		}		
	}
	
	/*
	 * a torony lovese
	 */
	public void shoot(){
		for (int j = 0; j < frequency; j++) {					//a frekvenciatol fugg, hanyszor kell loni
			for(Enemy enemy : enemyList ){						//minden ellensegre le kell adni egy lovest				
				
				Random randomGenerator = new Random();
				int randomInt = randomGenerator.nextInt(10);	//veletlen szam 0 es 9 kozott
				boolean split = randomInt==1?true:false;		//ha a kapott veletlen szam 1, split a loves
		
				enemy.hit(split);
				
				/*if(enemy instanceof Dwarf){											
						enemy.setHealth(health - damageDwarf);
						if (split) {
							gameController.splitDwarf(enemy);
							}
				}else if(enemy instanceof Elf){										
						enemy.setHealth(health - damageElf);
						if (split) {
							gameController.splitElf(enemy);
							}
				}else if(enemy instanceof Human){										
						enemy.setHealth(health - damageHuman);
						if (split) {
							gameController.splitHuman(enemy);
							}
				}
				else if(enemy instanceof Hobbit){								
						enemy.setHealth(health - damageHobbit);
						if (split) {
							gameController.splitHobbit(enemy);
							}
				}						*/
			}
		}
	}
	/*
	 * A t�nd�k elleni sebz�s lek�rdez�se
	 */
	public int getDamageElf(){
		return damageElf;
	}
	public void setDamegeElf(int dElf){
		damageElf = dElf;
	}	
	/*
	 * A emberek elleni sebz�s lek�rdez�se
	 */
	public int getDamageHuman(){
		return damageHuman;
	}
	public void setDamegeHuman(int dHuman){
		damageHuman = dHuman;
	}
	/*
	 * A t�rp�k elleni sebz�s lek�rdez�se
	 */
	public int getDamageDwarf(){
		return damageDwarf;
	}
	public void setDamegeDwarf(int dDwarf){
		damageDwarf = dDwarf;
	}
	/*
	 * A hobbitok elleni sebz�s lek�rdez�se
	 */
	public int getDamageHobbit(){
		return damageHobbit;
	}
	public void setDamegeHobbit(int dHobbit){
		damageHobbit = dHobbit;
	}
	/*
	 * A l�v�si frekvencia lek�rdez�se
	 */
	public int getFrequency(){
		return frequency;
	}
	/*
	 * A torony poz�ci�j�nak lek�rdez�se
	 */
	public void setFrequency(int freq){
		frequency = freq;
	}	
	/*
	 * A torony poz�ci�j�nak lek�rdez�se
	 */
	public Position getPosition() {
		return position;
	}
	
	/*
	 * A torony poziciojanak beallitasa
	 */
	public void setPosition(Position pos) {
		position = pos;
	}
	
	/*
	 * A torony hatosugaranak lekerdezese
	 */
	public double getRange() {
		return range;
	}
	
	/*
	 * a torony hatotavolsaganak beallitasa
	 */
	public void setRange(double ran) {
		range = ran;
	}
	
	/*
	 * A mezo beallitasa amin a torony van
	 */
	public void setField(Field f) {
		field = f;
	}
	
	/*
	 * Ember elleni ko hozzaadasa
	 */
	public void addAntiHuman() {
		if(gemList.size()<4){
			GemStone anti = new AntiHuman();
			gemList.add(anti);
			anti.setEffect(this);
		}
	}
	/*
	 * Tunde elleni ko hozzaadasa
	 */
	public void addAntiElf() {
		if(gemList.size()<4){
			GemStone anti = new AntiElf();
			gemList.add(anti);
			anti.setEffect(this);
		}
	}
	/*
	 * Torp elleni ko hozzaadasa
	 */
	public void addAntiDwarf() {
		if(gemList.size()<4){
			GemStone anti = new AntiDwarf();
			gemList.add(anti);
			anti.setEffect(this);
		}
	}
	/*
	 * Hobbit elleni ko hozzaadasa
	 */
	public void addAntiHobbit() {
		if(gemList.size()<4){
			GemStone anti = new AntiHobbit();
			gemList.add(anti);
			anti.setEffect(this);
		}
	}
	public void addPlusFrequency(){
		if(gemList.size()<4){
			GemStone anti = new PlusFrequency();
			gemList.add(anti);
			anti.setEffect(this);
		}
	}
	public void addPlusRange(){
		if(gemList.size()<4){
			GemStone anti = new PlusFrequency();
			gemList.add(anti);
			anti.setEffect(this);
		}
	}
	/*
	 * A varazsko listajanak lekerdezese
	 */
	public List<GemStone> getGemStoneList() {
		return gemList;
	}
	
	/*
	 * 	ellenseg hozzaadasa a listahoz
	 */
	public void addEnemy(Enemy e) {		
		if(!enemyList.contains(e)) {
			enemyList.add(e);
		}		
	}
	
	/*
	 * ellenseg eltavolitasa a listabol
	 */
	public void removeEnemy(Enemy e) {		
		if(enemyList.contains(e)) {
			enemyList.remove(e);
		}
	}
	
	/*
	 * Torony torlese
	 */
	public void wipe() {
		for(Enemy enemy : enemyList){
			enemy.removeObserver(this);
		}
	}
}