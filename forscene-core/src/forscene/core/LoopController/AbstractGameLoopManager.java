package forscene.core.LoopController;

import static playn.core.PlayN.graphics;

import java.util.ArrayList;

import playn.core.GroupLayer;
import playn.core.PlayN;

import forscene.core.entities.AbstractScene;
import forscene.core.entities.AbstractSceneGroup;
import forscene.core.events.system.DrawSceneEvent;
import forscene.core.events.system.EventManager;
import forscene.core.events.system.InitEvent;
import forscene.core.events.system.LoadSceneEvent;
import forscene.core.events.system.LoadSceneGroupEvent;
import forscene.core.events.system.NextEvent;
import forscene.core.events.system.UpdateSceneEvent;
import forscene.core.helper.DefaultSceneGroup;
import forscene.core.util.DebugLayer;


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

	/** debug: debugLayer */
	private static DebugLayer debug = new DebugLayer(); //Must change on singlethon 
	
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
			//PlayN.log().debug("Add --- next size > 0");
			tmp = this.sceneGroups.get(sceneGroups.size()-1);
			sceneGroup.setPrev(tmp);			
			tmp.setNext(sceneGroup);
			sceneGroups. set(sceneGroups.size()-1, tmp);			
		}//else setCurrentSceneGroup(sceneGroup);		
		this.sceneGroups.add(sceneGroup);		
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
		//PlayN.log().debug("LoadScene start!");
		//if (scene == null) throw new NullPointerException();
		
		if (scene == null){
			scene = currentSceneGroup.getFirstScene();
		}
		else
		{
			currentScene = scene;
			PlayN.log().debug("loadscene build/buildchild");
			scene.systemBuild();						
		}
		if (currentScene != null) prevScene=currentScene;
		
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
	 * @see forscene.core.LoopController.IGameLoopManager#getDebug()
	 */
	public DebugLayer getDebug() {
		return debug;
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#isDebugMode()
	 */
	public boolean isDebugMode() {
		return DEBUGMODE;
	}

	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#setDebug(forscene.core.util.DebugLayer)
	 */
	public void setDebug(DebugLayer debug) {
		AbstractGameLoopManager.debug = debug;
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
	
	
	/*public void incSeconds()
	{
		seconds++;
		tickRate=tmpTickRate;
		tmpTickRate = 0;
		debug.write(Long.toString(seconds));		
	}*/
	
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#incTicks()
	 */
	public void incTicks()
	{
		ticks++;
		debug.write(Long.toString(ticks));		
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
		//PlayN.log().debug("GoNext");
		if (currentScene == null) 
		{
			//PlayN.log().debug("GoScene currentScene null");
			if (currentSceneGroup == null )
			{
				//PlayN.log().debug("GoScene currentSceneGroup null");
				//PlayN.log().debug("GoScene all null > 0 ");
				if (sceneGroups.size()>0)
				{				
						//PlayN.log().debug("GoScene sceneGroups > 0 " + sceneGroups.size() );
						if (sceneGroups.get(0) == null )
						{
							//PlayN.log().debug("GoScene Return!");
							return;
						}
						eventMonitor.push(new LoadSceneGroupEvent(sceneGroups.get(0)));
				}
			}else //if (currentSceneGroup != null )
			{
				//PlayN.log().debug("GoScene currentSceneGroup != null");
				eventMonitor.push(new LoadSceneEvent(currentSceneGroup.getFirstScene()));

			}
		}
		else //(currentScene != null)
		{
			//PlayN.log().debug("GoScene currentScene != null");
			if (currentScene.hasNext()) //switch scene
			{
				//PlayN.log().debug("GoScene currentScene hasNext");
				eventMonitor.push(new LoadSceneEvent(currentScene.getNext()));
			}
			else //switch sceneGroup
			{
				PlayN.log().debug("GoScene !currentScene.hasNext() ...");
				if (currentSceneGroup.hasNext())
				{
					//PlayN.log().debug("GoScene hasNext ... nextSceneGroup");
					eventMonitor.push(new LoadSceneGroupEvent(currentSceneGroup.getNext()));
					//i must load firstScene of new  currentSceneGroup ... but it's not builded ...
					//eventMonitor.push(new EventLoadScene(currentSceneGroup.getNext().getFirstScene()));					
				}
			}
		}
	}
					
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#draw(forscene.core.entities.AbstractScene)
	 */
	public void draw(AbstractScene scene) 
	{

		if (scene != null)
		{
				currentScene= scene;
				if ((scene != null ) && scene.getRoot() != null)
				{
			//		PlayN.log().debug(" PRE - REDRAW SIZE : " + scene.getRoot().size() + 
			//				" depth : " + scene.getRoot().depth() + " : " + scene.getRoot().getClass());
					//scene.redraw();

					//if (currentScene.isToUpdate())
					//{
						getRoot().clear();
						getRoot().add(scene.getRoot());
					
						if((DEBUGMODE) ) 
						{
							root.add(debug.getRoot());						
						}
					//	currentScene.setToUpdate(false);
					//}
					
				}
		}
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.LoopController.IGameLoopManager#paint()
	 */
	public void paint()
	{
		eventMonitor.push(new DrawSceneEvent(currentScene));
		
		/* substitution by evenetDrawScene
		 * 
		ArrayList<Layer> ls = new ArrayList<Layer>();
		for ( int i = 0 ; i < root.size() ; i++)
		{
			ls.add(	root.get(i));			
			//PlayN.log().debug("EXXXXXXXXXX : " + ls.get(i));
		}
		//PlayN.log().debug("Size ls tm : " + ls.size());
		for ( int i = 0 ; i < ls.size() ; i++)
		{
			root.remove(ls.get(i));
			root.add(ls.get(i));
		}
		//PlayN.log().debug("Size root tm : " + root.size());
		 * 
		 */
		
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
/*			PlayN.log().debug("UPDATE SCENE" + currentScene.getTimeout() + " ht : " + currentScene.hasTimeout() +
					" CurrentTimer :" + getCurrentTimeTimer() + " StartTimer : " + startTimer + "");
			PlayN.log().debug("CurrentScene: " +
					" IS_READY_TO_SWITCH : " + currentScene.IS_READY_TO_SWITCH +
					" USE_TIMER : " + currentScene.USE_TIMER +
					"");*/
			if (currentScene.getUpdateRate() == 0)
			{
				eventMonitor.push(new UpdateSceneEvent(currentScene));
			}
			else if (getTicks() % (getTickRate()/currentScene.getUpdateRate()) == 0)
			{
				eventMonitor.push(new UpdateSceneEvent(currentScene));
			}
			// currentScene.updateState(); //OLD
			if (currentScene.isReadyToSwitch())
				eventMonitor.push(new NextEvent());
			
			if ( currentScene.hasTimeout())
			{				
				//PlayN.log().debug("USETIMER : " + (seconds - currentTimeTimer));
				if (startTimer == false )
				{
					startTimer = true;
					currentTimeTimer = getSeconds();				
				}
				
				if ((startTimer) && (getSeconds() - currentTimeTimer) >= currentScene.getTimeout() )
				{
					//PlayN.log().debug("CHECK TIMER!!!!!");
					eventMonitor.push(new NextEvent()); 
					startTimer = false;			
				}
			}			
			
		}else eventMonitor.push(new NextEvent());

//		PlayN.log().debug("currentScene!!!: " + currentScene);
//		if (currentScene != null )
//			PlayN.log().debug("currentScene NEXT!!!: " + currentScene.getNext());
		
		//Before ... now moved in paint
		//eventMonitor.push(new EventDrawScene(currentScene));
		
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
	

}