/*
 * 
 */
package forscene.system.events;

import forscene.system.entities.ForSceneConfigurator;
import forscene.system.managers.GameLoopManager;
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
            new LoadSceneEvent(GameLoopManager.getInstance()
                .getNextScene()),
            ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_SYSTEM_PRIORITY);
    setDone(true);
  }
}
