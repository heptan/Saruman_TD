package proto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class DrawTrap {
	public void draw(Trap o, Graphics g) {
		int tilesize = Constants.GUI_TILE_SIZE;
		int x = (int) o.getPosition().getX();
		int y = (int) o.getPosition().getY();
		Polygon p = new Polygon();
		int width = tilesize/5;
		g.setColor(new Color(66, 33, 0));
		p.addPoint( x*tilesize + width*2, y*tilesize + tilesize/2);
	    p.addPoint( x*tilesize + tilesize/2, y*tilesize + width*2);
	    p.addPoint( x*tilesize + width*3, y*tilesize + tilesize/2);
	    p.addPoint( x*tilesize + tilesize/2, y*tilesize + width*3);
	    g.fillPolygon(p);
	}
}
