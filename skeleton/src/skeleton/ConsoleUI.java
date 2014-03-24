package skeleton;

import java.io.*;

/*
 * A megfelelõ formátumban történõ kiírásért felelõs osztály.
 * Ezen osztály függvényeinek hívásán keresztül lehet válaszlehetõségeket,
 * kérdéseket, szekvenciadiagramokat kiírni, illetve a válaszokat beolvasni.
 */
public class ConsoleUI {
	private static int indent = 0;		// A behúzások mélységét tartalamzó változó
	
	/*
	 * Egy sima console-ra kiíró függvény, hogy egységesen ezen az osztályon 
	 * keresztül lehessen kezelni a kimeneteket.
	 */
	public static void writeSimple(String msg) {
		System.out.println(msg);
	}
	
	/*
	 * A szekvenciadiagramok "kirajzolásáért" felelõs függvény, a bekezdések
	 * megfelelõ kezelésérõl gondoskodik.
	 */
	public static void writeSeq(String msg) {
		// A bekezdések mélysége kissé sután, de az üzenet elsõ karaktere 
		// alapján változik. Az egységesség miatt bátorkodtam megtenni ezt a 
		// lépést és nem szétvenni két külön függvénybe (writeSeqCall, 
		// writeSeqRet).
		if (msg.charAt(0) == '-')
			++indent;
		for (int i = 0; i < indent; ++i)
			System.out.print("   ");
		System.out.println(msg);
		if (msg.charAt(0) == '<')
			--indent;
	}
	
	/*
	 * Ezen a függvényen keresztül lehet kérdéseket feltenni a felhasználónak,
	 * beépített ellenõrzést tartalmaz, hogy a felhasználó csak számot adhasson
	 * meg.
	 */
	public static int writeQuestion(String msg) {
		int answer = -1;				// a végleges válasz
		String sAnswer = "-1";			// a "raw data" válasz
		boolean answerIsGood = false;
		Console cons;
		
		System.out.println(msg);
		while (!answerIsGood) {			// a bemenetkérõ és helyességellenörzõ 
										// ciklus
			System.out.print("Valasz: ");
			BufferedReader br = new BufferedReader( new InputStreamReader(
								System.in));
			try {
				sAnswer = br.readLine();
			} catch (IOException e) {
				e.printStackTrace(); 
			}
			
			try {
				answer = Integer.parseInt(sAnswer);		// a nyers adat átváltása
				if(answer >= 0 && answer <= 8) {
					answerIsGood = true;
				}
				else {
					System.out.println("Ervenytelen valasz.");
				}
			}
			catch(NumberFormatException e) {
				System.out.println("Ervenytelen valasz.");
			}
		}
		return answer;
	}
}
