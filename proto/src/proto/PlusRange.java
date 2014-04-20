package proto;

/*
 * A torony lovesi hatosugarat modosito varazskovet reprezentalo osztaly.
 */
public class PlusRange extends GemStone {
	/*
	 *A metodus elkeri a parameterben kapott torony megfelelo erteket (range)
	 * a torony megfelelo get metodusaval, 
	 * modositja az erteket, majd a set metodussal beallitja a kiszamolt erteket.
	 */
	
	@Override
	public void setEffect(Tower toSet) {
		toSet.setRange(2*(toSet.getRange()));
		
	}	
	
	//Ezt a kovet nem lehet akadalyra rakni, ezert ha ez a helyzet hiba uzenetet kuldok.
	
	@Override
	public void setEffect(Trap toSet) {
		System.out.println("Ezt a kovet csak toronyra lehet tenni");;
		
	}
}