package proto;

/*
 * A torony hat�t�vols�g�nak n�vel�s�hez haszn�lt var�zsk�vet
 * megval�s�t� oszt�ly.
 */
public class PlusRange extends GemStone {
	/*
	 * A torony hat�t�vols�g�t n�veli.
	 */

	@Override
	public void setEffect(Tower toSet) {
		toSet.setRange(2*(toSet.getRange()));
		
	}	
	
	@Override
	public void setEffect(Trap toSet) {
		System.out.println("Ezt a kovet csak toronyra lehet tenni");;
		
	}
}
