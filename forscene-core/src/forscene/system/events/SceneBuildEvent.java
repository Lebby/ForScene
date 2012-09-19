/**
 * 
 */
package forscene.system.events;

import forscene.core.entities.AbstractScene;

/**
 * @author blackdevil
 * 
 */
public class SceneBuildEvent extends SceneEvent {

  /**
   * @param scene
   */
  public SceneBuildEvent(AbstractScene scene) {
    super(scene);
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.system.events.AbstractEvent#run()
   */
  @Override
  public void run() {
    getScene().buildOnce();
    setDone(true);
  }

}
