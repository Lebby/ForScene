/*
 * 
 */
package forscene.core.effects;

/**
 * @author Scuderi Giovanni Luca aka Lebby glscud@gmail.com
 * 
 */

// TODO: Auto-generated Javadoc
/**
 * The Class FadeOut.
 */
public class FadeOut extends FadeIn {

  /**
   * Instantiates a new fade out.
   */

  public FadeOut() {
    setStep(0.1f);
    setStartAlpha(1f);
    setEndAlpha(0);
    setCurrentAlpha(getStartAlpha());
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.effects.FadeIn#goNext()
   */
  @Override
  public void goNext() {
    /**
     * Change alpha.
     */

    if (getCurrentAlpha() <= getEndAlpha()) {
      stop();
    } else {
      setCurrentAlpha(getCurrentAlpha() - getStep());
    }
    getTarget().getRoot().setAlpha(getCurrentAlpha());
    // getTarget().refresh();
  }

}
