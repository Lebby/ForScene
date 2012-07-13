package forscene.core.entities;

import forscene.core.entities.toTest.AbstractLogicShape;
import forscene.core.util.BasicShapeInfo;

// TODO: Auto-generated Javadoc
/**
 * The Class ShapeObject.
 */
public class ShapeObject extends AbstractLogicShape{
	
	/** The info. */
	private BasicShapeInfo info;	
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.ILogicShape#getMaxX()
	 */
	public float getMaxX() {
		info.getMaxX();
		return 0;
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.ILogicShape#getMaxY()
	 */
	public float getMaxY() {
		info.getMaxY();
		return 0;
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.ILogicShape#getMinX()
	 */
	public float getMinX() {
		info.getMinX();
		return 0;
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.ILogicShape#getMinY()
	 */
	public float getMinY() {
		info.getMinY();
		return 0;
	}
}
