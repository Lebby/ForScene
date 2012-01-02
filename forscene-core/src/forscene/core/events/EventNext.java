package forscene.core.events;

import forscene.core.LoopController.AbstractGameLoopManager;
import forscene.core.LoopController.GameLoopManager;

public class EventNext extends AbstractEvent{

	@Override
	public void run() {
		AbstractGameLoopManager.getInstance().goNext();
	}

}
