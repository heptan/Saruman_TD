package proto;

/*
 * A terkepen talalhato objektumok poziciojanak tarolasahoz, 
 * pozicioadatokkal valo szamolashoz hasznalt osztaly. 
 * Letrehozasakor ellenorzi, hogy a megadott (x, y) koordinata
 *  a terkep teruleten belulre esik-e.
 */
public class Position {
	/*
	 * Tarolt pozicio x koordinataja.
	 * 
	 */
	private double x;
	/*
	 * Tarolt pozicio y koordinataja.
	 */
	private double y;
	
	/*
	 * Position osztaly kontstruktora, koordinatak inicializalasa.
	 */
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/*
	 * Az x koordinata lekerdezesehez hasznalt metodus.
	 */
	public double getX() {
		return x;
	}
	
	/*
	 * Az y koordinata lekerdezesehez hasznalt metodus.
	 */
	public double getY() {
		return y;
	}

	/*
	 * Az x koordinata beallitasahoz hasznalt metodus.
	 */
	
	public void setX(double _x) {
	
	}
	
	/*
	 * Az y koordinata beallitasahoz hasznalt metodus.
	 */
	public void setY(double _y) {
	
	}
	
	/*
	 * Megadja a parameterkent atadott Position tipusu objektumtol
	 *  valo tavolsagat az aktualis Position objektumnak.
	 */
	public double getDistance(Position a) {
		
	
		return Math.sqrt((x-a.x)*(x-a.x) + (y-a.y)*(y-a.y));
	}
}
