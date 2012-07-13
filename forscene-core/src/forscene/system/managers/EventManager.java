package forscene.system.managers;


import java.util.PriorityQueue;

import forscene.core.events.system.EventStatus;
import forscene.core.events.system.IEvent;




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
		//#Debug
		/*for (Iterator iterator = events.iterator(); iterator.hasNext();) {
			IEvent iEvent = (IEvent) iterator.next();
			PlayN.log().debug("EventMap :" + iEvent.getName() + " P : "+ iEvent.getStatus());
			
		}*/
		while(!events.isEmpty())
		{
			
			currentEvent = pop();			
			currentEvent.run();
			//useless ...
			EventObserverManager.getInstance().notify(currentEvent); 
			if (!currentEvent.isDone())
			{
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