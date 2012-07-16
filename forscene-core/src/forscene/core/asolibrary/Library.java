package forscene.core.asolibrary;

import java.util.LinkedList;
import java.util.Set;

import forscene.core.entities.AbstractSceneObject;
import forscene.system.entities.Resource;

//TODO: NOT TESTED ... NOT USED
public class Library {
  private static Library instance = null;

  public static Library getInstance() {
    if (Library.instance == null) {
      Library.instance = new Library();
    }
    return Library.instance;
  }

  private LinkedList<AbstractSceneObject<?>> objectsList;
  private LinkedList<Resource<?>>            resourcesList;

  private Set<ASOType>                       types;

  private Library() {
  }

  // TODO: TO IMPLEMENT
  public void addObject(AbstractSceneObject<?> object) {

  }

  // TODO: TO IMPLEMENT
  public void addResource(Resource<?> object) {

  }

  // TODO: TO IMPLEMENT
  public void getObject(AbstractSceneObject<?> object) {

  }

  // TODO: TO IMPLEMENT
  public void getResource(Resource<?> object) {

  }

  /*
   * public AbstractSceneObject getObjectByID(long ID) { for (Iterator iterator
   * = objects.iterator(); iterator.hasNext();) { AbstractSceneObject value =
   * (AbstractSceneObject) iterator.next(); if (value.getID() == ID) return
   * value; } return null; }
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

  public LinkedList<AbstractSceneObject<?>> getObjects() {
    return objectsList;
  }

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

  public Set<ASOType> getTypes() {
    return types;
  }

  public void setObjects(LinkedList<AbstractSceneObject<?>> objects) {
    objectsList = objects;
  }

  public void setTypes(Set<ASOType> types) {
    this.types = types;
  }

}