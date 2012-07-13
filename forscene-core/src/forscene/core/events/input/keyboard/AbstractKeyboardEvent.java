/**
 * 
 */
package forscene.core.events.input.keyboard;

import playn.core.Events.Input;
import playn.core.PlayN;
import forscene.core.events.input.AbstractInputEvent;

/**
 * @author blackdevil
 *
 */
public abstract class AbstractKeyboardEvent <T extends Input>
				extends AbstractInputEvent<T>{	
	
	
	public AbstractKeyboardEvent()
	{
		super();
		PlayN.log().debug("ASDASDAS");
	}
	
	@Override
	public int getPriority() {
		return 1;
	}
	
	
}
