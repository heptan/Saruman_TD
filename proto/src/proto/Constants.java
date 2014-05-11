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
	public static final String MAP_FILE_SRC = "map_s.test";

	/**
	 * A tornyok alapertelmezett hatosugara
	 */
	public static final int TOWER_DEFAULT_RANGE = 2;

	/**
	 * Kod eseten a tornyok hatosugara
	 */
	public static final int TOWER_MIST_RANGE = 0;

	/**
	 * Toronyalapertelmezett sebzesi erteke
	 */
	public static final int TOWER_SHOT = 20;

	/**
	 * Dwarf elleni varazskovel ellatott torony sebzesi erteke dwarf tipusu
	 * ellensegre
	 */
	public static final int TOWER_DAMAGEDWARF = 100;

	/**
	 * Elf elleni varazskovel ellatott torony sebzesi erteke elf tipusu
	 * ellensegre
	 */
	public static final int TOWER_DAMAGEELF = 100;

	/**
	 * Hobbit elleni varazskovel ellatott torony sebzesi erteke hobbit tipusu
	 * ellensegre
	 */
	public static final int TOWER_DAMAGEHOBBIT = 100;

	/**
	 * Human elleni varazskovel ellatott torony sebzesi erteke human tipusu
	 * ellensegre
	 */
	public static final int TOWER_DAMAGEHUMAN = 100;

	/**
	 * Enemyk maximalis eletereje, ekkora eleterovel inicializalodnak
	 */
	public static final int ENEMY_MAX_HEALTH = 100;

	/**
	 * Egy jatekban megjeleno ellensegek szama
	 */
	public static final int ENEMY_COUNTER_MAX = 10;

	/**
	 * Akadaly alapertelemezett elettartama lepesben merve
	 */
	public static final int TRAP_ENDTIME = 10;

	/**
	 * Dwarf ellenseg sebessegerteke, forditottan aranyos a lathato mozgasi
	 * sebesseggel, egy palyaelemen valo tartozkodas idejet adja meg
	 */
	public static final int SPEED_DWARF = 4;

	/**
	 * Elf ellenseg sebessegerteke, forditottan aranyos a lathato mozgasi
	 * sebesseggel, egy palyaelemen valo tartozkodas idejet adja meg
	 */
	public static final int SPEED_ELF = 0;

	/**
	 * Hobbit ellenseg sebessegerteke, forditottan aranyos a lathato mozgasi
	 * sebesseggel, egy palyaelemen valo tartozkodas idejet adja meg
	 */
	public static final int SPEED_HOBBIT = 3;

	/**
	 * Human ellenseg sebessegerteke, forditottan aranyos a lathato mozgasi
	 * sebesseggel, egy palyaelemen valo tartozkodas idejet adja meg
	 */
	public static final int SPEED_HUMAN = 2;

	/**
	 * A GUI-n levo, vezerloket tartalmazo sav szelessege
	 */
	public static final int GUI_CONTROLLER_W = 300;

	/**
	 * A palyaelemek meretet tarolo konstans inicializalaskor szamitodik a
	 * kepernyofelbontas fuggvenyeben
	 */
	public static int GUI_TILE_SIZE;

	/**
	 * Leptetesi idokoz ms-ban megadva
	 */
	public static final long TIMER_INTERVAL = 1000;
}
