package proto;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Az AntiHobbit rajzolo objektuma, kirajzolja a k�veket. A hobbitok elleni
 * varazskovek kirajzolasaert felelos osztaly.
 * 
 * @author Richard Czedli
 * @since 2014-05-09
 */
public class DrawAntiHobbit {

	/**
	 * A parameterkent kapott g objektummal kirajzoltat egy sarga szinu rombuszt
	 * a megkapott o objektum poziciojanak megfelelo negyzetracs bal kozepso
	 * hatodaba.
	 * 
	 * @param o
	 *            A kirajzolando Hobbit elleni varazsko
	 * 
	 * @param g
	 *            A graphics objektum, amire rajzolni kell
	 */
	public void draw(AntiHobbit o, Graphics g) {
		Position pos = o.getPosition();
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int tilesize = Constants.GUI_TILE_SIZE;

		g.setColor(new Color(255, 201, 14));
		g.fillPolygon(new int[] { x * tilesize, x * tilesize + tilesize / 4,
				x * tilesize + tilesize / 2, x * tilesize + tilesize / 4 },
				new int[] { y * tilesize + tilesize / 2,
						y * tilesize + tilesize / 3,
						y * tilesize + tilesize / 2,
						y * tilesize + tilesize * 2 / 3 }, 4);

	}
}
