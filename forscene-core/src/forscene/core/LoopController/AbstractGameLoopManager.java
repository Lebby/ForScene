package forscene.core.LoopController;

import static playn.core.PlayN.graphics;

import java.util.ArrayList;

import playn.core.GroupLayer;
import playn.core.Layer;
import playn.core.PlayN;

import forscene.core.entities.AbstractScene;
import forscene.core.entities.AbstractSceneGroup;
import forscene.core.events.EventDrawScene;
import forscene.core.events.EventInit;
import forscene.core.events.EventLoadScene;
import forscene.core.events.EventLoadSceneGroup;
import forscene.core.events.EventNext;
import forscene.core.events.EventNextScene;
import forscene.core.events.EventNextSceneGroup;
import forscene.core.events.EventUnloadScene;
import forscene.core.events.EventUnloadSceneGroup;
import forscene.core.events.EventUpdateScene;
import forscene.core.helper.DefaultSceneGroup;
import forscene.core.util.DebugLayer;


public abstract class AbstractGameLoopManager implements IGameLoopManager{
	
	private static AbstractGameLoopManager instance = null;
	private boolean DEBUGMODE = true;
	private boolean started = false;
	
	private AbstractScene currentScene,prevScene;
	private AbstractSceneGroup currentSceneGroup;
	private ArrayList<AbstractSceneGroup> sceneGroups;
	private EventMonitor eventMonitor;

	private static DebugLayer debug = new DebugLayer(); //Must change on singlethon 
	
	private long seconds;
	private long ticks = 0;
	
	//tick per second
	private short tickRate = 25 ;
	private short tmpTickRate = 0;
	
	private boolean startTimer = false;
	private long currentTimeTimer = 0;
	
	//PaintManager
	private static GroupLayer root;
	
	protected AbstractGameLoopManager()
	{
		eventMonitor = EventMonitor.getInstance();
		sceneGroups = new ArrayList<AbstractSceneGroup>();
		eventMonitor.push(new EventInit());
		root = graphics().rootLayer();		
	}
	
	
	public static IGameLoopManager getInstance()
	{
		if (instance == null)
		{
			instance = new AbstractGameLoopManager() {
			};
		}
		return instance;
	}
	
	public AbstractScene getCurrentScene() {
		return this.currentScene;		
	}
	
	public void setCurrentScene(AbstractScene scene) {
		currentScene=scene;
	}
	
	
	public AbstractSceneGroup getCurrentSceneGroup() {		
		return currentSceneGroup;
	}
	
	
	public void setCurrentSceneGroup(AbstractSceneGroup sceneGroup) 
	{
		currentSceneGroup = sceneGroup;		
	}
		
	
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
	
	
	public AbstractSceneGroup getNextSceneGroup() {
		if (currentSceneGroup == null) return null;		
		return currentSceneGroup.getNext();		
	}
	
	
	public AbstractScene getNextScene() {
		if (currentScene == null) return null;
		return currentScene.getNext();		
	}
	
	
	public ArrayList<AbstractSceneGroup> getSceneGroups() {
		return sceneGroups;
	}
	

