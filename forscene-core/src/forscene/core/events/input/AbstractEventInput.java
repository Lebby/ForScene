package forscene.core.events.input;

import playn.core.Events.Input;
import forscene.core.events.AbstractEvent;

public abstract class AbstractEventInput<T extends Input> extends AbstractEvent {
	private T  event;
	
	@Override
	public void run() {
		run(event);
	};
	

	public abstract void run(T event);
	
	public void setEvent(T event) {
		this.event = event;
	}
}
