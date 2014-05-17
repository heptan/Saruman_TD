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
//		int tilesize = Constants.GUI_TILE_SIZE;
//		int sizex = ((int) map.getSize().getX() + 1) * tilesize;
//		int sizey = ((int) map.getSize().getY() + 1) * tilesize;
//		g.setColor(Color.BLACK);
//
//		for (int x = 0; x < sizex; x += tilesize) {
//			for (int y = 0; y < sizey; y += tilesize) {
//				g.fillRect(x, y, 1, tilesize);
//				g.fillRect(x, y, tilesize, 1);
//			}
//		}
//		
//		//Utolso sor es oszlo szegely
//		g.fillRect(0, sizey-1, sizex, 1);
//		g.fillRect(sizex-1, 0, 1, sizey);
	}

}
