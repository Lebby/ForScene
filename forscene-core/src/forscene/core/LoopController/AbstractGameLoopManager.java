package forscene.core.LoopController;

import static playn.core.PlayN.graphics;

import java.util.ArrayList;

import playn.core.GroupLayer;
import playn.core.PlayN;

import forscene.core.entities.AbstractScene;
import forscene.core.entities.AbstractSceneGroup;
import forscene.core.entities.AbstractSceneObjectGroup;
import forscene.core.entities.ISceneObject;
import forscene.core.entities.NullAbstractSceneObject;
import forscene.core.events.system.DrawSceneEvent;
import forscene.core.events.system.EventManager;
import forscene.core.events.system.InitEvent;
import forscene.core.events.system.LoadSceneEvent;
import forscene.core.events.system.LoadSceneGroupEvent;
import forscene.core.events.system.NextEvent;
import forscene.core.events.system.UpdateSceneEvent;
import forscene.core.helper.DefaultSceneGroup;



// TODO: Auto-generated Javadoc
/**
 * The Class AbstractGameLoopManager.
 * It's a Singlethon class. It is true core of this library because it manages game loop.
 * 
 */
public abstract class AbstractGameLoopManager implements IGameLoopManager{
	
	/** Singlethon instance */
	private static AbstractGameLoopManager instance = null;
	
	/** DebugMode: if you set true a useless layer will be added to the game that show ticks in the upper-left corner */
	private boolean DEBUGMODE = true;
	
	/** currentScene: reference to current scene */
	private AbstractScene currentScene;
	
	/** prevScene: reference to previous scene */
	private AbstractScene prevScene;
	
	/** currentSceneGroup: reference to current sceneGroup */
	private AbstractSceneGroup currentSceneGroup;
	
	/** sceneGroups: container of all sceneGroups */
	private ArrayList<AbstractSceneGroup> sceneGroups;
	
	/** eventMonitor: instance of event monitor that manages events */
	private EventManager eventMonitor;
	
	/** seconds: seconds elapsed from starting game */
	private long seconds;
	
	/** ticks: ticks elapsed from starting game. Tick is a call of update function ( inherited from PlayN ) */
	private long ticks = 0;
	
	/** ms: milliseconds elapsed from starting game. It's calculated from alpha passed by PlayN. */
	private float ms = 0;
	
	/** tickRate: tick per seconds. It's similar to fps. */
	private short tickRate = 25 ;
	
	/** The start timer. */
	private boolean startTimer = false;
	
	/** The current time timer. */
	private long currentTimeTimer = 0;
	
	//PaintManager
	/** The root. */
	private static GroupLayer root;
	
	// Fake Scene ... used to parent
	private AbstractSceneObjectGroup parent = new NullAbstractSceneObject();
	
