/**
 * 
 */
package forscene.core.entities;

import playn.core.PlayN;
import playn.core.Surface;
import playn.core.SurfaceLayer;
import forscene.system.managers.AbstractGameLoopManager;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractFastPaintSceneObject.
 *
 * @author Scuderi Giovanni Luca {Lebby} mail:glscud@gmail.com
 */

// TODO: to add method of customization of surfaceLayer ( setRoot? )
public abstract class AbstractFastPaintSceneObject extends
    AbstractSceneObject<SurfaceLayer> {

  /**
   * Instantiates a new abstract fast paint scene object.
   */
  public AbstractFastPaintSceneObject() {
    SurfaceLayer layer = PlayN.graphics().createSurfaceLayer(
        AbstractGameLoopManager.getInstance().getWidth(),
        AbstractGameLoopManager.getInstance().getHeight());
    setRoot(layer);
  }

  /**
   * Gets the surface.
   *
   * @return the surface
   */
  public Surface getSurface() {
    return getRoot().surface();
  }
}
