package proto;

/*
 * Az akad�ly fenn�ll�si idej�nek meghosszabb�t�s�hoz haszn�lt
 * var�zsk�vet megval�s�t� oszt�ly.
 */
public class PlusTime extends GemStone {
	
	/*
	 * Konstruktor
	 */
	public PlusTime() {
		ConsoleUI.writeSeq("-->new plusTime(): plusTime");
		ConsoleUI.writeSeq("<--plusTime");
	}
	
	/*
	 * Az akad�ly fenn�ll�s�nak idej�t n�veli.
	 */

	@Override
	public void setEffect(Tower toSet) {
		System.out.println("Ezt a kovet csak akadalyra lehet tenni");
		
		
	}	
	
	@Override
	public void setEffect(Trap toSet) {
		toSet.setEndTime(2*(toSet.getEndTime()));
		
	}
}
