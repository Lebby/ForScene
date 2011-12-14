package forscene.core.old;

import static playn.core.PlayN.assetManager;
import static playn.core.PlayN.graphics;
import static playn.core.PlayN.pointer;


import playn.core.Keyboard;
import playn.core.Layer;
import playn.core.Mouse;
import playn.core.GroupLayer;
import forscene.core.util.DebugLayer;


public class GameController {
	private static GroupLayer root;
	private static DebugLayer debug;
	
	private static Mouse mouseListener;
	private static Keyboard keyboardListener;
	
	//private static GroupLayer currentGroup;
	private static Layer current;
	
	private static Scene currentScene;
	private static SceneGroup currentSceneGroup;
	
	private static long seconds;
	
	private static boolean startTimer = false;
	private static long currentTimeTimer = 0;
	
	public GameController()
	{
		root = graphics().rootLayer();
		seconds = 0;
		debug = new DebugLayer();
	}
	
	public static GroupLayer getRoot() {
		return root;
	}
	public static void setRoot(GroupLayer root) {
		GameController.root = root;
	}
	public static Mouse getMouseListener() {
		return mouseListener;
	}
	public static void setMouseListener(Mouse mouseListener) {
		GameController.mouseListener = mouseListener;
	}
	public static Keyboard getKeyboardListener() {
		return keyboardListener;
	}
	public static void setKeyboardListener(Keyboard keyboardListener) {
		GameController.keyboardListener = keyboardListener;
	}
	
	public static void loadSceneGroup(SceneGroup sceneGroup)
	{		
		//root = graphics().rootLayer();
		root.clear();
		currentSceneGroup = sceneGroup;
		//loadScene(currentSceneGroup.getFirstScene()); //<--- Cause problem
	}
	
	public static void loadScene(Scene scene)
	{		
		if (current != null )
		{
			//current.setVisible(false);
			root.remove(current);
			//root.destroy();
			//root.clear();
		}
		
		current = scene.getRoot();
		root.add(current);
		currentScene = scene;
	}
	
	public static void incSeconds()
	{
		seconds++;
		debug.write(Long.toString(seconds));		
	}
	
	public static void resetSeconds()
	{
		seconds = 0;
	}
	
	public static long getSeconds()
	{
		return seconds;
	}
	
	public static void updateScene()
	{
		if (currentScene == null) currentScene = currentSceneGroup.getFirstScene();
		if (currentScene.IS_CONDITIONAL)
		{
			currentScene.updateState();
		}		
		if ( currentScene.IS_READY_TO_SWITCH)
		{
			goNext();
		}
		
		if ( currentScene.USE_TIMER)
		{
			if (startTimer == false )
			{
				startTimer = true;
				currentTimeTimer = seconds;
				
			}
			if ((startTimer) && (seconds - currentTimeTimer) == currentScene.getSeconds() )
			{
				goNext();
				startTimer = false;			
			}			
		}		
	}
	
	private static void goNext()
	{
		currentSceneGroup.goNext();		
		loadScene(currentSceneGroup.getCurrentScene());
		addDebugLayer();
	}
	
	private static void addDebugLayer()
	{		
		root.add(debug.getRoot());
	}
	
	public static void setSize(int width, int height)
	{
		graphics().setSize(width, height);		
	}
}
