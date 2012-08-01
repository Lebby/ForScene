/*
 * 
 */
package forscene.system.managers;

import java.util.ArrayList;

import playn.core.PlayN;
import forscene.core.events.system.EventStatus;
import forscene.core.events.system.IEvent;
import forscene.system.entities.ForSceneConfigurator;
import forscene.system.entities.PriorityQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class EventMonitor.
 */
public class EventManager {

  /** The events. */
  private static PriorityQueue<IEvent> events;

  /** The start. */
  private static boolean               start    = false;

  /** The current event. */
  private static IEvent                currentEvent;

  /** The instance. */
  private static EventManager          instance = null;

  /**
   * Instantiates a new event monitor.
   */
  private EventManager() {
    EventManager.setEvents(new PriorityQueue<IEvent>());
  }

  /**
   * Gets the singlethon instance of EventMonitor.
   * 
   * @return singlethon instance of EventMonitor
   */
  public static EventManager getInstance() {
    if (EventManager.instance == null) {
      EventManager.instance = new EventManager();
    }
    return EventManager.instance;
  }

  /**
   * Update.
   */
  public void update() {

    if (getEvents().isEmpty()) {
      EventManager.currentEvent = null;
      return;
    }
    ArrayList<IEvent> tmp = new ArrayList<IEvent>();
    while (!getEvents().isEmpty()) {

      EventManager.currentEvent = pop();

      if (EventManager.currentEvent == null) {
        PlayN.log().debug("CurrentEvent Null");
        return;
      }
      // PlayN.log().debug("CurrentEvent: " + EventManager.currentEvent);
      // First run is Started ... setStatus check if it can pass in Started

      EventManager.currentEvent.setStatus(EventStatus.STARTED);
      EventManager.currentEvent.run();
      // Then go in running
      EventManager.currentEvent.setStatus(EventStatus.RUNNING);

      // useless ...
      EventObserverManager.getInstance().notify(EventManager.currentEvent);

      if (!EventManager.currentEvent.isDone()) {
        tmp.add(EventManager.currentEvent);
      } else {
        EventManager.currentEvent.setStatus(EventStatus.ENDED);
      }
    }

    for (int i = 0; i < tmp.size(); i++) {
      EventManager.getInstance().push(tmp.get(i));
    }

  }

  /**
   * Push.
   * 
   * @param evt
   *          the evt
   */
  public void push(IEvent evt) {
    getEvents().add(evt,
        ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_PRIORITY);
    evt.setStatus(EventStatus.ENQUEUED);
  }

  public void push(IEvent evt, short priority) {
    evt.setPriority(priority);
    getEvents().add(evt, priority);
    evt.setStatus(EventStatus.ENQUEUED);
  }

  /**
   * Pop.
   * 
   * @return the i event
   */
  public IEvent pop() {
    EventManager.currentEvent = getEvents().poll();
    if (EventManager.currentEvent == null) {
      return null;
    }
    return EventManager.currentEvent;
  }

  /**
   * Gets the current event.
   * 
   * @return the current event
   */
  public IEvent getCurrentEvent() {
    return EventManager.currentEvent;
  }

  /**
   * @return the events
   */
  public PriorityQueue<IEvent> getEvents() {
    return EventManager.events;
  }

  /**
   * @param events
   *          the events to set
   */
  private static void setEvents(PriorityQueue<IEvent> events) {
    EventManager.events = events;
  }

}