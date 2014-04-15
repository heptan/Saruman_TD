package proto;

/*
 * A torony t�zel�si gyakoris�g�t n�vel� var�zsk�vet megval�s�t�
 * oszt�ly.
 */
public class PlusFrequency extends GemStone {
	/*
	 * A torony t�zel�si gyakoris�g�t n�veli.
	*/
	@Override
	public void setEffect(Tower toSet) {
		toSet.setFrequency(2*toSet.getFrequency());
		
	}
	
	@Override
	public void setEffect(Trap toSet) {
		System.out.println("Ezt a kovet csak toronyra lehet tenni");;
		
	}
}
