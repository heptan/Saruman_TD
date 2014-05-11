package proto;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Dwarf ellenseg rajzolasahoz hasznalt objektum
 */
public class DrawDwarf {
	
	/**
	 * A rajzolast megvalosito metodus
	 * 
	 * @param o
	 *            A kirajzolando Dwarf ellenseg
	 * @param g
	 *            A graphics objektum, amire rajzolni kell
	 */
	public void draw(Dwarf o, Graphics g) {
		int tilesize = Constants.GUI_TILE_SIZE;
		int x = (int) o.getPosition().getX();
		int y = (int) o.getPosition().getY();		
		g.setColor(new Color(0, 176, 240));
		g.fillOval(x*tilesize+ 2,y*tilesize+2,tilesize/2-4,tilesize/2-4);				
	}
}
