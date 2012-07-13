/**
 * 
 */
package forscene.core.entities;

import forscene.core.util.GraphicFactory;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.PlayN;

/**
 * @author blackdevil
 *
 */
public abstract class AbstractSimpleSceneObject extends AbstractSceneObject<ImageLayer>{
	
	/**
	 * 
	 */
	public AbstractSimpleSceneObject() {
		setRoot(PlayN.graphics().createImageLayer());
	}

	/* (non-Javadoc)
	 * @see forscene.core.entities.ISceneObject#updateState()
	 */
	public void updateState() {
	}

	
	
	public void setImage(Image image)
	{
		getRoot().setImage(image);
	}
	
	public Image getImage()
	{
		return getRoot().image();
	}	
	
	public void loadImage(String url)
	{
		Image image = GraphicFactory.loadImage(url);
		setImage(image);
	}

}
