/*
 * 
 */
package forscene.core.util;

import playn.core.GroupLayer;
import playn.core.PlayN;
import forscene.core.entities.objects.AbstractSceneObject;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractSceneObjectBorder.
 */
public class AbstractSceneObjectBorder extends AbstractSceneObject<GroupLayer>{
	
	/** The object. */
	private AbstractSceneObject<?> object;	
	
	/**
	 * Instantiates a new abstract scene object border.
	 *
	 * @param object the object
	 */
	public AbstractSceneObjectBorder(AbstractSceneObject<?> object) {
		setTargetObject(object);
	}

	
	/* (non-Javadoc)
	 * @see forscene.system.ISceneObject#updateState()
	 */
	public void updateState() {	  

		if (object.isToUpdate())
		{			
			this.systemBuild();					
		}
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.AbstractSceneObject#build()
	 */
	@Override
	public void build() {		
		GroupLayer tmp = GraphicFactory.drawBorder(object.getRoot());		
		
		if (tmp != null)
		{
			this.setRoot(tmp);
			/*try {
				
				this.addSceneObject(new AbstractSceneObjectBorder(object));
			} catch (NoNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
	}
	
	/**
	 * Sets the target object.
	 *
	 * @param object the new target object
	 */
	public void setTargetObject(AbstractSceneObject object)
	{
		this.object = object;
		this.setName(object.getName()+"Border");
	}
}