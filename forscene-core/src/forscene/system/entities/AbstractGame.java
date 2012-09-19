/*
 * 
 */
package forscene.system.entities;

import java.util.ArrayList;

import playn.core.Game;
import playn.core.GroupLayer;
import playn.core.PlayN;
import forscene.core.entities.AbstractScene;
import forscene.core.entities.AbstractSceneGroup;
import forscene.system.events.InitEvent;
import forscene.system.managers.EventManager;
import forscene.system.managers.GameLoopManager;
import forscene.system.managers.IGameLoopManager;

/**
 * The Class AbstractGame. This class is the "main class" that you need to
 * extends to implement your game. It fowards management of game loop to an
 * AbstractGameLoopManager instance.
 * 
 * The main purpose is to manage logical scene sequence and you can do
 * implementing build method. In build method you can build your game by
 * creating scenes, scene groups and then adding to abstract game.
 * 
 * Why it's here is useless!: At start, scene management, time management, draw
 * management and various function were thinked to be splitted in different
 * managers. Now, it's logical useless, but i think that i'll split different
 * management to achieve a better design and a better optimization!
 * 
 */
public abstract class AbstractGame implements Game, IGameLoopManager {

  /** Frame count. */
  static long             frame = 0;

  /** The game manager instance. */
  static IGameLoopManager gameManager;

  /**
   * Main method. Implementing this method you can add scenes and scenegroups to
   * build your game! It is called in init method and add scenes/scenegroups
   * reference.
   */
  public abstract void build();

  public void preBuild() {
  }

  public void postBuild() {
  }

  /*
   * (non-Javadoc)
   * 
   * @see playn.core.Game#init()
   */
  public void init() {
    AbstractGame.gameManager = GameLoopManager.getInstance(this);
    PlayN.log().debug("INIT CALLED");
    EventManager.getInstance().push(new InitEvent(), (short) 0);
    /*
     * preBuild(); while (!ResourceManager.getInstance().isReady()) { ; }
     * build(); postBuild();
     */
  };

  /*
   * (non-Javadoc)
   * 
   * @see playn.core.Game#paint(float)
   */
  public void paint(float alpha) {
    if (AbstractGame.gameManager != null) {
      paint();
    }
  }

