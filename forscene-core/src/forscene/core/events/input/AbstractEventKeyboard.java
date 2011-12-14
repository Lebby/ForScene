package forscene.core.events.input;

import playn.core.Keyboard.Event;

public abstract class AbstractEventKeyboard extends AbstractEventInput<Event> {
	public AbstractEventKeyboard()
	{
		super();
	}
	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	

}
