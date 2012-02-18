package forscene.core.events.input;

import playn.core.Keyboard.Event;

public abstract class AbstractKeyboardEvent extends AbstractInputEvent<Event> {
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
