package forscene.core.events;

import forscene.core.LoopController.GameLoopManager;


public class EventTimerTick extends AbstractEvent{
	//private static int tick = 0;
	public EventTimerTick() {
		//tick++;
	}	
	
	@Override
	public void run() {
		//tick++;
		GameLoopManager.getInstance().incTicks();
	}


	/*public static int getTick() {
		return tick;
	}

	public static void setTick(int tick) {
		EventTimerTick.tick = tick;
	}*/

}