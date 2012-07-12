package forscene.core.events.listener;

import playn.core.PlayN;
import forscene.core.entities.AbstractScene;
import forscene.core.events.system.EventManager;
import forscene.core.events.system.IEvent;
import forscene.core.events.system.LoadSceneEvent;

public abstract class OnLoad extends  AbstractEventListener{
	private AbstractScene scene;	

	public OnLoad(AbstractScene scene) {
		this.scene = scene;		
	}
	
	@Override
	public boolean check() 
	{
		IEvent currEvent= EventManager.getInstance().getCurrentEvent();
		if (currEvent.getName().compareTo("LoadSceneEvent")==0)
		{
			LoadSceneEvent event = (LoadSceneEvent) currEvent;
			if (event.getScene() == scene)
			{
				PlayN.log().debug("DONE");
				return true;
			}
		}
		return false;
	}
	
	public AbstractScene getScene()
	{
		return scene;
	}
	
}