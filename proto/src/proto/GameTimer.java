package proto;

import java.util.Timer;
import java.util.TimerTask;
import java.lang.Long;

public class GameTimer {
	private GameController gamecontroller;
	private Timer timer;
	
	public GameTimer(GameController gc) {
		this.gamecontroller = gc;
		timer = new Timer(true);
	}
	
	private void tickEvent() {
		this.gamecontroller.nextStep();
	}
	
	public void setFastForward() {
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				tickEvent();
			}
		}, Constants.TIMER_INTERVAL/2);
	}
	
	public void setNormalSpeed() {
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				tickEvent();
			}
		}, Constants.TIMER_INTERVAL);
	}
	
	/*
	 * Ez csak egy pszeudo-pause funkcio, mert nem leallitja a szamlalot,
	 *   hanem a varakozasi idot 9223372036854775807 ms-ra allitja. A 
	 *   program varakozasban toltott ideje valoszinuleg nem haladja meg a
	 *   292 471 000 evet, igy ez kielegitonek tunik.
	 */
	public void pause() {
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				tickEvent();
			}
		}, 50000000);
	}
}
