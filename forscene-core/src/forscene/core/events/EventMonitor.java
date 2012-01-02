package forscene.core.events;

import java.util.PriorityQueue;

import playn.core.PlayN;



public class EventMonitor{
	private static PriorityQueue<IEvent> events;
	private static boolean start = false;
	private static IEvent currentEvent;
	private static EventMonitor instance = null;
	
	private EventMonitor()
	{
		events = new PriorityQueue<IEvent>();
	}
	
	public static EventMonitor getInstance()
	{
		if (instance == null)
		{
			instance = new EventMonitor();
		}
		return instance;
	}
	
	
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
			if (!currentEvent.isDone())
			{
				//PlayN.log().debug("push current event");
				tmp.add(currentEvent);
			}
		}
		events.addAll(tmp);
		
	}
	
	public void push(IEvent evt)
	{
		//PlayN.log().debug("evt IN: " + evt);
		events.add(evt);		
	}
	
	public IEvent pop()
	{		
		currentEvent = events.poll();
		//PlayN.log().debug("evt OUT: " + currentEvent);
		return currentEvent;
	}
}