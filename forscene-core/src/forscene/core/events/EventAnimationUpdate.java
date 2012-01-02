package forscene.core.events;


import playn.core.PlayN;
import forscene.core.LoopController.AbstractGameLoopManager;
import forscene.core.LoopController.GameLoopManager;
import forscene.core.entities.AbstractAnimation;

public class EventAnimationUpdate extends AbstractEvent{
	private AbstractAnimation animation;
	
	public EventAnimationUpdate(AbstractAnimation anim)
	{
		this.animation = anim;		
		setDone(false);
		this.setPriority(-1);
	}
	
	@Override
	public void run() {
		PlayN.log().debug("Animation update");

		if (animation.isStarted())
		{
			long updateRate = animation.getUpdateRate();
			/*PlayN.log().debug( " ticks " + GameLoopManager.getInstance().getTicks());
			PlayN.log().debug( " ticksRAte " + GameLoopManager.getInstance().getTickRate());
			PlayN.log().debug( " second " + GameLoopManager.getInstance().getSeconds());
			PlayN.log().debug( " updateRate " + updateRate );*/
			if (updateRate == 0 )
			{
				animation.run();				
				return;
			}
			
			 long scaledFps =  ( AbstractGameLoopManager.getInstance().getTickRate() / updateRate);
			 //PlayN.log().debug( " turi:  " + scaledFps  );
			if (scaledFps == 0 ) scaledFps =1;
			 if ((updateRate == 0)  || ((( AbstractGameLoopManager.getInstance().getTicks()))%scaledFps == 0)) 
			{
				animation.goNext();				
			}
		}else setDone(true);
	}
}
