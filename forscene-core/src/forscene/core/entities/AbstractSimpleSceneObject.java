/**
 * 
 */
package forscene.core.entities;

import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.PlayN;
import forscene.system.managers.ResourceManager;

/**
 * @author blackdevil
 * 
 */
public abstract class AbstractSimpleSceneObject extends
    AbstractSceneObject<ImageLayer> {

  /**
	 * 
	 */
  public AbstractSimpleSceneObject() {
    super();
    setRoot(PlayN.graphics().createImageLayer());
  }

  public void setImage(Image image) {
    getRoot().setImage(image);
  }

  public Image getImage() {
    return getRoot().image();
  }

  public void loadImage(String url) {
    Image image = ResourceManager.loadImage(url);
    setImage(image);
  }

}
