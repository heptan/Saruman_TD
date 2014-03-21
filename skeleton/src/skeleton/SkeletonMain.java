package skeleton;

/*
 * A szkeleton keretét adó osztály, õ felelõs a megfelelõ teszteset 
 * meghívásáért a felhasználó inputja alapján.
 */
public class SkeletonMain {
	static private ConsoleUI cons = new ConsoleUI();
	
	static public void main(String[] args) {
		int select = 0;
		do {
			// Válaszlehetõségek felsorolása, majd a válasz bekérése
			cons.writeSimple("Kerem valasszon egy tesztesetet:");
			cons.writeSimple("   1. Ellenseg altalanos palyaelemre lep.");
			cons.writeSimple("   2. Ellenseg torony hatosugaraba lep.");
			cons.writeSimple("   3. Ellenseg akadalyra lep.");
			cons.writeSimple("   4. Torony lerakasa.");
			cons.writeSimple("   5. Torony torlese.");
			cons.writeSimple("   6. Varazsko elhelyezese.");
			cons.writeSimple("   7. Akadaly elhelyezese.");
			cons.writeSimple("   8. Jatek vege, vesztettunk.");
			cons.writeSimple("   9. Jatek vege, nyertunk.");
			cons.writeSimple("   0. Kilepes a programbol.");
			
			select = cons.writeQuestion("");
			switch (select) {
				case 0: break;
				case 1: enemyOnRoad(); break;
				case 2: enemyInTowerRange(); break;
				case 3: enemyOnTrap(); break;
				case 4: towerDeployment(); break;
				case 5: towerRemovement(); break;
				case 6: gemDeployment(); break;
				case 7: trapDeployment(); break;
				case 8: gameOverLose(); break;
				case 9: gameOverWin(); break;
				default:cons.writeSimple("Undefined selection, "
						+ "the program will terminate... You."); 
						select = 0;
						break;
			}
		} while (select != 0);
		
	}
	
	/*
	 * Ellenség általános pályaelemre lép.
	 */
	static void enemyOnRoad() {
		cons.writeSimple("enemyOnRoad teszt eset:");
	}
	
	static void enemyInTowerRange() {
		cons.writeSimple("enemyInTowerRange teszt eset");
	}

	static void enemyOnTrap() {
		cons.writeSimple("enemyOnTrap teszt eset");
	}
	
	static void towerDeployment() {
		cons.writeSimple("towerDeployment teszt eset");
	}
	
	static void towerRemovement() {
		cons.writeSimple("towerRemovement teszt eset");
	}
	
	static void gemDeployment() {
		cons.writeSimple("gemDeployment teszt eset");
	}
	static void trapDeployment() {
		cons.writeSimple("trapDeployment teszt eset");
	}
	
	static void gameOverLose() {
		cons.writeSimple("gameOverLose teszt eset");
	}
	
	static void gameOverWin() {
		cons.writeSimple("gameOverWin teszt eset");
	}
	
}
