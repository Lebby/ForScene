/*
 * 
 */
package forscene.system.events;

import forscene.system.managers.GameLoopManager;

// TODO: Auto-generated Javadoc
/**
 * The Class EventNext.
 */
public class NextEvent extends AbstractEvent {

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.events.AbstractEvent#run()
   */
  @Override
  public void run() {
    GameLoopManager.getInstance().goNext();
    setDone(true);
  }

}
