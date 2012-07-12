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
		//PlayN.log().debug("Update scene pushed on " + scene);
		this.scene = scene;
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.events.AbstractEvent#run()
	 */
	@Override
	public void run() {
		tick++;
		//PlayN.log().debug("Scene " + scene + " builded? "+ scene.isBuilded());
		if (scene.isBuilded())
		{
		/* old ...
		 * if (((scene.isToUpdate()) || (scene.getUpdateRate() != 0 && tick%scene.getUpdateRate() == 0 )) )
		{			
			if ((scene.getRoot() == null)|| (scene.getRoot().parent() == null)) return;
			//MAYBE:WRONG! TODO: FIX OR CHECK THIS --- Fixed by pending childs			
			
			scene.updateChilds();
			PlayN.log().debug(" calling UpdateScene : " + scene);
			scene.updateState();
			scene.setToUpdate(false);			
		}*/
			//new
			// It isn't attached to scenegraph or is void 
			if ((!scene.hasParent()) || (scene.getRoot() == null)) return;
			//PlayN.log().debug("UpdateScene has parent or root : " + scene);
			// It has a fixed update rate
			if (scene.getUpdateRate() != 0)
			{
				//PlayN.log().debug("UpdateScene fixed: precall");
				if (tick%scene.getUpdateRate() == 0)
				{
					scene.updateChilds();
					scene.updateState();
					//PlayN.log().debug("UpdateScene fixed: " + scene);
					//scene.setToUpdate(false);
				}
			}
			else //updateRate = 0 ... same as: "update when it needs"
			{
				//PlayN.log().debug("UpdateScene dynamic: precall isToUpdate " + scene.isToUpdate());
				if(scene.isToUpdate())
				{
					scene.updateChilds();
					scene.updateState();
					//scene.setToUpdate(false);
					//PlayN.log().debug("UpdateScene dynamic: " + scene);
				}
			}
		}
		//if (scene.getUpdateRate() == 0) setDone(true);		
	}
	

}
