/*
 * 
 */
package forscene.system.events;

import forscene.core.events.system.AbstractEvent;
import forscene.system.managers.AbstractGameLoopManager;


// TODO: Auto-generated Javadoc
/**
 * The Class EventTimerTick.
 */
public class TimerTickEvent extends AbstractEvent{
	//private static int tick = 0;
	/**
	 * Instantiates a new event timer tick.
	 */
	public TimerTickEvent() {
	}	
	
	/* (non-Javadoc)
	 * @see forscene.core.events.AbstractEvent#run()
	 */
	@Override
	public void run() {
		AbstractGameLoopManager.getInstance().incTicks();
	}


	/*public static int getTick() {
		return tick;
	}

	public static void setTick(int tick) {
		EventTimerTick.tick = tick;
	}*/

}