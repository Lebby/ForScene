package forscene.core.events.listener;

import playn.core.PlayN;
import forscene.core.events.system.EventManager;
import forscene.core.events.system.IEvent;

public abstract class OnMouseMove extends  AbstractEventListener{

	@Override
	public boolean check() {
		IEvent currEvent= EventManager.getInstance().getCurrentEvent();
		PlayN.log().debug("Event Name:" + currEvent.getName());
		return false;
	}

}
