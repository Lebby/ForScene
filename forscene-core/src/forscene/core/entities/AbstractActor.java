package forscene.core.entities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import playn.core.GroupLayer;

import playn.core.PlayN;

import forscene.core.LoopController.EventMonitor;
import forscene.core.events.EventAnimationUpdate;



public abstract class AbstractActor extends AbstractSceneObject{
	private HashMap<String, AbstractActorAnimation> animations;
	private GroupLayer rest;
	
	public AbstractActor()
	{
		animations= new HashMap<String, AbstractActorAnimation>();
	}
	
	
	public HashMap<String, AbstractActorAnimation> getAnimations() {
		return animations;
	}
	
	public void setAnimations(HashMap<String, AbstractActorAnimation> animations) {
		this.animations = animations;
	}
	
	
	public void startAnim(String animation)
	{		
		//EventMonitor.getInstance().push(new EventStartAnimation(getAnimations().get(animation)));

		//last
		//AbstractActorAnimation tmp= getAnimations().get(animation);
		//tmp.setTarget(this);
				
		/*if  (currentAnimation != null)   currentAnimation.stop();
		if (tmp != null ) 	tmp	.start();
		currentAnimation = tmp;
		if (eventUpdate == null)
		{*/
			getAnimations().get(animation).start();			
			
		//}
		
	}
	
	
	
	public void stoptAnim(String animation)
	{		
		AbstractActorAnimation tmp= getAnimations().get(animation);
		tmp.stop(); //update self kill		
	}
	
	public void  stoptAllAnim()
	{
		 String[] animationKeyList = (String[]) getAnimations().keySet().toArray();
		for( int i = 0; i< animationKeyList.length; i++)
		{
			getAnimations().get(animationKeyList[i]).stop();
		}
		
	}
	
}
