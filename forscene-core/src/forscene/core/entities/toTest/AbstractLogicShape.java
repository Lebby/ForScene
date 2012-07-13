package forscene.core.entities.toTest;

import forscene.core.entities.ILogicShape;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractLogicShape.
 */
public abstract class AbstractLogicShape implements ILogicShape{

	/* (non-Javadoc)
	 * @see forscene.core.entities.ILogicShape#getWidth()
	 */
	public float getWidth() {
		return getMaxX()-getMinX();		
	}

	/* (non-Javadoc)
	 * @see forscene.core.entities.ILogicShape#getHeight()
	 */
	public float getHeight() {
		return getMaxY()-getMinY();		
	}

	/* (non-Javadoc)
	 * @see forscene.core.entities.ILogicShape#contains(float, float)
	 */
	public boolean contains(float x, float y) {		
		if ((x<getMaxX()) 
			&& (x>getMinX()) 
			&& (y<getMaxY()) 
			&& (y>getMinY())) return true;
		else return false;
	}

	/* (non-Javadoc)
	 * @see forscene.core.entities.ILogicShape#getCenterX()
	 */
	public float getCenterX() {
		return (getMaxX()+getMinX()/2);		
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.ILogicShape#getCenterY()
	 */
	public float getCenterY() {
		return (getMaxY()+getMinY()/2);
	}
	
}