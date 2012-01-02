package forscene.core.events;

import forscene.core.entities.AbstractScene;

public class EventUpdateScene extends AbstractEvent{
	AbstractScene scene;

	public EventUpdateScene(AbstractScene scene) {
		this.scene = scene;
	}
	@Override
	public void run() {
		if (scene.isToUpdate())
			scene.updateState();		
	}
	

}
