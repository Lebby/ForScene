/*
 * 
 */
package forscene.system;

import playn.core.Layer;

// TODO: Auto-generated Javadoc
/**
 * The Interface LayerObject.
 *
 * @param <T> the generic type
 */
public interface LayerObject<T extends Layer> {
	
	/**
	 * Gets the root.
	 *
	 * @return the root
	 */
	T getRoot();
	
	/**
	 * Sets the root.
	 *
	 * @param root the new root
	 */
	void setRoot(T root);
}
