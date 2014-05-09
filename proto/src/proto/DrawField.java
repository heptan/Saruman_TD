package proto;

import java.awt.Color;
import java.awt.Graphics;

public class DrawField {

	public void draw(Field o, Graphics g) {
		Position pos = o.getPosition();
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int tilesize = Constants.GUI_TILE_SIZE;

		g.setColor(new Color(118, 147, 60));
		g.fillRect(x * tilesize + x, y * tilesize + y, tilesize, tilesize);
	}
}