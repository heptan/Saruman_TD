package proto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

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

		// g.setColor(new Color(0xFF, 0x00, 0xFF));
		// g.fillOval(x * tilesize + tilesize / 2 + 2, y * tilesize + 2,
		// tilesize / 2 - 4, tilesize / 2 - 4);

		Image im = new ImageIcon("textures/elf.png").getImage();
		g.drawImage(im, x * tilesize + tilesize / 2, y * tilesize, x * tilesize
				+ tilesize, y * tilesize + tilesize / 2, 0, 0, im.getWidth(null),
				im.getHeight(null), null);
	}
}
