package forscene.core.listener;


import playn.core.Keyboard.Adapter;
import static playn.core.PlayN.keyboard;
import playn.core.Keyboard.Event;

import forscene.core.events.EventMonitor;
import forscene.core.events.input.EventKeyDown;
import forscene.core.events.input.EventKeyUp;

public class AbstractKeyboardListener extends Adapter implements IListener {	
	private EventKeyDown evtKeyDown;
	private EventKeyUp evtKeyUp;
	
	private AbstractKeyboardListener() {
		super();
	
	}
	
	public AbstractKeyboardListener(EventKeyDown event)
	{
		this();
		this.evtKeyDown = event;		
	}
	
	public AbstractKeyboardListener(EventKeyUp event)
	{
		this();
		this.evtKeyUp = event;
	}
	
	public AbstractKeyboardListener(EventKeyDown eventKeyDown,EventKeyUp eventKeyUp)
	{
		this();
		this.evtKeyDown = eventKeyDown;
		this.evtKeyUp = eventKeyUp;
	}

	
	@Override
	public void onKeyDown(Event event) {
		if (evtKeyDown == null) return;
		this.evtKeyDown.setEvent(event);
		EventMonitor.getInstance().push(this.evtKeyDown);
		this.evtKeyUp.setDone(true);
	}
	
	@Override
	public void onKeyUp(Event event) {
		if (evtKeyUp == null) return;
		this.evtKeyDown.setEvent(event);
		EventMonitor.getInstance().push(this.evtKeyUp);
		this.evtKeyDown.setDone(true);
	}

	
	public void register() {
		keyboard().setListener(this);		
	}
	
	
}