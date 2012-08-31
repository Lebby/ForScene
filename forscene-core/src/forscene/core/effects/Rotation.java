/**
 * 
 */
package forscene.core.effects;

import forscene.core.entities.AbstractEffect;

/**
 * @author Scuderi Giovanni Luca aka Lebby glscud@gmail.com
 * 
 */
public class Rotation extends AbstractEffect {

  /** The start scale. */
  private float    startAngle   = 0f;

  /** The current scale. */
  private float    currentAngle = startAngle;

  /** The end scale. */
  private float    endAngle     = 1f;

  /** The step. */
  private float    step         = 0.01f;

  private LoopType loop         = LoopType.NONE;

  private short    times        = 0;

  /** current times. */
  private float    currentTimes = times;

  /**
   * @return the currentAngle
   */
  public float getCurrentAngle() {
    return currentAngle;
  }

  /**
   * @param currentAngle
   *          the currentAngle to set
   */
  public void setCurrentAngle(float currentAngle) {
    this.currentAngle = currentAngle;
  }

  /**
   * @return the endAngle
   */
  public float getEndAngle() {
    return endAngle;
  }

  /**
   * @param endAngle
   *          the endAngle to set
   */
  public void setEndAngle(float endAngle) {
    this.endAngle = endAngle;
  }

  /**
   * @return the step
   */
  public float getStep() {
    return step;
  }

  /**
   * @param step
   *          the step to set
   */
  public void setStep(float step) {
    this.step = step;
  }

  /**
   * @return the loop
   */
  public LoopType getLoop() {
    return loop;
  }

  /**
   * @param loop
   *          the loop to set
   */
  public void setLoop(LoopType loop) {
    this.loop = loop;
  }

  /**
   * @return the times
   */
  public short getTimes() {
    return times;
  }

  /**
   * @param times
   *          the times to set
   */
  public void setTimes(short times) {
    this.times = times;
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.entities.AbstractAnimation#init()
   */
  @Override
  public void init() {
    currentAngle = startAngle;
    currentTimes = times;
    if (startAngle > endAngle) {
      if (step > 0) {
        step *= -1;
      }
    } else {
      if (step < 0) {
        step *= -1;
      }
    }
    getRoot().setRotation(currentAngle);

  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.entities.AbstractAnimation#goNext()
   */
  @Override
  public void goNext() {
    currentAngle += step;
    getRoot().setRotation(currentAngle);
    if (loop == LoopType.NONE) {
      if (currentAngle == endAngle) {
        stop();
      }
    } else if (loop == LoopType.BOUNCY) {
      if ((currentAngle == endAngle) || (currentAngle == startAngle)) {
        step *= -1;
      }
    } else if (loop == LoopType.INFINITE) {
      if ((currentAngle == endAngle)) {
        currentAngle = startAngle;
        currentTimes--;
      }
    } else if (loop == LoopType.REPEAT_N) {
      if ((currentAngle == endAngle)) {
        currentAngle = startAngle;
        currentTimes--;
        if (currentTimes == 0) {
          stop();
        }
      }
    } else if (loop == LoopType.BOUNCY_N) {
      if ((currentAngle == endAngle) || (currentAngle == startAngle)) {
        step *= -1;
        currentTimes -= 0.5f;
      }
      if (currentTimes == 0) {
        stop();
      }
    }

  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.entities.AbstractAnimation#run()
   */
  @Override
  public void run() {
    goNext();

  }
}
