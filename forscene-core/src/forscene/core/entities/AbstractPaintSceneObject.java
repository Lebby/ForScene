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
public abstract class AbstractPaintSceneObject extends AbstractSceneObjectGroup {

  /** The canvas. */
  private Canvas      canvas;
  // container of canvas
  /** The canvas image. */
  private CanvasImage canvasImage;

  private ImageLayer  imageLayer;

  /**
   * @return the imageLayer
   */
  public ImageLayer getImageLayer() {
    return imageLayer;
  }

  /**
   * @param imageLayer
   *          the imageLayer to set
   */
  public void setImageLayer(ImageLayer imageLayer) {
    this.imageLayer = imageLayer;
    getRoot().clear();
    getRoot().add(imageLayer);
  }

  /**
   * Instantiates a new abstract paint scene object.
   */
  public AbstractPaintSceneObject() {
    setCanvasImage(PlayN.graphics().createImage(
        AbstractGameLoopManager.getInstance().getWidth(),
        AbstractGameLoopManager.getInstance().getHeight()));
    setCanvas(getCanvasImage().canvas());
    getCanvas().clear();
    imageLayer = PlayN.graphics().createImageLayer(getCanvasImage());
    setRoot(PlayN.graphics().createGroupLayer());
    getRoot().add(imageLayer);
  }

  /**
   * Gets the canvas.
   * 
   * @return the canvas
   */
  public Canvas getCanvas() {
    return canvas;
  }

  /**
   * @return the canvasImage
   */
  protected CanvasImage getCanvasImage() {
    return canvasImage;
  }

  /**
   * @param canvasImage
   *          the canvasImage to set
   */
  protected void setCanvasImage(CanvasImage canvasImage) {
    this.canvasImage = canvasImage;
  }

  /**
   * @param canvas
   *          the canvas to set
   */
  protected void setCanvas(Canvas canvas) {
    this.canvas = canvas;
  }

}
