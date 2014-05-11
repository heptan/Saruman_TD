package proto;

import java.awt.Graphics;

/**
 * A kulonbozo tipusu ellensegek elleni sebzest modosito varazskovek
 * reprezentalasara hasznalt osztaly.
 */
public class AntiDwarf extends GemStone {

	/**
	 * A rajzolo objektumra mutato referencia
	 */
	private DrawAntiDwarf antiDwarfDrawer = new DrawAntiDwarf();

	/**
	 * A metodus mind a 4 tipusra azonos: elkeri a parameterben kapott torony
	 * megfelelo tipusu sebzeserteket a torony getDamageXxxx metodusaval,
	 * modositja az erteket, majd a setDamageXxxx metodussal beallitja a
	 * kiszamolt erteket.
	 * 
	 * @see proto.GemStone#setEffect(proto.Tower)
	 * @param toSet
	 *            A torony, amire a user a varazskovet elhelyezte.
	 */
	@Override
	public void setEffect(Tower toSet) {
		toSet.setDamegeDwarf(2 * (toSet.getDamageDwarf()));

	}

	/**
	 * Ezt a kovet nem lehet akadalyra rakni, ezert ha ez a helyzet hiba
	 * uzenetet kuldok.
	 * 
	 * @see proto.GemStone#setEffect(proto.Trap)
	 * @param toSet
	 *            Az akadaly, amire probalta volna a user a varazskovet
	 *            rahelyezni.
	 */
	@Override
	public void setEffect(Trap toSet) {
		System.out.println("Ezt a kovet csak toronyra lehet tenni");
		;

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
		antiDwarfDrawer.draw(this, g);
	}
}