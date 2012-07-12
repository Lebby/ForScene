package forscene.core.events.system;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import playn.core.PlayN;

import forscene.core.events.listener.AbstractEventListener;

// It allow to observe an event calling another event. 
// Map contains in "null" key a global event list
// Other keys contains a list of event that want to be notified when an event instance is processed by EventManager.
// This class could be avoided by implementing getCurrentEvent in EventManager.
// A poll is needed to implement an Observer by getCurrentEvent and it is a performance issue.
// EventObserverManager check global event observer and then try to find related observer of an event instance.

public class EventObserverManager {
	
	class InnerEventList extends LinkedList<AbstractEventListener>{};
	
	private HashMap<IEvent, InnerEventList > eventMap;
	private HashMap<String, InnerEventList> globalEventMap;
	private static EventObserverManager instance = null;
		
	public static EventObserverManager getInstance()
	{
		if ( instance == null )
			instance = new EventObserverManager();
		return instance;
	}
	
	private EventObserverManager() {
		eventMap = new HashMap<IEvent, InnerEventList>();
		globalEventMap = new HashMap<String, InnerEventList>();
	}
	
	public void notify(IEvent event)
	{
		if (globalEventMap.containsKey(event.getName()))
		{
			PlayN.log().debug(" EVENTMAP :" + globalEventMap.get(event.getName()) + " name: "+ event.getName());
			notifyObservers(globalEventMap.get(event.getName()));
			//TODO: CHECK THIS ... if event is done ... it must be removed
			/*if (event.isDone())
			{
				//#Debug
				PlayN.log().debug(" EVENTMAP REMOVED:" + globalEventMap.get(event.getName()) + " name: "+ event.getName());
				globalEventMap.remove(event);
			}*/			
		}
		
		if (eventMap.containsKey(event)) 
			notifyObservers(eventMap.get(event));		
	}
	
	
	private void notifyObservers(InnerEventList list)
	{		
		for (Iterator<AbstractEventListener>iterator = list.iterator(); iterator.hasNext();) {
			AbstractEventListener iEvent = (AbstractEventListener) iterator.next();
			if (iEvent.check())
				EventManager.getInstance().push(iEvent);//demand run to EventManager ... TODO: Adjust priorityLevel
		}
	}
	
	public void register(String globalEventName, AbstractEventListener callback)
	{
		InnerEventList tmp;
		if (globalEventMap.containsKey(globalEventName))
		{
			PlayN.log().debug(" EVENTMAP : EXIXTS" ); 
			tmp = globalEventMap.get(globalEventName);			
		}else 
		{
			tmp = new InnerEventList();			
			globalEventMap.put(globalEventName, tmp);
			PlayN.log().debug(" EVENTMAP : NO EXIXTS " + callback);
		}
		tmp.add(callback);
	}
	
	
	public void register(IEvent eventToMonitor, AbstractEventListener callback)
	{
		InnerEventList tmp;
		if (eventMap.containsKey(eventToMonitor))
		{
			tmp = eventMap.get(eventToMonitor);		
		}else 
		{
			tmp = new InnerEventList();
			eventMap.put(eventToMonitor, tmp);
		}
		tmp.add(callback);
	}	
	
	public void deregister(IEvent eventToMonitor)
	{
		if (eventMap.containsKey(eventToMonitor))
		{
			eventMap.remove(eventToMonitor);
		}
		else
			//#Debug
			PlayN.log().debug("Event Observer Manager Error: Event Not Found" + eventToMonitor);
	}
	
	public void deregister(String globalEventName)
	{
		if (globalEventMap.containsKey(globalEventName))
		{			 
			globalEventMap.remove(globalEventName);			
		}else 
			//#Debug
			PlayN.log().debug("Event Observer Manager Error: Event Not Found" + globalEventName);
	}

}
