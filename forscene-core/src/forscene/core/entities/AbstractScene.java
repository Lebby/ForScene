package forscene.core.entities;

import forscene.core.listener.AbstractKeyboardListener;
import forscene.core.listener.AbstractMouseListener;


public abstract class AbstractScene extends AbstractSceneObject{
	private long updateRate = 0;
	private AbstractMouseListener mouseListener;	
	private AbstractKeyboardListener keyboardListener;
	
	
	private boolean USE_TIMER = false;
	private boolean IS_READY_TO_SWITCH = false;
	private boolean IS_CONDITIONAL = false;
	private int seconds;
	
	private AbstractScene next,prev;
	
	
	public boolean isConditional()
	{
		return IS_CONDITIONAL;
	}
	
	public void setConditional(boolean isConditional)
	{
		IS_CONDITIONAL = isConditional;
	}
	
	public boolean isReadyToSwitch()
	{
		return IS_READY_TO_SWITCH;
	}
	
	public void setReadyToSwitch(boolean isReady)
	{
		IS_READY_TO_SWITCH = isReady;
	}
	
	public boolean hasTimeout()
	{
		return USE_TIMER;
	}	
	
	public AbstractMouseListener getMouseListener() {
		return mouseListener;
	}
	public void setMouseListener(AbstractMouseListener  mouseListener) {
		this.mouseListener = mouseListener;
	}
	public AbstractKeyboardListener  getKeyboardListener() {
		return keyboardListener;
	}

	public void setKeyboardListener(AbstractKeyboardListener  listener) {
		this.keyboardListener = listener;
		
	}

	
	public int getTimeout() {
		return seconds;
	}

	public void setTimeout(int seconds) {
		this.seconds = seconds;
		USE_TIMER = true;
	}
	
	public AbstractScene getNext(){
		return next;
	}
	public AbstractScene getPrev()
	{
		return prev;
	}
	public void setNext(AbstractScene next)
	{
		this.next = next;
	}
	
	public void setPrev(AbstractScene prev)
	{
		this.prev = prev;
	}
	
	public boolean hasNext()
	{
		return (next != null);
	}
	
	
	public void setUpdateRate(long rate )
	{
		this.updateRate = rate;
	}
	

	public long getUpdateRate()
	{
		return updateRate;
	}
	

}