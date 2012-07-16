/**
 * 
 */
package forscene.core.entities.toTest;

import playn.core.PlayN;
import playn.core.Surface;
import playn.core.SurfaceLayer;
import forscene.core.entities.AbstractSceneObject;
import forscene.system.managers.AbstractGameLoopManager;

/**
 * @author blackdevil
 * 
 */

// TODO: to add method of customization of surfaceLayer ( setRoot? )
public abstract class AbstractFastPaintSceneObject extends
    AbstractSceneObject<SurfaceLayer> {

  public AbstractFastPaintSceneObject() {
    SurfaceLayer layer = PlayN.graphics().createSurfaceLayer(
        AbstractGameLoopManager.getInstance().getWidth(),
        AbstractGameLoopManager.getInstance().getHeight());
    setRoot(layer);
  }

  public Surface getSurface() {
    return getRoot().surface();
  }
}
