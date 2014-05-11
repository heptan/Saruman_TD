package proto;

import java.awt.Graphics;

/**
 * A kulonbozo tipusu ellensegek elleni sebzest modosito varazskovek
 * reprezentalasara hasznalt osztaly.
 */
public class AntiHobbit extends GemStone {

	/**
	 * A rajzolo objektumra mutato referencia
	 */
	private DrawAntiHobbit antiHobbitDrawer = new DrawAntiHobbit();

	/**
	 * A metodus mind a 4 tipusra azonos: elkeri a parameterben kapott torony
	 * megfelelo tipusu sebzeserteket a torony getDamageXxxx metodusaval,
	 * modositja az erteket, majd a setDamageXxxx metodussal beallitja a
	 * kiszamolt erteket.
	 * 
	 * @see proto.GemStone#setEffect(proto.Tower)
	 * @param toSet Az akadaly, amire probalta volna a user a varazskovet rahelyezni.
	 */
	@Override
	public void setEffect(Tower toSet) {
		toSet.setDamegeHobbit(2 * (toSet.getDamageHobbit()));

	}

	/**
	 * Ezt a kovet nem lehet akadalyra rakni, ezert ha ez a helyzet hiba
	 * uzenetet kuldok.
	 * 
	 * @see proto.GemStone#setEffect(proto.Trap)
	 * @param toSet Az akadaly, amire probalta volna a user a varazskovet rahelyezni.
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
	 * @param g Az a graphics objektum, amire rajzolni kell.
	 */
	@Override
	public void draw(Graphics g) {
		antiHobbitDrawer.draw(this, g);
	}
}
