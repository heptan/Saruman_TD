package proto;

/**
 * A programban hasznalt konstansokat tarolo osztaly.
 * 
 * @author Alex Torok
 */
public class Constants {
	
	/**
	 * A betoltendo terkepkepet tartalmazo fajl relativ el
	 */
	public static final String MAP_FILE_SRC = "map_l.test";
	
	/**
	 * A tornyok alapertelmezett hatosugara
	 */
	public static final int TOWER_DEFAULT_RANGE = 2;
	
	/**
	 * Kod eseten a tornyok hatosugara
	 */
	public static final int MIST_RANGE = 0;
	
	/**
	 * Enemyk maximalis eletereje, ekkora eleterovel inicializalodnak
	 */
	public static final int ENEMY_MAX_HEALTH = 100;
	
	/**
	 * Egy jatekban megjeleno ellensegek szama
	 */
	public static final int ENEMY_COUNTER_MAX = 10;

	public static final int TOWER_SHOT = 20;
	public static final int TOWER_DAMAGEDWARF = 100;
	public static final int TOWER_DAMAGEELF = 100;
	public static final int TOWER_DAMAGEHOBBIT = 100;
	public static final int TOWER_DAMAGEHUMAN = 100;
	
	public static final int TRAP_ENDTIME = 10;
	
	public static final int SPEED_DWARF = 4;
	public static final int SPEED_ELF = 0;
	public static final int SPEED_HOBBIT = 3;
	public static final int SPEED_HUMAN = 2;
	
	public static final int GUI_CONTROLLER_W = 300;
	//Ez inicializalaskor szamitodik!
	public static int GUI_TILE_SIZE;
	
	public static final long TIMER_INTERVAL = 1000;
}