	public void loadSceneGroup(AbstractSceneGroup sceneGroup) {
		if (sceneGroup == null) throw new NullPointerException();		
		//PlayN.log().debug("glc.loadscenegroup" + sceneGroup);
		currentSceneGroup = sceneGroup;
		currentSceneGroup.chain(currentSceneGroup.build());
		currentScene = null;		
	}
	
	
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
			scene.build();
			scene.buildChild();
			
			
		}
		if (currentScene != null) prevScene=currentScene;
		
		//PlayN.log().debug("LoadScene end!");
		
	}

	
	public void removeSceneGroup(AbstractSceneGroup sceneGroup) {		
		if (sceneGroup == null) throw new NullPointerException();
		sceneGroups.remove(sceneGroups);
	}

	
	public void setDebugMode(boolean debug)
	{
		DEBUGMODE = debug;
	}

	
	public DebugLayer getDebug() {
		return debug;
	}

	
	public boolean isDebugMode() {
		return DEBUGMODE;
	}

	
	public void setDebug(DebugLayer debug) {
		AbstractGameLoopManager.debug = debug;
	}

	//PaintMan	
	
	
	public GroupLayer getRoot() {
		return root;
	}
	
	
	public void setRoot(GroupLayer root) {
		AbstractGameLoopManager.root = root;
	}
	
	
	public void setSize(int width, int height)
	{
		graphics().setSize(width, height);		
	}

		
	//Time Monitor
	
	public void setSeconds(long seconds) {
		seconds = seconds;
	}
	
	public void setCurrentTimeTimer(long currentTimeTimer) {
		currentTimeTimer = currentTimeTimer;
	}
	
	public long getSeconds() {
		return seconds;
	}
	
	public long getCurrentTimeTimer() {
		return currentTimeTimer;
	}
	
	
	public void incSeconds()
	{
		seconds++;
		tickRate=tmpTickRate;
		tmpTickRate = 0;
		debug.write(Long.toString(seconds));		
	}
	
	
	public void incTicks()
	{
		ticks++;
		tmpTickRate++;
		debug.write(Long.toString(ticks));		
	}
	
	
	public void resetSeconds()
	{
		seconds = 0;
	}
	
	// =======
	
	//most complex ................. 

	
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
						eventMonitor.push(new EventLoadSceneGroup(sceneGroups.get(0)));
				}
			}else //if (currentSceneGroup != null )
			{
				//PlayN.log().debug("GoScene currentSceneGroup != null");
				eventMonitor.push(new EventLoadScene(currentSceneGroup.getFirstScene()));

			}
		}
		else //(currentScene != null)
		{
			//PlayN.log().debug("GoScene currentScene != null");
			if (currentScene.hasNext()) //switch scene
			{
				//PlayN.log().debug("GoScene currentScene hasNext");
				eventMonitor.push(new EventLoadScene(currentScene.getNext()));
			}
			else //switch sceneGroup
			{
				PlayN.log().debug("GoScene !currentScene.hasNext() ...");
				if (currentSceneGroup.hasNext())
				{
					//PlayN.log().debug("GoScene hasNext ... nextSceneGroup");
					eventMonitor.push(new EventLoadSceneGroup(currentSceneGroup.getNext()));
					//i must load firstScene of new  currentSceneGroup ... but it's not builded ...
					//eventMonitor.push(new EventLoadScene(currentSceneGroup.getNext().getFirstScene()));					
				}
			}
		}
	}
					
	
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
					getRoot().clear();
					getRoot().add(scene.getRoot());
					
					if((DEBUGMODE) )//&& (getSeconds()%25==0))
					{
						root.add(debug.getRoot());						
					}
					
				}
		}
	}
	
	public void paint()
	{
		eventMonitor.push(new EventDrawScene(currentScene));
		
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
	
	public void updateState() 
	{
		
		eventMonitor.update();	
		if (currentScene != null )
		{
/*			PlayN.log().debug("CurrentScene: " +
					" IS_READY_TO_SWITCH : " + currentScene.IS_READY_TO_SWITCH +
					" USE_TIMER : " + currentScene.USE_TIMER +
					"");*/
			if (currentScene.getUpdateRate() == 0)
			{
				eventMonitor.push(new EventUpdateScene(currentScene));
			}
			else if (getTicks() % (getTickRate()/currentScene.getUpdateRate()) == 0)
			{
				eventMonitor.push(new EventUpdateScene(currentScene));
			}
			// currentScene.updateState(); //OLD
			if (currentScene.isReadyToSwitch())
				eventMonitor.push(new EventNext());
			
			if ( currentScene.hasTimeout())
			{				
//				PlayN.log().debug("USETIMER : " + (seconds - currentTimeTimer));
				if (startTimer == false )
				{
					startTimer = true;
					currentTimeTimer = seconds;				
				}
				if ((startTimer) && (seconds - currentTimeTimer) == currentScene.getTimeout() )
				{					
					eventMonitor.push(new EventNext()); 
					startTimer = false;			
				}
			}			
			
		}else eventMonitor.push(new EventNext());

//		PlayN.log().debug("currentScene!!!: " + currentScene);
//		if (currentScene != null )
//			PlayN.log().debug("currentScene NEXT!!!: " + currentScene.getNext());
		
		//Before ... now moved in paint
		//eventMonitor.push(new EventDrawScene(currentScene));
		
	}
	
	
	public void init()
	{
//		PlayN.log().debug("glc.Init");	
	}
	
	
	public long getTicks()
	{
		return ticks;
	}
	
	
	public short getTickRate()
	{
		return tickRate;
	}
	
	
	public void addScene(AbstractScene scene) {		
		DefaultSceneGroup.getInstance().addScene(scene);
		if (getSceneGroups().contains(DefaultSceneGroup.getInstance())) return;
		addSceneGroup(DefaultSceneGroup.getInstance());
	}
	
	

}