package forscene.core.entities;

import playn.core.Layer;
import playn.core.PlayN;
import forscene.core.events.system.AnimationUpdateEvent;
import forscene.core.events.system.EventManager;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractAnimation.
 */
public abstract class AbstractAnimation {
	
	/** The started. */
	private boolean started = false;	
	
	/** The init. */
	private boolean init=false;
	
	/** The target. */
	private AbstractSceneObject target;
	
	/** The update rate. */
	private long updateRate = 0;
	
	/**
	 * Builds the.
	 */
	public abstract void build();
	
	/**
	 * Start.
	 */
	public void start()
	{
		if (init == false)
		{
			init =true;
			build();
		}
		started = true;
		AnimationUpdateEvent eventUpdate = new AnimationUpdateEvent(this);
		EventManager.getInstance().push(eventUpdate);
	};
	
	/**
	 * Stop.
	 */
	public void stop(){
		started = false;
		PlayN.log().debug("ABSTRACT ANIMATION STOP!");
	};
	
	/**
	 * Checks if is started.
	 *
	 * @return true, if is started
	 */
	public boolean isStarted()
	{
		return started;
	}
	
	/**
	 * Checks if is stopped.
	 *
	 * @return true, if is stopped
	 */
	public boolean isStopped()
	{
		return !started;
	}
	
	/**
	 * Go next.
	 */
	public abstract void goNext(); //same of update state ...
	
	/**
	 * Run.
	 */
	public abstract  void run();
	
	/**
	 * Gets the target.
	 *
	 * @return the target
	 */
	public AbstractSceneObject getTarget() {
		return target;
	}
	
	/**
	 * Sets the target.
	 *
	 * @param actor the new target
	 */
	public void setTarget(AbstractSceneObject actor) {
		this.target = actor;
	}
	
	//@Override
	/**
	 * Update state.
	 */
	public void updateState() {		
		//GraphicFactory.refresh(getRoot()); //: wrong		
	}
	
	/**
	 * Sets the update rate.
	 *
	 * @param rate the new update rate
	 */
	public void setUpdateRate(long rate )
	{
		this.updateRate = rate;
	}
	
	/**
	 * Gets the update rate.
	 *
	 * @return the update rate
	 */
	public long getUpdateRate()
	{
		return updateRate;
	} 
	
	/**
	 * Gets the root.
	 *
	 * @return the root
	 */
	public Layer getRoot()
	{
		return getTarget().getRoot();
	}
	
	/**
	 * Sets the root.
	 *
	 * @param groupLayer the new root
	 */
	public void setRoot(Layer groupLayer)
	{
		getTarget().setRoot(groupLayer);
	}	
	
	
}