package proto;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Mezo palyaelem rajzolasahoz hasznalt objektum
 */
public class DrawField {

	/**
	 * A rajzolast megvalosito metodus
	 * 
	 * @param o
	 *            A kirajzolando mezo palyaelem
	 * @param g
	 *            A graphics objektum, amire rajzolni kell
	 */
	public void draw(Field o, Graphics g) {
		Position pos = o.getPosition();
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int tilesize = Constants.GUI_TILE_SIZE;

		g.setColor(new Color(118, 147, 60));
		g.fillRect(x * tilesize, y * tilesize , tilesize, tilesize);
	}
}
