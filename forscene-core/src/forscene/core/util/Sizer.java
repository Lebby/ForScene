/*
 * 
 */
package forscene.core.util;

import static playn.core.PlayN.graphics;
import playn.core.Layer;
import forscene.core.entities.AbstractSceneObject;
import forscene.system.managers.GameLoopManager;


// TODO: Auto-generated Javadoc
/**
 * The Class Sizer.
 */
public class Sizer extends AbstractSceneObject<Layer.HasSize> {
	
	/** The sizer. */
	private Layer.HasSize sizer;
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.AbstractSceneObject#build()
	 */
	@Override
	public void build() {
		
		sizer = graphics().createSurfaceLayer(
				GameLoopManager.getInstance().getWidth(), 
				GameLoopManager.getInstance().getHeight());
		setRoot(sizer);
		
	}

	
	/* (non-Javadoc)
	 * @see forscene.system.ISceneObject#updateState()
	 */
	public void updateState() {
		// TODO Auto-generated method stub
		
	}

}
