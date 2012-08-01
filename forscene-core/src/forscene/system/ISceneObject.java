/*
 * 
 */
package forscene.system;

import playn.core.Layer;
import forscene.core.entities.AbstractSceneObjectGroup;
import forscene.system.entities.ForSceneObject;
import forscene.system.entities.ObjectID;

// TODO: Auto-generated Javadoc
/**
 * The Interface ISceneObject.
 * 
 * @param <T>
 *          the generic type
 */
public interface ISceneObject<T extends Layer> extends LayerObject<T>,
    ForSceneObject {

  /**
   * Checks if is to update.
   * 
   * @return true, if is to update
   */
  abstract boolean isToUpdate();

  /**
   * Sets the to update.
   * 
   * @param toUpdate
   *          the new to update
   */
  abstract void setToUpdate(boolean toUpdate);

  /**
   * Update draw.
   * 
   * @param layer
   *          the layer
   */
  abstract void updateDraw(Layer layer);

  /**
   * Builds the.
   */
  abstract void build();

  /**
   * Builds the once.
   */
  abstract void buildOnce();

  /**
   * Update state.
   */
  abstract void updateState();

  /**
   * Gets the name.
   * 
   * @return the name
   */
  abstract String getName();

  /**
   * Sets the name.
   * 
   * @param name
   *          the new name
   */
  abstract void setName(String name);

  /**
   * Gets the type.
   * 
   * @return the type
   */
  abstract String getType();

  /**
   * System build.
   */
  abstract void systemBuild();

  /**
   * Contains.
   * 
   * @param x
   *          the x
   * @param y
   *          the y
   * @return true, if successful
   */
  abstract boolean contains(int x, int y);

  /**
   * Sets the update rate.
   * 
   * @param rate
   *          the new update rate
   */
  abstract void setUpdateRate(long rate);

  /**
   * Gets the update rate.
   * 
   * @return the update rate
   */
  abstract long getUpdateRate();

  /**
   * Sets the iD.
   * 
   * @param objectID
   *          the new iD
   */
  abstract void setID(ObjectID objectID);

  /**
   * Gets the parent.
   * 
   * @return the parent
   */
  abstract AbstractSceneObjectGroup getParent();

  /**
   * Sets the parent.
   * 
   * @param parent
   *          the new parent
   */
  abstract void setParent(AbstractSceneObjectGroup parent);

  /**
   * Checks for parent.
   * 
   * @return true, if successful
   */
  abstract boolean hasParent();

  /**
   * Checks if is builded.
   * 
   * @return the builded
   */
  abstract boolean isBuilded();

  /**
   * Hide.
   */
  abstract void hide();

  /**
   * Show.
   */
  abstract void show();

  /**
   * Checks if is visible.
   * 
   * @return true, if is visible
   */
  abstract boolean isVisible();

  abstract boolean isLoaded();

}