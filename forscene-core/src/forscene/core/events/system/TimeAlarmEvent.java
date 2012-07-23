/*
 * 
 */
package forscene.core.events.system;

import forscene.system.managers.AbstractGameLoopManager;

// TODO: Auto-generated Javadoc
/**
 * The Class EventTimeAlarm.
 */
public abstract class TimeAlarmEvent extends AbstractEvent {

  /** The time. */
  private float        time;

  /** The first time. */
  private boolean      firstTime = true;

  /** The timer. */
  private static float timer;

  /**
   * Instantiates a new event time alarm.
   * 
   * @param time
   *          the time
   */
  public TimeAlarmEvent(float time) {

    TimeAlarmEvent.timer = AbstractGameLoopManager.getInstance().getTicks();
    this.time = TimeAlarmEvent.timer + time;
  }

  /**
   * Start.
   */
  public void start() {
    if (firstTime) {
      firstTime = false;
      TimeAlarmEvent.timer = AbstractGameLoopManager.getInstance().getTicks();
      time = TimeAlarmEvent.timer + time;
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.events.system.AbstractEvent#run()
   */
  @Override
  public void run() {
    if (AbstractGameLoopManager.getInstance().getTicks() >= time) {
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
