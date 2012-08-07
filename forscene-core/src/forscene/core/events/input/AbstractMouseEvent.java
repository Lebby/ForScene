/*
 * 
 */
package forscene.core.events.input;

import playn.core.Events.Input;

/**
 * The Class AbstractMouseEvent.
 * 
 * @param <T>
 *          the generic type
 */
public abstract class AbstractMouseEvent<T extends Input> extends
    AbstractInputEvent<T> {
  /**
 * 
 */
  public AbstractMouseEvent() {
    setName("MouseEvent");
  }
}
