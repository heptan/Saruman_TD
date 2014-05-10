package proto;

import java.awt.Color;
import java.awt.Graphics;

/**
<<<<<<< HEAD
 * Az AntiDwarf rajzolo objektuma, kirajzolja a köveket.
=======
 * Az AntiDwarf rajzolo objektuma, kirajzolja a kï¿½veket.
>>>>>>> d88a478f4a0ce56798429370e9d4f8ad61a82aa7
 * A torpok elleni varazskovek kirajzolasaert felelos osztaly.
 * 
 * @author Richard Czedli
 * @since 2014-05-09
 */
<<<<<<< HEAD
public class DrawAntiDwarf extends GemDrawer {
=======
public class DrawAntiDwarf {
>>>>>>> d88a478f4a0ce56798429370e9d4f8ad61a82aa7

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
				
<<<<<<< HEAD
				g.setColor(new Color(0x64, 0x95, 0xED));
				g.fillPolygon(new int []{x,x+tilesize/4,x+tilesize/2,x+tilesize/4}, new int []{y+tilesize/6,y,y+tilesize/6,y+tilesize/3},4);
=======
				g.setColor(new Color(185, 122, 87));
				g.fillRect(x*tilesize+x, y*tilesize+y, tilesize,tilesize);
>>>>>>> d88a478f4a0ce56798429370e9d4f8ad61a82aa7
			} 
		}

