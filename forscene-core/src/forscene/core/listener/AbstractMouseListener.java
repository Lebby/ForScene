package forscene.core.listener;

import static playn.core.PlayN.mouse;
import playn.core.Mouse.Adapter;
import playn.core.Mouse.ButtonEvent;
import playn.core.Mouse.MotionEvent;
import playn.core.Mouse.WheelEvent;
import forscene.core.events.input.mouse.OnMouseButtonDownEvent;
import forscene.core.events.input.mouse.OnMouseButtonUpEvent;
import forscene.core.events.input.mouse.OnMouseMoveEvent;
import forscene.core.events.input.mouse.OnMouseWheelScrollEvent;
import forscene.system.managers.EventManager;


public class AbstractMouseListener extends Adapter implements IListener{
	private OnMouseButtonDownEvent evtMouseDown;	
	private OnMouseButtonUpEvent evtMouseUp;
	private OnMouseWheelScrollEvent evtMouseWheelScroll;
	private OnMouseMoveEvent evtMouseMove;

	private AbstractMouseListener() {
		super();
	}
	
	public AbstractMouseListener(OnMouseButtonDownEvent event)
	{
		this();
		this.evtMouseDown = event;
	}
	
	public AbstractMouseListener(OnMouseButtonUpEvent event)
	{
		this();
		this.evtMouseUp = event;
	}
	
	public AbstractMouseListener(OnMouseWheelScrollEvent event)
	{
		this();
		this.evtMouseWheelScroll = event;
	}
	public AbstractMouseListener(OnMouseMoveEvent event)
	{
		this();
		this.evtMouseMove = event;
	}
	
	public AbstractMouseListener(OnMouseButtonDownEvent eventMouseDown,OnMouseButtonUpEvent eventMouseUp)
	{
		this();
		this.evtMouseDown = eventMouseDown;
		this.evtMouseUp = eventMouseUp;
	}
	
	public AbstractMouseListener
	(OnMouseButtonDownEvent eventMouseDown, 
	 OnMouseButtonUpEvent eventMouseUp,
	 OnMouseMoveEvent eventMouseMove,
	 OnMouseWheelScrollEvent eventMouseScroll)
	{
		this();
		this.evtMouseDown = eventMouseDown;
		this.evtMouseMove = eventMouseMove;
		this.evtMouseUp = eventMouseUp;
		this.evtMouseWheelScroll = eventMouseScroll;		
	}
	

	@Override
	public void onMouseDown(ButtonEvent event) {		
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
