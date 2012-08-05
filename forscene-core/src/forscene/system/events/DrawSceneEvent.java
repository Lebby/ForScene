/*
 * 
 */
package forscene.system.events;

import playn.core.PlayN;
import forscene.core.entities.AbstractScene;
import forscene.system.Asserts;
import forscene.system.entities.ForSceneConfigurator;
import forscene.system.managers.AbstractGameLoopManager;

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
    Asserts.check(scene != null, "DrawSceneEvent: scene can't be null");
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
    PlayN.log().debug("DRAW");
    if (AbstractGameLoopManager.getInstance().draw(scene)) {
      setDone(true);
    } else {
      setDone(false);
    }
  }

}
