package forscene.core.events;

import forscene.core.entities.AbstractSceneGroup;

public class EventUnloadSceneGroup extends AbstractEvent{
	private AbstractSceneGroup sceneGroup;
	
	public EventUnloadSceneGroup(AbstractSceneGroup sceneGroup)
	{
		this.sceneGroup=sceneGroup;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
}
