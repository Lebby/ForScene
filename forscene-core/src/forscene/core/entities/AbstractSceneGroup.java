package forscene.core.entities;

import java.util.ArrayList;
import java.util.Iterator;

import playn.core.GroupLayer;

import forscene.core.util.GraphicFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractSceneGroup.
 */
public abstract class AbstractSceneGroup{
	
	/** The prev. */
	private AbstractSceneGroup next,prev;
	
	/** The scenes. */
	private ArrayList<AbstractScene> scenes;
	
	/** The root. */
	private GroupLayer root;	
	
	/** The current scene. */
	private float currentScene = -1;
	
	
	/**
	 * Builds the.
	 *
	 * @return the array list
	 */
	public abstract ArrayList<AbstractScene> build();
	
	/**
	 * Instantiates a new abstract scene group.
	 */
	public AbstractSceneGroup()
	{
		setRoot(GraphicFactory.createGroupLayer());
		setScenes(new ArrayList<AbstractScene>());
	}
	
	
	/**
	 * Gets the next.
	 *
	 * @return the next
	 */
	public AbstractSceneGroup getNext()
	{
		return next;
	}
	
	/**
	 * Gets the prev.
	 *
	 * @return the prev
	 */
	public AbstractSceneGroup getPrev()
	{
		return prev;
	}
	
	/**
	 * Sets the next.
	 *
	 * @param next the new next
	 */
	public void setNext(AbstractSceneGroup next)
	{
		this.next=next;
	}
	
	/**
	 * Sets the prev.
	 *
	 * @param prev the new prev
	 */
	public void setPrev(AbstractSceneGroup prev)
	{
		this.prev=prev;
	}

	
	/**
	 * Adds the scenes.
	 *
	 * @param scenes the scenes
	 */
	public void addScenes(ArrayList<AbstractScene> scenes)
	{
		if (this.getScenes() == null) this.setScenes(scenes);
		this.getScenes().addAll(scenes);
	}
	
	/*@Override
	public void setScenes(ArrayList<GLCScene> scenes)
	{
		scenes=scenes;
	}*/
	
	/**
	 * Chain.
	 *
	 * @param scenes the scenes
	 */
	public void chain(ArrayList<AbstractScene> scenes)
	{
		ArrayList<AbstractScene> tmp = new ArrayList<AbstractScene>();
		
		if (scenes == null) return;
		AbstractScene current=null,prev=null;
	
		for (Iterator<AbstractScene> iterator = scenes.iterator(); iterator.hasNext();) {
			current =  iterator.next();
			current.setPrev(prev);		
			if (prev != null )prev.setNext(current);
			prev=current;
			tmp.add(current);
		}
		this.setScenes(tmp);
		
		//chain scene sequence
		for (Iterator<AbstractScene> iterator = this.getScenes().iterator(); iterator.hasNext();) {			
			current =  iterator.next();
		}
	}
	
	/**
	 * Inner build.
	 */
	public void innerBuild()
	{
		chain(build());
	}
	
	/**
	 * Gets the first scene.
	 *
	 * @return the first scene
	 */
	public AbstractScene getFirstScene()
	{
		if (getScenes().size() == 0) return null;
		return getScenes().get(0);
	}
	
	/**
	 * Checks for next.
	 *
	 * @return true, if successful
	 */
	public boolean hasNext()
	{
		if (next == null) return false;
		return true;
	}

	/**
	 * Gets the scenes.
	 *
	 * @return the scenes
	 */
	public ArrayList<AbstractScene> getScenes() {
		return scenes;
	}

	/**
	 * Sets the scenes.
	 *
	 * @param scenes the new scenes
	 */
	public void setScenes(ArrayList<AbstractScene> scenes) {
		this.scenes = scenes;
	}
	
	/**
	 * Adds the scene.
	 *
	 * @param scene the scene
	 */
	public void addScene(AbstractScene scene)
	{
		getScenes().add(scene);
	}

	/**
	- * @return the root
	 */
	public GroupLayer getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(GroupLayer root) {
		this.root = root;
	}
}
