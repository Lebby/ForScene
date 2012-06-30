package forscene.core.util;

import static playn.core.PlayN.graphics;
import playn.core.ImageLayer;
import playn.core.Layer;
import forscene.core.LoopController.GameLoopManager;
import forscene.core.entities.AbstractSceneObject;


public class Sizer extends AbstractSceneObject {
	private Layer.HasSize sizer;
	@Override
	public void build() {
		
		sizer = graphics().createSurfaceLayer(
				GameLoopManager.getInstance().getWidth(), 
				GameLoopManager.getInstance().getHeight());
		setRoot(sizer);
		
	}

	@Override
	public void updateState() {
		// TODO Auto-generated method stub
		
	}

}
