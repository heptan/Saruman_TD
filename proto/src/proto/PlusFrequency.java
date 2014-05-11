package proto;

import java.awt.Graphics;

/*
 * A torony lovesi frekvenciajat modosito varazskovet reprezentalo osztaly.
 */
public class PlusFrequency extends GemStone {
	private DrawPlusFrequency PlusFrequencyDrawer = new DrawPlusFrequency();
	/*
	 *  A metodus elkeri a parameterben kapott torony megfelelo erteket (frequency)
	 *   a torony megfelelo get metodusaval, modositja az erteket, 
	 *   majd a set metodussal beallitja a kiszamolt erteket.

	*/
	@Override
	public void setEffect(Tower toSet) {
		toSet.setFrequency(2*toSet.getFrequency());
		
	}
	
	//Ezt a kovet nem lehet akadalyra rakni, ezert ha ez a helyzet hiba uzenetet kuldok.
	
	@Override
	public void setEffect(Trap toSet) {
		System.out.println("Ezt a kovet csak toronyra lehet tenni");;
		
	}
	/**
	 * A varazsko rajzolo metodusat hivja
	 * 
	 * @see proto.GemStone#draw(java.awt.Graphics)
	 * @param g
	 *            Az a graphics objektum, amire rajzolni kell.
	 */
	@Override
	public void draw(Graphics g) {
		PlusFrequencyDrawer.draw(this, g);
	}
}