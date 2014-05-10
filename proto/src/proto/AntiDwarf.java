package proto;

import java.awt.Graphics;

/*
 * A kulonbozo tipusu ellensegek elleni sebzest modosito varazskovek reprezentalasara hasznalt 
 * osztaly.
 */
public class AntiDwarf extends GemStone {
<<<<<<< HEAD
	 private DrawAntiDwarf dad=new DrawAntiDwarf();
	 
=======
	
	private DrawAntiDwarf antiDwarfDrawer = new DrawAntiDwarf();
	
>>>>>>> d88a478f4a0ce56798429370e9d4f8ad61a82aa7
//	A metodus mind a 4 tipusra azonos: elkeri a parameterben kapott torony megfelelo 
//	tipusu sebzeserteket a torony getDamageXxxx metodusaval, modositja az erteket,
//	majd a setDamageXxxx metodussal beallitja a kiszamolt erteket.
//	
	
	@Override
	public void setEffect(Tower toSet) {
		toSet.setDamegeDwarf(2*(toSet.getDamageDwarf()));
		
	}	
	
	//Ezt a kovet nem lehet akadalyra rakni, ezert ha ez a helyzet hiba uzenetet kuldok.
	@Override
	public void setEffect(Trap toSet) {
		System.out.println("Ezt a kovet csak toronyra lehet tenni");;
		
	}
<<<<<<< HEAD
	
	//public DrawAntiDwarf getDrawer(){
	 //return this.dad;	
		
		
	//}
=======

	@Override
	public void draw(Graphics g) {
		antiDwarfDrawer.draw(this, g);
	}
>>>>>>> d88a478f4a0ce56798429370e9d4f8ad61a82aa7
}
