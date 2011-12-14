package forscene.core.events;

import forscene.core.entities.AbstractScene;

public class EventUnloadScene extends AbstractEvent{
	private AbstractScene scene;	
	
	public EventUnloadScene(AbstractScene scene)
	{
		this.scene=scene;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
