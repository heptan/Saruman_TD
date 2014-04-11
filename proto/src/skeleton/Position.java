package skeleton;

/*
 * A térképen található objektumok pozíciójának tárolásához használt
 * osztály.
 */
public class Position {
	/*
	 * A pozíció x koordinátája.
	 */
	private double x;
	/*
	 * A pozíció y koordinátája.
	 */
	private double y;
	
	/*
	 * Position osztály kontstruktora, koordináták inicializálása
	 */
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/*
	 * Az x koordinátát kérdezi le.
	 */
	public double getX() {
		return x;
	}
	
	/*
	 * Az y koordinátát kérdezi le.
	 */
	public double getY() {
		return y;
	}

	/*
	 * Az x koordinátát állítja be.
	 */
	public void setX(double _x) {
	
	}
	
	/*
	 * Az y koordinátát állítja be.
	 */
	public void setY(double _y) {
	
	}
	
	/*
	 * Megadja a paraméterként átadott Position típusú objektumtól
	 * való távolságát
	 * TODO Nincs paraméter!
	 */
	public double getDistance() {
		return 0.0;
	}
}
