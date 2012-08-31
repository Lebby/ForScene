/*
 * 
 */
package forscene.core.effects;

import forscene.core.entities.AbstractEffect;

/**
 * @author Scuderi Giovanni Luca aka Lebby glscud@gmail.com
 * 
 */

// TODO: Auto-generated Javadoc
/**
 * The Class Scroll.
 */
public class Scroll extends AbstractEffect {

  /** The start x. */
  private float   startX;

  /** The start y. */
  private float   startY;

  /** The endX */
  private float   endX;

  /** The endY */
  private float   endY;

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

    switch (scrollType) {
    case UP:
      tmpY -= step;
      if (endY == tmpY) {
        stop();
      }
      break;

    case DOWN:
      tmpY += step;
      if (endY == tmpY) {
        stop();
      }
      break;

    case LEFT:
      tmpX -= step;
      if (endX == tmpX) {
        stop();
      }
      break;
    case RIGHT:
      tmpX += step;
      if (endX == tmpX) {
        stop();
      }
      break;

    case DOWN_LEFT:
      tmpX -= step;
      tmpY += step;
      break;
    case UP_RIGHT:
      tmpX += step;
      tmpY -= step;
      break;

    case DOWN_RIGHT:
      tmpX += step;
      tmpY += step;
      if ((endX == tmpX) && (endY == tmpY)) {
        stop();
      }
      break;
    case UP_LEFT:
      tmpX -= step;
      tmpY -= step;
      if ((endX == tmpX) && (endY == tmpY)) {
        stop();
      }
      break;
    }
    getRoot().setTranslation(tmpX, tmpY);
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
    tmpX = startX;
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
    tmpY = startY;
  }

  /**
   * Gets the position x.
   * 
   * @return the position x
   */
  public float getPositionX() {
    return getTarget().getRoot().transform().tx();
  }

  /**
   * Gets the position y.
   * 
   * @return the position y
   */
  public float getPositionY() {
    return getTarget().getRoot().transform().ty();
  }

  /**
   * @return the endX
   */
  public float getEndX() {
    return endX;
  }

  /**
   * @param endX
   *          the endX to set
   */
  public void setEndX(float endX) {
    this.endX = endX;
  }

  /**
   * @return the endY
   */
  public float getEndY() {
    return endY;
  }

  /**
   * @param endY
   *          the endY to set
   */
  public void setEndY(float endY) {
    this.endY = endY;
  }

}