package proto;

import java.util.List;
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
		
		System.out.println("Megettuk a kenyerunk JAVAt csapat - prototipus parancsertelmezo.");
		System.out.println("Adja meg a kivant parancsot es nyomja meg az 'Enter' billentyut!\n");
		
		String actcommand = "";
		
		while(!(actcommand.trim().equals("quit") || actcommand.trim().equals("exit"))) {
			
			try {
				
				actcommand = br.readLine();
				runCommand(actcommand,false);
				
			} catch(Exception e) {
				System.out.println("\nHiba a beolvasas folyaman, probalja ujra!\n");
				e.printStackTrace();
			}
			
		}
		
		System.out.println("\nViszlat!\n");
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
			
		case "lm":
			command_loadMap(input);
			break;
			
		case "loadCommandList":
			if(fromfile == true) {
				System.out.println("\nErvenytelen parancs a bemeneti parancsfajlban, a 'loadCommandList' parancs csak a parancsertelmezoben hasznalhato\n");
				return;
			}
				
			command_loadCommandList(input);
			break;
		
		case "addEnemy":
			command_addEnenmy(input);
			break;
			
		case "ae":
			command_addEnenmy(input);
			break;
			
		case "addTower":
			command_addTower(input);
			break;
			
		case "ato":
			command_addTower(input);
			break;
			
		case "removeTower":
			command_removeTower(input);
			break;
			
		case "rto":
			command_removeTower(input);
			break;
			
		case "addTrap":
			command_addTrap(input);
			break;
			
		case "atr":
			command_addTrap(input);
			break;
			
		case "addGemStone":
			command_addGemStone(input);
			break;
			
		case "ag":
			command_addGemStone(input);
			break;
			
		case "setRandomize":
			command_setRandomize(input);
			break;
			
		case "sr":
			command_setRandomize(input);
			break;
			
		case "nextStep":
			command_nextStep(input);
			break;
			
		case "n":
			command_nextStep(input);
			break;
			
		case "quit":
			break;
			
		case "exit":
			break;
			
		default:
			System.out.println("\nErvenytelen parancs!\n");
		
		}
	}
	
	/*
	 * Terkep betoltese fajlbol
	 */
	public static void command_loadMap(String[] input) {
		
		sandbox = new GameController();
		
		if(input.length != 2) {
			System.out.println("\nErvenytelen parameterezes!\n");
			return;
		}
		
		Map loadedmap = Loader.loadMap(input[1]);
		if(loadedmap == null) {
			System.out.println("\nHiba a terkepfajl beolvasasa soran!\n");
			return;
		}
		
		loadedmap.setGameController(sandbox);
		sandbox.setMap(loadedmap);
		
		MapPrinter.printMap(sandbox);
	}
	
	/*
	 * Parancslista betoltese fajlbol
	 */
	public static void command_loadCommandList(String[] input) {
		
		if(input.length != 2) {
			System.out.println("\nErvenytelen parameterezes!\n");
			return;
		}
		
		List<String> commands = Loader.loadCommands(input[1]);
		System.out.println("\nA beolvasott parancsok a kovetkezoek.\n");
		for(String command : commands) {
			runCommand(command, true);
		}
		System.out.println("");
	}
	
	/*
	 * Uj ellenseg hozzaadasa
	 */
	public static void command_addEnenmy(String[] input) {
		double posx, posy;
		
		if(input.length != 4) {
			System.out.println("\nErvenytelen parameterezes!\n");
			return;
		}
		
		if(!input[1].equals("dwarf") && !input[1].equals("elf") &&
				!input[1].equals("hobbit") && !input[1].equals("human")) {
			System.out.println("\nErvenytelen ellensegtipus!\n");
		}
		
		try {
			posx = Double.parseDouble(input[2]);
			posy = Double.parseDouble(input[3]);
		} catch(NumberFormatException e) {
			System.out.println("\nA koordinata nem szam!\n");
			return;
		}
		
		sandbox.startNewEnemy(posx, posy, input[1]);
		MapPrinter.printMap(sandbox);
	}
	
	/*
	 * Uj torony hozzaadasa
	 */
	public static void command_addTower(String[] input) {
		double posx, posy;
		
		if(input.length != 3) {
			System.out.println("\nErvenytelen parameterezes!\n");
			return;
		}
		
		try {
			posx = Double.parseDouble(input[1]);
			posy = Double.parseDouble(input[2]);
		} catch(NumberFormatException e) {
			System.out.println("\nA koordinata nem szam!\n");
			return;
		}
		
		Map map = sandbox.getMap();
		Tile tile = (map.getTile(posx,posy));
		if(tile.getClass() == Road.class) {
			System.out.println("\nUton nem helyeztheto el torony!\n");
			return;
		}
		
		Field field = (Field)map.getTile(posx, posy);
		if(field.getTower() != null) {
			System.out.println("\nA mezon mar van torony!\n");
			return;
		}
		
		field.setTower();
		MapPrinter.printMap(sandbox);
	}
	
	/*
	 * Meglevo torony torlese
	 */
	public static void command_removeTower(String[] input) {
		double posx, posy;
		
		if(input.length != 3) {
			System.out.println("\nErvenytelen parameterezes!\n");
			return;
		}
		
		try {
			posx = Double.parseDouble(input[1]);
			posy = Double.parseDouble(input[2]);
		} catch(NumberFormatException e) {
			System.out.println("\nA koordinata nem szam!\n");
			return;
		}
		
		Map map = sandbox.getMap();
		Tile tile = (map.getTile(posx,posy));
		if(tile.getClass() == Road.class) {
			System.out.println("\nUton nem lehet torony!\n");
			return;
		}
		
		Field field = (Field)map.getTile(posx, posy);
		if(field.getTower() == null) {
			System.out.println("\nA mezon nincs meg torony, nem lehet mit eltavolitani!\n");
			return;
		}
		
		field.resetTower();
		MapPrinter.printMap(sandbox);
	}
	
	/*
	 * Uj csapda hozzaadasa
	 */
	public static void command_addTrap(String[] input) {
		double posx, posy;
		
		if(input.length != 3) {
			System.out.println("\nErvenytelen parameterezes!\n");
			return;
		}
		
		try {
			posx = Double.parseDouble(input[1]);
			posy = Double.parseDouble(input[2]);
		} catch(NumberFormatException e) {
			System.out.println("\nA koordinata nem szam!\n");
			return;
		}
		
		Map map = sandbox.getMap();
		Tile tile = (map.getTile(posx,posy));
		if(tile.getClass() == Field.class) {
			System.out.println("\nMezon nem helyeztheto el akadaly!\n");
			return;
		}
		
		Road road = (Road)map.getTile(posx, posy);
		if(road.getTrap() != null) {
			System.out.println("\nAz uton mar van akadaly!\n");
			return;
		}
		
		road.setTrap();
		MapPrinter.printMap(sandbox);
	}
	
	/*
	 * Uj varazsko hozzaadasa
	 */
	public static void command_addGemStone(String[] input) {
		double posx, posy;
		
		if(input.length != 4) {
			System.out.println("\nErvenytelen parameterezes!\n");
			return;
		}

		if(!input[1].equals("antidwarf") && !input[1].equals("antielf") &&
				!input[1].equals("antihobbit") && !input[1].equals("antihuman") &&
				!input[1].equals("plustime") && !input[1].equals("plusfrequency") && !input[1].equals("plusrange")) {
			System.out.println("\nErvenytelen varazskotipus!\n");
			return;
		}
		
		try {
			posx = Double.parseDouble(input[2]);
			posy = Double.parseDouble(input[3]);
		} catch(NumberFormatException e) {
			System.out.println("\nA koordinata nem szam!\n");
			return;
		}
		
		Map map = sandbox.getMap();
		Tile tile = (map.getTile(posx,posy));
		if(tile.getClass() == Field.class) {
			Field field = (Field)tile;
			if(field.getTower() == null) {
				System.out.println("\nA mezon nincs torony, nem lehet mit varazskovezni!\n");
				return;
			}
			
			switch(input[1]) {
			case "antidwarf":
				field.addAntiDwarf();
				break;
			case "antielf":
				field.addAntiElf();
				break;
			case "antihobbit":
				field.addAntiHobbit();
				break;
			case "antihuman":
				field.addAntiHuman();
				break;
			case "plusfrequency":
				field.addPlusFrequency();
				break;
			case "plusrange":
				field.addPlusRange();
				break;
			}
		}
		else {
			Road road = (Road)tile;
			if(road.getTrap() == null) {
				System.out.println("\nAz uton nincs akadaly, nem lehet mit varazskovezni!\n");
				return;
			}
			
			road.addPlusTime();
		}
		
		MapPrinter.printMap(sandbox);
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
		
		sandbox.setRandomized(israndomize);
		if(israndomize) {
			System.out.println("\nVeletlenszeru viselkedes bekapcsolva!\n");
		}
		else {
			System.out.println("\nVeletlenszeru viselkedes kikapcsolva!\n");
		}
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
			for(int i = 0; i < stepnum; i++) {
				sandbox.nextStep();
			}
		}
		else {
			if(sandbox.getMap() != null) {
				sandbox.nextStep();
			}
		}
		
		if(sandbox.getMap() != null) {
			MapPrinter.printMap(sandbox);
		}
	}
}
