package proto;

/*
 * Az akadalyra helyezheto varazskovet reprezentalo osztaly.
 */
public class PlusTime extends GemStone {
	
	/*
	 * Konstruktor
	 */
	public PlusTime() {
	}
	
	//Ezt a kovet nem lehet toronyra rakni, ezert ha ez a helyzet hiba uzenetet kuldok.

	@Override
	public void setEffect(Tower toSet) {
		System.out.println("Ezt a kovet csak akadalyra lehet tenni");
		
		
	}	
	
	/*A parameterben kapott csapda lejarati idejet elkeri a csapda getEndTime metodusaval,
	 *  modositja a kapott erteket, majd a modositott ertekkel meghivja a setEndTime metodust.
	 */
	
	@Override
	public void setEffect(Trap toSet) {
		toSet.setEndTime(2*(toSet.getEndTime()));
		
	}
}