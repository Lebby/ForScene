package forscene.core.entities;

import java.util.Iterator;
import java.util.TreeSet;

import playn.core.GroupLayer;
import playn.core.PlayN;
import forscene.core.util.GraphicFactory;
import forscene.exceptions.AbstractObjectNotFoundException;
import forscene.exceptions.NoNameException;

public abstract class AbstractSceneObject {
	private GroupLayer root;
	private String name="";
	private ObjectID ID;
	private boolean toUpdate = true;
	
	public boolean isToUpdate() {
		return toUpdate;
	}

	public void setToUpdate(boolean toUpdate) {
		this.toUpdate = toUpdate;
	}
	//TODO: improve Object child
	private TreeSet<ObjectID> childs;
	
	
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
		setToUpdate(true);
	}
	
	public void updateDraw(GroupLayer layer)
	{
		this.getRoot().clear();
		this.getRoot().add(layer);
		setToUpdate(false);
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
		for( float i = 0; i < getRoot().size(); i++)
		{
			PlayN.log().debug("REDRAW ---INNER size : " + getRoot().get(i).getClass() );
			if (getRoot().get(i).getClass().toString().compareTo( "class playn.java.JavaGroupLayer") ==0)
			{
				PlayN.log().debug("\t size : " + ((GroupLayer) getRoot().get(i)).size() + " -||- " + ((GroupLayer) getRoot().get(i)));
			}	
		}*/
		setToUpdate(false);
		
	}
	
	
	public abstract void build();
	
	public abstract void updateState();
	
	public void addSceneObject(AbstractSceneObject object) throws NoNameException
	{
		if ( object.getName() == null || object.getName() == "" ) throw new NoNameException();
			childs.add(new ObjectID(object));
		PlayN.log().debug("childs size : " + childs.size());
		setToUpdate(true);
	}
	
	public void addSceneObject(String name,AbstractSceneObject object) throws NoNameException
	{
		object.setName(name);
		addSceneObject(object);
		setToUpdate(true);
	}
	
	public void removeSceneObject(AbstractSceneObject object) throws AbstractObjectNotFoundException
	{
		if (childs.contains(object))
			childs.remove(object);
		else throw new AbstractObjectNotFoundException();
		setToUpdate(true);
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
	
	public AbstractSceneObject getSceneObject(int i)
	{
		return (AbstractSceneObject) childs.toArray()[i];				
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
		setToUpdate(true);
	}
	
	public TreeSet<ObjectID> getChilds() {
		return childs;
	}

	public void setChilds(TreeSet<ObjectID> childs) {
		this.childs = childs;
		setToUpdate(true);
	}
	
	public int getSize()
	{
		return childs.size();
	}
	
	public void removeAllSceneObjectChild()
	{
		for (Iterator<ObjectID> iterator = childs.iterator(); iterator.hasNext();) {
			ObjectID type = (ObjectID) iterator.next();			
			type.getInstance().removeAllSceneObjectChild();			
		}
		for (Iterator<ObjectID> iterator = childs.iterator(); iterator.hasNext();) {
			ObjectID type = (ObjectID) iterator.next();			
			try {
				removeSceneObject(type.getInstance());
			} catch (AbstractObjectNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		setToUpdate(true);
	}
	
	
	
}
