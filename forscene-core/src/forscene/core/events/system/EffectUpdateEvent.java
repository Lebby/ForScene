package forscene.core.events.system;

import forscene.core.entities.AbstractEffect;


// TODO: Auto-generated Javadoc
/**
 * The Class EventEffectUpdate.
 */
public abstract class EffectUpdateEvent extends AbstractEvent {
	
	/** The effect. */
	private AbstractEffect effect;
	
	/**
	 * Instantiates a new event effect update.
	 *
	 * @param effect the effect
	 */
	public EffectUpdateEvent(AbstractEffect effect) {
		this.effect = effect;
		this.setDone(false);
		this.setPriority(-1);
	}
	
}
