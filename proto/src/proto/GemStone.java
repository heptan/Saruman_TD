package proto;

/*
 * Absztrakt osztaly. A kulonbozo- varazsko tipusoknak emeli ki a kozos tulajdonsagat,
 * illetve az oket hasznalo osztalyoknak ad egy egyseges kezelesi lehetoseget.
 */
public abstract class GemStone {

	
	/*
	 * Absztrakt fuggvenyek, melyek az egyseges iranyitast segitik, a megvalositas
	 * az egyes leszarmazottakban.
	 */
	public abstract void setEffect(Tower toSet);
	public abstract void setEffect(Trap toSet);
	
}
