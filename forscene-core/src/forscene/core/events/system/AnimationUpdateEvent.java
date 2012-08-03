/*
 * 
 */
package forscene.core.events.system;

import forscene.core.entities.AbstractAnimation;
import forscene.system.Asserts;
import forscene.system.managers.AbstractGameLoopManager;

// TODO: Auto-generated Javadoc
/**
 * The Class EventAnimationUpdate.
 */
public class AnimationUpdateEvent extends AbstractEvent {

  /** The animation. */
  private AbstractAnimation animation;

  /**
   * Instantiates a new event animation update.
   * 
   * @param anim
   *          the anim
   */
  public AnimationUpdateEvent(AbstractAnimation anim) {
    Asserts.check(anim != null, "anim can't be null");
    animation = anim;
    setDone(false);
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.events.AbstractEvent#run()
   */
  @Override
  public void run() {

    if (animation.isStarted()) {
      long updateRate = animation.getUpdateRate();
      /*
       * PlayN.log().debug( " ticks " +
       * GameLoopManager.getInstance().getTicks()); PlayN.log().debug(
       * " ticksRAte " + GameLoopManager.getInstance().getTickRate());
       * PlayN.log().debug( " second " +
       * GameLoopManager.getInstance().getSeconds()); PlayN.log().debug(
       * " updateRate " + updateRate );
       */
      long scaledFps;
      if (updateRate != 0) {
        scaledFps = (AbstractGameLoopManager.getInstance().getTickRate() / updateRate);
      } else {
        scaledFps = 1;
      }

      if ((updateRate == 0)
          || ((((AbstractGameLoopManager.getInstance().getTicks())) % scaledFps) == 0)) {
        animation.run();
        animation.getTarget().setToUpdate(false);
        setDone(false);
      }

      if (animation.getTarget().getParent() == null) {
        setDone(true);
      }
    } /*
       * else { setDone(true); }
       */
  }
}
