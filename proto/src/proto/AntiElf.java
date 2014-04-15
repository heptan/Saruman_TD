package proto;

/*
 * Az elf ellenség ellen használható varázskövet megvalósító osztály.
 */
public class AntiElf extends GemStone {
	

	@Override
	public void setEffect(Tower toSet) {
		toSet.setDamegeElf(2*(toSet.getDamageElf()));
		
	}	
	
	@Override
	public void setEffect(Trap toSet) {
		System.out.println("Ezt a kovet csak toronyra lehet tenni");;
		
	}	
}
