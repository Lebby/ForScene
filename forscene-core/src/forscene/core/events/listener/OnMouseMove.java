package forscene.core.events.listener;

import playn.core.PlayN;
import forscene.core.events.system.IEvent;
import forscene.system.managers.EventManager;

public abstract class OnMouseMove extends  AbstractEventListener{

	@Override
	public boolean check() {
		IEvent currEvent= EventManager.getInstance().getCurrentEvent();
		PlayN.log().debug("Event Name:" + currEvent.getName());
		return false;
	}

}
