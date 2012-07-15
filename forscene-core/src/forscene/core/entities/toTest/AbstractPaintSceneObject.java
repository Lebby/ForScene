/**
 * 
 */
package forscene.core.entities.toTest;

import playn.core.Canvas;
import playn.core.CanvasImage;
import playn.core.ImageLayer;
import playn.core.SurfaceLayer;
import static playn.core.PlayN.graphics;
import forscene.core.entities.AbstractSceneObject;
import forscene.core.entities.AbstractSimpleSceneObject;
import forscene.core.entities.bridges.FCanvasLayer;
import forscene.system.managers.GameLoopManager;



/**
 * @author blackdevil
 *
 */
public abstract class AbstractPaintSceneObject extends AbstractSimpleSceneObject {
	
	private Canvas canvas;
	//container of canvas
	private CanvasImage canvasImage;
	
	AbstractPaintSceneObject()
	{
		canvasImage = graphics().createImage(
				GameLoopManager.getInstance().getWidth(),
				GameLoopManager.getInstance().getHeight());				
		canvas = canvasImage.canvas();
		canvas.clear(); 
		ImageLayer immLayer = graphics().createImageLayer(canvasImage);
		setRoot(immLayer);
	}

	/**
	 * @return the canvas
	 */
	public Canvas getCanvas() {
		return canvas;
	}
	
}
