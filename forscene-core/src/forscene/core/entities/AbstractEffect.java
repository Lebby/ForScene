/*
 * 
 */
package forscene.core.entities;

import playn.core.Asserts;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractEffect.
 */
public abstract class AbstractEffect extends AbstractAnimation {

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.entities.AbstractAnimation#build()
   */
  @Override
  public void build() {
    Asserts.check(getTarget() != null, "target can't be null");
    getTarget().buildOnce();
    setRoot(getTarget().getRoot());
  }

}
