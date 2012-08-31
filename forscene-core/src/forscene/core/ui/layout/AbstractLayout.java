/*
 * 
 */
package forscene.core.ui.layout;

import forscene.core.entities.objects.AbstractSceneObject;
import forscene.core.entities.objects.AbstractSceneObjectGroup;
import forscene.exceptions.IDAlreadyPresentException;
import forscene.exceptions.NoNameException;

// TODO: Auto-generated Javadoc
// pseudo decorator ...
/**
 * The Class AbstractLayout.
 */
public abstract class AbstractLayout extends AbstractSceneObjectGroup implements
    ILayout {

  /** The current layout. */
  protected AbstractLayout currentLayout;

  /** The height. */
  private float            height;

  /** The width. */
  private float            width;

  /*
   * (non-Javadoc)
   * 
   * @see
   * forscene.core.entities.AbstractSceneObjectGroup#addSceneObject(forscene
   * .core.entities.AbstractSceneObject)
   */
  @Override
  public void addSceneObject(AbstractSceneObject<?> object)
      throws NoNameException {
    layout(object);

    try {

      super.addSceneObject(object);

    } catch (IDAlreadyPresentException e) {
      e.printStackTrace();
    }

    setToUpdate(true);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * forscene.core.entities.AbstractSceneObjectGroup#addSceneObject(java.lang
   * .String, forscene.core.entities.AbstractSceneObject)
   */
  @Override
  public void addSceneObject(String name, AbstractSceneObject<?> object)
      throws NoNameException, IDAlreadyPresentException {
    layout(object);
    setToUpdate(true);
    super.addSceneObject(name, object);
  }

  /**
   * Sets the layout.
   * 
   * @param layout
   *          the new layout
   */
  public void setLayout(AbstractLayout layout) {
    currentLayout = layout;
  }

  // public abstract void layout(AbstractSceneObject object);

  /**
   * Gets the width.
   * 
   * @return the width
   */
  public float getWidth() {
    return width;
  }

  /**
   * Gets the height.
   * 
   * @return the height
   */
  public float getHeight() {
    return height;
  }

  /**
   * Sets the height.
   * 
   * @param height
   *          the new height
   */
  public void setHeight(float height) {
    this.height = height;
  }

  /**
   * Sets the width.
   * 
   * @param width
   *          the new width
   */
  public void setWidth(float width) {
    this.width = width;
  }

}
