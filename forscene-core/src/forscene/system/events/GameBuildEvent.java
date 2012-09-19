/**
 * 
 */
package forscene.system.events;

import forscene.system.entities.ForSceneConfigurator;
import forscene.system.managers.GameLoopManager;
import forscene.system.managers.EventManager;

/**
 * @author blackdevil
 * 
 */
public class GameBuildEvent extends AbstractEvent {

  /*
   * (non-Javadoc)
   * 
   * @see forscene.system.events.AbstractEvent#run()
   */
  @Override
  public void run() {
    GameLoopManager.getInstance().build();
    EventManager.getInstance().push(new GamePostBuildEvent(),
        ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_SYSTEM_PRIORITY);
    setDone(true);
  }
}
