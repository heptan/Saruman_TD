package proto;

import java.util.ArrayList;
import java.util.List;

/**
 * Az ut megvalositasara hasznalt osztaly
 * 
 * @author Atilla Ivanics
 */
public class Road extends Tile {

	/*
	 * Az uton levo akadaly referenciajat tarolja
	 * (ha nincs akadaly, akkor null)
	 */
	private Trap trap;

	/*
	 * Az ellenseg haladasa szerinti kovetkezo utelemet tarolja
	 */
	private List<Road> nextroad;
	
	/*
	 * Road osztaly konstruktora, nextroad lista inicializalasa ures arraylist-re
	 */
	public Road() {
		nextroad = new ArrayList<Road>();
	}
	
	/*
	 * Road osztaly konstruktora, nextroad lista inicializalasa ures arraylist-re
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
		//TODO Akadaly idejenek beallitasa
	}
	
	/*
	 * Az aktualis utelemet koveto utelem lekerdezese
	 */
	public Road getNextRoad() {
		//TODO Veletlen valasztas
		return nextroad.get(0);
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
		if(road != null) {
			nextroad.add(road);
		}
	}
	
	/*
	 * Az utelemrol elerheto kovetkezo utelemekt inicializalo metodus
	 */
	public void setNeighbours(List<Road> junctionroadlist) {
		
		if(nextroad.size() != 0) {
			return;
		}
		
		Road junctionroad = null;
		for(Road r : junctionroadlist) {
			if(r.getPosition().getX() == position.getX() && r.getPosition().getY() == position.getY()) {
				junctionroad = r;
			}
		}
		if(junctionroad != null) {
			nextroad.clear();
			for(Road r : junctionroad.getNextRoadList()) {
				nextroad.add((Road)map.getTile(r.getPosition().getX(), r.getPosition().getY()));
				r.setNeighbours(junctionroadlist);
			}
		}
		else {
			for(Road r : map.getRoadNeighbours(position.getX(), position.getY())) {
				if(r.getNextRoadList().size() == 0) {
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
		//TODO
		//trap.addPlusTime();
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
}