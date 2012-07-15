/**
 * 
 */
package forscene.core.entities.toTest;

import java.awt.Graphics;

import playn.core.SurfaceLayer;
import forscene.core.entities.AbstractSceneObject;
import forscene.system.managers.GameLoopManager;
import static playn.core.PlayN.graphics;
/**
 * @author blackdevil
 *
 */
public abstract class AbstractFastDrawSceneObject extends AbstractSceneObject<SurfaceLayer> {
	
	AbstractFastDrawSceneObject()
	{
		SurfaceLayer layer = graphics().createSurfaceLayer(
				GameLoopManager.getInstance().getWidth(),
				GameLoopManager.getInstance().getHeight());				
	}
	
	public void getSurface()
	{
		getRoot().surface();
	}
}
