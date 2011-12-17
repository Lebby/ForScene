package forscene.core.events;

import forscene.core.LoopController.AbstractGameLoopManager;
import forscene.core.entities.AbstractScene;


public class EventDrawScene extends AbstractEvent {
	AbstractScene scene;
	public EventDrawScene(AbstractScene scene)
	{
		this.scene=scene;
	}
	
	@Override
	public void run() {
		AbstractGameLoopManager.getInstance().draw(scene);
	}


}