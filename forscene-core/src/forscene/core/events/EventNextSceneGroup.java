package forscene.core.events;

import forscene.core.LoopController.EventMonitor;
import forscene.core.LoopController.GameLoopManager;
import forscene.core.entities.AbstractSceneGroup;

public class EventNextSceneGroup extends AbstractEvent {

	@Override
	public void run() {
		AbstractSceneGroup sg =  GameLoopManager.getInstance().getNextSceneGroup();
		EventMonitor.getInstance().push(new EventLoadSceneGroup(sg));
		EventMonitor.getInstance().push(new EventLoadScene(sg.getFirstScene()));		
	}

	

}
