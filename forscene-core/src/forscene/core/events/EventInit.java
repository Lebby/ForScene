package forscene.core.events;

import playn.core.PlayN;

import forscene.core.LoopController.AbstractGameLoopManager;
import forscene.core.LoopController.GameLoopManager;

public class EventInit extends AbstractEvent{

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
