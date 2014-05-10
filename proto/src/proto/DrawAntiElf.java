package proto;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Az AntiElf rajzolo objektuma, kirajzolja a köveket.
 * A elfek elleni varazskovek kirajzolasaert felelos osztaly.
 * 
 * @author Richard Czedli
 * @since 2014-05-09
 */
public class DrawAntiElf {

	/**
	 * a parameterkent kapott g objektummal
		kirajzoltat egy magenta szinu rombuszt a megkapott o objektum poziciojanak 
		megfelelo negyzetracs jobb felso hatodaba.
	 */
	public void draw(AntiElf o, Graphics g) {
				Position pos = o.getPosition();
				int x = (int) pos.getX();
				int y = (int) pos.getY();
				int tilesize = Constants.GUI_TILE_SIZE;
				
				g.setColor(new Color(0xFF, 0x00, 0xFF));
				g.fillPolygon(new int []{x*tilesize+tilesize/2,x*tilesize+tilesize*3/4,x*tilesize+tilesize,x*tilesize+tilesize*3/4}, new int []{y*tilesize+tilesize/6,y*tilesize,y*tilesize+tilesize/6,y*tilesize+tilesize/3},4);
			} 
		}

