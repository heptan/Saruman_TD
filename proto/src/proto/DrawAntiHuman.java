package proto;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Az AntiHuman rajzolo objektuma, kirajzolja a köveket.
 * Az emberek elleni varazskovek kirajzolasaert felelos osztaly.
 * 
 * @author Richard Czedli
 * @since 2014-05-09
 */
public class DrawAntiHuman {

	/**
	a parameterkent kapott g objektummal

	kirajzoltat egy piros színu rombuszt a megkapott o objektum poziciojanak megfelelo 

	negyzetracs jobb kozepso hatodaba.
	 */
	public void draw(AntiHuman o, Graphics g) {
				Position pos = o.getPosition();
				int x = (int) pos.getX();
				int y = (int) pos.getY();
				int tilesize = Constants.GUI_TILE_SIZE;
				
				g.setColor(new Color(237, 28, 36));
				g.fillPolygon(new int []{x*tilesize+tilesize/2,x*tilesize+tilesize*3/4,x*tilesize+tilesize,x*tilesize+tilesize*3/4}, new int []{y*tilesize+tilesize/2,y*tilesize+tilesize/3,y*tilesize+tilesize/2,y*tilesize+tilesize*2/3},4);
			} 
		}

