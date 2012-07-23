/*
 * 
 */
package forscene.core.util;

import forscene.core.entities.AbstractSceneObject;
import forscene.system.ISceneObject;

// TODO: Auto-generated Javadoc
/**
 * The Class ASOUtil.
 */
public class ASOUtil {
	
	/**
	 * Draw border.
	 *
	 * @param object the object
	 * @return the i scene object
	 */
	public static ISceneObject drawBorder(final AbstractSceneObject object)
	{
		ISceneObject tmp = new AbstractSceneObjectBorder(object);
		return tmp;		
	}
}
