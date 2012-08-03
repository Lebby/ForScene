/*
 * 
 */
package forscene.system.events;

import forscene.core.entities.AbstractEffect;
import forscene.system.Asserts;

// TODO: Auto-generated Javadoc
/**
 * The Class EventEffectUpdate.
 */
public abstract class EffectUpdateEvent extends AbstractEvent {

  /**
   * Instantiates a new event effect update.
   * 
   * @param effect
   *          the effect
   */
  public EffectUpdateEvent(AbstractEffect effect) {
    Asserts.check(effect != null, "effect can't be null");
    setDone(false);
  }

}
