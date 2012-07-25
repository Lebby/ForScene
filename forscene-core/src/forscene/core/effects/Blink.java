/*
 * 
 */
package forscene.core.effects;

import forscene.core.entities.AbstractEffect;

// TODO: Auto-generated Javadoc
/**
 * The Class Blink.
 */
public class Blink extends AbstractEffect {
  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.entities.toTest.AbstractAnimation#init()
   */
  @Override
  public void init() {
    getRoot().setAlpha(0);
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.entities.toTest.AbstractAnimation#goNext()
   */
  @Override
  public void goNext() {
    if (getRoot().alpha() == 0f) {
      getRoot().setAlpha(1);
    } else {
      getRoot().setAlpha(0);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.entities.toTest.AbstractAnimation#run()
   */
  @Override
  public void run() {
    goNext();
  }

}
