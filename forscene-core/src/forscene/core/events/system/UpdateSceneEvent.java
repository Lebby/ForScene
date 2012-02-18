package forscene.core.events.system;

import forscene.core.entities.AbstractScene;

// TODO: Auto-generated Javadoc
/**
 * The Class EventUpdateScene.
 */
public class UpdateSceneEvent extends AbstractEvent{
	
	/** The scene. */
	AbstractScene scene;

	/**
	 * Instantiates a new event update scene.
	 *
	 * @param scene the scene
	 */
	public UpdateSceneEvent(AbstractScene scene) {
		this.scene = scene;
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.events.AbstractEvent#run()
	 */
	@Override
	public void run() {
		if (scene.isToUpdate())
			scene.updateState();		
	}
	

}
