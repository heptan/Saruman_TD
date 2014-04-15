package proto;

/*
 * Az ember ellens�g ellen haszn�lhat� var�zsk�vet megval�s�t� oszt�ly.
 */
public class AntiHuman extends GemStone {
	

	@Override
	public void setEffect(Tower toSet) {
		toSet.setDamegeHuman(2*(toSet.getDamageHuman()));
		
	}	
	
	@Override
	public void setEffect(Trap toSet) {
		System.out.println("Ezt a kovet csak toronyra lehet tenni");;
		
	}
	
}
