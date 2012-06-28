package forscene.core.ui.layout;

import playn.core.PlayN;
import forscene.core.entities.AbstractSceneObject;
import forscene.core.entities.AbstractSceneObjectGroup;
import forscene.exceptions.IDAlreadyPresentException;
import forscene.exceptions.NoNameException;


// pseudo decorator ...
public abstract class  AbstractLayout extends AbstractSceneObjectGroup implements ILayout{
	protected AbstractLayout currentLayout;
	private float height;
	private float width;
		
	@Override
	public void addSceneObject(AbstractSceneObject object)
			throws NoNameException {		
		layout(object);
		
		try {
			
			super.addSceneObject(object);
			
		} catch (IDAlreadyPresentException e) {
			e.printStackTrace();
		}
		setToUpdate(true);		
	}
	
	@Override
	public void addSceneObject(String name, AbstractSceneObject object)
			throws NoNameException {
		layout(object);
		setToUpdate(true);
		try {
			super.addSceneObject(name, object);
		} catch (IDAlreadyPresentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setLayout(AbstractLayout layout)
	{
		this.currentLayout = layout;
	}
	
	//public abstract void layout(AbstractSceneObject object);
	
	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}
	
	public void setHeight(float height)
	{
		this.height=height;
	}
	
	public void setWidth(float width)
	{
		this.width = width;
	}
	
}
