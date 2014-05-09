
package proto;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Az PlusFrequency rajzolo objektuma, kirajzolja a koveket.
 * A nagyobb tuzelesi gyakorisag novelesere valo varazskovek kirajzolasaert felelos osztaly.
 * 
 * @author Richard Czedli
 * @since 2014-05-09
 */
public class DrawPlusFrequency {

	/**
	 *a parameterkent kapott g objektummal

		kirajzoltat egy feh�r szinu rombuszt a megkapott o objektum poziciojanak megfelelo 
	
		negyzetracs bal also hatodaba.
	 */
	public void draw(PlusFrequency o, Graphics g) {
				Position pos = o.getPosition();
				int x = (int) pos.getX();
				int y = (int) pos.getY();
				int tilesize = Constants.GUI_TILE_SIZE;
				
				g.setColor(new Color(0xff, 0xff, 0xff));
				g.fillPolygon(new int []{x,x+tilesize/4,x+tilesize/2,x+tilesize/4}, new int []{y+tilesize*5/6,y+tilesize*2/3,y+tilesize*5/6,y+tilesize},4);
			} 
		}

