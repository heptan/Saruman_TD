package proto;

/*
 * A t�rp ellens�g ellen haszn�lhat� var�zsk�vet megval�s�t� oszt�ly.
 */
public class AntiDwarf extends GemStone {
	
	@Override
	public void setEffect(Tower toSet) {
		toSet.setDamegeDwarf(2*(toSet.getDamageDwarf()));
		
	}	
	
	@Override
	public void setEffect(Trap toSet) {
		System.out.println("Ezt a kovet csak toronyra lehet tenni");;
		
	}
}
