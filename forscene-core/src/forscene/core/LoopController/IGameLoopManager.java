package forscene.core.LoopController;

import java.util.ArrayList;

import playn.core.GroupLayer;

import forscene.core.entities.AbstractScene;
import forscene.core.entities.AbstractSceneGroup;
import forscene.core.util.DebugLayer;

public interface IGameLoopManager {
	
	ArrayList<AbstractSceneGroup> getSceneGroups();
	
	AbstractScene getNextScene();
	AbstractSceneGroup getNextSceneGroup();
	void setCurrentSceneGroup(AbstractSceneGroup sceneGroup);
	void setCurrentScene(AbstractScene scene);
	AbstractSceneGroup getCurrentSceneGroup();
	AbstractScene getCurrentScene();
	
	void loadScene(AbstractScene scene); // call scene.build
	void loadSceneGroup(AbstractSceneGroup sceneGroup); //--> call scenegroup.build
	
	void addSceneGroup(AbstractSceneGroup sceneGroup); //default add on last
	
	void removeSceneGroup(AbstractSceneGroup sceneGroup);		
	
	void updateState();	
	void draw(AbstractScene scene); //attach in root

	void init();

	void resetSeconds();

	void setDebugMode(boolean debug);

	DebugLayer getDebug();

	boolean isDebugMode();

	void setDebug(DebugLayer debug);

	GroupLayer getRoot();

	void setRoot(GroupLayer root);

	void setSeconds(long seconds);

	void setCurrentTimeTimer(long currentTimeTimer);

	long getSeconds();

	long getCurrentTimeTimer();

	//void incSeconds();

	void paint();

	void setSize(int width, int height);

	void goNext();

	void incTicks();

	long getTicks();

	short getTickRate();

	void addScene(AbstractScene scene);

	void incTime(float delta);
	
	
}