package forscene.core.entities;

import java.util.ArrayList;
import java.util.Iterator;

import playn.core.GroupLayer;

import forscene.core.util.GraphicFactory;

public abstract class AbstractSceneGroup {
	private AbstractSceneGroup next,prev;
	private ArrayList<AbstractScene> scenes;
	
	private GroupLayer root;	
	private float currentScene = -1;
	
	
	public abstract ArrayList<AbstractScene> build();
	
	public AbstractSceneGroup()
	{
		root = 	GraphicFactory.createGroupLayer();
		setScenes(new ArrayList<AbstractScene>());
	}
	
	
	public AbstractSceneGroup getNext()
	{
		return next;
	}
	public AbstractSceneGroup getPrev()
	{
		return prev;
	}
	
	public void setNext(AbstractSceneGroup next)
	{
		this.next=next;
	}
	public void setPrev(AbstractSceneGroup prev)
	{
		this.prev=prev;
	}

	
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
		
		for (Iterator<AbstractScene> iterator = this.getScenes().iterator(); iterator.hasNext();) {
			
			current =  iterator.next();
			//current.setPrev(prev);		
			//if (prev != null )prev.setNext(current);
			
			/*PlayN.log().debug("*-------------*");
			PlayN.log().debug("GLCScene prev :" + current.getPrev());
			PlayN.log().debug("GLCScene ---- :" + current);			
			PlayN.log().debug("GLCScene next :" + current.getNext());
			prev=current;*/			
			
		}
		//this.scenes = scenes;//
	}
	
	public void innerBuild()
	{
		chain(build());
	}
	
	public AbstractScene getFirstScene()
	{
		if (getScenes().size() == 0) return null;
		return getScenes().get(0);
	}
	
	public boolean hasNext()
	{
		if (next == null) return false;
		return true;
	}

	public ArrayList<AbstractScene> getScenes() {
		return scenes;
	}

	public void setScenes(ArrayList<AbstractScene> scenes) {
		this.scenes = scenes;
	}
	
	public void addScene(AbstractScene scene)
	{
		getScenes().add(scene);
	}
}
