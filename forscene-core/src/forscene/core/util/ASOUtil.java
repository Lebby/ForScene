package forscene.core.util;

import forscene.core.entities.AbstractSceneObject;
import forscene.core.entities.ISceneObject;

public class ASOUtil {
	public static ISceneObject drawBorder(final AbstractSceneObject object)
	{
		ISceneObject tmp = new AbstractSceneObjectBorder(object);
		return tmp;		
	}
}
