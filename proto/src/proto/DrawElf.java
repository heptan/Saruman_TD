package proto;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Dwarf ellenseg rajzolasahoz hasznalt objektum
 */
public class DrawElf {

	/**
	 * A rajzolast megvalosito metodus
	 * 
	 * @param o
	 *            A kirajzolando Elf ellenseg
	 * @param g
	 *            A graphics objektum, amire rajzolni kell
	 */
	public void draw(Elf o, Graphics g) {
		int tilesize = Constants.GUI_TILE_SIZE;
		int x = (int) o.getPosition().getX();
		int y = (int) o.getPosition().getY();
		g.setColor(new Color(0xFF, 0x00, 0xFF));
		g.fillOval(x * tilesize + tilesize / 2 + 2, y * tilesize + 2,
				tilesize / 2 - 4, tilesize / 2 - 4);
	}
}
