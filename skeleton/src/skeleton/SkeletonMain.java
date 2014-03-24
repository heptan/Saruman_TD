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
			cons.writeSimple("   1. Ellenseg altalanos palyaelemre lep");
			cons.writeSimple("   2. Ellenseg torony hatosugaraba lep");
			cons.writeSimple("   3. Ellenseg akadalyra lep");
			cons.writeSimple("   4. Torony lerakasa");
			cons.writeSimple("   5. Torony torlese");
			cons.writeSimple("   6. Varazsko elhelyezese");
			cons.writeSimple("   7. Akadaly elhelyezese");
			cons.writeSimple("   8. Jatek vege, a jatekos veszit");
			cons.writeSimple("   0. Kilepes a programbol");
			
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
		cons.writeSimple("1. Ellenseg altalanos palyaelemre lep:");
		Enemy e = new Enemy();
		Road actr = new Road();
		Road nextr = new Road();
		actr.setNextRoad(nextr);
		e.setActRoad(actr);
		e.nextStep(1);
	}
	
	static void enemyInTowerRange() {
		cons.writeSimple("2. Ellenseg torony hatosugaraba lep:");
		Enemy e = new Enemy();
		e.EllensegToronyHatosugaraban();
	}

	static void enemyOnTrap() {
		cons.writeSimple("3. Ellenseg akadalyra lep");
		Enemy e = new Enemy();
		e.nextStep(3);
	}
	
	static void towerDeployment() {
		cons.writeSimple("4. Torony lerakasa");
		Map m = new Map();
		m.addTower(new Position(0,0));
	}
	
	static void towerRemovement() {
		cons.writeSimple("5. Torony torlese");
		Map m = new Map();
		m.removeTower(new Position(0,0));
	}
	
	static void gemDeployment() {
		cons.writeSimple("6. Varazsko elhelyezese");
		Road r = new Road();
		r.gemDeployment();
	}
	
	static void trapDeployment() {
		cons.writeSimple("7. Akadaly elhelyezese");
		Map m = new Map();
		m.addTrap(new Position(0, 0));
	}
	
	static void gameOverLose() {
		cons.writeSimple("8. Jatek vege, a jatekos veszit");
		Enemy e = new Enemy();
		e.gameOverLose();
	}
	
}
