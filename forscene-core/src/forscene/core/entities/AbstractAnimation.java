package forscene.core.entities;

import playn.core.PlayN;
import forscene.core.LoopController.EventMonitor;
import forscene.core.events.EventAnimationUpdate;
import forscene.core.util.GraphicFactory;

public abstract  class AbstractAnimation extends AbstractSceneObject{
	private boolean started = false;	
	private boolean init=false;
	private AbstractSceneObject  target;
	private long updateRate = 0;
	
	
	public void start()
	{
		if (init == false)
		{
			init =true;
			build();
		}
		started = true;
		EventAnimationUpdate eventUpdate = new EventAnimationUpdate(this);
		EventMonitor.getInstance().push(eventUpdate);
	};
	
	public void stop(){
		started = false;
		PlayN.log().debug("ABSTRACT ANIMATION STOP!");
	};
	
	public boolean isStarted()
	{
		return started;
	}
	
	public abstract void goNext();
	public abstract  void run();
	
	public AbstractSceneObject getTarget() {
		return target;
	}
	
	public void setTarget(AbstractSceneObject actor) {
		this.target = actor;
		/*this.getRoot().clear(); TODO: fix these issue!
		this.getRoot().add(actor.getRoot());*/
	}
	
	@Override
	public void updateState() {		
		//GraphicFactory.refresh(getRoot()); //: wrong		
	}
	
	public void setUpdateRate(long rate )
	{
		this.updateRate = rate;
	}
	
	public long getUpdateRate()
	{
		return updateRate;
	} 
	
}