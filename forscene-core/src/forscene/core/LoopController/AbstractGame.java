package forscene.core.LoopController;

import java.util.ArrayList;

import playn.core.Game;
import playn.core.GroupLayer;
import playn.core.PlayN;
import forscene.core.entities.AbstractScene;
import forscene.core.entities.AbstractSceneGroup;
import forscene.core.util.DebugLayer;

public abstract class AbstractGame   implements Game, IGameLoopManager {
	static long frame = 0;
	IGameLoopManager gameManager;
	
	public abstract  void build();
	

	public void init() {		
		gameManager =  GameLoopManager.getInstance();
		build();
		
	};
	
	
	public void paint(float alpha) {
		paint();
	}
	
	// delta = ms from last call
	public void update(float delta) 
	{		
		//PlayN.log().debug("delta" + delta + "Incs" + incs);
		//for ( int i = 0 ; i < incs; i++)
		//{
			//PlayN.log().debug("INCSECONDS");
			//incSeconds();
		//}
		frame++;
		incTicks();
		incTime(delta);
		/*if ((updateRate() != 0 ) && ( (frame%(1f/updateRate())) ==0) ) 
		{			
			updateState();
		}*/
		updateState();
		//PlayN.log().debug("update update state");
		
	}

	
	public void incTime(float delta) {
		gameManager.incTime(delta);
	}


	public ArrayList<AbstractSceneGroup> getSceneGroups() {
		return gameManager.getSceneGroups();
		
	}

	
	public AbstractScene getNextScene() {
		return gameManager.getNextScene();
	}

	
	public AbstractSceneGroup getNextSceneGroup() {
		return gameManager.getNextSceneGroup();
	}

	
	public void setCurrentSceneGroup(AbstractSceneGroup sceneGroup) {
		 gameManager.setCurrentSceneGroup(sceneGroup);
		
	}

	
	public void setCurrentScene(AbstractScene scene) {
		gameManager.setCurrentScene(scene);
		
	}

	
	public AbstractSceneGroup getCurrentSceneGroup() {
		return gameManager.getCurrentSceneGroup();
	}

	
	public AbstractScene getCurrentScene() {
		return gameManager.getCurrentScene();
	}

	
	public void loadScene(AbstractScene scene) {
		gameManager.loadScene(scene);
		
	}

	
	public void loadSceneGroup(AbstractSceneGroup sceneGroup) {
		gameManager.loadSceneGroup(sceneGroup);
		
	}

	
	public void addSceneGroup(AbstractSceneGroup sceneGroup) {
		gameManager.addSceneGroup(sceneGroup);		
	}

	
	public void removeSceneGroup(AbstractSceneGroup sceneGroup) {
		gameManager.removeSceneGroup(sceneGroup);
		
	}

	
	public void updateState() {
		gameManager.updateState();
		
	}

	
	public void draw(AbstractScene scene) {
		gameManager.draw(scene);
		
	}

	
	public void resetSeconds() {
		gameManager.resetSeconds();
		
	}

	
	public void setDebugMode(boolean debug) {
		gameManager.setDebugMode(debug);
		
	}

	
	public DebugLayer getDebug() {
		return gameManager.getDebug();
	}

	
	public boolean isDebugMode() {
		return gameManager.isDebugMode();
	}

	
	public void setDebug(DebugLayer debug) {
		gameManager.setDebug(debug);
		
	}

	
	public GroupLayer getRoot() {
		return gameManager.getRoot();
	}

	
	public void setRoot(GroupLayer root) {
		gameManager.setRoot(root);
		
	}

	
	public void setSeconds(long seconds) {
		gameManager.setSeconds(seconds);
		
	}

	
	public void setCurrentTimeTimer(long currentTimeTimer) {
		gameManager.setCurrentTimeTimer(currentTimeTimer);
		
	}

	
	public long getSeconds() {
		return gameManager.getSeconds();
		
	}

	
	public long getCurrentTimeTimer() {
		return gameManager.getCurrentTimeTimer();
	}

	
	/*public void incSeconds() {
		gameManager.incSeconds();
		
	}*/

	
	public void paint() {
		gameManager.paint();
		
	}

	
	public void setSize(int width, int height) {
		gameManager.setSize(width, height);
		
	}

	
	public void goNext() {
		gameManager.goNext();
		
	}

	
	public void incTicks() {
		gameManager.incTicks();
		
	}

	
	public long getTicks() {		
		return gameManager.getTicks();
	}

	
	public short getTickRate() {		
		return gameManager.getTickRate();	
	}	
	
	
	public void addScene(AbstractScene scene)
	{
		 gameManager.addScene(scene);
	}
	
}  