package proto;

/*
 * A t�rk�pen tal�lhat� objektumok poz�ci�j�nak t�rol�s�hoz haszn�lt
 * oszt�ly.
 */
public class Position {
	/*
	 * A poz�ci� x koordin�t�ja.
	 */
	private double x;
	/*
	 * A poz�ci� y koordin�t�ja.
	 */
	private double y;
	
	/*
	 * Position oszt�ly kontstruktora, koordin�t�k inicializ�l�sa
	 */
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/*
	 * Az x koordin�t�t k�rdezi le.
	 */
	public double getX() {
		return x;
	}
	
	/*
	 * Az y koordin�t�t k�rdezi le.
	 */
	public double getY() {
		return y;
	}

	/*
	 * Az x koordin�t�t �ll�tja be.
	 */
	public void setX(double _x) {
	
	}
	
	/*
	 * Az y koordin�t�t �ll�tja be.
	 */
	public void setY(double _y) {
	
	}
	
	/*
	 * Megadja a param�terk�nt �tadott Position t�pus� objektumt�l
	 * val� t�vols�g�t
	 */
	public double getDistance(Position a) {
		
	
		return Math.sqrt((x-a.x)*(x-a.x) + (y-a.y)*(y-a.y));
	}
}
