package forscene.core.events.system;

import playn.core.PlayN;

import forscene.core.LoopController.AbstractGameLoopManager;

// TODO: Auto-generated Javadoc
/**
 * The Class EventInit.
 */
public class InitEvent extends AbstractEvent{

	/* (non-Javadoc)
	 * @see forscene.core.events.AbstractEvent#run()
	 */
	@Override
	public void run() {
		this.setDone(false);
		PlayN.log().debug("EventInit calling init");
		AbstractGameLoopManager.getInstance().init();
		if ((AbstractGameLoopManager.getInstance().getCurrentSceneGroup() != null)
				&& (AbstractGameLoopManager.getInstance().getCurrentScene() != null))
		{
			setDone(true);
		}
		setDone(true);
		
	}
}
