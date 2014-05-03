package proto;

/*
 * A torony lovesi frekvenciajat modosito varazskovet reprezentalo osztaly.
 */
public class PlusFrequency extends GemStone {
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
}