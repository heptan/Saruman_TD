package proto;

import java.awt.Graphics;

/**
 * A kulonbozo tipusu ellensegek elleni sebzest modosito varazskovek
 * reprezentalasara hasznalt osztaly.
 */
public class AntiElf extends GemStone {

	/**
	 * A rajzolo objektumra mutato referencia
	 */
	private DrawAntiElf antiElfDrawer = new DrawAntiElf();

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
		toSet.setDamegeElf(2 * (toSet.getDamageElf()));

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
	 * A varazsko rajzolasahoz hasznalt metodus
	 * 
	 * @see proto.GemStone#draw(java.awt.Graphics)
	 * @param g
	 *            Az a graphics objektum, amire rajzolni kell.
	 */
	@Override
	public void draw(Graphics g) {
		antiElfDrawer.draw(this, g);
	}
}
