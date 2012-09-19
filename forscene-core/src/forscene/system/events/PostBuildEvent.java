/**
 * 
 */
package forscene.system.events;

import forscene.core.entities.AbstractScene;

/**
 * @author blackdevil
 * 
 */
public class PostBuildEvent extends SceneEvent {

  /**
   * @param scene
   */
  public PostBuildEvent(AbstractScene scene) {
    super(scene);
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.system.events.AbstractEvent#run()
   */
  @Override
  public void run() {
    if (getScene().isBuilded()) {
      getScene().postBuild();
      setDone(true);
    }
  }

}
