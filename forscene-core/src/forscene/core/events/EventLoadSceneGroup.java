package forscene.core.events;

import playn.core.PlayN;

import forscene.core.LoopController.GameLoopManager;
import forscene.core.entities.AbstractSceneGroup;


public class EventLoadSceneGroup extends AbstractEvent{

	private AbstractSceneGroup scene;
	
	public EventLoadSceneGroup(AbstractSceneGroup scene)
	{
		PlayN.log().debug("EventLoadSceneGroup scene: " + scene );
		this.scene=scene;		
	}
	
	@Override
	public void run() { 
		//GameLoopController.loadSceneGroup(sceneGroup);
		PlayN.log().debug("EventLoadSceneGroup RUN scene: " + scene );
		GameLoopManager.getInstance().loadSceneGroup(scene);
		//EventMonitor.getInstance().push(new EventLoadScene(scene.getFirstScene()));
	}	

}
