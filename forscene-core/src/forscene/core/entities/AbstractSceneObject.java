package forscene.core.entities;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import playn.core.GroupLayer;
import playn.core.PlayN;
import forscene.core.LoopController.ObjectID;
import forscene.core.util.GraphicFactory;
import forscene.exceptions.AbstractObjectNotFoundException;
import forscene.exceptions.NoNameException;

public abstract class AbstractSceneObject{
	private GroupLayer root;
	private String name="";
	private ObjectID ID;
	
	//TODO: improve Object child
	TreeSet<ObjectID> childs;
	
	public AbstractSceneObject() {
		root = GraphicFactory.createGroupLayer();
		root.clear();
		childs = new TreeSet<ObjectID>();
		ID = new ObjectID(this);
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
	
	//evil function
	private void redraw()
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
	
	public void addSceneObject(AbstractSceneObject object) throws NoNameException
	{
		if ( object.getName() == null || object.getName() == "" ) throw new NoNameException();
			childs.add(new ObjectID(object));
		PlayN.log().debug("childs size : " + childs.size());
	}
	
	public void addSceneObject(String name,AbstractSceneObject object) throws NoNameException
	{
		object.setName(name);
		addSceneObject(object);
	}
	
	public void removeSceneObject(AbstractSceneObject object) throws AbstractObjectNotFoundException
	{
		if (childs.contains(object))
			childs.remove(object);
		else throw new AbstractObjectNotFoundException();
	}
	
	public AbstractSceneObject getSceneObject(String name) throws AbstractObjectNotFoundException
	{
		for (Iterator<ObjectID> iterator = childs.iterator(); iterator.hasNext();) {
			ObjectID type = (ObjectID) iterator.next();
			if (type.getName()==name)
				return type.getInstance();
		}
		throw new AbstractObjectNotFoundException();		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
	public String getType()
	{
		return ID.getType();
	}
	
	public void buildChild()
	{
		for (Iterator<ObjectID> iterator = childs.iterator(); iterator.hasNext();) {
			ObjectID type = (ObjectID) iterator.next();					
			type.getInstance().build();
			type.getInstance().buildChild();						
			getRoot().add(type.getInstance().getRoot());
			PlayN.log().debug("BuildChild");
		}
		
	}
	
}
