/**
 * 
 */
package forscene.core.entities;

import playn.core.Canvas;
import playn.core.CanvasImage;
import playn.core.ImageLayer;
import playn.core.PlayN;
import forscene.system.managers.AbstractGameLoopManager;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractPaintSceneObject.
 *
 * @author Scuderi Giovanni Luca {Lebby} mail:glscud@gmail.com
 */
public abstract class AbstractPaintSceneObject extends
    AbstractSimpleSceneObject {

  /** The canvas. */
  private Canvas      canvas;
  // container of canvas
  /** The canvas image. */
  private CanvasImage canvasImage;

  /**
   * Instantiates a new abstract paint scene object.
   */
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
   * Gets the canvas.
   *
   * @return the canvas
   */
  public Canvas getCanvas() {
    return canvas;
  }

}
