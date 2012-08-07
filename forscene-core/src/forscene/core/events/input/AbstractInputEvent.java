/*
 * 
 */
package forscene.core.events.input;

import playn.core.Events.Input;
import forscene.system.Asserts;
import forscene.system.events.AbstractEvent;

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

  /**
   * 
   */
  public AbstractInputEvent() {
    setName("InputEvent");
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.events.system.AbstractEvent#run()
   */
  @Override
  public void run() {
    Asserts.check(event != null, "Event can't be null");
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
    Asserts.check(event != null, "Event can't be null");
    this.event = event;
  }
}
