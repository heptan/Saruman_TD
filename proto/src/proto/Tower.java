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
	private List<Enemy> enemyList;
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
	 * Konstruktor, parametere a mezo, ami a torony van
	 */
	public Tower(Field place) {
		gemList = new ArrayList<GemStone>();
		enemyList = new ArrayList<Enemy>();
		damageElf = Constants.TOWER_DAMAGEELF;
		damageHuman = Constants.TOWER_DAMAGEHUMAN;
		damageDwarf = Constants.TOWER_DAMAGEDWARF;
		damageHobbit = Constants.TOWER_DAMAGEHOBBIT;
		frequency = 1;
		range = Constants.TOWER_DEFAULT_RANGE;
		field = place;
		position = place.getPosition();
	}

	/*
	 * ez a fuggveny hivodik meg amikor az ellenseg lep
	 */
	@Override
	public void notifyFromEnemy(Enemy enemy) {
		Position enemyPosition = enemy.getPosition(); // az ellenseg
														// poziciojanak lekerese
		double distance = enemyPosition.getDistance(position); // a tavolsag
																// kiszamitasa
		if (distance < range) { // ha tavolsagon belul van, felvetel a listaba
			addEnemy(enemy);
		} else { // ha a hatotavolsagon kivul van, akkor torles a listabol
			removeEnemy(enemy);
		}
	}

	/*
	 * a torony lovese
	 */
	public void shoot() {
		for (int j = 0; j < frequency; j++) { // a frekvenciatol fugg, hanyszor
												// kell loni
			for (Enemy enemy : enemyList) { // minden ellensegre le kell adni
											// egy lovest
				
				boolean split = false;
				if(field.getMap().getGameController().isRandomized()) {
					Random randomGenerator = new Random();
					int randomInt = randomGenerator.nextInt(10); // veletlen szam 0
																	// es 9 kozott
					split = randomInt == 1 ? true : false; // ha a kapott
																	// veletlen szam
																	// 1, split a
																	// loves
				}
				else {
					System.out.println("\nVagjuk kette az ellenseget? {i|n}\n");
					
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					try {
						String inputtext = br.readLine();
						if(inputtext.trim().equals("i")) {
							split = true;
						}
						else if(inputtext.trim().equals("n")) {
							split = false;
						}
						else {
							System.out.println("Nem ervenyes bemenet, az ellenseg nem lesz kettevagva!");
						}
					} catch(Exception e) {
						System.out.println("Hiba a bemenet beolvasasakor, az ellenseg nem lesz kettevagva!");
					}
				}

				// ez mi a szosz??????? --> enemy.hit(split, this); //az enemy-t
				// talalat eri ettol a toronytol
				// segedvaltozo, figyeli, hogy volt-e loves, ha nem, akkor
				// meghivja a default shot fuggvenyet az ellensegnek
				// ezzel biztositva, hogy ne fordulhasson elo az, hogy az
				// ellenseget nem eri talalat, mikor a hatosugaron belul van.
				boolean wasHit = false;
				// Ellenorizzuk, hogy mely kovekkel rendelkezik a torony, majd
				// meghivjuk a megfelelo sebzo fuggvenyeket. Ha semmilyennel,
				// akkor default 10-et fog sebezni.
				if (gemListHas(AntiDwarf.class)) {
					enemy.getShotWithAntiDwarf(damageDwarf);
					wasHit = true;
				}
				if (gemListHas(AntiElf.class)) {
					enemy.getShotWithAntiElf(damageElf);
					wasHit = true;
				}
				if (gemListHas(AntiHobbit.class)) {
					enemy.getShotWithAntiHobbit(damageHobbit);
					wasHit = true;
				}
				if (gemListHas(AntiHuman.class)) {
					enemy.getShotWithAntiHuman(damageHuman);
					wasHit = true;
				}
				if (!wasHit) {
					enemy.getShot(Constants.TOWER_SHOT); // default sebzes
				}
				// A lovessorozatot lezaro fuggvenyhivas. Ebben valasztodik ki
				// a megfelelo mennyisegu sebzes.
				enemy.shotEnd();

				// Vegul az ellenseg split-elesenek az kezelese
				if (split)
					enemy.split();
			}
		}
	}

	/*
	 * Segedfuggveny a torony lovesehez. Visszaadja, hogy a parameterben atadott
	 * objektum osztalyaval megegyezo objektum van-e a gemList listaban. Egesz
	 * pontosan ez ahhoz kell, hogy megtudjuk milyen tipusu lovest kell
	 * leadnunk.
	 */
	private boolean gemListHas(Class<? extends GemStone> gs) {
		for (GemStone gemst : gemList) {
			if (gemst != null && gs.isInstance(gemst))
				;
			return true;
		}
		return false;
	}

	/*
	 * A tundek elleni sebzodes lekerdezese es beallitasa
	 */
	public int getDamageElf() {
		return damageElf;
	}

	public void setDamegeElf(int dElf) {
		damageElf = dElf;
	}

	/*
	 * A emberek elleni sebzodes lekerdezese es beallitasa
	 */
	public int getDamageHuman() {
		return damageHuman;
	}

	public void setDamegeHuman(int dHuman) {
		damageHuman = dHuman;
	}

	/*
	 * A torpok elleni sebzodes lekerdezese es beallitasa
	 */
	public int getDamageDwarf() {
		return damageDwarf;
	}

	public void setDamegeDwarf(int dDwarf) {
		damageDwarf = dDwarf;
	}

	/*
	 * A hobbitok elleni sebzodes lekerdezese es beallitasa
	 */
	public int getDamageHobbit() {
		return damageHobbit;
	}

	public void setDamegeHobbit(int dHobbit) {
		damageHobbit = dHobbit;
	}

	/*
	 * A lovesi frekvencia lekerdezese es beallitasa
	 */
	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int freq) {
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
	 * A torony hatosugaranak lekerdezese
	 */
	public double getRange() {
		return range;
	}

	/*
	 * A torony hatosugaranak novelese a kapott ertekkel
	 */
	public void setRange(double ran) {
		range += ran;
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
		if (gemList.size() < 4) { // csak akkor kell hozzaadni, ha 4-nel
									// kevesebb van
			GemStone anti = new AntiHuman(); // letre kell hozni
			gemList.add(anti); // betenni a listaba
			anti.setEffect(this); // es beallitani a hatasat
			anti.setPosition(position);// beallitjuk a poziciojat
		}
	}

	/*
	 * Tunde elleni ko hozzaadasa
	 */
	public void addAntiElf() {
		if (gemList.size() < 4) {
			GemStone anti = new AntiElf();
			gemList.add(anti);
			anti.setEffect(this);
			anti.setPosition(position);// beallitjuk a poziciojat
			
		}
	}

	/*
	 * Torp elleni ko hozzaadasa
	 */
	public void addAntiDwarf() {
		if (gemList.size() < 4) {
			GemStone anti = new AntiDwarf();
			gemList.add(anti);
			anti.setEffect(this);
			anti.setPosition(position);// beallitjuk a poziciojat
			((DrawAntiDwarf) (anti.getDrawer())).
		}
	}

	/*
	 * Hobbit elleni ko hozzaadasa
	 */
	public void addAntiHobbit() {
		if (gemList.size() < 4) {
			GemStone anti = new AntiHobbit();
			gemList.add(anti);
			anti.setEffect(this);
			anti.setPosition(position);// beallitjuk a poziciojat
		}
	}

	/*
	 * Frekvencianovelo ko hozzaadasa
	 */
	public void addPlusFrequency() {
		if (gemList.size() < 4) {
			GemStone anti = new PlusFrequency();
			gemList.add(anti);
			anti.setEffect(this);
			anti.setPosition(position);// beallitjuk a poziciojat
		}
	}

	/*
	 * Hatosugarnovelo ko hozzaadasa
	 */
	public void addPlusRange() {
		if (gemList.size() < 4) {
			GemStone anti = new PlusRange();
			gemList.add(anti);
			anti.setEffect(this);
			anti.setPosition(position);// beallitjuk a poziciojat
		}
	}

	/*
	 * A varazsko listajanak lekerdezese
	 */
	public List<GemStone> getGemStoneList() {
		return gemList;
	}

	/*
	 * ellenseg hozzaadasa a listahoz
	 */
	public void addEnemy(Enemy e) {
		if (!enemyList.contains(e)) {
			enemyList.add(e);
		}
	}

	/*
	 * ellenseg eltavolitasa a listabol
	 */
	public void removeEnemy(Enemy e) {
		if (enemyList.contains(e)) {
			enemyList.remove(e);
		}
	}

	/*
	 * Torony torlese
	 */
	public void wipe() {
		for (Enemy enemy : enemyList) {
			enemy.removeObserver(this);
		}
	}
}