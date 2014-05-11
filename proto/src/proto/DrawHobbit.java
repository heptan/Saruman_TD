package proto;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Dwarf ellenseg rajzolasahoz hasznalt objektum
 */
public class DrawHobbit {

	/**
	 * A hobbit rajzolasat megvalosito metodus.
	 * 
	 * @param o
	 *            A kirajzolando Hobbit ellenseg
	 * @param g
	 *            A graphics objektum, amire rajzolni kell
	 */
	public void draw(Hobbit o, Graphics g) {
		int tilesize = Constants.GUI_TILE_SIZE;
		int x = (int) o.getPosition().getX();
		int y = (int) o.getPosition().getY();
		g.setColor(new Color(255, 201, 14));
		g.fillOval(x * tilesize + 2, y * tilesize + tilesize / 2 + 2,
				tilesize / 2 - 4, tilesize / 2 - 4);
	}
}
