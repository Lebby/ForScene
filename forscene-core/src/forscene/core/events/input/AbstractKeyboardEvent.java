/**
 * 
 */
package forscene.core.events.input;

import playn.core.Events.Input;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractKeyboardEvent.
 *
 * @param <T> the generic type
 * @author blackdevil
 */
public abstract class AbstractKeyboardEvent <T extends Input>
				extends AbstractInputEvent<T>{	
	
	
	/**
	 * Instantiates a new abstract keyboard event.
	 */
	public AbstractKeyboardEvent()
	{
		super();		
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.events.system.AbstractEvent#getPriority()
	 */
	@Override
	public int getPriority() {
		return 1;
	}
	
	
}
