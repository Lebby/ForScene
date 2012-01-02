package forscene.core.events;

import forscene.core.LoopController.GameLoopManager;

public class EventNextScene extends AbstractEvent{

	@Override
	public void run() {	
		EventMonitor.getInstance().push(new EventLoadScene(GameLoopManager.getInstance().getNextScene()));		
	}
}
