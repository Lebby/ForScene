package forscene.core.events;

import playn.core.PlayN;

import forscene.core.LoopController.GameLoopManager;

public class EventInit extends AbstractEvent{

	@Override
	public void run() {
		this.setDone(false);
		PlayN.log().debug("EventInit calling init");
		GameLoopManager.getInstance().init();
		if ((GameLoopManager.getInstance().getCurrentSceneGroup() != null)
				&& (GameLoopManager.getInstance().getCurrentScene() != null))
		{
			setDone(true);
		}
		setDone(true);
		
	}
}
