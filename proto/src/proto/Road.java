package proto;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Az ut megvalositasara hasznalt osztaly
 * 
 * @author Atilla Ivanics
 */
public class Road extends Tile {

	private DrawRoad roadDrawer = new DrawRoad();
	/*
	 * Az uton levo akadaly referenciajat tarolja (ha nincs akadaly, akkor null)
	 */
	private Trap trap;

	/*
	 * Az ellenseg haladasa szerinti kovetkezo utelemet tarolja
	 */
	private List<Road> nextroad;

	/*
	 * Road osztaly konstruktora, nextroad lista inicializalasa ures
	 * arraylist-re
	 */
	public Road() {
		nextroad = new ArrayList<Road>();
		trap = null;
	}

	/*
	 * Road osztaly konstruktora, nextroad lista inicializalasa ures
	 * arraylist-re
	 */
	public Road(double x, double y) {
		nextroad = new ArrayList<Road>();
		position = new Position(x, y);
	}

	/*
	 * Az uton levo akadaly referenciajanak lekerdezese
	 */
	public Trap getTrap() {
		return trap;
	}

	/*
	 * Az uton levo akadaly referenciajanak beallitasa
	 */
	public void setTrap() {
		trap = new Trap();
		trap.setPosition(this.position);
		trap.setRoad(this);
		for(Enemy e : map.getGameController().getEnemyList()) {
			e.addObserver(trap);
		}
	}

	// Nem lehet rajta torony
	@Override
	public Tower getTower() {
		return null;
	}

	/*
	 * Az aktualis utelemet koveto utelem lekerdezese
	 */
	public Road getNextRoad() {
		
		if (map.getGameController().isRandomized()) {
			if(nextroad.size() == 0) {
				return null;
			}
			Random rand = new Random();
			int n = rand.nextInt(nextroad.size());
			return nextroad.get(n);
		}
		else {
			if(nextroad.size() > 1) {
				
				System.out
						.println("Valassza ki a kovetkezo utelem sorszamat az alabbi listabol! Jelenlegi utelem; PosX="
								+ this.getPosition().getX()
								+ ", PosY="
								+ this.getPosition().getY());
				for (int i = 0; i < nextroad.size(); i++) {
					System.out.println(i + " > PosX=" + nextroad.get(i).position.getX() + ", PosY=" + nextroad.get(i).getPosition().getY());
				}
				
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					String inputtext = "";
					try {
						inputtext = br.readLine();
					} catch (IOException e1) {
						System.out.println("Nem ertelmezheto bemenet, 0. elem kivalasztva!");
					}
					int selectedindex = 0;
					try {
						selectedindex = Integer.parseInt(inputtext);
					} catch(Exception e) {
						System.out.println("Nem ertelmezheto bemenet, 0. elem kivalasztva!");
					}
					if(selectedindex >= nextroad.size()) {
						System.out.println("Nem ertelmezheto bemenet, 0. elem kivalasztva!");
						selectedindex = 0;
					}
				
					return nextroad.get(selectedindex);
					
			}
			
			if(nextroad.size() > 0) {
				return nextroad.get(0);
			}
			
			return null;
		}
		
	}

	/*
	 * Az aktualis utelemet koveto utelemek listajanak
	 */
	public List<Road> getNextRoadList() {
		return nextroad;
	}

	/*
	 * Az aktualis utelemet koveto utelem beallitasa
	 */
	public void addNextRoad(Road road) {
		if (road != null) {
			nextroad.add(road);
		}
	}

	/*
	 * Az utelemrol elerheto kovetkezo utelemekt inicializalo metodus
	 */
	public void setNeighbours(List<Road> junctionroadlist) {

		if (nextroad.size() != 0) {
			return;
		}

		Road junctionroad = null;
		for (Road r : junctionroadlist) {
			if (r.getPosition().getX() == position.getX()
					&& r.getPosition().getY() == position.getY()) {
				junctionroad = r;
			}
		}
		if (junctionroad != null) {
			nextroad.clear();
			for (Road r : junctionroad.getNextRoadList()) {
				nextroad.add((Road) map.getTile(r.getPosition().getX(), r
						.getPosition().getY()));
				r.setNeighbours(junctionroadlist);
			}
		} else {
			for (Road r : map.getRoadNeighbours(position.getX(),
					position.getY())) {
				if (r.getNextRoadList().size() == 0) {
					nextroad.add(r);
					r.setNeighbours(junctionroadlist);
				}
			}
		}
	}

	/*
	 * Az akadaly idejet meghosszabbito varazsko hozzaadasa
	 */
	@Override
	public void addPlusTime() {
		if (trap != null) {
			trap.addPlusTime();
		}
	}

	/*
	 * A tobbi tipust itt nem hasznalhatjuk, hiba
	 */
	@Override
	public void addAntiHuman() {
		System.out.println("Ezt a kovet csak toronyra lehet tenni");
	}

	@Override
	public void addAntiElf() {
		System.out.println("Ezt a kovet csak toronyra lehet tenni");
	}

	@Override
	public void addAntiDwarf() {
		System.out.println("Ezt a kovet csak toronyra lehet tenni");
	}

	@Override
	public void addAntiHobbit() {
		System.out.println("Ezt a kovet csak toronyra lehet tenni");
	}

	@Override
	public void addPlusFrequency() {
		System.out.println("Ezt a kovet csak toronyra lehet tenni");
	}

	@Override
	public void addPlusRange() {
		System.out.println("Ezt a kovet csak toronyra lehet tenni");
	}
	
	/**
	 * Rajzolas kezdemenyezzese
	 */
	public void draw(Graphics g) {
		roadDrawer.draw(this, g);
		if(trap != null){
			trap.draw(g);
		}
	}

}