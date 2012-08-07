/**
 * 
 */
package forscene.core.events.input;

import playn.core.Mouse.ButtonEvent;

/**
 * The Class AbstractMouseButtonEvent.
 * 
 * @author Scuderi Giovanni Luca {Lebby} mail:glscud@gmail.com
 */
public abstract class AbstractMouseButtonEvent extends
    AbstractMouseEvent<ButtonEvent> {
  /**
 * 
 */
  public AbstractMouseButtonEvent() {
    setName("MouseButtonEvent");
  }
}
