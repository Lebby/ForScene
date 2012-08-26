/*
 * 
 */
package forscene.system.managers;

import java.util.ArrayList;
import java.util.HashMap;

import playn.core.PlayN;
import forscene.core.events.listener.AbstractEventListener;
import forscene.system.entities.ForSceneConfigurator;
import forscene.system.events.IEvent;

// TODO: Auto-generated Javadoc
// It allow to observe an event calling another event. 
// Map contains in "null" key a global event list
// Other keys contains a list of event that want to be notified when an event instance is processed by EventManager.
// This class could be avoided by implementing getCurrentEvent in EventManager.
// A poll is needed to implement an Observer by getCurrentEvent and it is a performance issue.
// EventObserverManager check global event observer and then try to find related observer of an event instance.

/**
 * The Class EventObserverManager.
 */
public class EventObserverManager {

  /**
   * The Class InnerEventList.
   */
  class InnerEventList extends ArrayList<AbstractEventListener> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
  };

  /** The event map. */
  private HashMap<IEvent, InnerEventList> eventMap;

  /** The global event map. */
  private HashMap<String, InnerEventList> globalEventMap;

  /** The instance. */
  private static EventObserverManager     instance = null;

  /**
   * Gets the single instance of EventObserverManager.
   * 
   * @return single instance of EventObserverManager
   */
  public static EventObserverManager getInstance() {
    if (EventObserverManager.instance == null) {
      EventObserverManager.instance = new EventObserverManager();
    }
    return EventObserverManager.instance;
  }

  /**
   * Instantiates a new event observer manager.
   */
  private EventObserverManager() {
    eventMap = new HashMap<IEvent, InnerEventList>();
    globalEventMap = new HashMap<String, InnerEventList>();
  }

  /**
   * Notify.
   * 
   * @param event
   *          the event
   */
  public void notify(IEvent event) {
    if (globalEventMap.containsKey(event.getName())) {
      notifyObservers(globalEventMap.get(event.getName()));

      // TODO: CHECK THIS ... if event is done ... it must be removed
      /*
       * if (event.isDone()) { //#Debug PlayN.log().debug(" EVENTMAP REMOVED:" +
       * globalEventMap.get(event.getName()) + " name: "+ event.getName());
       * globalEventMap.remove(event); }
       */
    }

    if (eventMap.containsKey(event)) {
      notifyObservers(eventMap.get(event));
    }
  }

  /**
   * Notify observers.
   * 
   * @param list
   *          the list
   */
  private void notifyObservers(InnerEventList list) {
    for (AbstractEventListener abstractEventListener : list) {
      AbstractEventListener iEvent = abstractEventListener;
      if (iEvent.check()) {
        // demand run to EventManager ... TODO: Adjust priorityLevel
        EventManager.getInstance().push(iEvent,
            ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_SYSTEM_PRIORITY);
      }
    }
  }

  /**
   * Register.
   * 
   * @param globalEventName
   *          the global event name
   * @param callback
   *          the callback
   */
  public void register(String globalEventName, AbstractEventListener callback) {
    InnerEventList tmp;
    if (globalEventMap.containsKey(globalEventName)) {
      tmp = globalEventMap.get(globalEventName);
      tmp.add(callback);
    } else {
      tmp = new InnerEventList();
      tmp.add(callback);
      globalEventMap.put(globalEventName, tmp);
      PlayN.log().debug(
          " EVENTMAP : NO EXIXTS " + globalEventName + " CB: "
              + callback.getName());
    }
  }

  /**
   * Register.
   * 
   * @param eventToMonitor
   *          the event to monitor
   * @param callback
   *          the callback
   */
  public void register(IEvent eventToMonitor, AbstractEventListener callback) {
    InnerEventList tmp;
    if (eventMap.containsKey(eventToMonitor)) {
      tmp = eventMap.get(eventToMonitor);
    } else {
      tmp = new InnerEventList();
      eventMap.put(eventToMonitor, tmp);
    }
    tmp.add(callback);
  }

  /**
   * Deregister.
   * 
   * @param eventToMonitor
   *          the event to monitor
   */
  public void deregister(IEvent eventToMonitor) {
    if (eventMap.containsKey(eventToMonitor)) {
      eventMap.remove(eventToMonitor);
    } else {
      // #Debug
      PlayN.log().debug(
          "Event Observer Manager Error: Event Not Found" + eventToMonitor);
    }
  }

  /**
   * Deregister.
   * 
   * @param globalEventName
   *          the global event name
   */
  public void deregister(String globalEventName) {
    if (globalEventMap.containsKey(globalEventName)) {
      globalEventMap.remove(globalEventName);
    } else {
      // #Debug
      PlayN.log().debug(
          "Event Observer Manager Error: Event Not Found" + globalEventName);
    }
  }

}
