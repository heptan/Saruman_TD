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
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {

		Position mapsize = guimanager.getGameController().getMapSize();

		if (guimanager.getGameController().getWin()
				|| guimanager.getGameController().getGameOver()
				|| mapsize == new Position(0, 0)) {
			int w = guimanager.getFrameSize().width;
			int h = guimanager.getFrameSize().height;

			g.setColor(Color.GRAY);
			g.fillRect(0, 0, w, h);
		} else {

			// Terkep kirajzolasa
			guimanager.redrawAll(g);
		}

	}

}