/**
 * 
 */
package forscene.core.effects;

import forscene.core.entities.AbstractEffect;

/**
 * @author Scuderi Giovanni Luca aka Lebby glscud@gmail.com
 * 
 */
public class Scale extends AbstractEffect {

  /** The start scale. */
  private float     startScale   = 0f;

  /** The current scale. */
  private float     currentScale = startScale;

  /** The end scale. */
  private float     endScale     = 1f;

  /** The step. */
  private float     step         = 0.01f;

  /** Loop */
  private LoopType  loop         = LoopType.NONE;

  /** repeat times. */
  private short     times        = 0;

  /** current times. */
  private float     currentTimes = times;

  private ScaleType scale        = ScaleType.SCALEXY;

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.entities.AbstractAnimation#init()
   */
  @Override
  public void init() {
    currentScale = startScale;
    currentTimes = times;
    if (startScale > endScale) {
      if (step > 0) {
        step *= -1;
      }
    } else {
      if (step < 0) {
        step *= -1;
      }
    }
    if (scale == ScaleType.SCALEXY) {
      getRoot().setScale(currentScale);
    }
    if (scale == ScaleType.SCALEX) {
      getRoot().setScale(currentScale, 1);
    }
    if (scale == ScaleType.SCALEY) {
      getRoot().setScale(1, currentScale);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.entities.AbstractAnimation#goNext()
   */
  @Override
  public void goNext() {
    currentScale += step;
    getRoot().setScale(currentScale);
    if (loop == LoopType.NONE) {
      if (currentScale == endScale) {
        stop();
      }
    } else if (loop == LoopType.BOUNCY) {
      if ((currentScale == endScale) || (currentScale == startScale)) {
        step *= -1;
      }
    } else if (loop == LoopType.INFINITE) {
      if ((currentScale == endScale)) {
        currentScale = startScale;
        currentTimes--;
      }
    } else if (loop == LoopType.REPEAT_N) {
      if ((currentScale == endScale)) {
        currentScale = startScale;
        currentTimes--;
        if (currentTimes == 0) {
          stop();
        }
      }
    } else if (loop == LoopType.BOUNCY_N) {
      if ((currentScale == endScale) || (currentScale == startScale)) {
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

  /**
   * @return the currentScale
   */
  public float getCurrentScale() {
    return currentScale;
  }

  /**
   * @param currentScale
   *          the currentScale to set
   */
  public void setCurrentScale(float currentScale) {
    this.currentScale = currentScale;
  }

  /**
   * @return the endScale
   */
  public float getEndScale() {
    return endScale;
  }

  /**
   * @param endScale
   *          the endScale to set
   */
  public void setEndScale(float endScale) {
    this.endScale = endScale;
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
  public LoopType isLoop() {
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

  /**
   * @return the currentTimes
   */
  public short getCurrentTimes() {
    return (short) currentTimes;
  }

  /**
   * @param currentTimes
   *          the currentTimes to set
   */
  public void setCurrentTimes(short currentTimes) {
    this.currentTimes = currentTimes;
  }

  /**
   * @return the scale
   */
  public ScaleType getScale() {
    return scale;
  }

  /**
   * @param scale
   *          the scale to set
   */
  public void setScale(ScaleType scale) {
    this.scale = scale;
  }

}
