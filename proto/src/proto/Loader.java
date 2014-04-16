package proto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/*
 * Fajbol torteno terkepkep, parancslista beolvasasara
 */
public class Loader {
	
	/*
	 * Terkepkepet beolvaso metodus
	 */
	public static Map loadMap(String path) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		    
		} catch(Exception e) {
			System.out.println("Hiba a fajl beolvasasa soran!");
		}
		
		return null;
	}
	
	/*
	 * Parancslistat beolvaso metodus
	 */
	public static List<String> loadCommands(String path) {
		List<String> loadedcommands = new ArrayList<String>();
		
		
		
		return loadedcommands;
	}
}