  // delta = ms from last call
  /*
   * (non-Javadoc)
   * 
   * @see playn.core.Game#update(float)
   */
  public void update(float delta) {
    if (AbstractGame.gameManager != null) {
      AbstractGame.frame++;
      incTicks();
      incTime(delta);
      // #Debug
      /*
       * if ((updateRate() != 0 ) && ( (frame%updateRate()) ==0) ) {
       * updateState(); }
       */
      updateState();
    }

  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.LoopController.IGameLoopManager#incTime(float)
   */
  public void incTime(float delta) {
    AbstractGame.gameManager.incTime(delta);
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.LoopController.IGameLoopManager#getSceneGroups()
   */
  public ArrayList<AbstractSceneGroup> getSceneGroups() {
    return AbstractGame.gameManager.getSceneGroups();

  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.LoopController.IGameLoopManager#getNextScene()
   */
  public AbstractScene getNextScene() {
    return AbstractGame.gameManager.getNextScene();
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.LoopController.IGameLoopManager#getNextSceneGroup()
   */
  public AbstractSceneGroup getNextSceneGroup() {
    return AbstractGame.gameManager.getNextSceneGroup();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * forscene.core.LoopController.IGameLoopManager#setCurrentSceneGroup(forscene
   * .core.entities.AbstractSceneGroup)
   */
  public void setCurrentSceneGroup(AbstractSceneGroup sceneGroup) {
    AbstractGame.gameManager.setCurrentSceneGroup(sceneGroup);

  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * forscene.core.LoopController.IGameLoopManager#setCurrentScene(forscene.
   * core.entities.AbstractScene)
   */
  public void setCurrentScene(AbstractScene scene) {
    AbstractGame.gameManager.setCurrentScene(scene);

  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.LoopController.IGameLoopManager#getCurrentSceneGroup()
   */
  public AbstractSceneGroup getCurrentSceneGroup() {
    return AbstractGame.gameManager.getCurrentSceneGroup();
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.LoopController.IGameLoopManager#getCurrentScene()
   */
  public AbstractScene getCurrentScene() {
    return AbstractGame.gameManager.getCurrentScene();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * forscene.core.LoopController.IGameLoopManager#loadScene(forscene.core.entities
   * .AbstractScene)
   */
  public void loadScene(AbstractScene scene) {
    AbstractGame.gameManager.loadScene(scene);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * forscene.core.LoopController.IGameLoopManager#loadSceneGroup(forscene.core
   * .entities.AbstractSceneGroup)
   */
  public void loadSceneGroup(AbstractSceneGroup sceneGroup) {
    AbstractGame.gameManager.loadSceneGroup(sceneGroup);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * forscene.core.LoopController.IGameLoopManager#addSceneGroup(forscene.core
   * .entities.AbstractSceneGroup)
   */
  public void addSceneGroup(AbstractSceneGroup sceneGroup) {
    AbstractGame.gameManager.addSceneGroup(sceneGroup);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * forscene.core.LoopController.IGameLoopManager#removeSceneGroup(forscene
   * .core.entities.AbstractSceneGroup)
   */
  public void removeSceneGroup(AbstractSceneGroup sceneGroup) {
    AbstractGame.gameManager.removeSceneGroup(sceneGroup);

  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.LoopController.IGameLoopManager#updateState()
   */
  public void updateState() {
    AbstractGame.gameManager.updateState();

  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * forscene.core.LoopController.IGameLoopManager#draw(forscene.core.entities
   * .AbstractScene)
   */
  public boolean draw(AbstractScene scene) {
    return AbstractGame.gameManager.draw(scene);
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.LoopController.IGameLoopManager#resetSeconds()
   */
  public void resetSeconds() {
    AbstractGame.gameManager.resetSeconds();

  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.LoopController.IGameLoopManager#getRoot()
   */
  public GroupLayer getRoot() {
    return AbstractGame.gameManager.getRoot();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * forscene.core.LoopController.IGameLoopManager#setRoot(playn.core.GroupLayer
   * )
   */
  public void setRoot(GroupLayer root) {
    AbstractGame.gameManager.setRoot(root);

  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.LoopController.IGameLoopManager#setSeconds(long)
   */
  public void setSeconds(long seconds) {
    AbstractGame.gameManager.setSeconds(seconds);

  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * forscene.core.LoopController.IGameLoopManager#setCurrentTimeTimer(long)
   */
  public void setCurrentTimeTimer(long currentTimeTimer) {
    AbstractGame.gameManager.setCurrentTimeTimer(currentTimeTimer);

  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.LoopController.IGameLoopManager#getSeconds()
   */
  public long getSeconds() {
    return AbstractGame.gameManager.getSeconds();

  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.LoopController.IGameLoopManager#getCurrentTimeTimer()
   */
  public long getCurrentTimeTimer() {
    return AbstractGame.gameManager.getCurrentTimeTimer();
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.LoopController.IGameLoopManager#paint()
   */
  public void paint() {
    AbstractGame.gameManager.paint();

  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.LoopController.IGameLoopManager#setSize(int, int)
   */
  public void setSize(int width, int height) {
    AbstractGame.gameManager.setSize(width, height);

  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.LoopController.IGameLoopManager#goNext()
   */
  public void goNext() {
    AbstractGame.gameManager.goNext();

  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.LoopController.IGameLoopManager#incTicks()
   */
  public void incTicks() {
    AbstractGame.gameManager.incTicks();

  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.LoopController.IGameLoopManager#getTicks()
   */
  public long getTicks() {
    return AbstractGame.gameManager.getTicks();
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.LoopController.IGameLoopManager#getTickRate()
   */
  public short getTickRate() {
    return AbstractGame.gameManager.getTickRate();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * forscene.core.LoopController.IGameLoopManager#addScene(forscene.core.entities
   * .AbstractScene)
   */
  public void addScene(AbstractScene scene) {
    AbstractGame.gameManager.addScene(scene);
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.LoopController.IGameLoopManager#getHeight()
   */
  public float getHeight() {
    return AbstractGame.gameManager.getHeight();
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.LoopController.IGameLoopManager#getHeight()
   */
  public float getWidth() {
    return AbstractGame.gameManager.getWidth();
  }

}