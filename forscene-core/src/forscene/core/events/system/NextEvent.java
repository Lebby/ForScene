package forscene.core.events.system;

import forscene.core.LoopController.AbstractGameLoopManager;

// TODO: Auto-generated Javadoc
/**
 * The Class EventNext.
 */
public class NextEvent extends AbstractEvent{

	/* (non-Javadoc)
	 * @see forscene.core.events.AbstractEvent#run()
	 */
	@Override
	public void run() {
		AbstractGameLoopManager.getInstance().goNext();
	}

}
