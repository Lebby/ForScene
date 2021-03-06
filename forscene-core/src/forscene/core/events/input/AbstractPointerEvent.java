/**
 * 
 */
package forscene.core.events.input;

import playn.core.Pointer;

/**
 * The Class AbstractPointerEvent.
 * 
 * @author Scuderi Giovanni Luca {Lebby} mail:glscud@gmail.com
 */
public abstract class AbstractPointerEvent extends
    AbstractInputEvent<Pointer.Event> {

  /**
   * 
   */
  public AbstractPointerEvent() {
    setName("PointerEvent");
  }

}
