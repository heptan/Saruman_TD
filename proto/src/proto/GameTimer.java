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

	/**
	 * Konstruktor
	 */
	public GameTimer(GameController gc) {
		this.gamecontroller = gc;
		timer = new Timer(true);
	}

	/**
	 * GuiManager referenciajanak beallitasa
	 */
	public void setGUIManager(GuiManager gm) {
		this.guiManager = gm;
	}

	/**
	 * GuiManager referenciajanak lekerdezese
	 */
	public GuiManager getGUIManager() {
		return this.guiManager;
	}

	/**
	 * Meghatarozott idokozonkent mukodo funkciok
	 */
	private void tickEvent() {
		if (!gamecontroller.getWin() && !gamecontroller.getGameOver()) {
			this.gamecontroller.nextStep();
			this.guiManager.refreshLists();
			this.guiManager.getMapPanel().repaint();
			this.guiManager.itsOver();
		}
	}

	/**
	 * Normal jateksebesseg beallitasa
	 */
	public void setNormalSpeed() {
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				tickEvent();
			}
		}, 0, Constants.TIMER_INTERVAL);
	}

	/**
	 * Gyorsitott jateksebesseg beallitasa
	 */
	public void setFastForward() {
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				tickEvent();
			}
		}, 0, Constants.TIMER_INTERVAL / 2);
	}

	/**
	 * Jatek megallitasa
	 */
	public void pause() {
		timer.cancel();
		timer.purge();
	}

	/**
	 * ide kell valami hogy varjon 5 mp-et
	 */
	public void wait5sec() {
	}

}
