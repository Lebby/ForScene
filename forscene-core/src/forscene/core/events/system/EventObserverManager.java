package forscene.core.events.system;

import java.util.HashMap;
import java.util.LinkedList;

// It allow to observe an event calling another event. 
// Map contains in "null" key a global event list
// Other keys contains a list of event that want to be notified when an event instance is processed by EventManager.
// This class could be avoided by implementing getCurrentEvent in EventManager.
// A poll is needed to implement an Observer by getCurrentEvent and it is a performance issue.
// EventObserverManager check global event observer and then try to find related observer of an event instance.

public class EventObserverManager {
 	
	private HashMap<IEvent, InnerEventList > eventMap;
		
	public EventObserverManager() {
		eventMap = new HashMap<IEvent, InnerEventList>();
		eventMap.put(null, new InnerEventList());
	}
	
	public void notify(IEvent event){
		InnerEventList list = eventMap.get(null);
		notifyObservers(list,event); // verify global observer
		if (eventMap.containsKey(event)) notifyObservers(eventMap.get(event),event);		
	}
	
	
	private void notifyObservers(InnerEventList list, IEvent event)
	{
		//TODO: HERE
		
	}
	
	class InnerEventList extends LinkedList<IEvent>{};
		
}
