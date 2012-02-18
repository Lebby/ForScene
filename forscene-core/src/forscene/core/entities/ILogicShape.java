package forscene.core.entities;

// TODO: Auto-generated Javadoc
/**
 * The Interface ILogicShape.
 */
public interface ILogicShape {	
	
	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	float getWidth();
	
	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	float getHeight();
	
	/**
	 * Contains.
	 *
	 * @param x the x
	 * @param y the y
	 * @return true, if successful
	 */
	boolean contains(float x, float y);
	
	/**
	 * Gets the center x.
	 *
	 * @return the center x
	 */
	float getCenterX();
	
	/**
	 * Gets the center y.
	 *
	 * @return the center y
	 */
	float getCenterY();
	
	/**
	 * Gets the max x.
	 *
	 * @return the max x
	 */
	float getMaxX();
	
	/**
	 * Gets the max y.
	 *
	 * @return the max y
	 */
	float getMaxY();
	
	/**
	 * Gets the min x.
	 *
	 * @return the min x
	 */
	float getMinX();
	
	/**
	 * Gets the min y.
	 *
	 * @return the min y
	 */
	float getMinY();
}
