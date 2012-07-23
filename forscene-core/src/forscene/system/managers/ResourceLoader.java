/**
 * 
 */
package forscene.system.managers;

import playn.core.ImageLayer;
import playn.core.Layer;
import playn.core.PlayN;
import forscene.core.entities.AbstractSceneObject;
import forscene.core.entities.AbstractSceneObjectGroup;

// TODO: Auto-generated Javadoc
/**
 * The Class ResourceLoader.
 *
 * @author blackdevil
 */
public class ResourceLoader {

  /**
   * Adds the image.
   *
   * @param url the url
   * @param scene the scene
   * @return the image layer
   */
  public static ImageLayer addImage(String url, AbstractSceneObject<?> scene) {
    ImageLayer image = ResourceManager.loadImageLayer(url);

    if (scene instanceof AbstractSceneObjectGroup) {
      ((AbstractSceneObjectGroup) scene).getRoot().add(image);
      ResourceManager.getInstance().load(image);
    } else if (scene instanceof AbstractSceneObject) {
      ((AbstractSceneObject<Layer.HasSize>) scene).setRoot(image);
   }
    return image;
  }

}
