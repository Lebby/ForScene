/*
 * 
 */
package forscene.system.events;

import forscene.core.entities.AbstractSceneGroup;

// TODO: Auto-generated Javadoc
/**
 * The Class EventUnloadSceneGroup.
 */
public class UnloadSceneGroupEvent extends AbstractEvent {

  /** The scene group. */
  private AbstractSceneGroup sceneGroup;

  /**
   * Instantiates a new event unload scene group.
   * 
   * @param sceneGroup
   *          the scene group
   */
  public UnloadSceneGroupEvent(AbstractSceneGroup sceneGroup) {
    this.sceneGroup = sceneGroup;
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
