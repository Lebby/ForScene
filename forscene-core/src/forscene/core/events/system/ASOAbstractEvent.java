package forscene.core.events.system;

import forscene.core.entities.AbstractSceneObject;

public abstract class ASOAbstractEvent  extends AbstractEvent{
	private AbstractSceneObject aso;	
	
	private ASOAbstractEvent()
	{		
		super();
	}
	
	public ASOAbstractEvent(AbstractSceneObject absractSceneObject) {
		this();
		this.aso = absractSceneObject;
	}
	
	
}
