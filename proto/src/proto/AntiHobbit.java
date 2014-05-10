package proto;

import java.awt.Graphics;

/*
 * A kulonbozo tipusu ellensegek elleni sebzest modosito varazskovek reprezentalasara hasznalt 
 * osztaly.
 */
public class AntiHobbit extends GemStone {

	private DrawAntiHobbit antiHobbitDrawer = new DrawAntiHobbit();

//	A metodus mind a 4 tipusra azonos: elkeri a parameterben kapott torony megfelelo 
//	tipusu sebzeserteket a torony getDamageXxxx metodusaval, modositja az erteket,
//	majd a setDamageXxxx metodussal beallitja a kiszamolt erteket.
//
	@Override
	public void setEffect(Tower toSet) {
		toSet.setDamegeHobbit(2*(toSet.getDamageHobbit()));
		
	}	
	
	//Ezt a kovet nem lehet akadalyra rakni, ezert ha ez a helyzet hiba uzenetet kuldok.
	@Override
	public void setEffect(Trap toSet) {
		System.out.println("Ezt a kovet csak toronyra lehet tenni");;
		
	}
	@Override
	public void draw(Graphics g) {
		antiHobbitDrawer.draw(this, g);
	}
}
