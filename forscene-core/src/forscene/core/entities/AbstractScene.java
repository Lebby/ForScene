package forscene.core.entities;

import forscene.core.listener.AbstractKeyboardListener;
import forscene.core.listener.AbstractMouseListener;


// TODO: Auto-generated Javadoc
/**
 * The Class AbstractScene.
 */
public abstract class AbstractScene extends AbstractSceneObjectGroup{	
	
	/** The mouse listener. */
	private AbstractMouseListener mouseListener;	
	
	/** The keyboard listener. */
	private AbstractKeyboardListener keyboardListener;
	
	
	/** The US e_ timer. */
	private boolean USE_TIMER = false;
	
	/** The I s_ read y_ t o_ switch. */
	private boolean IS_READY_TO_SWITCH = false;
	
	/** The I s_ conditional. */
	private boolean IS_CONDITIONAL = false;
	
	/** The seconds. */
	private float seconds;
	
	/** The prev. */
	private AbstractScene next,prev;
	
	
	/**
	 * Checks if is conditional.
	 *
	 * @return true, if is conditional
	 */
	public boolean isConditional()
	{
		return IS_CONDITIONAL;
	}
	
	/**
	 * Sets the conditional.
	 *
	 * @param isConditional the new conditional
	 */
	public void setConditional(boolean isConditional)
	{
		IS_CONDITIONAL = isConditional;
	}
	
	/**
	 * Checks if is ready to switch.
	 *
	 * @return true, if is ready to switch
	 */
	public boolean isReadyToSwitch()
	{
		return IS_READY_TO_SWITCH;
	}
	
	/**
	 * Sets the ready to switch.
	 *
	 * @param isReady the new ready to switch
	 */
	public void setReadyToSwitch(boolean isReady)
	{
		IS_READY_TO_SWITCH = isReady;
	}
	
	/**
	 * Checks for timeout.
	 *
	 * @return true, if successful
	 */
	public boolean hasTimeout()
	{
		return USE_TIMER;
	}	
	
	/**
	 * Gets the mouse listener.
	 *
	 * @return the mouse listener
	 */
	public AbstractMouseListener getMouseListener() {
		return mouseListener;
	}
	
	/**
	 * Sets the mouse listener.
	 *
	 * @param mouseListener the new mouse listener
	 */
	public void setMouseListener(AbstractMouseListener  mouseListener) {
		this.mouseListener = mouseListener;
	}
	
	/**
	 * Gets the keyboard listener.
	 *
	 * @return the keyboard listener
	 */
	public AbstractKeyboardListener  getKeyboardListener() {
		return keyboardListener;
	}

	/**
	 * Sets the keyboard listener.
	 *
	 * @param listener the new keyboard listener
	 */
	public void setKeyboardListener(AbstractKeyboardListener  listener) {
		this.keyboardListener = listener;
		
	}

	
	/**
	 * Gets the timeout.
	 *
	 * @return the timeout
	 */
	public float getTimeout() {
		return seconds;
	}

	/**
	 * Sets the timeout.
	 *
	 * @param seconds the new timeout
	 */
	public void setTimeout(float seconds) {
		this.seconds = seconds;
		USE_TIMER = true;
	}
	
	/**
	 * Gets the next.
	 *
	 * @return the next
	 */
	public AbstractScene getNext(){
		return next;
	}
	
	/**
	 * Gets the prev.
	 *
	 * @return the prev
	 */
	public AbstractScene getPrev()
	{
		return prev;
	}
	
	/**
	 * Sets the next.
	 *
	 * @param next the new next
	 */
	public void setNext(AbstractScene next)
	{
		this.next = next;
	}
	
	/**
	 * Sets the prev.
	 *
	 * @param prev the new prev
	 */
	public void setPrev(AbstractScene prev)
	{
		this.prev = prev;
	}
	
	/**
	 * Checks for next.
	 *
	 * @return true, if successful
	 */
	public boolean hasNext()
	{
		return (next != null);
	}
}
