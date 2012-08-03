/*
 * 
 */
package forscene.system.events;

import forscene.core.entities.AbstractSceneGroup;
import forscene.system.entities.ForSceneConfigurator;
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
    EventManager.getInstance().push(new LoadSceneGroupEvent(sg),
        ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_SYSTEM_PRIORITY);
    EventManager.getInstance().push(new LoadSceneEvent(sg.getFirstScene()),
        ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_SYSTEM_PRIORITY);
    setDone(true);
  }

}
