import java.io.*;

/*
 * A megfelelõ formátumban történõ kiírásért felelõs osztály.
 * Ezen osztály függvényeinek hívásán keresztül lehet válaszlehetõségeket,
 * kérdéseket, szekvenciadiagramokat kiírni, illetve a válaszokat beolvasni.
 */
public class ConsoleUI {
	private int indent = 0;		// A behúzások mélységét tartalamzó változó
	
	/*
	 * Egy sima console-ra kiíró függvény, hogy egységesen ezen az osztályon 
	 * keresztül lehessen kezelni a kimeneteket.
	 */
	public void writeSimple(String msg) {
		System.out.println(msg);
	}
	
	/*
	 * A szekvenciadiagramok "kirajzolásáért" felelõs függvény, a bekezdések
	 * megfelelõ kezelésérõl gondoskodik.
	 */
	public void writeSeq(String msg) {
		// A bekezdések mélysége kissé sután, de az üzenet elsõ karaktere 
		// alapján változik. Az egységesség miatt bátorkodtam megtenni ezt a 
		// lépést és nem szétvenni két külön függvénybe (writeSeqCall, 
		// writeSeqRet).
		if (msg.charAt(0) == '-')
			++indent;
		else if (msg.charAt(0) == '<')
			--indent;
		for (int i = 0; i < indent; ++i)
			System.out.println("\t");
		System.out.println(msg);
	}
	
	/*
	 * Ezen a függvényen keresztül lehet kérdéseket feltenni a felhasználónak,
	 * beépített ellenõrzést tartalmaz, hogy a felhasználó csak számot adhasson
	 * meg.
	 */
	public int writeQuestion(String msg) {
		int answer = -1;				// a végleges válasz
		String sAnswer = "-1";			// a "raw data" válasz
		boolean answerIsGood = false;
		Console cons;
		
		System.out.println(msg);
		while (!answerIsGood) {			// a bemenetkérõ és helyességellenörzõ 
										// ciklus
			System.out.print("Válasz: ");
			BufferedReader br = new BufferedReader( new InputStreamReader(
								System.in));
			try {
				sAnswer = br.readLine();
			} catch (IOException e) {
				e.printStackTrace(); 
			}
			
			int i = 0;
										// a válasz csak szám(ok)ból állhat
			while (i < sAnswer.length() && sAnswer.charAt(i) >= '0'
										&& sAnswer.charAt(i) <= '9')
				++i;
			if ( i >= sAnswer.length())
				answerIsGood = true;
			else
				System.out.println("Érvénytelen válasz.");
		}
		answer = Integer.parseInt(sAnswer);		// a nyers adat átváltása
		return answer;
	}
}
