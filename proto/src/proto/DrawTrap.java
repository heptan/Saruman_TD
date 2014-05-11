package proto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class DrawTrap {
	public void draw(Trap o, Graphics g) {
		int tilesize = Constants.GUI_TILE_SIZE;
		int x = (int) o.getPosition().getX();
		int y = (int) o.getPosition().getY();
		g.setColor(new Color(107, 37, 4));		
	    g.fillOval(x*tilesize+2,y*tilesize+2,tilesize-4,tilesize-4);
	}
}
