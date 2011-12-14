package forscene.core.entities;

import java.util.HashMap;
import java.util.Set;

import playn.core.GroupLayer;
import forscene.core.LoopController.ObjectID;
import forscene.core.util.GraphicFactory;

public abstract class AbstractSceneObject{
	private GroupLayer root;
	private String name="";
	private ObjectID<AbstractSceneObject> ID;
	
	//TODO: improve Object child
	Set<ObjectID<AbstractSceneObject>> childs;
	
	public AbstractSceneObject() {
		root = GraphicFactory.createGroupLayer();
		root.clear();
	}
	
	public GroupLayer getRoot()
	{
		return root;
	}
	
	public void setRoot(GroupLayer groupLayer)
	{
		this.root = groupLayer;
	}
	
	public void updateDraw(GroupLayer layer)
	{
		this.getRoot().clear();
		this.getRoot().add(layer);
	}
	
	public void redraw()
	{
		//PlayN.log().debug("REDRAW SIZE 1 : " + getRoot().size() + " depth : " + getRoot().depth() + " : " + getRoot().getClass());
		GroupLayer parent = this.getRoot().parent();
		if (parent != null )
		{
			parent.remove(this.getRoot());
			parent.clear();
			parent.add(getRoot());			
		}
		/*PlayN.log().debug("REDRAW SIZE : " + getRoot().size() + " depth : " + getRoot().depth() + " : " + getRoot().getClass());
		for( int i = 0; i < getRoot().size(); i++)
		{
			PlayN.log().debug("REDRAW ---INNER size : " + getRoot().get(i).getClass() );
			if (getRoot().get(i).getClass().toString().compareTo( "class playn.java.JavaGroupLayer") ==0)
			{
				PlayN.log().debug("\t size : " + ((GroupLayer) getRoot().get(i)).size() + " -||- " + ((GroupLayer) getRoot().get(i)));
			}	
		}*/	
		
	}
	
	
	public abstract void build();
	
	public abstract void updateState();
	
	public void addSceneObject(AbstractSceneObject object)
	{
		childs.add(new ObjectID<AbstractSceneObject>(object));
	}
	
	public void removeSceneObject(AbstractSceneObject object)
	{
		
	}
	
	public AbstractSceneObject getSceneObject()
	{
		return null;		
	}

	public String getName() {
		return ID.getName();
	}

	public void setName(String name) {
		ID.setName (name);
	}

	public long getID() {
		return ID.getID();
	}

	public void setID(long iD) {
		ID.setID(iD);
	}
	
	public String getType()
	{
		return ID.getType();
	}
	
}
