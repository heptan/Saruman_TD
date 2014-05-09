package proto;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Az AntiDwarf rajzolo objektuma, kirajzolja a köveket.
 * A torpok elleni varazskovek kirajzolasaert felelos osztaly.
 * 
 * @author Richard Czedli
 * @since 2014-05-09
 */
public class DrawAntiDwarf {

	/**
	 * a parameterkent kapott g objektummal

		kirajzoltat egy hupikek szinu rombuszt a megkapott o objektum poziciojanak megfelelo 

		negyzetracs bal felso hatodaba.
	 */
	public void draw(AntiDwarf o, Graphics g) {
		int tilesize = Constants.GUI_TILE_SIZE;
		int sizex = ((int) map.getSize().getX() + 1) * tilesize;
		int sizey = ((int) map.getSize().getY() + 1) * tilesize;



}}
