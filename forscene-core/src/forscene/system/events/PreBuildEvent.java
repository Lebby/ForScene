/**
 * 
 */
package forscene.system.events;

import forscene.core.entities.AbstractScene;
import forscene.system.managers.EventManager;

/**
 * @author blackdevil
 * 
 */
public class PreBuildEvent extends SceneEvent {

  /**
   * @param scene
   */
  public PreBuildEvent(AbstractScene scene) {
    super(scene);
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.system.events.AbstractEvent#run()
   */
  @Override
  public void run() {
    getScene().preBuild();
    EventManager.getInstance().push(new LoadResourcesEvent(getScene()));
    setDone(true);
  }
}