	/**
	 * Instantiates a new abstract game loop manager.
	 */
	protected AbstractGameLoopManager()
	{
		eventMonitor = EventManager.getInstance();
		sceneGroups = new ArrayList<AbstractSceneGroup>();
		eventMonitor.push(new InitEvent());
		root = graphics().rootLayer();		
	}
	
	
	/**
	 * Gets the single instance of AbstractGameLoopManager.
	 *
	 * @return single instance of AbstractGameLoopManager
	 */
	public static IGameLoopManager getInstance()
	{
		if (instance == null)
		{
			instance = new AbstractGameLoopManager() {
			};
		}
		return instance;
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getCurrentScene()
	 */
	public AbstractScene getCurrentScene() {
		return this.currentScene;		
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#setCurrentScene(forscene.core.entities.AbstractScene)
	 */
	public void setCurrentScene(AbstractScene scene) {
		currentScene=scene;
	}
	
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getCurrentSceneGroup()
	 */
	public AbstractSceneGroup getCurrentSceneGroup() {		
		return currentSceneGroup;
	}
		
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#setCurrentSceneGroup(forscene.core.entities.AbstractSceneGroup)
	 */
	public void setCurrentSceneGroup(AbstractSceneGroup sceneGroup) 
	{
		currentSceneGroup = sceneGroup;		
	}
		
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#addSceneGroup(forscene.core.entities.AbstractSceneGroup)
	 */
	public void addSceneGroup(AbstractSceneGroup sceneGroup) 
	{
		AbstractSceneGroup tmp = null;
		if (this.sceneGroups.size() > 0 )
		{
			//#Debug
			//PlayN.log().debug("Add --- next size > 0");
			tmp = this.sceneGroups.get(sceneGroups.size()-1);
			sceneGroup.setPrev(tmp);			
			tmp.setNext(sceneGroup);
			sceneGroups. set(sceneGroups.size()-1, tmp);			
		}//else setCurrentSceneGroup(sceneGroup);		
		this.sceneGroups.add(sceneGroup);
		//#Debu
		/*PlayN.log().debug("Add --- next" + this.sceneGroups.get(sceneGroups.size()-1).getNext());
		PlayN.log().debug("Add --- prev" + this.sceneGroups.get(sceneGroups.size()-1).getPrev());
		PlayN.log().debug("Add --- last" + this.sceneGroups.get(sceneGroups.size()-1));*/
		
	}
	
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getNextSceneGroup()
	 */
	public AbstractSceneGroup getNextSceneGroup() {
		if (currentSceneGroup == null) return null;		
		return currentSceneGroup.getNext();		
	}
	
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getNextScene()
	 */
	public AbstractScene getNextScene() {
		if (currentScene == null) return null;
		return currentScene.getNext();		
	}
	
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getSceneGroups()
	 */
	public ArrayList<AbstractSceneGroup> getSceneGroups() {
		return sceneGroups;
	}
	

	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#loadSceneGroup(forscene.core.entities.AbstractSceneGroup)
	 */
	public void loadSceneGroup(AbstractSceneGroup sceneGroup) {
		if (sceneGroup == null) throw new NullPointerException();		
		//PlayN.log().debug("glc.loadscenegroup" + sceneGroup);
		currentSceneGroup = sceneGroup;
		currentSceneGroup.chain(currentSceneGroup.build());
		currentScene = null;		
	}
	
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#loadScene(forscene.core.entities.AbstractScene)
	 */
	public void loadScene(AbstractScene scene) {
		if (scene == null){
			scene = currentSceneGroup.getFirstScene();
		}
		else
		{			
			PlayN.log().debug("loadscene build/buildchild");
			scene.systemBuild();
			//currentScene = scene;
		}
		if (currentScene != null) prevScene=currentScene;
		draw(scene);
		//PlayN.log().debug("LoadScene end!");
		
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#removeSceneGroup(forscene.core.entities.AbstractSceneGroup)
	 */
	public void removeSceneGroup(AbstractSceneGroup sceneGroup) {		
		if (sceneGroup == null) throw new NullPointerException();
		sceneGroups.remove(sceneGroups);
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#setDebugMode(boolean)
	 */
	public void setDebugMode(boolean debug)
	{
		DEBUGMODE = debug;
	}

	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#isDebugMode()
	 */
	public boolean isDebugMode() {
		return DEBUGMODE;
	}

	//PaintMan	
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getRoot()
	 */
	public GroupLayer getRoot() {
		return root;
	}
	
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#setRoot(playn.core.GroupLayer)
	 */
	public void setRoot(GroupLayer root) {
		AbstractGameLoopManager.root = root;
	}
	
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#setSize(int, int)
	 */
	public void setSize(int width, int height)
	{
		graphics().setSize(width, height);		
	}

		
	//Time Monitor
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#setSeconds(long)
	 */
	public void setSeconds(long seconds) {
		this.seconds = seconds;
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#setCurrentTimeTimer(long)
	 */
	public void setCurrentTimeTimer(long currentTimeTimer) {
		this.currentTimeTimer = currentTimeTimer;
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getSeconds()
	 */
	public long getSeconds() {
		return seconds;
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getCurrentTimeTimer()
	 */
	public long getCurrentTimeTimer() {
		return currentTimeTimer;
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#incTicks()
	 */
	public void incTicks()
	{
		ticks++;		
	}
	
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#resetSeconds()
	 */
	public void resetSeconds()
	{
		seconds = 0;
	}
	
	// =======
	
	//most complex ................. 

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#goNext()
	 */
	public void goNext()
	{
		if (currentScene == null) 
		{
			if (currentSceneGroup == null )
			{
				if (sceneGroups.size()>0)
				{				
					if (sceneGroups.get(0) == null )
					{
						return;
					}
					eventMonitor.push(new LoadSceneGroupEvent(sceneGroups.get(0)));
				}
			}else //if (currentSceneGroup != null )
			{
				eventMonitor.push(new LoadSceneEvent(currentSceneGroup.getFirstScene()));
			}
		}
		else //(currentScene != null)
		{
			if (currentScene.hasNext()) //switch scene
			{
				eventMonitor.push(new LoadSceneEvent(currentScene.getNext()));
			}
			else //switch sceneGroup
			{
				PlayN.log().debug("GoScene !currentScene.hasNext() ...");
				if (currentSceneGroup.hasNext())
				{
					eventMonitor.push(new LoadSceneGroupEvent(currentSceneGroup.getNext()));
				}
			}
		}
	}
					
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#draw(forscene.core.entities.AbstractScene)
	 */
	public void draw(AbstractScene scene) 
	{
		if ((scene != null) && (currentScene != scene ) )
		{				
				if (scene.getRoot() != null)
				{
						getRoot().clear();
						getRoot().add(scene.getRoot());
						currentScene= scene;
						scene.setParent(parent);
				}
		}
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#paint()
	 */
	public void paint()
	{
		//ATTENZIONE ELIMINATO MOMENTANEAMENTE
		//eventMonitor.push(new DrawSceneEvent(currentScene));
	}
	
	// =======
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#updateState()
	 */
	public void updateState() 
	{
		eventMonitor.update();
		if (currentScene != null )
		{
			if (currentScene.getUpdateRate() == 0)
			{
				eventMonitor.push(new UpdateSceneEvent(currentScene));
			}
			if  ((currentScene.getUpdateRate()!=0) 
					&& (getTicks() % getTickRate()/currentScene.getUpdateRate()) == 0) 
			{
				eventMonitor.push(new UpdateSceneEvent(currentScene));
			}
			if ((currentScene.getUpdateRate() == 0) && (currentScene.isToUpdate()))
			{
				eventMonitor.push(new UpdateSceneEvent(currentScene));
			}
			if (currentScene.isReadyToSwitch())
				eventMonitor.push(new NextEvent());
			if ( currentScene.hasTimeout())
			{				
				if (startTimer == false )
				{
					startTimer = true;
					currentTimeTimer = getSeconds();				
				}
				if ((startTimer) && (getSeconds() - currentTimeTimer) >= currentScene.getTimeout() )
				{
					eventMonitor.push(new NextEvent()); 
					startTimer = false;			
				}
			}			
		}else eventMonitor.push(new NextEvent());		
	}
	
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#init()
	 */
	public void init()
	{
//		PlayN.log().debug("glc.Init");	
	}
	
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getTicks()
	 */
	public long getTicks()
	{
		return ticks;
	}
	
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getTickRate()
	 */
	public short getTickRate()
	{
		return tickRate;
	}
	
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#addScene(forscene.core.entities.AbstractScene)
	 */
	public void addScene(AbstractScene scene) {		
		DefaultSceneGroup.getInstance().addScene(scene);
		if (getSceneGroups().contains(DefaultSceneGroup.getInstance())) return;
		addSceneGroup(DefaultSceneGroup.getInstance());
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#incTime(float)
	 */
	public void incTime(float delta) 
	{		
		ms+=delta;
		if (ms>1000)
		{
			seconds++;
			ms-=1000;			
		}
		
	}

	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getHeight()
	 */
	public float getHeight() {
		return graphics().height();
	}

	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#getWidth()
	 */
	public float getWidth() {
		return graphics().width();
	}
	
	public void redraw()
	{
		AbstractScene tmp=getCurrentScene();
		if (tmp!=null)
		{
			getRoot().clear();
			getRoot().add(tmp.getRoot());
		}
		PlayN.log().debug("redraw");
	}
	
}