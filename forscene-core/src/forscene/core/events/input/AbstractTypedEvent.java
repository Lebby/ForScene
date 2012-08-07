/**
 * 
 */
package forscene.core.events.input;

import playn.core.Keyboard.TypedEvent;

/**
 * The Class AbstractTypedEvent.
 * 
 * @author Scuderi Giovanni Luca {Lebby} mail:glscud@gmail.com
 */
public abstract class AbstractTypedEvent extends
    AbstractKeyboardEvent<TypedEvent> {

  /**
   * 
   */
  public AbstractTypedEvent() {
    setName("KeyTypedEvent");
  }
}
