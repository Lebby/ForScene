package forscene.core.events.system;

import forscene.core.entities.AbstractScene;
import forscene.system.managers.AbstractGameLoopManager;

// TODO: Auto-generated Javadoc
/**
 * The Class EventLoadScene.
 */
public class LoadSceneEvent extends AbstractEvent{
	
	/** The scene. */
	private AbstractScene scene;
	
	/**
	 * Instantiates a new event load scene.
	 *
	 * @param scene the scene
	 */
	public LoadSceneEvent(AbstractScene scene) {
		this.scene = scene;
		this.setPriority(-1);
	}

	/* (non-Javadoc)
	 * @see forscene.core.events.AbstractEvent#run()
	 */
	
	@Override
	public void run() {
		AbstractGameLoopManager.getInstance().loadScene(scene);
		if (scene.getKeyboardListener() != null) scene.getKeyboardListener().register();
		if (scene.getMouseListener() != null) scene.getMouseListener().register();
		setDone(true);
	}
	
	public AbstractScene getScene() {
		return scene;
	}

}
