package proto;

import java.awt.Color;
import java.awt.Graphics;

public class DrawHuman {
	public void draw(Human o, Graphics g) {
		int tilesize = Constants.GUI_TILE_SIZE;
		int x = (int) o.getPosition().getX();
		int y = (int) o.getPosition().getY();		
		g.setColor(new Color(237, 28, 36));
		g.fillOval(x*tilesize+tilesize/2 + 2,y*tilesize+tilesize/2+2,tilesize/2-4,tilesize/2-4);		
	}
}
