/*
 * 
 */
package forscene.core.entities.toTest;

import java.util.HashMap;

import playn.core.GroupLayer;
import forscene.core.entities.AbstractSceneObject;
import forscene.system.Asserts;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractActor.
 */
public abstract class AbstractActor extends AbstractSceneObject {

  /** The animations. */
  private HashMap<String, AbstractActorAnimation> animations;

  /** The rest. */
  private GroupLayer                              rest;

  /**
   * Instantiates a new abstract actor.
   */
  public AbstractActor() {
    animations = new HashMap<String, AbstractActorAnimation>();
  }

  /**
   * Gets the animations.
   * 
   * @return the animations
   */
  public HashMap<String, AbstractActorAnimation> getAnimations() {
    return animations;
  }

  /**
   * Sets the animations.
   * 
   * @param animations
   *          the animations
   */
  public void setAnimations(HashMap<String, AbstractActorAnimation> animations) {
    Asserts.check(animations != null, "animations can't be null");
    this.animations = animations;
  }

  /**
   * Start anim.
   * 
   * @param animation
   *          the animation
   */
  public void startAnim(String animation) {
    Asserts.check(animation != null, "animation can't be null");
    Asserts.check(animation != "", "animation can't be void");
    // EventMonitor.getInstance().push(new
    // EventStartAnimation(getAnimations().get(animation)));

    // last
    // AbstractActorAnimation tmp= getAnimations().get(animation);
    // tmp.setTarget(this);

    /*
     * if (currentAnimation != null) currentAnimation.stop(); if (tmp != null )
     * tmp .start(); currentAnimation = tmp; if (eventUpdate == null) {
     */
    getAnimations().get(animation).start();

    // }

  }

  /**
   * Stopt anim.
   * 
   * @param animation
   *          the animation
   */
  public void stoptAnim(String animation) {
    Asserts.check(animation != null, "animation can't be null");
    Asserts.check(animation != "", "animation can't be void");
    AbstractActorAnimation tmp = getAnimations().get(animation);
    tmp.stop(); // update self kill
  }

  /**
   * Stopt all anim.
   */
  public void stoptAllAnim() {
    String[] animationKeyList = (String[]) getAnimations().keySet().toArray();
    for (String element : animationKeyList) {
      getAnimations().get(element).stop();
    }

  }
}
