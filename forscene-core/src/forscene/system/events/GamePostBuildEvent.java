/**
 * 
 */
package forscene.system.events;

import forscene.system.managers.GameLoopManager;

/**
 * @author blackdevil
 * 
 */
public class GamePostBuildEvent extends AbstractEvent {

  /*
   * (non-Javadoc)
   * 
   * @see forscene.system.events.AbstractEvent#run()
   */
  @Override
  public void run() {
    GameLoopManager.getInstance().postBuild();
    setDone(true);
  }
}
