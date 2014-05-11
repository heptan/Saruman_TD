package proto;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Torony rajzolasahoz hasznalt objektum
 */
public class DrawTower {

	/**
	 * A rajzolast megvalosito metodus
	 * 
	 * @param o
	 *            A kirajzolando torony
	 * @param g
	 *            A graphics objektum, amire rajzolni kell
	 */
	public void draw(Tower o, Graphics g) {
		int tilesize = Constants.GUI_TILE_SIZE;
		int x = (int) o.getPosition().getX();
		int y = (int) o.getPosition().getY();
		g.setColor(new Color(0, 0, 0));
		g.fillOval(x * tilesize + 2, y * tilesize + 2, tilesize - 4,
				tilesize - 4);
	}
}
