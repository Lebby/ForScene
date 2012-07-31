/*
 * 
 */
package forscene.core.events.listener;

import playn.core.PlayN;
import forscene.core.entities.AbstractScene;
import forscene.core.events.system.IEvent;
import forscene.core.events.system.LoadSceneEvent;
import forscene.system.managers.EventManager;

// TODO: Auto-generated Javadoc
/**
 * The Class OnLoad.
 */
public abstract class OnLoad extends AbstractEventListener {

  /** The scene. */
  private AbstractScene scene;

  /**
   * Instantiates a new on load.
   * 
   * @param scene
   *          the scene
   */
  public OnLoad(AbstractScene scene) {
    this.scene = scene;
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.events.listener.AbstractEventListener#check()
   */
  @Override
  public boolean check() {
    IEvent currEvent = EventManager.getInstance().getCurrentEvent();
    if (currEvent == null) {
      return false;
    }
    if (currEvent.getName().compareTo("LoadSceneEvent") == 0) {
      LoadSceneEvent event = (LoadSceneEvent) currEvent;
      if (event.getScene() == scene) {
        PlayN.log().debug("DONE");
        setDone(true);
        return true;
      }
    }
    return false;
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