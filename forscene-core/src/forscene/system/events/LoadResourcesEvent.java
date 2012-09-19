/**
 * 
 */
package forscene.system.events;

import forscene.core.entities.AbstractScene;
import forscene.system.managers.EventManager;
import forscene.system.managers.ResourceManager;

/**
 * @author blackdevil
 * 
 */
public class LoadResourcesEvent extends SceneEvent {
  /**
   * @param scene
   */
  public LoadResourcesEvent(AbstractScene scene) {
    super(scene);
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.system.events.AbstractEvent#run()
   */
  @Override
  public void run() {
    if (!ResourceManager.getInstance().isReady()) {
      ResourceManager.getInstance().loadResources();
    } else {
      EventManager.getInstance().push(new SceneBuildEvent(getScene()));
      setDone(true);
    }
  }

}
