/*
 * 
 */
package forscene.system.events;

import forscene.core.entities.AbstractScene;
import forscene.system.managers.AbstractGameLoopManager;

// TODO: Auto-generated Javadoc
/**
 * The Class EventUpdateScene.
 */
public class UpdateSceneEvent extends AbstractEvent {

  /** The scene. */
  private AbstractScene scene;

  /** The tick. */
  private static short  tick = 0;

  /**
   * Instantiates a new event update scene.
   * 
   * @param scene
   *          the scene
   */
  public UpdateSceneEvent(AbstractScene scene) {
    this.scene = scene;
    UpdateSceneEvent.tick = 0;
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.events.AbstractEvent#run()
   */
  @Override
  public void run() {
    UpdateSceneEvent.tick++;
    if (scene.isBuilded()) {
      // It isn't attached to scenegraph or is void
      if ((!scene.hasParent()) || (scene.getRoot() == null)) {
        return;
      }
      // It has a fixed update rate
      if (scene.getUpdateRate() != 0) {
        if (AbstractGameLoopManager.getInstance().getCurrentScene() != scene) {
          setDone(true);
        }
        if ((UpdateSceneEvent.tick % scene.getUpdateRate()) == 0) {
          scene.updateChilds();
          scene.updateState();
        }

      } else // updateRate = 0 ... same as: "update when it needs"

      if (scene.isToUpdate()) {
        scene.updateChilds();
        scene.updateState();
        scene.setToUpdate(false);
      }

    }
  }
}
