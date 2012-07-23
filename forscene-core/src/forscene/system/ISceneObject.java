/*
 * 
 */
package forscene.system;

import forscene.core.entities.AbstractSceneObjectGroup;
import forscene.system.entities.ForSceneObject;
import forscene.system.entities.ObjectID;
import playn.core.Layer;

// TODO: Auto-generated Javadoc
/**
 * The Interface ISceneObject.
 *
 * @param <T> the generic type
 */
public interface ISceneObject<T extends Layer> 
extends LayerObject<T> , ForSceneObject{

	/**
	 * Checks if is to update.
	 *
	 * @return true, if is to update
	 */
	public abstract boolean isToUpdate();

	/**
	 * Sets the to update.
	 *
	 * @param toUpdate the new to update
	 */
	public abstract void setToUpdate(boolean toUpdate);	
	
	/**
	 * Update draw.
	 *
	 * @param layer the layer
	 */
	public abstract void updateDraw(Layer layer);

	/**
	 * Builds the.
	 */
	public abstract void build();

	/**
	 * Builds the once.
	 */
	public abstract void buildOnce();

	/**
	 * Update state.
	 */
	public abstract void updateState();	

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public abstract String getName();

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public abstract void setName(String name);

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public abstract String getType();

	/**
	 * System build.
	 */
	public abstract void systemBuild();

	/**
	 * Contains.
	 *
	 * @param x the x
	 * @param y the y
	 * @return true, if successful
	 */
	public abstract boolean contains(int x, int y);

	/**
	 * Sets the update rate.
	 *
	 * @param rate the new update rate
	 */
	public abstract void setUpdateRate(long rate);

	/**
	 * Gets the update rate.
	 *
	 * @return the update rate
	 */
	public abstract long getUpdateRate();

	/**
	 * Sets the iD.
	 *
	 * @param objectID the new iD
	 */
	public abstract void setID(ObjectID objectID);

	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	public abstract AbstractSceneObjectGroup getParent();

	/**
	 * Sets the parent.
	 *
	 * @param parent the new parent
	 */
	public abstract void setParent(AbstractSceneObjectGroup parent);

	/**
	 * Checks for parent.
	 *
	 * @return true, if successful
	 */
	public abstract boolean hasParent();

	/**
	 * Checks if is builded.
	 *
	 * @return the builded
	 */
	public abstract boolean isBuilded();

	/**
	 * Hide.
	 */
	public abstract void hide();

	/**
	 * Show.
	 */
	public abstract void show();

	/**
	 * Checks if is visible.
	 *
	 * @return true, if is visible
	 */
	public abstract boolean isVisible();

}