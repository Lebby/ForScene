/*
 * 
 */
package forscene.core.events.system;

import forscene.core.entities.AbstractScene;

// TODO: Auto-generated Javadoc
/**
 * The Class EventUnloadScene.
 */
public class UnloadSceneEvent extends AbstractEvent {

  /** The scene. */
  private AbstractScene scene;

  /**
   * Instantiates a new event unload scene.
   * 
   * @param scene
   *          the scene
   */
  public UnloadSceneEvent(AbstractScene scene) {
    this.scene = scene;
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.events.AbstractEvent#run()
   */
  @Override
  public void run() {
    // TODO Auto-generated method stub
    setDone(true);
  }

}
