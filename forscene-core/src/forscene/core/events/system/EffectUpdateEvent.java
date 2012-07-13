package forscene.core.events.system;

import forscene.core.entities.toTest.AbstractEffect;


// TODO: Auto-generated Javadoc
/**
 * The Class EventEffectUpdate.
 */
public abstract class EffectUpdateEvent extends AbstractEvent {
	
	/**
	 * Instantiates a new event effect update.
	 *
	 * @param effect the effect
	 */
	public EffectUpdateEvent(AbstractEffect effect) {
		this.setDone(false);
		this.setPriority(-1);
	}
	
}
