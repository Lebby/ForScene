package forscene.core.events.system;

import forscene.core.entities.AbstractScene;
import forscene.system.managers.AbstractGameLoopManager;


// TODO: Auto-generated Javadoc
/**
 * The Class EventDrawScene.
 */
public class DrawSceneEvent extends AbstractEvent {
	
	/** The scene. */
	protected AbstractScene scene;
	
	/**
	 * Instantiates a new event draw scene.
	 *
	 * @param scene the scene
	 */
	public DrawSceneEvent(AbstractScene scene)
	{
		this.scene=scene;
		this.setPriority(-1);
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.events.AbstractEvent#run()
	 */
	@Override
	public void run() {		
		AbstractGameLoopManager.getInstance().draw(scene);
		setDone(true);
	}
	
	


}
