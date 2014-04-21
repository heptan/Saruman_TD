package proto;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * A proto keretet ado osztaly, teszteles innet indul
 * 
 * @author Alex Torok
 * @since 2014-04-20
 */
public class ProtoMain {
	
	static GameController sandbox = GameController.getInstace();
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("'Megettuk a kenyerunk JAVAt csapat - prototipus parancsertelmezo.");
		System.out.println("Adja meg a kivant parancsot es nyomja meg az 'Enter' billentyut!\n");
		
		String actcommand = "";
		
		while(!actcommand.trim().equals("quit")) {
			
			try {
				
				actcommand = br.readLine();
				runCommand(actcommand,false);
				
			} catch(Exception e) {
				System.out.println("Hiba a beolvasas folyaman, probalja ujra!");
				e.printStackTrace();
			}
			
		}
		
		System.out.println("\nViszlat!");
	}
	
	/*
	 * Aktualis parancs feldolgozasahoz hasznalt metodus
	 */
	public static void runCommand(String command, boolean fromfile) {
		if(command == null || command.trim().equals("")) {
			System.out.println("\nNull erteku, vagy ures parancs!\n");
			return;
		}
		
		command = command.trim();
		String[] input = command.split(" ");
		
		switch(input[0]) {
		
		case "loadMap":
			command_loadMap(input);
			break;
			
		case "loadCommandList":
			if(fromfile == true) {
				System.out.println("Ervenytelen parancs a bemeneti parancsfajlban, a 'loadCommandList' parancs csak a parancsertelmezoben hasznalhato");
				return;
			}
				
			command_loadCommandList(input);
			break;
		
		case "addEnemy":
			command_addEnenmy(input);
			break;
			
		case "addTower":
			command_addTower(input);
			break;
			
		case "removeTower":
			command_removeTower(input);
			break;
			
		case "addTrap":
			command_addTrap(input);
			break;
			
		case "addGemStone":
			command_addGemStone(input);
			break;
			
		case "setRandomize":
			command_setRandomize(input);
			break;
			
		case "nextStep":
			command_nextStep(input);
			break;
			
		default:
			System.out.println("\nErvenytelen parancs!\n");
		
		}
	}
	
	/*
	 * Terkep betoltese fajlbol
	 */
	public static void command_loadMap(String[] input) {
		
		if(input.length != 2) {
			System.out.println("Ervenytelen parameterezes!");
			return;
		}
		
		System.out.println(input[0] + ", file: " + input[1] + "\n");
		
		Map loadedmap = Loader.loadMap(input[1]);
		if(loadedmap == null) {
			System.out.println("Hiba a terkepfajl beolvasasa soran!");
			return;
		}
		
		sandbox.setMap(loadedmap);
		
		MapPrinter.printMap(sandbox);
	}
	
	/*
	 * Parancslista betoltese fajlbol
	 */
	public static void command_loadCommandList(String[] input) {
		
		if(input.length != 2) {
			System.out.println("Ervenytelen parameterezes!");
			return;
		}
		
		System.out.println(input[0] + ", file: " + input[1]);
	}
	
	/*
	 * Uj ellenseg hozzaadasa
	 */
	public static void command_addEnenmy(String[] input) {
		int posx, posy;
		
		if(input.length != 4) {
			System.out.println("Ervenytelen parameterezes!");
			return;
		}
		
		if(!input[1].equals("dwarf") && !input[1].equals("elf") &&
				!input[1].equals("hobbit") && !input[1].equals("human")) {
			System.out.println("Ervenytelen ellensegtipus!");
		}
		
		try {
			posx = Integer.parseInt(input[2]);
			posy = Integer.parseInt(input[3]);
		} catch(NumberFormatException e) {
			System.out.println("A koordinata nem szam!");
			return;
		}
		
		System.out.println(input[0] + ", type: " + input[1] +
				", x: " + input[2] + ", y: " + input[3]);
	}
	
	/*
	 * Uj torony hozzaadasa
	 */
	public static void command_addTower(String[] input) {
		int posx, posy;
		
		if(input.length != 3) {
			System.out.println("Ervenytelen parameterezes!");
			return;
		}
		
		try {
			posx = Integer.parseInt(input[1]);
			posy = Integer.parseInt(input[2]);
		} catch(NumberFormatException e) {
			System.out.println("A koordinata nem szam!");
			return;
		}
		
		System.out.println(input[0] + ", x: " + input[1] + ", y: " + input[2]);
	}
	
	/*
	 * Meglevo torony torlese
	 */
	public static void command_removeTower(String[] input) {
		int posx, posy;
		
		if(input.length != 3) {
			System.out.println("Ervenytelen parameterezes!");
			return;
		}
		
		try {
			posx = Integer.parseInt(input[1]);
			posy = Integer.parseInt(input[2]);
		} catch(NumberFormatException e) {
			System.out.println("A koordinata nem szam!");
			return;
		}
		
		System.out.println(input[0] + ", x: " + input[1] + ", y: " + input[2]);
	}
	
	/*
	 * Uj csapda hozzaadasa
	 */
	public static void command_addTrap(String[] input) {
		int posx, posy;
		
		if(input.length != 3) {
			System.out.println("Ervenytelen parameterezes!");
			return;
		}
		
		try {
			posx = Integer.parseInt(input[1]);
			posy = Integer.parseInt(input[2]);
		} catch(NumberFormatException e) {
			System.out.println("A koordinata nem szam!");
			return;
		}
		
		System.out.println(input[0] + ", x: " + input[1] + ", y: " + input[2]);
	}
	
	/*
	 * Uj varazsko hozzaadasa
	 */
	public static void command_addGemStone(String[] input) {
		int posx, posy;
		
		if(input.length != 4) {
			System.out.println("Ervenytelen parameterezes!");
			return;
		}

		if(!input[1].equals("antihuman") && !input[1].equals("antielf") &&
				!input[1].equals("antidwarf") && !input[1].equals("antihobbit") &&
				!input[1].equals("plustime") && !input[1].equals("plusfrequency") && !input[1].equals("plusrange")) {
			System.out.println("Ervenytelen varazskotipus!");
			return;
		}
		
		try {
			posx = Integer.parseInt(input[2]);
			posy = Integer.parseInt(input[3]);
		} catch(NumberFormatException e) {
			System.out.println("A koordinata nem szam!");
			return;
		}
		
		System.out.println(input[0] + ", type: " + input[1] + 
				", x: " + input[2] + ", y: " + input[3]);
	}
	
	/*
	 * Veletlenszeru viselkedes beallitasa
	 */
	public static void command_setRandomize(String[] input) {
		boolean israndomize;
		
		if(input.length != 2) {
			System.out.println("Ervenytelen parameterezes!");
			return;
		}
		
		if(input[1].equals("T")) {
			israndomize = true;
		}
		else if(input[1].equals("F")) {
			israndomize = false;
		}
		else {
			System.out.println("Ervenytelen a parameter ereteke! {T,F}");
			return;
		}
		
		System.out.println(input[0] + ", israndomize: " + input[1]);
	}
	
	/*
	 * Jatekmenet leptetese
	 */
	public static void command_nextStep(String[] input) {
		int stepnum;
		
		if(input.length < 1 || input.length > 2) {
			System.out.println("Ervenytelen parameterezes!");
			return;
		}
		
		if(input.length == 2) {
			try {
				stepnum = Integer.parseInt(input[1]);
			} catch(NumberFormatException e) {
				System.out.println("A lepesszam nem szam!");
				return;
			}
			
			System.out.println(input[0] + ", stepnum: " + input[1]);
		}
		else {
			System.out.println(input[0]);
		}
	}
}
