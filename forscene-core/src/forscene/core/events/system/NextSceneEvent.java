/*
 * 
 */
package forscene.core.events.system;

import forscene.system.managers.AbstractGameLoopManager;
import forscene.system.managers.EventManager;

// TODO: Auto-generated Javadoc
/**
 * The Class EventNextScene.
 */
public class NextSceneEvent extends AbstractEvent {

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.events.AbstractEvent#run()
   */
  @Override
  public void run() {
    EventManager.getInstance()
        .push(
            new LoadSceneEvent(AbstractGameLoopManager.getInstance()
                .getNextScene()));
    setDone(true);
  }
}
