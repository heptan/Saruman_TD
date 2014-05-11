package proto;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Az PlusRange rajzolo objektuma, kirajzolja a k�veket. A plusz hatotavot ado
 * varazskovek kirajzolasaert felelos osztaly.
 * 
 * @author Richard Czedli
 * @since 2014-05-09
 */
public class DrawPlusRange {

	/**
	 * A parameterkent kapott g objektummal kirajzoltat egy szurke szinu
	 * rombuszt a megkapott o objektum poziciojanak megfelelo negyzetracs jobb
	 * also hatodaba.
	 * 
	 * @param o
	 *            A kirajzolando tuzelesi hatotavolsagot modosito varazsko
	 * @param g
	 *            A graphics objektum, amire rajzolni kell
	 */
	public void draw(PlusRange o, Graphics g) {
		Position pos = o.getPosition();
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int tilesize = Constants.GUI_TILE_SIZE;

		g.setColor(new Color(0x80, 0x80, 0x80));
		g.fillPolygon(new int[] { x * tilesize + tilesize / 2,
				x * tilesize + tilesize * 3 / 4, x * tilesize + tilesize,
				x * tilesize + tilesize * 3 / 4 }, new int[] {
				y * tilesize + tilesize * 5 / 6,
				y * tilesize + tilesize * 2 / 3,
				y * tilesize + tilesize * 5 / 6, y * tilesize + tilesize }, 4);
	}
}
