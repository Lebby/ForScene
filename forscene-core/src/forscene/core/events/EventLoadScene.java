package forscene.core.events;

import forscene.core.LoopController.GameLoopManager;
import forscene.core.entities.AbstractScene;

public class EventLoadScene extends AbstractEvent{
	private AbstractScene scene;
	
	public EventLoadScene(AbstractScene scene) {
		this.scene = scene;
		this.setPriority(-1);
	}

	@Override
	public void run() {
		GameLoopManager.getInstance().loadScene(scene);
		if (scene.getKeyboardListener() != null) scene.getKeyboardListener().register();
		if (scene.getMouseListener() != null) scene.getMouseListener().register();
		this.setDone(true);
	}

}
