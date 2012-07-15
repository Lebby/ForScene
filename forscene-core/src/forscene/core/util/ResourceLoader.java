/**
 * 
 */
package forscene.core.util;

import static playn.core.PlayN.graphics;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Layer;
import playn.core.PlayN;
import playn.core.Sound;
import forscene.core.entities.AbstractSceneObject;
import forscene.core.entities.AbstractSceneObjectGroup;
import forscene.system.managers.ResourceManager;

/**
 * @author blackdevil
 *
 */
public class ResourceLoader {

	public static ImageLayer addImage(String url,AbstractSceneObject<?> scene)
	{
		ImageLayer image = loadImageLayer(url);
		
		if (scene instanceof AbstractSceneObjectGroup)
		{
			((AbstractSceneObjectGroup)scene).getRoot().add(image);
			ResourceManager.getInstance().load(image);
		}
		else if (scene instanceof AbstractSceneObject)
		{
			((AbstractSceneObject<Layer.HasSize>)scene).setRoot(image);
		}
		
		//#Debug
		PlayN.log().debug("addImage debug: " + image);
		return image;
	}
	
	public static Image loadImage(String url)
	{
		Image image = PlayN.assets().getImage(url);
		ResourceManager.getInstance().load(image);
	    return image;
	}
	
	public static ImageLayer loadImageLayer(String url)
	{
		Image bgImage = PlayN.assets().getImage(url);
	    ImageLayer bgLayer = graphics().createImageLayer(bgImage);
	    ResourceManager.getInstance().load(bgImage);
	    return bgLayer;
	}
	
	public static Sound loadSound(String url)
	{
		Sound sound = PlayN.assets().getSound(url);
		ResourceManager.getInstance().load(sound);
		return sound;
	}	

}
