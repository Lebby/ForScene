package forscene.core.old;

import java.util.ArrayList;
import playn.core.GroupLayer;
import playn.core.Graphics;
import forscene.core.util.GraphicFactory;

import static playn.core.PlayN.assetManager;
import static playn.core.PlayN.graphics;
import static playn.core.PlayN.pointer;


public class SceneGroup {
	private GroupLayer root;
	private ArrayList<Scene> scenes;
	private int currentScene = -1;
	
	public SceneGroup()
	{
		root = 	GraphicFactory.createGroupLayer();
		scenes = new ArrayList<Scene>();
	}
	
	public GroupLayer getRoot() {
		return root;
	}
	public void setRoot(GroupLayer root) {
		this.root = root;
	}
	public ArrayList<Scene> getScenes() {
		return scenes;
	}
	public void setScenes(ArrayList<Scene> scenes) {
		this.scenes = scenes;
	}
	
	public Scene getFirstScene()
	{
		return scenes.get(0);
	}
	
	public void addScene(Scene scene)
	{		
		scenes.add(scene);
	}
	
	public void addScene(Scene scene, int index)
	{
		scenes.add(index, scene);
	}
	
	public Scene getCurrentScene()
	{
		if (currentScene == -1 )
		{
			currentScene = 0;
		}
		/*System.out.println("CurrentScene :!!!" + currentScene);
		System.out.println("CurrentScene :!!!" + scenes.get(currentScene));
		System.out.println("CurrentScene :!!!" + scenes.get(1));
		System.out.println("CurrentScene :!!!" + scenes.get(2));
		System.out.println("CurrentScene :!!!" + scenes.get(3));*/
	
		return scenes.get(currentScene);
	}
	
	public boolean hasNext()
	{
		/*System.err.println("Scene size" + scenes.size());
		System.err.println("CurrentScene " + currentScene);*/
		if (currentScene  < scenes.size()-1 )
		{
			return true;
		}
		return false;
	}
	
	public void goNext()
	{
		if (hasNext())
		{
			//System.err.println("GONEXT!");
			currentScene++;
		}						
	}
	
}
