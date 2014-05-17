package proto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

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

		// g.setColor(new Color(118, 147, 60));
		// g.fillRect(x * tilesize, y * tilesize , tilesize, tilesize);

		Image im = new ImageIcon("textures/field.png").getImage();
		g.drawImage(im,x * tilesize, y * tilesize, x * tilesize + tilesize, y * tilesize + tilesize,
				0, 0, im.getWidth(null), im.getHeight(null), null);
	}
}
