import java.io.*;

/*
 * A megfelel� form�tumban t�rt�n� ki�r�s�rt felel�s oszt�ly.
 * Ezen oszt�ly f�ggv�nyeinek h�v�s�n kereszt�l lehet v�laszlehet�s�geket,
 * k�rd�seket, szekvenciadiagramokat ki�rni, illetve a v�laszokat beolvasni.
 */
public class ConsoleUI {
	private int indent = 0;		// A beh�z�sok m�lys�g�t tartalamz� v�ltoz�
	
	/*
	 * Egy sima console-ra ki�r� f�ggv�ny, hogy egys�gesen ezen az oszt�lyon 
	 * kereszt�l lehessen kezelni a kimeneteket.
	 */
	public void writeSimple(String msg) {
		System.out.println(msg);
	}
	
	/*
	 * A szekvenciadiagramok "kirajzol�s��rt" felel�s f�ggv�ny, a bekezd�sek
	 * megfelel� kezel�s�r�l gondoskodik.
	 */
	public void writeSeq(String msg) {
		// A bekezd�sek m�lys�ge kiss� sut�n, de az �zenet els� karaktere 
		// alapj�n v�ltozik. Az egys�gess�g miatt b�torkodtam megtenni ezt a 
		// l�p�st �s nem sz�tvenni k�t k�l�n f�ggv�nybe (writeSeqCall, 
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
	 * Ezen a f�ggv�nyen kereszt�l lehet k�rd�seket feltenni a felhaszn�l�nak,
	 * be�p�tett ellen�rz�st tartalmaz, hogy a felhaszn�l� csak sz�mot adhasson
	 * meg.
	 */
	public int writeQuestion(String msg) {
		int answer = -1;				// a v�gleges v�lasz
		String sAnswer = "-1";			// a "raw data" v�lasz
		boolean answerIsGood = false;
		Console cons;
		
		System.out.println(msg);
		while (!answerIsGood) {			// a bemenetk�r� �s helyess�gellen�rz� 
										// ciklus
			System.out.print("V�lasz: ");
			BufferedReader br = new BufferedReader( new InputStreamReader(
								System.in));
			try {
				sAnswer = br.readLine();
			} catch (IOException e) {
				e.printStackTrace(); 
			}
			
			int i = 0;
										// a v�lasz csak sz�m(ok)b�l �llhat
			while (i < sAnswer.length() && sAnswer.charAt(i) >= '0'
										&& sAnswer.charAt(i) <= '9')
				++i;
			if ( i >= sAnswer.length())
				answerIsGood = true;
			else
				System.out.println("�rv�nytelen v�lasz.");
		}
		answer = Integer.parseInt(sAnswer);		// a nyers adat �tv�lt�sa
		return answer;
	}
}
