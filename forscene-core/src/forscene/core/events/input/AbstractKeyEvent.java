/**
 * 
 */
package forscene.core.events.input;

import playn.core.Keyboard.Event;

/**
 * The Class AbstractKeyEvent.
 * 
 * @author Scuderi Giovanni Luca {Lebby} mail:glscud@gmail.com
 */
public abstract class AbstractKeyEvent extends AbstractKeyboardEvent<Event> {
  /**
 * 
 */
  public AbstractKeyEvent() {
    setName("KeyEvent");
  }
}
