/**
 * 
 */
package forscene.core.entities.toTest;

import playn.core.Image;
import playn.core.ImmediateLayer;
import playn.core.ImmediateLayer.Renderer;
import playn.core.PlayN;
import playn.core.Surface;
import forscene.core.entities.objects.AbstractSceneObject;
import forscene.system.Asserts;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractAnimatedSceneObject.
 * 
 * @author Scuderi Giovanni Luca {Lebby} mail:glscud@gmail.com
 */
public abstract class AbstractAnimatedSceneObject extends
    AbstractSceneObject<ImmediateLayer> {

  /** The surface. */
  private Surface surface;

  /** The image. */
  private Image   image;

  /** The autodraw. */
  boolean         autodraw = true;

  /** The x. */
  private float   x        = 0f;

  /** The y. */
  private float   y        = 0f;

  /**
   * Instantiates a new abstract animated scene object.
   */
  public AbstractAnimatedSceneObject() {

    ImmediateLayer imm = PlayN.graphics().createImmediateLayer(new Renderer() {
      // default render ...
      public void render(Surface surface) {
        if (!isBuilded()) {
          setSurface(surface);
          surface.clear();
        } else {
          if (isAutoDraw()) {
            surface.clear();
            innerDraw();
          } else {
            // call user defined updateDraw
            updateDraw();
          }
        }
      }
    });
    setRoot(imm);
    /*
     * SurfaceLayer layer = PlayN.graphics().createSurfaceLayer(
     * AbstractGameLoopManager.getInstance().getWidth(),
     * AbstractGameLoopManager.getInstance().getHeight()); surface =
     * sl.surface();
     */

  }

  /**
   * Sets the surface.
   * 
   * @param surface
   *          the new surface
   */
  protected void setSurface(Surface surface) {
    Asserts.check(surface != null, "surface can't be null");
    this.surface = surface;
  }

  /**
   * Gets the surface.
   * 
   * @return the surface
   */
  public Surface getSurface() {
    return surface;
  }

  /**
   * Update draw.
   */
  public abstract void updateDraw();

  /**
   * Update draw.
   * 
   * @param image
   *          the image
   * @param x
   *          the x
   * @param y
   *          the y
   */
  public void updateDraw(Image image, float x, float y) {
    Asserts.check(image != null, "image can't be null");
    Asserts.check((x * y) >= 0, "x,y can't be negative");
    surface.drawImage(image, x, y);
  }

  /**
   * Sets the x.
   * 
   * @param xPosition
   *          the new x
   */
  public void setX(float x) {
    this.x = x;
  }

  /**
   * Sets the y.
   * 
   * @param yPosition
   *          the new y
   */
  public void setY(float y) {
    this.y = y;
  }

  /**
   * Gets the x.
   * 
   * @return the x
   */
  public float getX() {
    return x;
  }

  /**
   * Gets the y.
   * 
   * @return the y
   */
  public float getY() {
    return y;
  }

  /**
   * Sets the image.
   * 
   * @param image
   *          the new image
   */
  public void setImage(Image image) {
    Asserts.check(image != null, "image can't be null");
    this.image = image;
  }

  /**
   * Gets the image.
   * 
   * @return the image
   */
  public Image getImage() {
    return image;
  }

  /**
   * Inner draw.
   */
  private void innerDraw() {
    if ((image != null) && (surface != null)) {
      surface.drawImage(image, x, y);
    }
  }

  /**
   * Sets the auto draw.
   * 
   * @param autodraw
   *          the new auto draw
   */
  public void setAutoDraw(boolean autodraw) {
    this.autodraw = autodraw;
  }

  /**
   * Checks if is auto draw.
   * 
   * @return true, if is auto draw
   */
  public boolean isAutoDraw() {
    return autodraw;
  }

}