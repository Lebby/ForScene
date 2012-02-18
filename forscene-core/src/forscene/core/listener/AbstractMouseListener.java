package forscene.core.listener;

import static playn.core.PlayN.mouse;
import playn.core.Mouse.Adapter;
import playn.core.Mouse.ButtonEvent;
import playn.core.Mouse.MotionEvent;
import playn.core.Mouse.WheelEvent;

import forscene.core.events.input.mouse.OnButtonDownMouseEvent;
import forscene.core.events.input.mouse.OnButtonUpMouseEvent;
import forscene.core.events.input.mouse.OnMoveMouseEvent;
import forscene.core.events.input.mouse.OnScrollMouseEvent;
import forscene.core.events.system.EventManager;


public class AbstractMouseListener extends Adapter implements IListener{
	private OnButtonDownMouseEvent evtMouseDown;	
	private OnButtonUpMouseEvent evtMouseUp;
	private OnScrollMouseEvent evtMouseWheelScroll;
	private OnMoveMouseEvent evtMouseMove;

	private AbstractMouseListener() {
		super();
	}
	
	public AbstractMouseListener(OnButtonDownMouseEvent event)
	{
		this();
		this.evtMouseDown = event;
	}
	
	public AbstractMouseListener(OnButtonUpMouseEvent event)
	{
		this();
		this.evtMouseUp = event;
	}
	
	public AbstractMouseListener(OnScrollMouseEvent event)
	{
		this();
		this.evtMouseWheelScroll = event;
	}
	public AbstractMouseListener(OnMoveMouseEvent event)
	{
		this();
		this.evtMouseMove = event;
	}
	
	public AbstractMouseListener(OnButtonDownMouseEvent eventMouseDown,OnButtonUpMouseEvent eventMouseUp)
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
		EventManager.getInstance().push(this.evtMouseDown);		
	}
	
	
	@Override
	public void onMouseMove(MotionEvent event) {
		if (evtMouseMove == null) return;
		this.evtMouseMove.setEvent(event);
		EventManager.getInstance().push(this.evtMouseMove);
		
	}
	
	@Override
	public void onMouseUp(ButtonEvent event) {
		if (evtMouseUp == null) return;
		this.evtMouseUp.setEvent(event);
		EventManager.getInstance().push(this.evtMouseUp);		
	}
	
	@Override
	public void onMouseWheelScroll(WheelEvent event) {
		if (evtMouseWheelScroll == null) return;
		this.evtMouseWheelScroll.setEvent(event);
		EventManager.getInstance().push(this.evtMouseWheelScroll);		
	}

	
	public void register() {
		mouse().setListener(this);		
	}

}
