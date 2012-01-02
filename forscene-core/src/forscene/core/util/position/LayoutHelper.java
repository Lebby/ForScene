package forscene.core.util.position;

import playn.core.ImageLayer;
import pythagoras.f.Point;

public class LayoutHelper {
	private static LayoutHelper instance;
	private LayoutHelper() {
	}
	public static LayoutHelper getInstance()
	{
		if (instance != null ) return instance;
		else
		{
			instance= new LayoutHelper();
			return instance;			
		}
	}
	
	public Point getCenter(ImageLayer layer)
	{
		Point p = new Point();
		p.set(layer.scaledWidth()/2+layer.originX(), layer.scaledHeight()/2+layer.originY());		
		return p;		
	}
	
}
