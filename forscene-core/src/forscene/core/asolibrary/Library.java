/*
 * 
 */
package forscene.core.asolibrary;

import java.util.LinkedList;
import java.util.Set;

import forscene.core.entities.AbstractSceneObject;
import forscene.system.entities.Resource;

// TODO: Auto-generated Javadoc
//TODO: NOT TESTED ... NOT USED
/**
 * The Class Library.
 */
public class Library {
  
  /** The instance. */
  private static Library instance = null;

  /**
   * Gets the single instance of Library.
   *
   * @return single instance of Library
   */
  public static Library getInstance() {
    if (Library.instance == null) {
      Library.instance = new Library();
    }
    return Library.instance;
  }

  /** The objects list. */
  private LinkedList<AbstractSceneObject<?>> objectsList;
  
  /** The resources list. */
  private LinkedList<Resource<?>>            resourcesList;

  /** The types. */
  private Set<ASOType>                       types;

  /**
   * Instantiates a new library.
   */
  private Library() {
  }

  // TODO: TO IMPLEMENT
  /**
   * Adds the object.
   *
   * @param object the object
   */
  public void addObject(AbstractSceneObject<?> object) {

  }

  // TODO: TO IMPLEMENT
  /**
   * Adds the resource.
   *
   * @param object the object
   */
  public void addResource(Resource<?> object) {

  }

  // TODO: TO IMPLEMENT
  /**
   * Gets the object.
   *
   * @param object the object
   * @return the object
   */
  public void getObject(AbstractSceneObject<?> object) {

  }

  // TODO: TO IMPLEMENT
  /**
   * Gets the resource.
   *
   * @param object the object
   * @return the resource
   */
  public void getResource(Resource<?> object) {

  }

  /*
   * public AbstractSceneObject getObjectByID(long ID) { for (Iterator iterator
   * = objects.iterator(); iterator.hasNext();) { AbstractSceneObject value =
   * (AbstractSceneObject) iterator.next(); if (value.getID() == ID) return
   * value; } return null; }
   */

  /**
   * Gets the object by name.
   *
   * @param name the name
   * @return the object by name
   */
  public AbstractSceneObject<?> getObjectByName(String name) {
    for (Object element : objectsList) {
      AbstractSceneObject<?> value = (AbstractSceneObject<?>) element;
      if (value.getName() == name) {
        return value;
      }
    }
    return null;
  }

  /**
   * Gets the objects.
   *
   * @return the objects
   */
  public LinkedList<AbstractSceneObject<?>> getObjects() {
    return objectsList;
  }

  /**
   * Gets the objects by type.
   *
   * @param type the type
   * @return the objects by type
   */
  public AbstractSceneObject<?>[] getObjectsByType(String type) {
    LinkedList<AbstractSceneObject<?>> tmp = new LinkedList<AbstractSceneObject<?>>();
    for (Object element : objectsList) {
      AbstractSceneObject<?> value = (AbstractSceneObject<?>) element;
      if (value.getType() == type) {
        tmp.add(value);
      }
    }
    return null;
  }

  /**
   * Gets the types.
   *
   * @return the types
   */
  public Set<ASOType> getTypes() {
    return types;
  }

  /**
   * Sets the objects.
   *
   * @param objects the new objects
   */
  public void setObjects(LinkedList<AbstractSceneObject<?>> objects) {
    objectsList = objects;
  }

  /**
   * Sets the types.
   *
   * @param types the new types
   */
  public void setTypes(Set<ASOType> types) {
    this.types = types;
  }

}