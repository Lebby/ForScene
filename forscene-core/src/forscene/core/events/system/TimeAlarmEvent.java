package forscene.core.events.system;

import forscene.system.managers.GameLoopManager;
import playn.core.PlayN;


// TODO: Auto-generated Javadoc
/**
 * The Class EventTimeAlarm.
 */
public abstract class TimeAlarmEvent extends AbstractEvent{
	
	/** The time. */
	private float time;
	private boolean firstTime= true;
	
	/** The timer. */
	private static float timer;

	/**
	 * Instantiates a new event time alarm.
	 *
	 * @param time the time
	 */
	public TimeAlarmEvent(float time)
	{
		
		timer = GameLoopManager.getInstance().getTicks();
		this.time= timer+time;
	}
	
	public void start()
	{
		if(firstTime) 
		{
			firstTime = false;
			timer = GameLoopManager.getInstance().getTicks();
			this.time= timer+time;
		}
	}
	
	@Override
	public void run() {		
		if(GameLoopManager.getInstance().getTicks()>=time)
		{			
			alarm();
			this.setDone(true);
		}else this.setDone(false);
		//PlayN.log().debug(GameLoopManager.getInstance().getTicks() + " -> " +time);
	}
	
	public abstract void alarm();
	
}
