package proto;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Az AntiHobbit rajzolo objektuma, kirajzolja a köveket.
 * A hobbitok elleni varazskovek kirajzolasaert felelos osztaly.
 * 
 * @author Richard Czedli
 * @since 2014-05-09
 */
public class DrawAntiHobbit {

	/**
	 * a parameterkent kapott g objektummal
	kirajzoltat egy sarga szinu rombuszt a megkapott o objektum poziciojanak megfelelo 
	negyzetracs bal kozepso hatodaba.	 */
	public void draw(AntiHobbit o, Graphics g) {
				Position pos = o.getPosition();
				int x = (int) pos.getX();
				int y = (int) pos.getY();
				int tilesize = Constants.GUI_TILE_SIZE;
				
				g.setColor(new Color(0xff, 0xff, 0x00));
				g.fillPolygon(new int []{x,x+tilesize/4,x+tilesize/2,x+tilesize/4}, new int []{y+tilesize/2,y+tilesize/3,y+tilesize/2,y+tilesize*2/3},4);
			} 
		}

