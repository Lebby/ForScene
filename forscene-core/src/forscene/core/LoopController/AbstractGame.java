package forscene.core.LoopController;

import java.util.ArrayList;

import playn.core.Game;
import playn.core.GroupLayer;
import forscene.core.entities.AbstractScene;
import forscene.core.entities.AbstractSceneGroup;


/**
 * The Class AbstractGame.
 * This class is the "main class" that you need to extends to implement your game. 
 * It fowards management of game loop to an AbstractGameLoopManager instance.
 * 
 * The main purpose is to manage logical scene sequence and you can do implementing build method. 
 * In build method you can build your game by creating scenes, scene groups and then adding to abstract game.  
 * 
 * Why it's here is useless!: 
 * At start, scene management, time management, draw management and various function were thinked to be splitted in different managers.
 * Now, it's logical useless, but i think that i'll split different management to achieve a better design and a better optimization!
 *    
 */
public abstract class AbstractGame implements Game, IGameLoopManager {
	
	/** Frame count. */
	static long frame = 0;
	
	/** The game manager instance. */
	IGameLoopManager gameManager;
	
	/**
	 * Main method.
	 * Implementing this method you can add scenes and scenegroups to build your game!
	 * It is called in init method and add scenes/scenegroups reference.
	 */
	public abstract  void build();
	

	/* (non-Javadoc)
	 * @see playn.core.Game#init()
	 */
	public void init() {		
		gameManager =  AbstractGameLoopManager.getInstance();
		build();
		
	};
	
	
	/* (non-Javadoc)
	 * @see playn.core.Game#paint(float)
	 */
	public void paint(float alpha) {
		paint();
	}
	
	// delta = ms from last call
	/* (non-Javadoc)
	 * @see playn.core.Game#update(float)
	 */
	public void update(float delta) 
	{
		//#Debug
		//PlayN.log().debug("delta" + delta + "Incs" );
		//for ( int i = 0 ; i < incs; i++)
		//{
			//PlayN.log().debug("INCSECONDS");
			//incSeconds();
		//}
		frame++;
		incTicks();
		incTime(delta);
		//#Debug
		/*if ((updateRate() != 0 ) && ( (frame%updateRate()) ==0) ) 
		{			
			updateState();
		}*/
		updateState();
		
		//PlayN.log().debug("update update state");
		
		
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#incTime(float)
	 */
	public void incTime(float delta) {
		gameManager.incTime(delta);
	}


	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getSceneGroups()
	 */
	public ArrayList<AbstractSceneGroup> getSceneGroups() {
		return gameManager.getSceneGroups();
		
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getNextScene()
	 */
	public AbstractScene getNextScene() {
		return gameManager.getNextScene();
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getNextSceneGroup()
	 */
	public AbstractSceneGroup getNextSceneGroup() {
		return gameManager.getNextSceneGroup();
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#setCurrentSceneGroup(forscene.core.entities.AbstractSceneGroup)
	 */
	public void setCurrentSceneGroup(AbstractSceneGroup sceneGroup) {
		 gameManager.setCurrentSceneGroup(sceneGroup);
		
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#setCurrentScene(forscene.core.entities.AbstractScene)
	 */
	public void setCurrentScene(AbstractScene scene) {
		gameManager.setCurrentScene(scene);
		
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getCurrentSceneGroup()
	 */
	public AbstractSceneGroup getCurrentSceneGroup() {
		return gameManager.getCurrentSceneGroup();
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getCurrentScene()
	 */
	public AbstractScene getCurrentScene() {
		return gameManager.getCurrentScene();
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#loadScene(forscene.core.entities.AbstractScene)
	 */
	public void loadScene(AbstractScene scene) {
		gameManager.loadScene(scene);
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#loadSceneGroup(forscene.core.entities.AbstractSceneGroup)
	 */
	public void loadSceneGroup(AbstractSceneGroup sceneGroup) {
		gameManager.loadSceneGroup(sceneGroup);
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#addSceneGroup(forscene.core.entities.AbstractSceneGroup)
	 */
	public void addSceneGroup(AbstractSceneGroup sceneGroup) {
		gameManager.addSceneGroup(sceneGroup);		
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#removeSceneGroup(forscene.core.entities.AbstractSceneGroup)
	 */
	public void removeSceneGroup(AbstractSceneGroup sceneGroup) {
		gameManager.removeSceneGroup(sceneGroup);
		
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#updateState()
	 */
	public void updateState() {
		gameManager.updateState();
		
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#draw(forscene.core.entities.AbstractScene)
	 */
	public void draw(AbstractScene scene) {
		gameManager.draw(scene);		
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#resetSeconds()
	 */
	public void resetSeconds() {
		gameManager.resetSeconds();
		
	}	
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getRoot()
	 */
	public GroupLayer getRoot() {
		return gameManager.getRoot();
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#setRoot(playn.core.GroupLayer)
	 */
	public void setRoot(GroupLayer root) {
		gameManager.setRoot(root);
		
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#setSeconds(long)
	 */
	public void setSeconds(long seconds) {
		gameManager.setSeconds(seconds);
		
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#setCurrentTimeTimer(long)
	 */
	public void setCurrentTimeTimer(long currentTimeTimer) {
		gameManager.setCurrentTimeTimer(currentTimeTimer);
		
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getSeconds()
	 */
	public long getSeconds() {
		return gameManager.getSeconds();
		
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getCurrentTimeTimer()
	 */
	public long getCurrentTimeTimer() {
		return gameManager.getCurrentTimeTimer();
	}

			
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#paint()
	 */
	public void paint() {
		gameManager.paint();
		
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#setSize(int, int)
	 */
	public void setSize(int width, int height) {
		gameManager.setSize(width, height);
		
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#goNext()
	 */
	public void goNext() {
		gameManager.goNext();
		
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#incTicks()
	 */
	public void incTicks() {
		gameManager.incTicks();
		
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getTicks()
	 */
	public long getTicks() {		
		return gameManager.getTicks();
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getTickRate()
	 */
	public short getTickRate() {		
		return gameManager.getTickRate();	
	}	
	
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#addScene(forscene.core.entities.AbstractScene)
	 */
	public void addScene(AbstractScene scene)
	{
		 gameManager.addScene(scene);
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getHeight()
	 */
	public float getHeight()
	{
		return gameManager.getHeight();
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getHeight()
	 */
	public float getWidth()
	{
		return gameManager.getWidth();
	}
	
}