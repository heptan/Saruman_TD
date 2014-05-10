package proto;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Az AntiDwarf rajzolo objektuma, kirajzolja a k�veket.
 * A torpok elleni varazskovek kirajzolasaert felelos osztaly.
 * 
 * @author Richard Czedli
 * @since 2014-05-09
 */
public class DrawAntiDwarf {

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
				
				g.setColor(new Color(185, 122, 87));
				g.fillRect(x*tilesize+x, y*tilesize+y, tilesize,tilesize);
			} 
		}

