package proto;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Az jatek idozitesehez hasznalt osztaly
 */
public class GameTimer {
	private GameController gamecontroller;
	private Timer timer;
	private GuiManager guiManager;

	public void setGUIManager(GuiManager gm) {
		this.guiManager = gm;
	}

	public GuiManager getGUIManager() {
		return this.guiManager;
	}

	public GameTimer(GameController gc) {
		this.gamecontroller = gc;
		timer = new Timer(true);
	}

	private void tickEvent() {
		if (!gamecontroller.getWin() && !gamecontroller.getGameOver()) {
			this.gamecontroller.nextStep();
			this.guiManager.refreshLists();
			this.guiManager.getMapPanel().repaint();
			this.guiManager.itsOver();
		}
	}

	public void setFastForward() {
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				tickEvent();
			}
		}, 0, Constants.TIMER_INTERVAL / 2);
	}

	public void setNormalSpeed() {
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				tickEvent();
			}
		}, 0, Constants.TIMER_INTERVAL);
	}

	public void wait5sec() {
		// ide kell valami hogy varjon 5 mp-t
	}

	/**
	 * Ez csak egy pszeudo-pause funkcio, mert nem leallitja a szamlalot, hanem
	 * a varakozasi idot 9223372036854775807 ms-ra allitja. A program
	 * varakozasban toltott ideje valoszinuleg nem haladja meg a 292 471 000
	 * evet, igy ez kielegitonek tunik.
	 */
	public void pause() {
		timer.cancel();
		timer.purge();
	}
}
