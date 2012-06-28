package forscene.core.events.input.keyboard;

import forscene.core.events.input.AbstractInputEvent;
import playn.core.Events.Input;

public abstract class AbstractKeyboardEvent<T extends Input> extends AbstractInputEvent<T> {
	public AbstractKeyboardEvent()
	{
		super();
	}
	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 1;
	}
}
