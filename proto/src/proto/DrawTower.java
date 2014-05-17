package proto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

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
		
//		g.setColor(new Color(0, 0, 0));
//		g.fillOval(x * tilesize + 2, y * tilesize + 2, tilesize - 4,
//				tilesize - 4);
		
		Image im = new ImageIcon("textures/tower.png").getImage();
		g.drawImage(im,x * tilesize, y * tilesize, x * tilesize + tilesize, y * tilesize + tilesize,
				0, 0, im.getWidth(null), im.getHeight(null), null);
	}
}
