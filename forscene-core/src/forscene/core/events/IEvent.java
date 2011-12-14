package forscene.core.events;



public interface IEvent extends Comparable<AbstractEvent>{		
	void run();	
	boolean isDone();	
}
