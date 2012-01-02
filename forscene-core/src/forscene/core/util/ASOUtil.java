package forscene.core.util;

import forscene.core.entities.AbstractSceneObject;

public class ASOUtil {
	public static AbstractSceneObject drawBorder(final AbstractSceneObject object)
	{
		AbstractSceneObject tmp = new AbstractSceneObjectBorder(object);
		return tmp;		
	}
}
