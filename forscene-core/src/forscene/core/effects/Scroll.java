/*
 * 
 */
package forscene.core.effects;

import forscene.core.entities.toTest.AbstractEffect;

// TODO: Auto-generated Javadoc
/**
 * The Class Scroll.
 */
public class Scroll extends AbstractEffect {

  /** The start x. */
  private float   startX;

  /** The start y. */
  private float   startY;

  /** The tmp y. */
  private float   tmpX, tmpY;

  /** The step. */
  private float   step = 1;

  /** The loop. */
  private boolean loop = false;

  /**
   * The Enum ScrollType.
   */
  public static enum ScrollType {
    /** The LEFT. */
    LEFT,
    /** The RIGHT. */
    RIGHT,
    /** The UP. */
    UP,
    /** The DOWN. */
    DOWN,
    /** The U p_ left. */
    UP_LEFT,
    /** The U p_ right. */
    UP_RIGHT,
    /** The DOW n_ left. */
    DOWN_LEFT,
    /** The DOW n_ right. */
    DOWN_RIGHT
  };

  /** The scroll type. */
  private ScrollType scrollType = ScrollType.RIGHT;

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.entities.toTest.AbstractAnimation#init()
   */
  @Override
  public void init() {
  }

  /**
   * Gets the scroll type.
   * 
   * @return the scroll type
   */
  public ScrollType getScrollType() {
    return scrollType;
  }

  /**
   * Sets the scroll type.
   * 
   * @param scrollType
   *          the new scroll type
   */
  public void setScrollType(ScrollType scrollType) {
    this.scrollType = scrollType;
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
   *          the new step
   */
  public void setStep(float step) {
    this.step = step;
  }

  /**
   * Checks if is loop.
   * 
   * @return true, if is loop
   */
  public boolean isLoop() {
    return loop;
  }

  /**
   * Sets the loop.
   * 
   * @param loop
   *          the new loop
   */
  public void setLoop(boolean loop) {
    this.loop = loop;
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.entities.toTest.AbstractAnimation#goNext()
   */
  @Override
  public void goNext() {
    run();
  }

  /**
   * Scroll.
   */
  private void scroll() {
    float x = getTarget().getRoot().originX();
    float y = getTarget().getRoot().originY();

    switch (scrollType) {
    case UP:
      getRoot().setTranslation(x, y - step);
      break;
    case DOWN:
      getRoot().setTranslation(x, y + step);
      break;

    case LEFT:
      tmpX--;
      // getTarget().getRoot().setTranslation(tmpX , tmpY);
      getRoot().setTranslation(tmpX, tmpY);
      break;
    case RIGHT:
      tmpX++;
      // getTarget().getRoot().setTranslation(tmpX, tmpY);
      getRoot().setTranslation(tmpX, tmpY);
      break;

    case DOWN_LEFT:
      getTarget().getRoot().setTranslation(x - step, y + step);
      break;
    case UP_RIGHT:
      getTarget().getRoot().setTranslation(x + step, y - step);
      break;

    case DOWN_RIGHT:
      getTarget().getRoot().setTranslation(x + step, y + step);
      break;
    case UP_LEFT:
      getTarget().getRoot().setTranslation(x - step, y - step);
      break;
    }

  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.entities.toTest.AbstractAnimation#run()
   */
  @Override
  public void run() {
    scroll();
  }

  /**
   * Gets the start x.
   * 
   * @return the start x
   */
  public float getStartX() {
    return startX;
  }

  /**
   * Sets the start x.
   * 
   * @param startX
   *          the new start x
   */
  public void setStartX(float startX) {
    this.startX = startX;
  }

  /**
   * Gets the start y.
   * 
   * @return the start y
   */
  public float getStartY() {
    return startY;
  }

  /**
   * Sets the start y.
   * 
   * @param startY
   *          the new start y
   */
  public void setStartY(float startY) {
    this.startY = startY;
  }

  /**
   * Gets the position x.
   * 
   * @return the position x
   */
  public float getPositionX() {
    return getTarget().getRoot().originX();
  }

  /**
   * Gets the position y.
   * 
   * @return the position y
   */
  public float getPositionY() {
    return getTarget().getRoot().originY();
  }

}