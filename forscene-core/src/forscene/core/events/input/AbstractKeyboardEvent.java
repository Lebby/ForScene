/**
 * 
 */
package forscene.core.events.input;

import playn.core.Events.Input;

/**
 * @author blackdevil
 *
 */
public abstract class AbstractKeyboardEvent <T extends Input>
				extends AbstractInputEvent<T>{	
	
	
	public AbstractKeyboardEvent()
	{
		super();		
	}
	
	@Override
	public int getPriority() {
		return 1;
	}
	
	
}
