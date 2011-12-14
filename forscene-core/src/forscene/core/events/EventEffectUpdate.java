package forscene.core.events;

import forscene.core.entities.AbstractEffect;


public abstract class EventEffectUpdate extends AbstractEvent {
	private AbstractEffect effect;
	
	public EventEffectUpdate(AbstractEffect effect) {
		this.effect = effect;
		this.setDone(false);
	}
	
}
