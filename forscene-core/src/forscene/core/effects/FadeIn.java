/*
 * 
 */
package forscene.core.effects;

import playn.core.PlayN;
import forscene.core.entities.toTest.AbstractEffect;

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
  private float step         = 0.1f;

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.entities.toTest.AbstractAnimation#goNext()
   */
  @Override
  public void goNext() {
    changeAlpha();
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
   * Change alpha.
   */
  private void changeAlpha() {
    if (currentAlpha >= endAlpha) {
      stop();
    } else {
      currentAlpha += step;
    }
    getTarget().getRoot().setAlpha(currentAlpha);
    getTarget().refresh();
    PlayN.log().debug(
        "FadeIN change alpha " + getTarget().getRoot().alpha() + " parent "
            + getTarget().getRoot().parent());
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
  protected void setCurrentAlpha(float f) {
    currentAlpha = f;
  }

}
