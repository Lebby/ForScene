package forscene.core.entities;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.TreeSet;

import playn.core.GroupLayer;
import playn.core.PlayN;
import forscene.core.util.GraphicFactory;
import forscene.exceptions.AbstractObjectNotFoundException;
import forscene.exceptions.IDAlreadyPresentException;
import forscene.exceptions.NoNameException;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractSceneObjectGroup.
 */
public abstract class AbstractSceneObjectGroup extends AbstractSceneObject{
	
	/** The root. */
	private GroupLayer root;
	
	//TODO: improve Object child
	/** The childs. */
	private TreeSet<ObjectID> childs;
	private PriorityQueue<ObjectID> pendingChilds;
	
	/**
	 * Instantiates a new abstract scene object.
	 */
	public AbstractSceneObjectGroup() {
		super();
		root = GraphicFactory.createGroupLayer();
		root.clear();
		childs = new TreeSet<ObjectID>();
		pendingChilds = new PriorityQueue<ObjectID>();
		
	}	
	
	
	/**
	 * Gets the root.
	 *
	 * @return the root
	 */
	@Override
	public GroupLayer getRoot()
	{
		return root;
	}
	
	/**
	 * Sets the root.
	 *
	 * @param groupLayer the new root
	 */
	public void setRoot(GroupLayer root)
	{
		this.root = root;
		setToUpdate(true);
	}	
	
	/**
	 * Adds the scene object.
	 *
	 * @param object the object
	 * @throws NoNameException the no name exception
	 * @throws IDAlreadyPresentException 
	 */
	public void addSceneObject(AbstractSceneObject object) throws NoNameException, IDAlreadyPresentException
	{
		if ( object.getName() == null || object.getName() == "" ) throw new NoNameException();
		
		//childs.add(new ObjectID(object));
		ObjectID element =new ObjectID(object);
		if(!pendingChilds.add(element)) throw new IDAlreadyPresentException();	
		PlayN.log().debug("AddSceneObject:" + this + " childs size : " + childs.size() + " pending size " + pendingChilds.size() + " " + element.getInstance() );
		//PlayN.log().debug("Element instance " + element.getInstance() );
		setToUpdate(true);
	}
	
	/**
	 * Adds the scene object.
	 *
	 * @param name the name
	 * @param object the object
	 * @throws NoNameException the no name exception
	 * @throws IDAlreadyPresentException 
	 */
	public void addSceneObject(String name,AbstractSceneObject object) throws NoNameException, IDAlreadyPresentException
	{
		object.setName(name);
		addSceneObject(object);
		setToUpdate(true);
	}
	
	/**
	 * Removes the scene object.
	 *
	 * @param object the object
	 * @throws AbstractObjectNotFoundException the abstract object not found exception
	 */
	public void removeSceneObject(AbstractSceneObject object) throws AbstractObjectNotFoundException
	{
		if (childs.contains(object))
			childs.remove(object);
		else throw new AbstractObjectNotFoundException();
		setToUpdate(true);
	}
	
	/**
	 * Gets the scene object.
	 *
	 * @param name the name
	 * @return the scene object
	 * @throws AbstractObjectNotFoundException the abstract object not found exception
	 */
	public AbstractSceneObject getSceneObject(String name) throws AbstractObjectNotFoundException
	{		
		for (Iterator<ObjectID> iterator = childs.iterator(); iterator.hasNext();) {
			ObjectID type = iterator.next();
			if (type.getName()==name)
				return type.getInstance();
		}
		for (Iterator<ObjectID> iterator = pendingChilds.iterator(); iterator.hasNext();) {
			ObjectID type = iterator.next();			
			if (type.getName()==name)
				return type.getInstance();
		}
		throw new AbstractObjectNotFoundException();		
	}
	
	/**
	 * Gets the scene object.
	 *
	 * @param i the i
	 * @return the scene object
	 */
	public AbstractSceneObject getSceneObject(int i)
	{
		return (AbstractSceneObject) childs.toArray()[i];				
	}

	
	/**
	 * Builds the child.
	 */
	public void buildChilds()
	{		
		ObjectID element = pendingChilds.poll();		
		//PlayN.log().debug("Object " + this);
		while(element!=null )
		{			 
			childs.add(element);
			element.getInstance().build();
			element.getInstance().setToUpdate(false);
			
			if (!element.getInstance().isToUpdate())
			{
				//PlayN.log().debug("BuildChild " + element.getInstance() + "isToUpdate " + element.getInstance().isToUpdate());
				if (element.getInstance() instanceof AbstractSceneObjectGroup) {
					((AbstractSceneObjectGroup) element.getInstance()).buildChilds();
				}
			}
			getRoot().add(element.getInstance().getRoot());			 
			element = pendingChilds.poll();		
		}	
		setToUpdate(false);
	}
	
	
	public void updateChilds()
	{
		//call update on child builded
		//PlayN.log().debug("UpdateChilds " + this);
		for (Iterator<ObjectID> iterator = childs.iterator(); iterator.hasNext();) {
			ObjectID obj = iterator.next();					
			//type.getInstance().build();
			if (obj.getInstance() instanceof AbstractSceneObjectGroup) {
				AbstractSceneObjectGroup objGroup = (AbstractSceneObjectGroup)obj.getInstance();
				objGroup.updateState();
				if (objGroup.pendingChilds.size() >0) 
				objGroup.buildChilds();								
			}
			obj.getInstance().updateState();		
		}
		this.updateState();
		
	}
	
	/**
	 * Gets the childs.
	 *
	 * @return the childs
	 */
	public TreeSet<ObjectID> getChilds() {
		return childs;
	}

	/**
	 * Sets the childs.
	 *
	 * @param childs the new childs
	 */
	public void setChilds(TreeSet<ObjectID> childs) {
		this.childs = childs;
		setToUpdate(true);
	}
	
	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize()
	{
		return childs.size();
	}
	
	/**
	 * Removes the all scene object child.
	 */
	public void removeAllSceneObjectChild()
	{
		for (Iterator<ObjectID> iterator = childs.iterator(); iterator.hasNext();) {
			ObjectID type = iterator.next();
			if (type.getInstance() instanceof AbstractSceneObjectGroup) {
				((AbstractSceneObjectGroup)type.getInstance()).removeAllSceneObjectChild();				
			}
						
		}
		for (Iterator<ObjectID> iterator = childs.iterator(); iterator.hasNext();) {
			ObjectID type = iterator.next();			
			try {
				removeSceneObject(type.getInstance());
			} catch (AbstractObjectNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		setToUpdate(true);
	}
	
	@Override
	public void systemBuild()
	{
		build();
		buildChilds();
	}
	
	@Override
	public boolean isToUpdate() {		
		if (pendingChilds.size()> 0) return true;
		
		for (Iterator<ObjectID> iterator = childs.iterator(); iterator.hasNext();) {
			ObjectID child = (ObjectID) iterator.next();
			if (child.getInstance().isToUpdate()){				
				return true;			
			}
		}
		
		return super.isToUpdate();
	}
	
}
