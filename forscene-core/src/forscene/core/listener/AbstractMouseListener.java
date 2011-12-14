package forscene.core.listener;

import static playn.core.PlayN.keyboard;
import static playn.core.PlayN.mouse;
import playn.core.Mouse.Adapter;
import playn.core.Mouse.ButtonEvent;
import playn.core.Mouse.MotionEvent;
import playn.core.Mouse.WheelEvent;

import forscene.core.LoopController.EventMonitor;
import forscene.core.events.input.EventMouseDown;
import forscene.core.events.input.EventMouseMove;
import forscene.core.events.input.EventMouseScroll;
import forscene.core.events.input.EventMouseUp;


public class AbstractMouseListener extends Adapter implements IListener{
	private EventMouseDown evtMouseDown;	
	private EventMouseUp evtMouseUp;
	private EventMouseScroll evtMouseWheelScroll;
	private EventMouseMove evtMouseMove;

	private AbstractMouseListener() {
		super();
	}
	
	public AbstractMouseListener(EventMouseDown event)
	{
		this();
		this.evtMouseDown = event;
	}
	
	public AbstractMouseListener(EventMouseUp event)
	{
		this();
		this.evtMouseUp = event;
	}
	
	public AbstractMouseListener(EventMouseScroll event)
	{
		this();
		this.evtMouseWheelScroll = event;
	}
	public AbstractMouseListener(EventMouseMove event)
	{
		this();
		this.evtMouseMove = event;
	}
	
	public AbstractMouseListener(EventMouseDown eventMouseDown,EventMouseUp eventMouseUp)
	{
		this();
		this.evtMouseDown = eventMouseDown;
		this.evtMouseUp = eventMouseUp;
	}

	@Override
	public void onMouseDown(ButtonEvent event) {	
		// TODO Auto-generated method stub	
		if (evtMouseDown == null) return;
		this.evtMouseDown.setEvent(event);
		EventMonitor.getInstance().push(this.evtMouseDown);		
	}
	
	
	@Override
	public void onMouseMove(MotionEvent event) {
		if (evtMouseMove == null) return;
		this.evtMouseMove.setEvent(event);
		EventMonitor.getInstance().push(this.evtMouseMove);
		
	}
	
	@Override
	public void onMouseUp(ButtonEvent event) {
		if (evtMouseUp == null) return;
		this.evtMouseUp.setEvent(event);
		EventMonitor.getInstance().push(this.evtMouseUp);		
	}
	
	@Override
	public void onMouseWheelScroll(WheelEvent event) {
		if (evtMouseWheelScroll == null) return;
		this.evtMouseWheelScroll.setEvent(event);
		EventMonitor.getInstance().push(this.evtMouseWheelScroll);		
	}

	
	public void register() {
		mouse().setListener(this);		
	}

}
