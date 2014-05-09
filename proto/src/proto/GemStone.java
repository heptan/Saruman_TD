package proto;

/*
 * Absztrakt osztaly. A kulonbozo- varazsko tipusoknak emeli ki a kozos tulajdonsagat,
 * illetve az oket hasznalo osztalyoknak ad egy egyseges kezelesi lehetoseget.
 */
public abstract class GemStone {
	
	protected Position position;
	
	public Position getPosition() {
		return position;
	}
	
	/*
	 * A position attributum setter metodusa
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	
	/*
	 * Absztrakt fuggvenyek, melyek az egyseges iranyitast segitik, a megvalositas
	 * az egyes leszarmazottakban.
	 */
	public abstract void setEffect(Tower toSet);
	public abstract void setEffect(Trap toSet);
	
}
