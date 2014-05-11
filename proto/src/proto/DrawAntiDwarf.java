package proto;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Az AntiDwarf rajzolo objektuma, kirajzolja a koveket. A torpok elleni
 * varazskovek kirajzolasaert felelos osztaly.
 * 
 * @author Richard Czedli
 * @since 2014-05-09
 */
public class DrawAntiDwarf {

	/**
	 * A parameterkent kapott g objektummal kirajzoltat egy hupikek szinu
	 * rombuszt a megkapott o objektum poziciojanak megfelelo negyzetracs bal
	 * felso hatodaba.
	 * 
	 * @param o
	 *            A kirajzolando Dwarf elleni varazsko
	 * @param g
	 *            A graphics objektum, amire rajzolni kell
	 */
	public void draw(AntiDwarf o, Graphics g) {
		Position pos = o.getPosition();
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int tilesize = Constants.GUI_TILE_SIZE;

		g.setColor(new Color(0, 176, 240));
		g.fillPolygon(new int[] { x * tilesize, x * tilesize + tilesize / 4,
				x * tilesize + tilesize / 2, x * tilesize + tilesize / 4 },
				new int[] { y * tilesize + tilesize / 6, y * tilesize,
						y * tilesize + tilesize / 6,
						y * tilesize + tilesize / 3 }, 4);
	}
}
