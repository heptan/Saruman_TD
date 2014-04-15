package proto;

/*
 * Az elf ellenség ellen használható varázskövet megvalósító osztály.
 */
public class AntiElf extends GemStone {
	
	/*
	 * TODO Ez mire is kell pontosan? Milyen attrib�tumot �ll�t be?
	 */
	@Override
	public void setEffect(Tower toSet) {
		toSet.setDamegeElf(2*(toSet.getDamageElf()));
	}	
}
