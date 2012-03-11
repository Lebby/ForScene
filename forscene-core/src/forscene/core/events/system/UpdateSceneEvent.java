package forscene.core.events.system;

import playn.core.PlayN;
import forscene.core.LoopController.AbstractGameLoopManager;
import forscene.core.LoopController.GameLoopManager;
import forscene.core.entities.AbstractScene;

// TODO: Auto-generated Javadoc
/**
 * The Class EventUpdateScene.
 */
public class UpdateSceneEvent extends AbstractEvent{
	
	/** The scene. */
	AbstractScene scene;
	private static short tick = 0;

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
		tick++;
		
		if (((scene.isToUpdate()) || (scene.getUpdateRate() != 0 && tick%scene.getUpdateRate() == 0 )) )// || tick%25==0)
		{			
			if ((scene.getRoot() == null)|| (scene.getRoot().parent() == null)) return;
			scene.buildChild();   //MAYBE:WRONG! TODO: FIX OR CHECK THIS --- Fixed by pending childs			
			scene.updateState();			
		}
	}
	

}
