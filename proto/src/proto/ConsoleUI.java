package proto;

import java.io.*;

/*
 * A megfelel� form�tumban t�rt�n� ki�r�s�rt felel�s oszt�ly.
 * Ezen oszt�ly f�ggv�nyeinek h�v�s�n kereszt�l lehet v�laszlehet�s�geket,
 * k�rd�seket, szekvenciadiagramokat ki�rni, illetve a v�laszokat beolvasni.
 */
public class ConsoleUI {
	private static int indent = 0;		// A beh�z�sok m�lys�g�t tartalamz� v�ltoz�
	
	/*
	 * Egy sima console-ra ki�r� f�ggv�ny, hogy egys�gesen ezen az oszt�lyon 
	 * kereszt�l lehessen kezelni a kimeneteket.
	 */
	public static void writeSimple(String msg) {
		System.out.println(msg);
	}
	
	/*
	 * A szekvenciadiagramok "kirajzol�s��rt" felel�s f�ggv�ny, a bekezd�sek
	 * megfelel� kezel�s�r�l gondoskodik.
	 */
	public static void writeSeq(String msg) {
		// Az �zenet els� karaktere alapj�n v�ltozik.
		if (msg.charAt(0) == '-')
			++indent;
		for (int i = 0; i < indent; ++i)
			System.out.print("   ");
		System.out.println(msg);
		if (msg.charAt(0) == '<')
			--indent;
	}
	
	/*
	 * Ezen a f�ggv�nyen kereszt�l lehet k�rd�seket feltenni a felhaszn�l�nak,
	 * be�p�tett ellen�rz�st tartalmaz, hogy a felhaszn�l� csak sz�mot adhasson
	 * meg.
	 */
	public static int writeQuestion(String msg) {
		int answer = -1;				// a v�gleges v�lasz
		String sAnswer = "-1";			// a "raw data" v�lasz
		boolean answerIsGood = false;
		Console cons;
		
		System.out.println(msg);
		while (!answerIsGood) {			// a bemenetk�r� �s helyess�gellen�rz� 
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
				answer = Integer.parseInt(sAnswer);		// a nyers adat �tv�lt�sa
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
