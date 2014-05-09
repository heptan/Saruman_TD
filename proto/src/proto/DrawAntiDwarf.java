package proto;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Az AntiDwarf rajzolo objektuma, kirajzolja a köveket.
 * A torpok elleni varazskovek kirajzolasaert felelos osztaly.
 * 
 * @author Richard Czedli
 * @since 2014-05-09
 */
public class DrawAntiDwarf extends GemDrawer {

	/**
	 * a parameterkent kapott g objektummal

		kirajzoltat egy hupikek szinu rombuszt a megkapott o objektum poziciojanak megfelelo 

		negyzetracs bal felso hatodaba.
	 */
	public void draw(AntiDwarf o, Graphics g) {
				Position pos = o.getPosition();
				int x = (int) pos.getX();
				int y = (int) pos.getY();
				int tilesize = Constants.GUI_TILE_SIZE;
				
				g.setColor(new Color(0x64, 0x95, 0xED));
				g.fillPolygon(new int []{x,x+tilesize/4,x+tilesize/2,x+tilesize/4}, new int []{y+tilesize/6,y,y+tilesize/6,y+tilesize/3},4);
			} 
		}

