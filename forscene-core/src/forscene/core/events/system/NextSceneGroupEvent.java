/*
 * 
 */
package forscene.core.events.system;

import forscene.core.entities.AbstractSceneGroup;
import forscene.system.managers.AbstractGameLoopManager;
import forscene.system.managers.EventManager;

// TODO: Auto-generated Javadoc
/**
 * The Class EventNextSceneGroup.
 */
public class NextSceneGroupEvent extends AbstractEvent {

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.events.AbstractEvent#run()
   */
  @Override
  public void run() {
    AbstractSceneGroup sg = AbstractGameLoopManager.getInstance()
        .getNextSceneGroup();
    EventManager.getInstance().push(new LoadSceneGroupEvent(sg));
    EventManager.getInstance().push(new LoadSceneEvent(sg.getFirstScene()));
    setDone(true);
  }

}
