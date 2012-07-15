package forscene.core.listener;

import static playn.core.PlayN.mouse;
import playn.core.PlayN;
import playn.core.Mouse.Adapter;
import playn.core.Mouse.ButtonEvent;
import playn.core.Mouse.MotionEvent;
import playn.core.Mouse.WheelEvent;
import forscene.core.events.input.AbstractMouseButtonEvent;
import forscene.core.events.input.AbstractMouseEvent;
import forscene.core.events.input.AbstractMouseMotionEvent;
import forscene.core.events.input.AbstractMouseWheelEvent;
import forscene.system.managers.EventManager;


public class AbstractMouseListener extends Adapter implements IListener{
	
	private AbstractMouseButtonEvent evtMouseDown;	
	private AbstractMouseButtonEvent evtMouseUp;
	private AbstractMouseWheelEvent  evtMouseWheelScroll;
	private AbstractMouseMotionEvent evtMouseMove;

	public AbstractMouseListener() {
		super();
	}	
	
	public AbstractMouseListener(AbstractMouseButtonEvent eventMouseDown,AbstractMouseButtonEvent eventMouseUp)
	{
		this();
		this.evtMouseDown = eventMouseDown;
		this.evtMouseUp = eventMouseUp;
	}
	
	public AbstractMouseListener
	(AbstractMouseButtonEvent eventMouseDown, 
	 AbstractMouseButtonEvent eventMouseUp,
	 AbstractMouseMotionEvent eventMouseMove,
	 AbstractMouseWheelEvent eventMouseScroll)
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
	
	/**
	 * @return the evtMouseDown
	 */
	public AbstractMouseButtonEvent getMouseDown() {
		return evtMouseDown;
	}

	/**
	 * @param evtMouseDown the evtMouseDown to set
	 */
	public void setMouseDown(AbstractMouseButtonEvent evtMouseDown) {
		this.evtMouseDown = evtMouseDown;
	}

	/**
	 * @return the evtMouseUp
	 */
	public AbstractMouseButtonEvent getMouseUp() {
		return evtMouseUp;
	}

	/**
	 * @param evtMouseUp the evtMouseUp to set
	 */
	public void setMouseUp(AbstractMouseButtonEvent evtMouseUp) {
		this.evtMouseUp = evtMouseUp;
	}

	/**
	 * @return the evtMouseWheelScroll
	 */
	public AbstractMouseWheelEvent getMouseWheelScroll() {
		return evtMouseWheelScroll;
	}

	/**
	 * @param evtMouseWheelScroll the evtMouseWheelScroll to set
	 */
	public void setMouseWheelScroll(
			AbstractMouseWheelEvent evtMouseWheelScroll) {
		this.evtMouseWheelScroll = evtMouseWheelScroll;
	}

	/**
	 * @return the evtMouseMove
	 */
	public AbstractMouseMotionEvent getMouseMove() {
		return evtMouseMove;
	}

	/**
	 * @param evtMouseMove the evtMouseMove to set
	 */
	public void setMouseMove(AbstractMouseMotionEvent evtMouseMove) {
		this.evtMouseMove = evtMouseMove;
	}

	public void register() {
		mouse().setListener(this);		
	}
	
}