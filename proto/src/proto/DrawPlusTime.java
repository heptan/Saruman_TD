package proto;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Az PlusTime rajzolo objektuma, kirajzolja a köveket.
 * A torpok elleni varazskovek kirajzolasaert felelos osztaly.
 * 
 * @author Richard Czedli
 * @since 2014-05-09
 */
public class DrawPlusTime {

	/**
	 * a parameterkent kapott g objektummal

	kirajzoltat egy sotetebb barna szinu, kis meretu rombuszt a megkapott o objektum 

	poziciojanak megfelelo negyzetracs kozepere.	 */
	
	public void draw(PlusTime o, Graphics g) {
				Position pos = o.getPosition();
				int x = (int) pos.getX();
				int y = (int) pos.getY();
				int tilesize = Constants.GUI_TILE_SIZE;
				
				g.setColor(new Color(0x99, 0x66, 0x00));
				g.fillPolygon(new int []{x*tilesize+tilesize/4,x*tilesize+tilesize/2,x*tilesize+tilesize*3/4,x*tilesize+tilesize/2}, new int []{y*tilesize+tilesize/2,y*tilesize+tilesize/3,y*tilesize+tilesize/3,y*tilesize+tilesize*4/6},4);
			} 
		}

