/**
 * 
 */
package forscene.core.entities.objects;

import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.PlayN;
import forscene.system.Asserts;
import forscene.system.managers.ResourceManager;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractSimpleSceneObject.
 * 
 * @author Scuderi Giovanni Luca {Lebby} mail:glscud@gmail.com
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
   * @param image
   *          the new image
   */
  public void setImage(Image image) {
    Asserts.check(image != null, "image can't be null");
    getRoot().setImage(image);
    setToUpdate(true);
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
   * @param url
   *          the url
   */
  public void loadImage(String url) {
    Asserts.check(url != null, "url can't be null");
    Asserts.check(url != "", "url can't be void");
    Image image = ResourceManager.getImage(url);
    setImage(image);
  }

}
