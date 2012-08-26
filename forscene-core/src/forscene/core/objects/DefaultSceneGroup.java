/*
 * 
 */
package forscene.core.objects;

import forscene.core.entities.AbstractSceneGroup;

// TODO: Auto-generated Javadoc
/**
 * The Class DefaultSceneGroup.
 */
public class DefaultSceneGroup extends AbstractSceneGroup {

  /** The instance. */
  private static AbstractSceneGroup instance = null;

  /**
   * Instantiates a new default scene group.
   */
  private DefaultSceneGroup() {
    super();
  }

  /**
   * Gets the single instance of DefaultSceneGroup.
   * 
   * @return single instance of DefaultSceneGroup
   */
  public static AbstractSceneGroup getInstance() {
    if (DefaultSceneGroup.instance != null) {
      return DefaultSceneGroup.instance;
    }
    DefaultSceneGroup.instance = new DefaultSceneGroup();
    return DefaultSceneGroup.instance;
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.entities.AbstractSceneGroup#build()
   */
  @Override
  public void build() {
  }

}
