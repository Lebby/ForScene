package forscene.core.events;



public abstract class AbstractEvent implements IEvent{
	private int priority = 0;
	private boolean done = true;	

	public int compareTo(AbstractEvent o) {
		return (this.priority- o.priority );		
	}
	
	public int getPriority()
	{
		return priority;
	}
	
	public void setPriority(int priority)
	{
		this.priority = priority; 
	}
	
	public boolean isDone()
	{
		return done;
	}
	
	public boolean setDone(boolean done)
	{
		return this.done=done;
	}

	public abstract void run();

}
