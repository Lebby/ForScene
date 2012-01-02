package forscene.core.util;

import playn.core.GroupLayer;
import playn.core.PlayN;
import forscene.core.entities.AbstractSceneObject;

public class AbstractSceneObjectBorder extends AbstractSceneObject{
	private AbstractSceneObject object;	
	
	public AbstractSceneObjectBorder(AbstractSceneObject object) {
		setTargetObject(object);
	}

	@Override
	public void updateState() {
		if (object.isToUpdate())
		{
			this.removeAllSceneObjectChild();
			this.build();					
		}
	}
	
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
	
	public void setTargetObject(AbstractSceneObject object)
	{
		this.object = object;
		this.setName(object.getName()+"Border");
		PlayN.log().debug("**********"+
				getName());
	}
}