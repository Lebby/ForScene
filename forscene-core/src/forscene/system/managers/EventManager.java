/*
 * 
 */
package forscene.system.managers;

import java.util.PriorityQueue;

import playn.core.PlayN;
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

    PlayN.log().debug("EventMap Size: " + EventManager.events.size());
    for (Object element : EventManager.events) {
      IEvent iEvent = (IEvent) element;
      PlayN.log().debug(
          "EventMap :" + iEvent.getName() + (" P : " + iEvent.getStatus()));
    }

    while (!EventManager.events.isEmpty()) {

      EventManager.currentEvent = pop();
      /*
       * PlayN.log().debug( "evt : " + EventManager.currentEvent.getName() +
       * " : " + EventManager.currentEvent + " status " +
       * EventManager.currentEvent.getStatus());
       */
      EventManager.currentEvent.run();

      // useless ...
      EventObserverManager.getInstance().notify(EventManager.currentEvent);
      if (!EventManager.currentEvent.isDone()) {
        tmp.add(EventManager.currentEvent);
        EventManager.currentEvent.setStatus(EventStatus.RUNNING);
        /*
         * PlayN.log().debug( "evt : " + EventManager.currentEvent.getName() +
         * " : " + EventManager.currentEvent + " status " +
         * EventManager.currentEvent.getStatus());
         */
        EventManager.currentEvent.run();
      } else {
        EventManager.currentEvent.setStatus(EventStatus.ENDED);
        /*
         * PlayN.log().debug( "evt : " + EventManager.currentEvent.getName() +
         * " : " + EventManager.currentEvent + " status " +
         * EventManager.currentEvent.getStatus());
         * EventManager.currentEvent.run();
         */
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
    /* boolean result = */
    EventManager.events.add(evt);
    evt.setStatus(EventStatus.ENQUEUED);
    /*
     * PlayN.log().debug( "evt : " + evt.getName() + " : " + evt + " status " +
     * evt.getStatus());
     */
  }

  /**
   * Pop.
   * 
   * @return the i event
   */
  public IEvent pop() {
    EventManager.currentEvent = EventManager.events.poll();
    EventManager.currentEvent.setStatus(EventStatus.STARTED);
    /*
     * PlayN.log().debug( "evt : " + EventManager.currentEvent.getName() + " : "
     * + EventManager.currentEvent + " status " +
     * EventManager.currentEvent.getStatus());
     */
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
}