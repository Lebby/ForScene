package forscene.core.entities;


import playn.core.CanvasLayer;
import playn.core.GroupLayer;
import playn.core.ImageLayer;
import playn.core.Layer;
import playn.core.SurfaceLayer;

import static playn.core.PlayN.graphics;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractSceneObject.
 */
public abstract class AbstractSceneObject implements ASOTemplate<Layer>{
	
	/** The update rate. */
	private long updateRate = 0;
	
	/** The root. */
	private ImageLayer root; //TODO: This must be template ... < T extends Layer > !!!
	
	/** The name. */
	private String name="";
	
	/** The ID. */
	private ObjectID ID;
	
	/** The to update. */
	private boolean toUpdate = true;
	
	private boolean builded = false; 

	private AbstractSceneObject parent;
	
	/**
	 * Checks if is to update.
	 *
	 * @return true, if is to update
	 */
	public boolean isToUpdate() {		
		return toUpdate;
	}

	/**
	 * Sets the to update.
	 *
	 * @param toUpdate the new to update
	 */
	public void setToUpdate(boolean toUpdate) {
		this.toUpdate = toUpdate;
	}

		/**
	 * Instantiates a new abstract scene object.
	 */
	public AbstractSceneObject() {
		//root = GraphicFactory.createGroupLayer();
		root = graphics().createImageLayer();

		ID = new ObjectID(this);
		/*name = this.getClass().getName();
		if (name.lastIndexOf('.') > 0) {
		    name = name.substring(name.lastIndexOf('.')+1);
		}*/
		name = ""+this;
	}	
	
	
	/**
	 * Gets the root.
	 *
	 * @return the root
	 */	
	public Layer getRoot()
	{
		return root;
	}
	
	/**
	 * Sets the root.
	 *
	 * @param groupLayer the new root
	 */
	public void setRoot(Layer layer)
	{
		this.root = (ImageLayer)layer;
		setToUpdate(true);
	}
	
	/**
	 * Update draw.
	 *
	 * @param layer the layer
	 */
	public void updateDraw(Layer layer)
	{
//		this.getRoot().clear();
		//this.getRoot().add(layer);
		getRoot().parent().remove(layer);
		getRoot().parent().add(layer);
		setToUpdate(false);
	}
	
	//evil function
	/**
	 * Redraw.
	 */
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
	
	
	/**
	 * Builds the.
	 */
	public abstract void build();
	
	public void buildOnce()
	{
		if(!isBuilded())
		{
			systemBuild();
		}
	}
	
	/**
	 * Update state.
	 */
	public abstract void updateState();
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
		
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType()
	{
		return ID.getType();
	}
	
	public void systemBuild()
	{
		build();
		setBuilded(true);
		setToUpdate(false);
	}
	
	
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
	
	/**
	 * Sets the update rate.
	 *
	 * @param rate the new update rate
	 */
	public void setUpdateRate(long rate )
	{
		this.updateRate = rate;
	}
	

	/**
	 * Gets the update rate.
	 *
	 * @return the update rate
	 */
	public long getUpdateRate()
	{
		return updateRate;
	}

	public void setID(ObjectID objectID) {
		this.ID = objectID;
		
	}
	
	public AbstractSceneObject getParent()
	{
		return this.parent;
	}
	
	public void setParent(AbstractSceneObject parent)
	{
		this.parent = parent;
	}
	
	public boolean hasParent()
	{
		return (parent!=null);
	}

	/**
	 * @return the builded
	 */
	public boolean isBuilded() {
		return builded;
	}
	
	public void hide()
	{
		root.setAlpha(0);
	}
	
	public void show()
	{
		root.setAlpha(1);
	}
	
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
	
}