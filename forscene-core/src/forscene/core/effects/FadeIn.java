/*
 * 
 */
package forscene.core.effects;

import forscene.core.entities.AbstractEffect;
import forscene.system.Asserts;

/**
 * @author Scuderi Giovanni Luca aka Lebby glscud@gmail.com
 * 
 */

// TODO: Auto-generated Javadoc
/**
 * The Class FadeIn.
 */
public class FadeIn extends AbstractEffect {

  /** The start alpha. */
  private float startAlpha   = 0f;

  /** The current alpha. */
  private float currentAlpha = startAlpha;

  /** The end alpha. */
  private float endAlpha     = 1f;

  /** The step. */
  private float step         = 0.01f;

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.entities.toTest.AbstractAnimation#goNext()
   */
  @Override
  public void goNext() {
    /**
     * Change alpha.
     */

    if (currentAlpha >= endAlpha) {
      stop();
    } else {
      currentAlpha += step;
    }
    getTarget().getRoot().setAlpha(currentAlpha);
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

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.entities.toTest.AbstractAnimation#init()
   */
  @Override
  public void init() {
    currentAlpha = startAlpha;
  }

  /**
   * Gets the start alpha.
   * 
   * @return the startAlpha
   */
  public float getStartAlpha() {
    return startAlpha;
  }

  /**
   * Sets the start alpha.
   * 
   * @param startAlpha
   *          the startAlpha to set
   */
  public void setStartAlpha(float startAlpha) {
    Asserts.check(startAlpha > 0, "startAlpha must be >= 0");
    this.startAlpha = startAlpha;
  }

  /**
   * Gets the end alpha.
   * 
   * @return the endAlpha
   */
  public float getEndAlpha() {
    return endAlpha;
  }

  /**
   * Sets the end alpha.
   * 
   * @param endAlpha
   *          the endAlpha to set
   */
  public void setEndAlpha(float endAlpha) {
    Asserts.check(endAlpha >= 0, "endAlpha must be >= 0");
    this.endAlpha = endAlpha;
  }

  /**
   * Gets the step.
   * 
   * @return the step
   */
  public float getStep() {
    return step;
  }

  /**
   * Sets the step.
   * 
   * @param step
   *          the step to set
   */
  public void setStep(float step) {
    Asserts.check(step > 0, "step must be >= 0");
    this.step = step;
  }

  /**
   * Gets the current alpha.
   * 
   * @return the current alpha
   */
  public float getCurrentAlpha() {
    return currentAlpha;
  }

  /**
   * Sets the current alpha.
   * 
   * @param f
   *          the new current alpha
   */
  protected void setCurrentAlpha(float alpha) {
    Asserts.check(alpha > 0, "alpha must be >= 0");
    currentAlpha = alpha;
  }

}
