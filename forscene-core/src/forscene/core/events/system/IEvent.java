package forscene.core.events.system;



// TODO: Auto-generated Javadoc
/**
 * The Interface IEvent.
 */
public interface IEvent extends Comparable<AbstractEvent>{		
	
	/**
	 * Run.
	 */
	void run();	
	
	/**
	 * Checks if is done.
	 *
	 * @return true, if is done
	 */
	boolean isDone();
	
	EventStatus getStatus();
	
	void setStatus(EventStatus status);
	
	String getName();
	
	void setName(String name);
	
}