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
	}
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
		
				enemy.hit(split, this);							//az enemy-t talalat eri ettol a toronytol
				
			}
		}
	}
	/*
	 * A tundek elleni sebzodes lekerdezese es beallitasa
	 */
	public int getDamageElf(){
		return damageElf;
	}
	public void setDamegeElf(int dElf){
		damageElf = dElf;
	}	
	/*
	 * A emberek elleni sebzodes lekerdezese es beallitasa
	 */
	public int getDamageHuman(){
		return damageHuman;
	}
	public void setDamegeHuman(int dHuman){
		damageHuman = dHuman;
	}
	/*
	 * A torpok elleni sebzodes lekerdezese es beallitasa
	 */
	public int getDamageDwarf(){
		return damageDwarf;
	}
	public void setDamegeDwarf(int dDwarf){
		damageDwarf = dDwarf;
	}
	/*
	 * A hobbitok elleni sebzodes lekerdezese es beallitasa
	 */
	public int getDamageHobbit(){
		return damageHobbit;
	}
	public void setDamegeHobbit(int dHobbit){
		damageHobbit = dHobbit;
	}
	/*
	 * A lovesi frekvencia lekerdezese es beallitasa
	 */
	public int getFrequency(){
		return frequency;
	}
	public void setFrequency(int freq){
		frequency = freq;
	}	
	/*
	 * a torony poziciojanak lekerdezese es beallitasa
	 */
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position pos) {
		position = pos;
	}
	
	/*
	 * A torony hatosugaranak lekerdezese es beallitasa
	 */
	public double getRange() {
		return range;
	}
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
		if(gemList.size()<4){					//csak akkor kell hozzaadni, ha 4-nel kevesebb van
			GemStone anti = new AntiHuman();	//letre kell hozni
			gemList.add(anti);					//betenni a listaba
			anti.setEffect(this);				//es beallitani a hatasat
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
	/*
	 * Frekvencianovelo ko hozzaadasa
	 */
	public void addPlusFrequency(){
		if(gemList.size()<4){
			GemStone anti = new PlusFrequency();
			gemList.add(anti);
			anti.setEffect(this);
		}
	}
	/*
	 * Hatosugarnovelo ko hozzaadasa
	 */
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