package proto;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * A terkepet megjelenito panel, erre tortenik a terkepelemek kirajzolasa
 * 
 * @author Atilla Ivanics, Alex Torok
 * @since 2014-05-02
 */
public class MapPanel extends JPanel {
	
	/**
	 * GuiManager-re mutato referencia
	 */
	private GuiManager guimanager;

	/**
	 * Konstruktor, GuiManager inicializalasa
	 */
	public MapPanel(GuiManager guimanager) {
		this.guimanager = guimanager;
	}
	
	/**
	 * Ezzel a metodussal tortenik a terkep ujrarajzolasa
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g){
		
		//Alap magenta szinu vaszon kirajzolasa
		Position mapsize = guimanager.getGameController().getMapSize();
		g.setColor(new Color(255, 53, 197));
		g.fillRect(0, 0, ((int)mapsize.getX() + 1) * Constants.GUI_TILE_SIZE, ((int)mapsize.getY() + 1) * Constants.GUI_TILE_SIZE);
		
		//Terkep negyzetracsanak kirajzolasa
		guimanager.redrawAll(g);	
		
	}

}