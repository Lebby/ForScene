package forscene.core.entities;


import playn.core.CanvasLayer;
import playn.core.GroupLayer;
import playn.core.ImageLayer;
import playn.core.Layer;
import playn.core.PlayN;
import playn.core.SurfaceLayer;




/**
 * The Class AbstractSceneObject.
 */
public abstract class AbstractSceneObject<T extends Layer> implements ISceneObject<T>{

	/**
	 * Instantiates a new abstract scene object.
	 */
	/*
	public AbstractSceneObject() {
		setRoot(graphics().createImageLayer());		
		
		setToUpdate(false);
	}*/

	/** The update rate. */
	private long updateRate = 0;
	
	/** The root */
	private T root;
	
	/** The ID. */
	private ObjectID ID;
	
	/** The to update. */
	private boolean toUpdate = true;
	
	private boolean builded = false; 

	// The parent. If it is null means that it is orphan => it isn't in scenegraph. 
	private AbstractSceneObjectGroup parent;
	
	
	public AbstractSceneObject() {
		setID(new ObjectID(this));
		setName(""+this);
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.ISceneObject#isToUpdate()
	 */
	public boolean isToUpdate() {		
		return toUpdate;
	}

	/* (non-Javadoc)
	 * @see forscene.core.entities.ISceneObject#setToUpdate(boolean)
	 */
	public void setToUpdate(boolean toUpdate) {
		
		/*PlayN.log().debug(this + " Called setToUpdate " + toUpdate);
		
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		for (int i = 0; i < stackTraceElements.length; i++) {
			PlayN.log().debug("" + stackTraceElements[i]);
	}*/
		
		this.toUpdate = toUpdate;
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.ISceneObject#getRoot()
	 */	
	public T getRoot()
	{
		return root;
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.ISceneObject#setRoot(playn.core.Layer)
	 */
	public void setRoot(T layer)
	{
		this.root = layer;
		setToUpdate(true);
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.ISceneObject#updateDraw(playn.core.Layer)
	 */
	public void updateDraw(Layer layer)
	{
//		this.getRoot().clear();
		//this.getRoot().add(layer);
		getRoot().parent().remove(layer);
		getRoot().parent().add(layer);
		//setToUpdate(false);
	}	
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.ISceneObject#build()
	 */
	public abstract void build();
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.ISceneObject#buildOnce()
	 */
	public void buildOnce()
	{
		if(!isBuilded())
		{
			systemBuild();
		}
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.ISceneObject#systemBuild()
	 */
	public void systemBuild()
	{
		build();		
		while(!ResourceManager.getInstance().isReady())
		{
			ResourceManager.getInstance().loadResources();
		}
		setBuilded(true);
		setToUpdate(true);		
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.ISceneObject#setUpdateRate(long)
	 */
	public void setUpdateRate(long rate )
	{
		this.updateRate = rate;
	}
	

	/* (non-Javadoc)
	 * @see forscene.core.entities.ISceneObject#getUpdateRate()
	 */
	public long getUpdateRate()
	{
		return updateRate;
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.ISceneObject#hide()
	 */
	public void hide()
	{
		root.setAlpha(0);
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.ISceneObject#show()
	 */
	public void show()
	{
		root.setAlpha(1);
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.ISceneObject#isVisible()
	 */
	public boolean isVisible()
	{
		if (root.alpha()>0) return true;
		return false;
	}
	
	/**
	 * @param builded the builded to set
	 */
	protected void setBuilded(boolean builded) {
		this.builded = builded;
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.ISceneObject#isBuilded()
	 */
	public boolean isBuilded() {
		return builded;
	}
	
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.ISceneObject#setID(forscene.core.entities.ObjectID)
	 */
	public void setID(ObjectID objectID) {
		this.ID = objectID;
		
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.ISceneObject#getType()
	 */
	public String getType()
	{
		return ID.getType();
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.ISceneObject#getName()
	 */
	public String getName() {
		return ID.getName();
	}

	/* (non-Javadoc)
	 * @see forscene.core.entities.ISceneObject#setName(java.lang.String)
	 */
	public void setName(String name) {
		ID.setName(name);
	}
	
	public ObjectID getObjectID() {		
		return ID;
	}

	public long getID() {
		return ID.getID();
	}
	
	
	
	//parent
	public AbstractSceneObjectGroup getParent() {		
		return parent;
	}
	public boolean hasParent() {
		return (parent!=null);
	}
	public void setParent(AbstractSceneObjectGroup parent) {
		this.parent=parent;
		parent.setToUpdate(true);
		
	}

	
	//TODO: TO MOVE
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.ISceneObject#contains(int, int)
	 */
	public boolean contains(int x, int y)
	{
		return contains(x,y,root);
	}


	private boolean contains(int x, int y, Layer layer)
	{
		if (layer instanceof GroupLayer)
		{			
			for (int i = 0; i < ((GroupLayer)layer).size(); i++)
				if (contains(x,y,((GroupLayer)layer).get(i))) return true;			
		}
		else if ((layer instanceof Layer.HasSize) ||
			 (layer instanceof ImageLayer) ||
			 (layer instanceof SurfaceLayer) ||
			 (layer instanceof CanvasLayer) )
		{
			 Layer.HasSize tmp = ( Layer.HasSize)layer;
			 
			 if ( (x > tmp.originX()) && (x<  (tmp.originX() +  tmp.width()))   
			 &&   (y > tmp.originY()) && (y<  (tmp.originY() + tmp.height())) )
			 {
				 return true;
			 }		 
		}
		 return false;
	}
	
	//evil function
	/**
	 * Redraw.
	 */
	public void refresh()
	{
		PlayN.log().debug("called refresh");
		//#Debug
		//PlayN.log().debug("REDRAW SIZE 1 : " + getRoot().size() + " depth : " + getRoot().depth() + " : " + getRoot().getClass());
		GroupLayer parent = this.getRoot().parent();
		if (parent != null )
		{
			parent.remove(this.getRoot());
			//parent.clear();
			parent.add(getRoot());			
		}
		//#Debug
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
}