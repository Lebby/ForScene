package forscene.core.events.system;

import java.util.PriorityQueue;

import playn.core.PlayN;



// TODO: Auto-generated Javadoc
/**
 * The Class EventMonitor.
 */
public class EventManager{
	
	/** The events. */
	private static PriorityQueue<IEvent> events;
	
	/** The start. */
	private static boolean start = false;
	
	/** The current event. */
	private static IEvent currentEvent;
	
	

	/** The instance. */
	private static EventManager instance = null;
	
	/**
	 * Instantiates a new event monitor.
	 */
	private EventManager()
	{
		events = new PriorityQueue<IEvent>();
	}
	
	/**
	 * Gets the singlethon instance of EventMonitor.
	 *
	 * @return singlethon instance of EventMonitor
	 */
	public static EventManager getInstance()
	{
		if (instance == null)
		{
			instance = new EventManager();
		}
		return instance;
	}
	
	
	/**
	 * Update.
	 */
	public void update()
	{		
		//System.out.println("CurrentEvent: " + currentEvent);	
		if (events == null)
		{
			events = new PriorityQueue<IEvent>();			
		}	
		
		if (events.size() == 0)
		{
			currentEvent = null;
			return;
		}
		PriorityQueue<IEvent> tmp = new PriorityQueue<IEvent>();
		
		while(!events.isEmpty())
		{
			//PlayN.log().debug("event run");
			currentEvent = pop();			
			currentEvent.run();
			//useless ...
			EventObserverManager.getInstance().notify(currentEvent); 
			if (!currentEvent.isDone())
			{
				//PlayN.log().debug("push current event");
				tmp.add(currentEvent);
				currentEvent.setStatus(EventStatus.RUNNING);
			} else currentEvent.setStatus(EventStatus.ENDED);
		}
		events.addAll(tmp);
		
	}
	
	/**
	 * Push.
	 *
	 * @param evt the evt
	 */
	public void push(IEvent evt)
	{
		//PlayN.log().debug("evt IN: " + evt);
		events.add(evt);
		evt.setStatus(EventStatus.ENQUEUED);
	}
	
	/**
	 * Pop.
	 *
	 * @return the i event
	 */
	public IEvent pop()
	{		
		currentEvent = events.poll();
		currentEvent.setStatus(EventStatus.STARTED);
		return currentEvent;
	}
	
	public IEvent getCurrentEvent() {
		return currentEvent;
	}
}