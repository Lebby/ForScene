/*
 * 
 */
package forscene.core.events.system;

import playn.core.PlayN;
import forscene.core.entities.AbstractSceneGroup;
import forscene.system.managers.AbstractGameLoopManager;
import forscene.system.managers.EventManager;

// TODO: Auto-generated Javadoc
/**
 * The Class EventLoadSceneGroup.
 */
public class LoadSceneGroupEvent extends AbstractEvent {

  /** The scene. */
  private AbstractSceneGroup scene;

  /**
   * Instantiates a new event load scene group.
   * 
   * @param scene
   *          the scene
   */
  public LoadSceneGroupEvent(AbstractSceneGroup scene) {
    PlayN.log().debug("EventLoadSceneGroup scene: " + scene);
    this.scene = scene;
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.events.AbstractEvent#run()
   */
  @Override
  public void run() {
    // GameLoopController.loadSceneGroup(sceneGroup);
    PlayN.log().debug("EventLoadSceneGroup RUN scene: " + scene);
    AbstractGameLoopManager.getInstance().loadSceneGroup(scene);
    EventManager.getInstance().push(new LoadSceneEvent(scene.getFirstScene()));
    setDone(true);
  }

}
