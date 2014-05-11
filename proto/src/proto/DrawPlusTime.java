package proto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * Az PlusTime rajzolo objektuma, kirajzolja a k�veket. A torpok elleni
 * varazskovek kirajzolasaert felelos osztaly.
 * 
 * @author Richard Czedli
 * @since 2014-05-09
 */
public class DrawPlusTime {

	/**
	 * A parameterkent kapott g objektummal kirajzoltat egy sotetebb barna
	 * szinu, kis meretu rombuszt a megkapott o objektum poziciojanak megfelelo
	 * negyzetracs kozepere.
	 * 
	 * @param o
	 *            A kirajzolando elettartamat modosito varazsko
	 * @param g
	 *            A graphics objektum, amire rajzolni kell
	 */
	public void draw(PlusTime o, Graphics g) {
		Position pos = o.getPosition();
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int tilesize = Constants.GUI_TILE_SIZE;
		g.setColor(new Color(44, 33, 0));
		Polygon p = new Polygon();
		p.addPoint(x * tilesize + tilesize / 3, y * tilesize + tilesize / 2);
		p.addPoint(x * tilesize + tilesize / 2, y * tilesize + tilesize / 3);
		p.addPoint(x * tilesize + (tilesize / 3) * 2, y * tilesize + tilesize
				/ 2);
		p.addPoint(x * tilesize + tilesize / 2, y * tilesize + (tilesize / 3)
				* 2);
		g.fillPolygon(p);
	}
}
