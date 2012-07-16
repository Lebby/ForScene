package forscene.core.entities;

import java.util.PriorityQueue;
import java.util.TreeSet;

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
  private TreeSet<ObjectID>       childs;
  private PriorityQueue<ObjectID> pendingChilds;

  /**
   * Instantiates a new abstract scene object group.
   */
  public AbstractSceneObjectGroup() {
    super();
    setRoot(GraphicFactory.createGroupLayer());
    getRoot().clear();
    childs = new TreeSet<ObjectID>();
    pendingChilds = new PriorityQueue<ObjectID>();
  }

  /**
   * Adds the scene object.
   * 
   * @param <T>
   * 
   * @param object
   *          the object
   * @throws NoNameException
   *           the no name exception
   * @throws IDAlreadyPresentException
   */
  public void addSceneObject(AbstractSceneObject<?> object)
      throws NoNameException, IDAlreadyPresentException {
    if ((object.getName() == null) || (object.getName() == "")) {
      PlayN.log().debug("ERROR");
      throw new NoNameException();

    }

    ObjectID element = new ObjectID(object);
    if (!pendingChilds.add(element)) {
      PlayN.log().debug("ERROR ID");
      throw new IDAlreadyPresentException();
    }

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
   */
  public void addSceneObject(String name, AbstractSceneObject<?> object)
      throws NoNameException, IDAlreadyPresentException {
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
  public AbstractSceneObject<?> getSceneObject(int i) {
    return (AbstractSceneObject<?>) childs.toArray()[i];
  }

  /**
   * Builds the child.
   */
  public void buildChilds() {
    ObjectID element = pendingChilds.poll();
    // PlayN.log().debug("Object " + this);
    while (element != null) {
      childs.add(element);
      element.getInstance().buildOnce();
      element.getInstance().setParent(this);
      element.getInstance().setToUpdate(true);
      // element.getInstance().setToUpdate(false);

      if (!element.getInstance().isToUpdate()) {
        // PlayN.log().debug("BuildChild " + element.getInstance() +
        // "isToUpdate " + element.getInstance().isToUpdate());
        if (element.getInstance() instanceof AbstractSceneObjectGroup) {
          ((AbstractSceneObjectGroup) element.getInstance()).buildChilds();
        }
      }
      getRoot().add(element.getInstance().getRoot());
      element = pendingChilds.poll();
    }
    // setToUpdate(false);
    setToUpdate(true);
  }

  public void updateChilds() {
    // call update on child builded
    // PlayN.log().debug("Childs size:" + childs.size());
    for (ObjectID obj : childs) {
      if (obj.getInstance() instanceof AbstractSceneObjectGroup) {
        AbstractSceneObjectGroup objGroup = (AbstractSceneObjectGroup) obj
            .getInstance();
        // objGroup.updateChilds();
        // i think this is wrong ... why rebuild Childs?
        /*
         * if (objGroup.pendingChilds.size() > 0) { objGroup.buildChilds(); }
         */
        // objGroup.updateState();
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
  public TreeSet<ObjectID> getChilds() {
    return childs;
  }

  /**
   * Sets the childs.
   * 
   * @param childs
   *          the new childs
   */
  public void setChilds(TreeSet<ObjectID> childs) {
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

  @Override
  public void systemBuild() {
    build();
    buildChilds();
    while (!ResourceManager.getInstance().isReady()) {
      ResourceManager.getInstance().loadResources();
    }
    setBuilded(true);
  }

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