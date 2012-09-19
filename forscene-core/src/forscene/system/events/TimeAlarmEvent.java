/*
 * 
 */
package forscene.system.events;

import forscene.system.managers.GameLoopManager;

// TODO: Auto-generated Javadoc
/**
 * The Class EventTimeAlarm.
 */
public abstract class TimeAlarmEvent extends AbstractEvent {

  /** The time. */
  private long    delay;

  /** The first time. */
  private boolean firstTime = true;

  /** The timer. */
  private long    startTime;

  /**
   * Instantiates a new event time alarm.
   * 
   * @param delay
   *          the time in msec
   */
  public TimeAlarmEvent(int delay) {
    this.delay = delay;
  }

  /**
   * Start.
   */
  public void start() {
    if (firstTime) {
      firstTime = false;
      startTime = GameLoopManager.getInstance().getTicks();
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.events.system.AbstractEvent#run()
   */
  @Override
  public void run() {
    if (GameLoopManager.getInstance().getTicks() >= (startTime + delay)) {
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
