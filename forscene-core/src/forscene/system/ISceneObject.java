package forscene.system;

import forscene.core.entities.AbstractSceneObjectGroup;
import forscene.system.entities.ForSceneObject;
import forscene.system.entities.ObjectID;
import playn.core.Layer;

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

	public abstract void systemBuild();

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

	public abstract void setID(ObjectID objectID);

	public abstract AbstractSceneObjectGroup getParent();

	public abstract void setParent(AbstractSceneObjectGroup parent);

	public abstract boolean hasParent();

	/**
	 * @return the builded
	 */
	public abstract boolean isBuilded();

	public abstract void hide();

	public abstract void show();

	public abstract boolean isVisible();

}