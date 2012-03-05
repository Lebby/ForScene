package forscene.core.listener;


import static playn.core.PlayN.keyboard;
import playn.core.Keyboard.Adapter;
import playn.core.Keyboard.Event;
import playn.core.Keyboard.TypedEvent;
import forscene.core.events.input.keyboard.OnKeyDownEvent;
import forscene.core.events.input.keyboard.OnKeyTypedEvent;
import forscene.core.events.input.keyboard.OnKeyUpEvent;
import forscene.core.events.system.EventManager;

public class AbstractKeyboardListener extends Adapter implements IListener {	
	private OnKeyDownEvent evtKeyDown;
	private OnKeyUpEvent evtKeyUp;
	private OnKeyTypedEvent evtKeyTyped;
	
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
	
	@Override
	public void onKeyTyped(TypedEvent event) {
		if (evtKeyTyped == null) return;		
		this.evtKeyTyped.setEvent( event);
		EventManager.getInstance().push(this.evtKeyTyped);
		this.evtKeyTyped.setDone(true);
	}

	public void register() {
		keyboard().setListener(this);		
	}	
	
}