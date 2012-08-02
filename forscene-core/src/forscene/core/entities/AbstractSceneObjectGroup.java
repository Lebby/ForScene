/*
 * 
 */
package forscene.core.entities;

import java.util.ArrayList;

import playn.core.Asserts;
import playn.core.GroupLayer;
import playn.core.PlayN;
import forscene.core.util.GraphicFactory;
import forscene.exceptions.AbstractObjectNotFoundException;
import forscene.exceptions.IDAlreadyPresentException;
import forscene.exceptions.NoNameException;
import forscene.system.entities.ObjectID;
import forscene.system.managers.ResourceManager;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractSceneObjectGroup.
 */
public abstract class AbstractSceneObjectGroup extends
    AbstractSceneObject<GroupLayer> {

  // TODO: improve Object child
  /** The childs. */
  private ArrayList<ObjectID> childs;

  /** The pending childs. */
  private ArrayList<ObjectID> pendingChilds;

  /**
   * Instantiates a new abstract scene object group.
   */
  public AbstractSceneObjectGroup() {
    super();
    setRoot(GraphicFactory.createGroupLayer());
    getRoot().clear();
    childs = new ArrayList<ObjectID>();
    pendingChilds = new ArrayList<ObjectID>();
  }

  /**
   * Adds the scene object.
   * 
   * @param object
   *          the object
   * @throws NoNameException
   *           the no name exception
   * @throws IDAlreadyPresentException
   *           the iD already present exception
   */
  public void addSceneObject(AbstractSceneObject<?> object)
      throws NoNameException, IDAlreadyPresentException {
    Asserts.check(object != null, "object can't be null");
    if ((object.getName() == null) || (object.getName() == "")) {
      PlayN.log().debug("ERROR");
      throw new NoNameException();

    }

    ObjectID element = new ObjectID(object);
    if (!pendingChilds.add(element)) {
      PlayN.log().debug("ERROR ID");
      throw new IDAlreadyPresentException();
    }

    PlayN.log().debug("adding - " + pendingChilds.size() + " obj :" + element);

    setToUpdate(true);
  }

  /**
   * Adds the scene object.
   * 
   * @param name
   *          the name
   * @param object
   *          the object
   * @throws NoNameException
   *           the no name exception
   * @throws IDAlreadyPresentException
   *           the iD already present exception
   */
  public void addSceneObject(String name, AbstractSceneObject<?> object)
      throws NoNameException, IDAlreadyPresentException {
    Asserts.check(object != null, "object can't be null");
    Asserts.check(name != null, "name can't be null");
    Asserts.check(name != "", "name can't be void");
    object.setName(name);
    addSceneObject(object);
    setToUpdate(true);
  }

  /**
   * Removes the scene object.
   * 
   * @param object
   *          the object
   * @throws AbstractObjectNotFoundException
   *           the abstract object not found exception
   */
  public void removeSceneObject(AbstractSceneObject<?> object)
      throws AbstractObjectNotFoundException {
    Asserts.check(object != null, "object can't be null");
    if (childs.contains(object)) {
      object.setParent(null);
      childs.remove(object);
    } else {
      throw new AbstractObjectNotFoundException();
    }
    setToUpdate(true);
  }

  /**
   * Gets the scene object.
   * 
   * @param name
   *          the name
   * @return the scene object
   * @throws AbstractObjectNotFoundException
   *           the abstract object not found exception
   */
  public AbstractSceneObject<?> getSceneObject(String name)
      throws AbstractObjectNotFoundException {
    Asserts.check(name != null, "name can't be null");
    Asserts.check(name != "", "name can't be void");
    for (ObjectID type : childs) {
      if (type.getName() == name) {
        return type.getInstance();
      }
    }
    for (ObjectID type : pendingChilds) {
      if (type.getName() == name) {
        return type.getInstance();
      }
    }
    throw new AbstractObjectNotFoundException();
  }

  /**
   * Gets the scene object.
   * 
   * @param i
   *          the i
   * @return the scene object
   */
  public AbstractSceneObject<?> getSceneObject(int index) {
    Asserts.check(index >= 0, "index must be >=0");
    return (AbstractSceneObject<?>) childs.toArray()[index];
  }

  /**
   * Builds the child.
   */
  public void buildChilds() {
    PlayN.log().debug("ASGO : BuildChilds  p-childs : " + pendingChilds.size());
    PlayN.log().debug("ASGO : BuildChilds  childs : " + childs.size());
    ObjectID element;
    if (pendingChilds.size() > 0) {
      element = pendingChilds.get(0);
      pendingChilds.remove(0);
    } else {
      element = null;
    }

    while (element != null) {
      PlayN.log().debug("Object " + element.getName());
      childs.add(element);
      element.getInstance().buildOnce();
      element.getInstance().setParent(this);
      element.getInstance().setToUpdate(true);
      // element.getInstance().setToUpdate(false);

      if (!element.getInstance().isToUpdate()) {

        if (element.getInstance() instanceof AbstractSceneObjectGroup) {
          ((AbstractSceneObjectGroup) element.getInstance()).buildChilds();
        }
      }
      getRoot().add(element.getInstance().getRoot());
      if (pendingChilds.size() > 0) {
        element = pendingChilds.get(0);
        pendingChilds.remove(0);
      } else {
        element = null;
      }
    }

    // setToUpdate(false);
    // setToUpdate(true);
  }

  /**
   * Update childs.
   */
  public void updateChilds() {

    // call update on child builded
    for (ObjectID obj : childs) {
      if (obj.getInstance() instanceof AbstractSceneObjectGroup) {
        AbstractSceneObjectGroup objGroup = (AbstractSceneObjectGroup) obj
            .getInstance();
        objGroup.updateChilds();
        if (objGroup.pendingChilds.size() > 0) {
          objGroup.buildChilds();
        }
        objGroup.updateState();
      }
      obj.getInstance().updateState();
    }
    updateState();
  }

  /**
   * Gets the childs.
   * 
   * @return the childs
   */
  public ArrayList<ObjectID> getChilds() {
    return childs;
  }

  /**
   * Sets the childs.
   * 
   * @param childs
   *          the new childs
   */
  public void setChilds(ArrayList<ObjectID> childs) {
    Asserts.check(childs != null, "childs can't be null");
    this.childs = childs;
    setToUpdate(true);
  }

  /**
   * Gets the size.
   * 
   * @return the size
   */
  public int getSize() {
    return childs.size();
  }

  /**
   * Removes the all scene object child.
   */
  public void removeAllSceneObjectChild() {
    for (ObjectID type : childs) {
      if (type.getInstance() instanceof AbstractSceneObjectGroup) {
        ((AbstractSceneObjectGroup) type.getInstance())
            .removeAllSceneObjectChild();
      }

    }
    for (ObjectID type : childs) {
      try {
        removeSceneObject(type.getInstance());
      } catch (AbstractObjectNotFoundException e) {
        e.printStackTrace();
      }
    }
    setToUpdate(true);
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.entities.AbstractSceneObject#systemBuild()
   */
  @Override
  public void systemBuild() {
    build();
    buildChilds();
    // while (!ResourceManager.getInstance().isReady()) {
    ResourceManager.getInstance().loadResources();
    // }
    setBuilded(true);
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.entities.AbstractSceneObject#isToUpdate()
   */
  @Override
  public boolean isToUpdate() {
    if (pendingChilds.size() > 0) {
      return true;
    }

    for (ObjectID child : childs) {
      if (child.getInstance().isToUpdate()) {
        return true;
      }
    }
    return super.isToUpdate();
  }

}