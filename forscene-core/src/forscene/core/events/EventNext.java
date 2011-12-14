package forscene.core.events;

import forscene.core.LoopController.GameLoopManager;

public class EventNext extends AbstractEvent{

	@Override
	public void run() {
		GameLoopManager.getInstance().goNext();
	}

}
