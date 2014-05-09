package proto;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A terkep objektum rajzolo objektuma, kirajzolja a negyzetracsot
 * 
 * @author Alex Torok
 * @since 2014-05-03
 */
public class DrawMap {

	/**
	 * Terkep (negyzetracs) rajzolo metodus
	 * 
	 * @param map
	 *            Kirajzolando terkep objektum
	 * @param g
	 *            Ahova mindezt ki kene rajzolni
	 */
	public void draw(Map map, Graphics g) {
		int tilesize = Constants.GUI_TILE_SIZE;
		int sizex = ((int) map.getSize().getX() + 1) * tilesize;
		int sizey = ((int) map.getSize().getY() + 1) * tilesize;

		for (int x = 0; x < sizex; x += tilesize) {
			for (int y = 0; y < sizey; y += tilesize) {
				g.setColor(Color.BLACK);
				g.fillRect(x, y, 1, (tilesize / 4));
				g.fillRect(x, y, (tilesize / 4), 1);
				g.setColor(Color.RED);
				g.fillRect(x, y + (tilesize / 4), 1, (tilesize / 4));
				g.fillRect(x + (tilesize / 4), y, (tilesize / 4), 1);
				g.setColor(Color.BLACK);
				g.fillRect(x, y + 2 * (tilesize / 4), 1, (tilesize / 4));
				g.fillRect(x + 2 * (tilesize / 4), y, (tilesize / 4), 1);
				g.setColor(Color.RED);
				g.fillRect(x, y + 3 * (tilesize / 4), 1, (tilesize / 4));
				g.fillRect(x + 3 * (tilesize / 4), y, (tilesize / 4), 1);
			}
			
			//Utolso oszlopszegely
			for (int y = 0; y < sizey; y += (tilesize / 4)) {
				if(g.getColor() == Color.BLACK) {
					g.setColor(Color.RED);
				} else {
					g.setColor(Color.BLACK);
				}
				g.fillRect(sizex - 1, y, 1, (tilesize / 4));
			}
		}

		//Utolso sorszegely
		for (int x = 0; x < sizex; x += (tilesize / 4)) {
			if(g.getColor() == Color.BLACK) {
				g.setColor(Color.RED);
			} else {
				g.setColor(Color.BLACK);
			}
			g.fillRect(x, sizey - 1, (tilesize / 4), 1);
		}
	}

}
