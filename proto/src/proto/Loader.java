package proto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Fajbol torteno terkepkep, parancslista beolvasasara
 * 
 * @author Alex Torok
 * @since 2014-04-20
 */
public class Loader {

	/*
	 * Terkepkepet beolvaso metodus
	 */
	public static Map loadMap(String path) {

		List<String> maplines = new ArrayList<String>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line = null;
			while ((line = reader.readLine()) != null) {
				maplines.add(line);
			}

		} catch (FileNotFoundException e) {
			System.out.println("A megadott fajl nem talalhato!");
		} catch (Exception e) {
			System.out.println("Hiba a fajl beolvasasa soran!");
			e.printStackTrace();
		}

		if (maplines.size() != 0) {
			return parseMap(maplines);
		}

		return null;
	}

	/*
	 * Terkepkep parser
	 */
	private static Map parseMap(List<String> maplines) {
		int i = 0, x = 0, y = 0;
		Map loadedmap = new Map();
		
		String line = maplines.get(0);
		while (!line.equals("<JUNCTIONS>") && i < maplines.size()) {
			for (String item : line.split("\\|")) {
				if (!item.trim().equals("")) {
					Tile newtile = null;
					if (item.equals("R")) {
						newtile = new Road();
					} else if (item.equals("F")) {
						newtile = new Field();
					}
					newtile.setPosition(new Position(x, y));
					newtile.setMap(loadedmap);
					x++;
					loadedmap.addTile(newtile);
				}
			}
			x = 0;
			y++;
			i++;
			if(i < maplines.size()) {
				line = maplines.get(i);
			}
		}

		i++;
		System.out.print("\n");
		List<Road> junctionroadlist = new ArrayList<Road>();
		while (i < maplines.size()) {
			String[] junction = maplines.get(i++).split("\\|");
			int junction_x = Integer.parseInt(junction[0].split(",")[0]);
			int junction_y = Integer.parseInt(junction[0].split(",")[1]);
			Road targetroad = new Road(junction_x,junction_y);
			
			for (int neighbour = 1; neighbour < junction.length; neighbour++) {
				String nextroadtext = junction[neighbour];
				if (!nextroadtext.trim().equals("")) {
					int nextroad_x = Integer
							.parseInt(nextroadtext.split(",")[0]);
					int nextroad_y = Integer
							.parseInt(nextroadtext.split(",")[1]);
					targetroad.addNextRoad((Road) loadedmap.getTile(nextroad_x,
							nextroad_y));
				}
			}
			
			junctionroadlist.add(targetroad);

		}

		setAllNeighbours(loadedmap, junctionroadlist);

		return loadedmap;
	}

	/*
	 * Fajlbol beolvasott elagazas, becsatlakozas kovetkezo utelemenek
	 * beallitasa
	 */
	private static void setAllNeighbours(Map map, List<Road> junctionroadlist) {		
		
		if(map.getTile(0, 0).getClass() == Road.class) {
			((Road)map.getTile(0, 0)).setNeighbours(junctionroadlist);
		}
		
	}

	/*
	 * Parancslistat beolvaso metodus
	 */
	public static List<String> loadCommands(String path) {
		List<String> loadedcommands = new ArrayList<String>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line = null;
			while ((line = reader.readLine()) != null) {
				loadedcommands.add(line);
			}

		} catch (FileNotFoundException e) {
			System.out.println("A megadott fajl nem talalhato!");
		} catch (Exception e) {
			System.out.println("Hiba a fajl beolvasasa soran!");
			e.printStackTrace();
		}
		
		return loadedcommands;
	}
}
