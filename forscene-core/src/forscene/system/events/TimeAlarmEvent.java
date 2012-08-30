/*
 * 
 */
package forscene.system.events;

import playn.core.PlayN;
import forscene.system.managers.AbstractGameLoopManager;

// TODO: Auto-generated Javadoc
/**
 * The Class EventTimeAlarm.
 */
public abstract class TimeAlarmEvent extends AbstractEvent {

  /** The time. */
  private float   delay;

  /** The first time. */
  private boolean firstTime = true;

  /** The timer. */
  private float   startTime;

  /**
   * Instantiates a new event time alarm.
   * 
   * @param delay
   *          the time
   */
  public TimeAlarmEvent(float delay) {
    this.delay = delay;
    PlayN.log().debug(
        "Time: " + AbstractGameLoopManager.getInstance().getTicks()
            + " Alarm at : " + delay);
  }

  /**
   * Start.
   */
  public void start() {
    if (firstTime) {
      firstTime = false;
      startTime = AbstractGameLoopManager.getInstance().getTicks();
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.events.system.AbstractEvent#run()
   */
  @Override
  public void run() {
    if (AbstractGameLoopManager.getInstance().getTicks() >= (startTime + delay)) {
      alarm();
      setDone(true);
    } else {
      setDone(false);
    }

  }

  /**
   * Alarm.
   */
  public abstract void alarm();

}
