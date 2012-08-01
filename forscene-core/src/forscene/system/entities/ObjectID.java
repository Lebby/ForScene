/*
 * 
 */
package forscene.system.entities;

import forscene.core.asolibrary.ASOType;
import forscene.core.entities.AbstractSceneObject;

// TODO: Auto-generated Javadoc
/**
 * The Class ObjectID.
 */
public class ObjectID implements Comparable<ObjectID>, ForSceneObject {

  /** The ID. */
  private long                   ID;

  /** The name. */
  private String                 name = "";

  /** The instance. */
  private AbstractSceneObject<?> instance;

  /** The type. */
  private ASOType                type;

  /**
   * Instantiates a new object id.
   * 
   * @param instance
   *          the instance
   */
  public ObjectID(AbstractSceneObject<?> instance) {
    this.instance = instance;
    // TODO: change when json rappresentation is implemented
    setName(instance.toString());
  }

  /**
   * Gets the name.
   * 
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   * 
   * @param name
   *          the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the single instance of ObjectID.
   * 
   * @return single instance of ObjectID
   */
  public AbstractSceneObject<?> getInstance() {
    return instance;
  }

  /**
   * Sets the instance.
   * 
   * @param instance
   *          the new instance
   */
  public void setInstance(AbstractSceneObject<?> instance) {
    this.instance = instance;
  }

  /**
   * Gets the type.
   * 
   * @return the type
   */
  public String getType() {
    return type.getType();
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  public int compareTo(ObjectID arg0) {
    return getName().compareTo(arg0.getName());
  }

  // TODO: TO FIX BY LIBRAY IMPLEMENTATION
  /*
   * (non-Javadoc)
   * 
   * @see forscene.system.entities.ForSceneObject#getObjectID()
   */
  public ObjectID getObjectID() {
    return this;
  }

  // TODO: TO FIX BY LIBRAY IMPLEMENTATION
  /*
   * (non-Javadoc)
   * 
   * @see forscene.system.entities.ForSceneObject#getID()
   */
  public long getID() {
    return ID;
  }

}