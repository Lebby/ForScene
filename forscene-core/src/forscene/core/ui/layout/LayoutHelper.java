/*
 * 
 */
package forscene.core.ui.layout;

import playn.core.ImageLayer;
import pythagoras.f.Point;

// TODO: Auto-generated Javadoc
/**
 * The Class LayoutHelper.
 */
public class LayoutHelper {
	
	/** The instance. */
	private static LayoutHelper instance;
	
	/**
	 * Instantiates a new layout helper.
	 */
	private LayoutHelper() {
	}
	
	/**
	 * Gets the single instance of LayoutHelper.
	 *
	 * @return single instance of LayoutHelper
	 */
	public static LayoutHelper getInstance()
	{
		if (instance != null ) return instance;
		else
		{
			instance= new LayoutHelper();
			return instance;			
		}
	}
	
	/**
	 * Gets the center.
	 *
	 * @param layer the layer
	 * @return the center
	 */
	public Point getCenter(ImageLayer layer)
	{
		Point p = new Point();
		p.set(layer.scaledWidth()/2+layer.originX(), layer.scaledHeight()/2+layer.originY());		
		return p;		
	}
	
}
