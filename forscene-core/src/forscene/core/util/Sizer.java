package forscene.core.util;

import static playn.core.PlayN.graphics;
import playn.core.Layer;
import forscene.core.LoopController.GameLoopManager;
import forscene.core.entities.AbstractSceneObject;


public class Sizer extends AbstractSceneObject<Layer.HasSize> {
	private Layer.HasSize sizer;
	@Override
	public void build() {
		
		sizer = graphics().createSurfaceLayer(
				GameLoopManager.getInstance().getWidth(), 
				GameLoopManager.getInstance().getHeight());
		setRoot(sizer);
		
	}

	
	public void updateState() {
		// TODO Auto-generated method stub
		
	}

}
