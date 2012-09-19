/**
 * 
 */
package forscene.system.events;

import forscene.core.entities.AbstractScene;
import forscene.system.Asserts;

/**
 * @author blackdevil
 * 
 */
public abstract class SceneEvent extends AbstractEvent {
  private AbstractScene scene;

  /**
   * 
   */
  private SceneEvent() {
    super();
  }

  /**
   * 
   */
  public SceneEvent(AbstractScene scene) {
    Asserts.check(scene != null, "Scene can't be null");
    setScene(scene);
  }

  /**
   * @return the scene
   */
  public AbstractScene getScene() {
    return scene;
  }

  /**
   * @param scene
   *          the scene to set
   */
  public void setScene(AbstractScene scene) {
    Asserts.check(scene != null, "Scene can't be null");
    this.scene = scene;
  }

}
