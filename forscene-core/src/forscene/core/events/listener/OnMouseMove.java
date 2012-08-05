/*
 * 
 */
package forscene.core.events.listener;

import forscene.system.events.IEvent;
import forscene.system.managers.EventManager;

// TODO: Auto-generated Javadoc
/**
 * The Class OnMouseMove.
 */

public abstract class OnMouseMove extends AbstractEventListener {

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.events.listener.AbstractEventListener#check()
   */
  @Override
  public boolean check() {
    IEvent currEvent = EventManager.getInstance().getCurrentEvent();

    return false;
  }

}
