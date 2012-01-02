package forscene.core.util;

import playn.core.GroupLayer;
import forscene.core.entities.AbstractSceneObject;
import forscene.exceptions.NoNameException;

public class ASOUtil {
	public static AbstractSceneObject drawBorder(final AbstractSceneObject object)
	{
		AbstractSceneObject tmp = new AbstractSceneObjectBorder(object);
		return tmp;		
	}
}
