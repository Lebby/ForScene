/*
 * 
 */
package forscene.core.events.system;

import forscene.core.entities.AbstractScene;
import forscene.system.Asserts;
import forscene.system.entities.ForSceneConfigurator;

// TODO: Auto-generated Javadoc
/**
 * The Class EventDrawScene.
 */
public class DrawSceneEvent extends AbstractEvent {

  /** The scene. */
  protected AbstractScene scene;

  /**
   * Instantiates a new event draw scene.
   * 
   * @param scene
   *          the scene
   */
  public DrawSceneEvent(AbstractScene scene) {
    Asserts.check(scene != null, "scene can't be null");
    this.scene = scene;
    setPriority(ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_SYSTEM_PRIORITY);
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.events.AbstractEvent#run()
   */
  @Override
  public void run() {
    // AbstractGameLoopManager.getInstance().draw(scene);
    setDone(true);
  }

}
