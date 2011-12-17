package forscene.core.events;


import playn.core.PlayN;
import forscene.core.LoopController.GameLoopManager;
import forscene.core.entities.AbstractAnimation;
import forscene.core.util.GraphicFactory;

public class EventAnimationUpdate extends AbstractEvent{
	private AbstractAnimation animation;
	
	public EventAnimationUpdate(AbstractAnimation anim)
	{
		this.animation = anim;		
		setDone(false);
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
			
			 long scaledFps =  ( GameLoopManager.getInstance().getTickRate() / updateRate);
			 //PlayN.log().debug( " turi:  " + scaledFps  );
			if (scaledFps == 0 ) scaledFps =1;
			 if ((updateRate == 0)  || ((( GameLoopManager.getInstance().getTicks()))%scaledFps == 0)) 
			{
				animation.goNext();
				//animation.getTarget(). updateDraw(animation.getRoot());
				
				animation.redraw();
				
				//setDone(true);
				
			}
		}else setDone(true);
	}
}
