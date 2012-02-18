package forscene.core.listener;


import playn.core.Keyboard.Adapter;
import static playn.core.PlayN.keyboard;
import playn.core.Keyboard.Event;

import forscene.core.events.input.OnKeyDownEvent;
import forscene.core.events.input.OnKeyUpEvent;
import forscene.core.events.system.EventManager;

public class AbstractKeyboardListener extends Adapter implements IListener {	
	private OnKeyDownEvent evtKeyDown;
	private OnKeyUpEvent evtKeyUp;
	
	private AbstractKeyboardListener() {
		super();
	
	}
	
	public AbstractKeyboardListener(OnKeyDownEvent event)
	{
		this();
		this.evtKeyDown = event;		
	}
	
	public AbstractKeyboardListener(OnKeyUpEvent event)
	{
		this();
		this.evtKeyUp = event;
	}
	
	public AbstractKeyboardListener(OnKeyDownEvent eventKeyDown,OnKeyUpEvent eventKeyUp)
	{
		this();
		this.evtKeyDown = eventKeyDown;
		this.evtKeyUp = eventKeyUp;
	}

	
	@Override
	public void onKeyDown(Event event) {
		if (evtKeyDown == null) return;
		this.evtKeyDown.setEvent(event);
		EventManager.getInstance().push(this.evtKeyDown);
		this.evtKeyUp.setDone(true);
	}
	
	@Override
	public void onKeyUp(Event event) {
		if (evtKeyUp == null) return;
		this.evtKeyDown.setEvent(event);
		EventManager.getInstance().push(this.evtKeyUp);
		this.evtKeyDown.setDone(true);
	}

	
	public void register() {
		keyboard().setListener(this);		
	}
	
	
}