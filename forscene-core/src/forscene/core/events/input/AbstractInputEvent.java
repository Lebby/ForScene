/*
 * 
 */
package forscene.core.events.input;

import playn.core.Events.Input;
import forscene.core.events.system.AbstractEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractInputEvent.
 * 
 * @param <T>
 *          the generic type
 */
public abstract class AbstractInputEvent<T extends Input> extends AbstractEvent {

  /** The event. */
  private T event;

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.events.system.AbstractEvent#run()
   */
  @Override
  public void run() {
    run(event);
    setDone(true);
  };

  /**
   * Run.
   * 
   * @param event
   *          the event
   */
  public abstract void run(T event);

  /**
   * Sets the event.
   * 
   * @param event
   *          the new event
   */
  public void setEvent(T event) {
    this.event = event;
  }
}
