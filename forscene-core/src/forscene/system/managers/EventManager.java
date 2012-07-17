package forscene.system.managers;

import java.util.PriorityQueue;

import forscene.core.events.system.EventStatus;
import forscene.core.events.system.IEvent;

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
    EventManager.events = new PriorityQueue<IEvent>();
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

    if (EventManager.events == null) {
      EventManager.events = new PriorityQueue<IEvent>();
    }

    if (EventManager.events.size() == 0) {
      EventManager.currentEvent = null;
      return;
    }
    PriorityQueue<IEvent> tmp = new PriorityQueue<IEvent>();
    // #Debug
    /*
     * for (Iterator iterator = events.iterator(); iterator.hasNext();) { IEvent
     * iEvent = (IEvent) iterator.next(); PlayN.log().debug("EventMap :" +
     * iEvent.getName() + " P : "+ iEvent.getStatus());
     * 
     * }
     */
    while (!EventManager.events.isEmpty()) {

      EventManager.currentEvent = pop();
      EventManager.currentEvent.run();
      // useless ...
      EventObserverManager.getInstance().notify(EventManager.currentEvent);
      if (!EventManager.currentEvent.isDone()) {
        tmp.add(EventManager.currentEvent);
        EventManager.currentEvent.setStatus(EventStatus.RUNNING);
      } else {
        EventManager.currentEvent.setStatus(EventStatus.ENDED);
      }
    }
    EventManager.events.addAll(tmp);

  }

  /**
   * Push.
   * 
   * @param evt
   *          the evt
   */
  public void push(IEvent evt) {
    // PlayN.log().debug("evt IN: " + evt);
    EventManager.events.add(evt);
    evt.setStatus(EventStatus.ENQUEUED);
  }

  /**
   * Pop.
   * 
   * @return the i event
   */
  public IEvent pop() {
    EventManager.currentEvent = EventManager.events.poll();
    EventManager.currentEvent.setStatus(EventStatus.STARTED);
    return EventManager.currentEvent;
  }

  public IEvent getCurrentEvent() {
    return EventManager.currentEvent;
  }
}