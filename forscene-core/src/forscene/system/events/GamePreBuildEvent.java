/**
 * 
 */
package forscene.system.events;

import forscene.system.entities.ForSceneConfigurator;
import forscene.system.managers.GameLoopManager;
import forscene.system.managers.EventManager;
import forscene.system.managers.ResourceManager;

/**
 * @author blackdevil
 * 
 */
public class GamePreBuildEvent extends AbstractEvent {

  /*
   * (non-Javadoc)
   * 
   * @see forscene.system.events.AbstractEvent#run()
   */
  @Override
  public void run() {

    GameLoopManager.getInstance().preBuild();
    ResourceManager.getInstance().loadResources();
    if (ResourceManager.getInstance().isReady()) {
      setDone(true);
      EventManager.getInstance().push(new GameBuildEvent(),
          ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_SYSTEM_PRIORITY);
    }
  }

}
