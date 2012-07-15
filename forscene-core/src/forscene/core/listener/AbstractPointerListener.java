package forscene.core.listener;

import static playn.core.PlayN.pointer;
import playn.core.PlayN;
import playn.core.Pointer.Adapter;
import playn.core.Pointer.Event;

import forscene.core.events.input.AbstractPointerEvent;
import forscene.system.managers.EventManager;


public class AbstractPointerListener extends Adapter implements IListener{
	private AbstractPointerEvent onPointerDrag;
	private AbstractPointerEvent onPointerEnd;
	private AbstractPointerEvent onPointerStart;	
	
	public void register() {
		pointer().setListener(this);
	}
	
	public AbstractPointerListener() {
		super();
	}
	
	@Override
	public void onPointerDrag(Event event) {
		PlayN.log().debug("pointer Drag");
		if (getPointerDrag() == null) return;
		getPointerDrag().setEvent(event);
		EventManager.getInstance().push(this.getPointerDrag());	
	}
	
	@Override
	public void onPointerEnd(Event event) {
		PlayN.log().debug("pointer end");
		if (getPointerEnd() == null) return;
		getPointerEnd().setEvent(event);
		EventManager.getInstance().push(this.getPointerEnd());
	}
	
	@Override
	public void onPointerStart(Event event) {
		PlayN.log().debug("pointer start");
		if (getPointerStart() == null) return;
		getPointerStart().setEvent(event);
		EventManager.getInstance().push(this.getPointerStart());
	}

	/**
	 * @return the onPointerDrag
	 */
	public AbstractPointerEvent getPointerDrag() {
		return onPointerDrag;
	}

	/**
	 * @param onPointerDrag the onPointerDrag to set
	 */
	public void setPointerDrag(AbstractPointerEvent onPointerDrag) {
		this.onPointerDrag = onPointerDrag;
	}

	/**
	 * @return the onPointerEnd
	 */
	public AbstractPointerEvent getPointerEnd() {
		return onPointerEnd;
	}

	/**
	 * @param onPointerEnd the onPointerEnd to set
	 */
	public void setPointerEnd(AbstractPointerEvent onPointerEnd) {
		this.onPointerEnd = onPointerEnd;
	}

	/**
	 * @return the onPointerStart
	 */
	public AbstractPointerEvent getPointerStart() {
		return onPointerStart;
	}

	/**
	 * @param onPointerStart the onPointerStart to set
	 */
	public void setPointerStart(AbstractPointerEvent onPointerStart) {
		this.onPointerStart = onPointerStart;
	}
	
}