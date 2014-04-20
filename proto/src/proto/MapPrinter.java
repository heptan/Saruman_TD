package proto;

import java.util.List;

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
	public static void printMap(Map map) {
		List<Tile> tilelist = map.getTileList();
		Position size = map.getSize();
		String[][] tilegrid = new String[((int)size.getY()) + 1][((int)size.getX()) + 1];
		for(Tile tile : tilelist) {
			int x = (int) tile.getPosition().getX();
			int y = (int) tile.getPosition().getY();
			if(tile.getClass() == Road.class)
				tilegrid[y][x] = " ";
			else if(tile.getClass() == Field.class) {
				tilegrid[y][x] = "F";
			}
		}
		
		for(int y = 0; y < tilegrid.length; y++) {
			System.out.print("|");
			for(int x = 0; x < tilegrid[y].length; x++) {
				System.out.print(tilegrid[y][x] + "|");
			}
			System.out.println("");
		}
	}

}
