package proto;

/*
 * Az hobbit ellens�g ellen haszn�lhat� var�zsk�vet megval�s�t� oszt�ly.
 */
public class AntiHobbit extends GemStone {


	@Override
	public void setEffect(Tower toSet) {
		toSet.setDamegeHobbit(2*(toSet.getDamageHobbit()));
		
	}	
	
	@Override
	public void setEffect(Trap toSet) {
		System.out.println("Ezt a kovet csak toronyra lehet tenni");;
		
	}
}
