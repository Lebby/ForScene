/*
 * 
 */
package forscene.system.events;

import forscene.core.entities.AbstractScene;
import forscene.system.entities.ForSceneConfigurator;
import forscene.system.managers.GameLoopManager;
import forscene.system.managers.EventManager;

// TODO: Auto-generated Javadoc
/**
 * The Class EventLoadScene.
 */
public class LoadSceneEvent extends AbstractEvent {

  /** The scene. */
  private AbstractScene scene;

  /**
   * Instantiates a new event load scene.
   * 
   * @param scene
   *          the scene
   */
  public LoadSceneEvent(AbstractScene scene) {
    this.scene = scene;
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.events.AbstractEvent#run()
   */

  @Override
  public void run() {
    GameLoopManager.getInstance().loadScene(scene);
    if (scene.getKeyboardListener() != null) {
      scene.getKeyboardListener().register();
    }
    if (scene.getMouseListener() != null) {
      scene.getMouseListener().register();
    }
    if (scene.getPointerListener() != null) {
      scene.getPointerListener().register();
    }
    EventManager.getInstance().push(new DrawSceneEvent(scene),
        ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_SYSTEM_PRIORITY);
    EventManager.getInstance().push(new UpdateSceneEvent(scene),
        ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_SYSTEM_PRIORITY);

    setDone(true);
  }

  /**
   * Gets the scene.
   * 
   * @return the scene
   */
  public AbstractScene getScene() {
    return scene;
  }

}
