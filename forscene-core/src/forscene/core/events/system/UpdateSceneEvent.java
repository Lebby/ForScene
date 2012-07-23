/*
 * 
 */
package forscene.core.events.system;

import playn.core.PlayN;
import forscene.core.entities.AbstractScene;

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
    // DebugUtil.printCallerStack(this, "UpdateSceneEvent", "");
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
      /*
       * old ... if (((scene.isToUpdate()) || (scene.getUpdateRate() != 0 &&
       * tick%scene.getUpdateRate() == 0 )) ) { if ((scene.getRoot() == null)||
       * (scene.getRoot().parent() == null)) return; //MAYBE:WRONG! TODO: FIX OR
       * CHECK THIS --- Fixed by pending childs
       * 
       * scene.updateChilds(); PlayN.log().debug(" calling UpdateScene : " +
       * scene); scene.updateState(); scene.setToUpdate(false); }
       */
      // new
      // It isn't attached to scenegraph or is void
      if ((!scene.hasParent()) || (scene.getRoot() == null)) {
        return;
      }
      // It has a fixed update rate
      if (scene.getUpdateRate() != 0) {
        if ((UpdateSceneEvent.tick % scene.getUpdateRate()) == 0) {
          PlayN.log().debug("Ur: ok " + scene.getUpdateRate());
          scene.updateChilds();
          scene.updateState();
        }
        /*
         * else // PATCH .. what's happens if ticks are missed? ( it could //
         * happens? ) { long l = (UpdateSceneEvent.tick %
         * scene.getUpdateRate()); PlayN.log().debug("Ur: " +
         * scene.getUpdateRate() + " mod : " + l); }
         */
      } else // updateRate = 0 ... same as: "update when it needs"

      if (scene.isToUpdate()) {
        scene.updateChilds();
        scene.updateState();
      }
      scene.setToUpdate(false);
      setDone(true);

    }
    /*
     * useless if (scene.getUpdateRate() == 0) { setDone(true);
     * scene.setToUpdate(false); }
     */
  }
}
