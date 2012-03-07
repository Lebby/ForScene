package forscene.core.events.system;



// TODO: Auto-generated Javadoc
/**
 * The Class AbstractEvent.
 */
public abstract class AbstractEvent implements IEvent{
	
	/** The priority. */
	private int priority = 0;
	
	/** The done. */
	private boolean done = true;
	
	private EventStatus status = EventStatus.NONE;
	
	private String name ="";

	public AbstractEvent() {		
		name = this.getClass().getName();
		if (name.lastIndexOf('.') > 0) {
		    name = name.substring(name.lastIndexOf('.')+1);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(AbstractEvent o) {
		return (this.priority- o.priority );		
	}
	
	/**
	 * Gets the priority.
	 *
	 * @return the priority
	 */
	public int getPriority()
	{
		return priority;
	}
	
	/**
	 * Sets the priority.
	 *
	 * @param priority the new priority
	 */
	public void setPriority(int priority)
	{
		this.priority = priority; 
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.events.IEvent#isDone()
	 */
	public boolean isDone()
	{
		return done;
	}
	
	/**
	 * Sets the done.
	 *
	 * @param done the done
	 * @return true, if successful
	 */
	public boolean setDone(boolean done)
	{
		return this.done=done;
	}

	/* (non-Javadoc)
	 * @see forscene.core.events.IEvent#run()
	 */
	public abstract void run();
	

	public EventStatus getStatus() {
		return this.status;
	}
	
	
	public void setStatus(EventStatus status) {
		/* complex checking on status */
		switch(this.status)
		{
			case RUNNING: 			
			case ENDED: if (status == EventStatus.STARTED) break;
			case NONE:
			case ENQUEUED:
			case STARTED:			
			case PAUSED:
			default: this.status = status;
			break;		
		}		
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;		
	}
	
}