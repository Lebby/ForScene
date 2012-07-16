/**
 * 
 */
package forscene.core.entities.toTest;

import playn.core.Canvas;
import playn.core.CanvasImage;
import playn.core.ImageLayer;
import playn.core.PlayN;
import forscene.core.entities.AbstractSimpleSceneObject;
import forscene.system.managers.AbstractGameLoopManager;

/**
 * @author blackdevil
 * 
 */
public abstract class AbstractPaintSceneObject extends
    AbstractSimpleSceneObject {

  private Canvas      canvas;
  // container of canvas
  private CanvasImage canvasImage;

  public AbstractPaintSceneObject() {
    canvasImage = PlayN.graphics().createImage(
        AbstractGameLoopManager.getInstance().getWidth(),
        AbstractGameLoopManager.getInstance().getHeight());
    canvas = canvasImage.canvas();
    canvas.clear();
    ImageLayer immLayer = PlayN.graphics().createImageLayer(canvasImage);
    setRoot(immLayer);
  }

  /**
   * @return the canvas
   */
  public Canvas getCanvas() {
    return canvas;
  }

}
