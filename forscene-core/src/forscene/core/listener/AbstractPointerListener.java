package forscene.core.listener;

import static playn.core.PlayN.pointer;
import playn.core.Pointer.Adapter;
import playn.core.Pointer.Event;

public class AbstractPointerListener extends Adapter implements IListener{ //TODO: TO IMPLEMENT

	
	public void register() {
		pointer().setListener(this);
	}
	
	public AbstractPointerListener() {
		super();
	}
	
	@Override
	public void onPointerDrag(Event event) {
		// TODO Auto-generated method stub
		super.onPointerDrag(event);
	}@Override
	public void onPointerEnd(Event event) {
		// TODO Auto-generated method stub
		super.onPointerEnd(event);
	}@Override
	public void onPointerStart(Event event) {
		// TODO Auto-generated method stub
		super.onPointerStart(event);
	}

}
