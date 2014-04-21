package proto;

import java.util.List;
import java.util.Observable;

/**
 * Terkep, ellenseglista, toronylista, akadalylista kiiratasa a kepernyore
 * 
 * @author BlackDog
 * @since 2014-04-20
 */
public class MapPrinter {

	/*
	 * Palya allapotanak kiiratasa
	 */
	public static void printMap(GameController gamecontroller) {
		Map map = gamecontroller.getMap();
		List<Tile> tilelist = map.getTileList();
		Position size = map.getSize();
		String[][] tilegrid = new String[((int) size.getY()) + 1][((int) size
				.getX()) + 1];
		
		//Terkepkepet tarolo tomb feltoltese; field, road, tower, trap
		for (Tile tile : tilelist) {
			int x = (int) tile.getPosition().getX();
			int y = (int) tile.getPosition().getY();
			if (tile.getClass() == Road.class)
				if(((Road)tile).getTrap() == null) {
					tilegrid[y][x] = " ";
				} else {
					tilegrid[y][x] = "R";
				}
			else if (tile.getClass() == Field.class) {
				if(((Field)tile).getTower() == null) {
					tilegrid[y][x] = "F";
				} else {
					tilegrid[y][x] = "T";
				}
			}
		}
		
		//Terkepkepet tarolo tomb feltoltese; Dwarf, Elf, Hobbit, Human
		for(Enemy e : gamecontroller.getEnemyList()) {
			int x = (int)e.getPosition().getX();
			int y = (int)e.getPosition().getY();
			if(!tilegrid[y][x].equals(" ")) {
				tilegrid[y][x] = "M";
			}
			else {
				if (e.getClass() == Dwarf.class) {
					tilegrid[y][x] = "D";
				} else if (e.getClass() == Elf.class) {
					tilegrid[y][x] = "E";
				} else if (e.getClass() == Hobbit.class) {
					tilegrid[y][x] = "O";
				} else if (e.getClass() == Human.class) {
					tilegrid[y][x] = "H";
				}
			}
		}
		
		// Terkepkep kiirasa
		System.out.println();
		if(gamecontroller.getMap().getTileList().size() > 0) {
			for (int y = 0; y < tilegrid.length; y++) {
				System.out.print("|");
				for (int x = 0; x < tilegrid[y].length; x++) {
					System.out.print(tilegrid[y][x] + "|");
				}
				System.out.println("");
			}
		}

		// Ellenseglista kiiratasa
		for (Enemy e : gamecontroller.getEnemyList()) {
			if (e.getClass() == Dwarf.class) {
				System.out.println("(" + (int)e.getPosition().getX() + ","
						+ (int)e.getPosition().getY() + "), Dwarf, " + e.getHealth());
			} else if (e.getClass() == Elf.class) {
				System.out.println("(" + (int)e.getPosition().getX() + ","
						+ (int)e.getPosition().getY() + "), Elf, " + e.getHealth());
			} else if (e.getClass() == Hobbit.class) {
				System.out.println("(" + (int)e.getPosition().getX() + ","
						+ (int)e.getPosition().getY() + "), Hobbit, " + e.getHealth());
			} else if (e.getClass() == Human.class) {
				System.out.println("(" + (int)e.getPosition().getX() + ","
						+ (int)e.getPosition().getY() + "), Human, " + e.getHealth());
			}
		}

		// Toronylista kiirasa
		int towerpcs = 0;
		for (Tile t : tilelist) {
			if (t.getClass() == Field.class && ((Field) t).getTower() != null) {
				towerpcs++;
			}
		}
		if(towerpcs > 0) {
			System.out.println("\nTowers:");
			for (Tile t : tilelist) {
				if (t.getClass() == Field.class && ((Field) t).getTower() != null) {
					Tower tw = ((Field) t).getTower();
					System.out.println("\t(" + (int)tw.getPosition().getX() + ","
							+ (int)tw.getPosition().getY() + "), " + tw.getRange());
	
					if (tw.getGemStoneList().size() != 0) {
						for (GemStone g : tw.getGemStoneList()) {
							if (g.getClass() == AntiDwarf.class) {
								System.out.println("\t\tAntiDwarf");
							} else if (g.getClass() == AntiElf.class) {
								System.out.println("\t\tAntiElf");
							} else if (g.getClass() == AntiHobbit.class) {
								System.out.println("\t\tAntiHobbit");
							} else if (g.getClass() == AntiHuman.class) {
								System.out.println("\t\tAntiHuman");
							} else if (g.getClass() == PlusFrequency.class) {
								System.out.println("\t\tPlusFrequency");
							} else if (g.getClass() == PlusRange.class) {
								System.out.println("\t\tPlusRange");
							}
						}
					}
				}
			}
		}
			
		// Akadalylista kiirasa
		int trapspcs = 0;
		for (Tile t : tilelist) {
			if (t.getClass() == Road.class && ((Road) t).getTrap() != null) {
				trapspcs++;
			}
		}
		if(trapspcs > 0) {
		System.out.println("\nTraps:");
			for (Tile t : tilelist) {
				if (t.getClass() == Road.class && ((Road) t).getTrap() != null) {
					Trap tr = ((Road) t).getTrap();
					System.out.println("\t(" + (int)tr.getPosition().getX() + ","
							+ (int)tr.getPosition().getY() + "), " + tr.getEndTime());
	
					if (tr.isGemStoned()) {
							System.out.println("\t\tPlusTime");
						}
				}
			}
		}
		
		System.out.println("");
	}
}
