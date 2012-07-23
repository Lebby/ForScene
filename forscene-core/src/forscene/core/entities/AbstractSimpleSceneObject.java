/**
 * 
 */
package forscene.core.entities;

import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.PlayN;
import forscene.system.managers.ResourceManager;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractSimpleSceneObject.
 *
 * @author blackdevil
 */
public abstract class AbstractSimpleSceneObject extends
    AbstractSceneObject<ImageLayer> {

  /**
   * Instantiates a new abstract simple scene object.
   */
  public AbstractSimpleSceneObject() {
    super();
    setRoot(PlayN.graphics().createImageLayer());
  }

  /**
   * Sets the image.
   *
   * @param image the new image
   */
  public void setImage(Image image) {
    getRoot().setImage(image);
  }

  /**
   * Gets the image.
   *
   * @return the image
   */
  public Image getImage() {
    return getRoot().image();
  }

  /**
   * Load image.
   *
   * @param url the url
   */
  public void loadImage(String url) {
    Image image = ResourceManager.loadImage(url);
    setImage(image);
  }

}
