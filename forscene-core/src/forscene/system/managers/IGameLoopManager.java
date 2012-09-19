/*
 * 
 */
package forscene.system.managers;

import java.util.ArrayList;

import playn.core.GroupLayer;
import forscene.core.entities.AbstractScene;
import forscene.core.entities.AbstractSceneGroup;

// TODO: Auto-generated Javadoc
/**
 * The Interface IGameLoopManager.
 */
public interface IGameLoopManager {

  /**
   * Gets the scene groups.
   * 
   * @return the scene groups
   */
  ArrayList<AbstractSceneGroup> getSceneGroups();

  /**
   * Gets the next scene.
   * 
   * @return the next scene
   */
  AbstractScene getNextScene();

  /**
   * Gets the next scene group.
   * 
   * @return the next scene group
   */
  AbstractSceneGroup getNextSceneGroup();

  /**
   * Sets the current scene group.
   * 
   * @param sceneGroup
   *          the new current scene group
   */
  void setCurrentSceneGroup(AbstractSceneGroup sceneGroup);

  /**
   * Sets the current scene.
   * 
   * @param scene
   *          the new current scene
   */
  void setCurrentScene(AbstractScene scene);

  /**
   * Gets the current scene group.
   * 
   * @return the current scene group
   */
  AbstractSceneGroup getCurrentSceneGroup();

  /**
   * Gets the current scene.
   * 
   * @return the current scene
   */
  AbstractScene getCurrentScene();

  /**
   * Load scene.
   * 
   * @param scene
   *          the scene
   */
  void loadScene(AbstractScene scene); // call scene.build

  /**
   * Load scene group.
   * 
   * @param sceneGroup
   *          the scene group
   */
  void loadSceneGroup(AbstractSceneGroup sceneGroup); // --> call
                                                      // scenegroup.build

  /**
   * Adds the scene group.
   * 
   * @param sceneGroup
   *          the scene group
   */
  void addSceneGroup(AbstractSceneGroup sceneGroup); // default add on last

  /**
   * Removes the scene group.
   * 
   * @param sceneGroup
   *          the scene group
   */
  void removeSceneGroup(AbstractSceneGroup sceneGroup);

  /**
   * Update state.
   */
  void updateState();

  /**
   * Draw.
   * 
   * @param scene
   *          the scene
   */
  boolean draw(AbstractScene scene); // attach in root

  /**
   * Inits the.
   */
  void init();

  /**
   * Reset seconds.
   */
  void resetSeconds();

  /**
   * Gets the root.
   * 
   * @return the root
   */
  GroupLayer getRoot();

  /**
   * Sets the root.
   * 
   * @param root
   *          the new root
   */
  void setRoot(GroupLayer root);

  /**
   * Sets the seconds.
   * 
   * @param seconds
   *          the new seconds
   */
  void setSeconds(long seconds);

  /**
   * Sets the current time timer.
   * 
   * @param currentTimeTimer
   *          the new current time timer
   */
  void setCurrentTimeTimer(long currentTimeTimer);

  /**
   * Gets the seconds.
   * 
   * @return the seconds
   */
  long getSeconds();

  /**
   * Gets the current time timer.
   * 
   * @return the current time timer
   */
  long getCurrentTimeTimer();

  // void incSeconds();

  /**
   * Paint.
   */
  void paint();

  /**
   * Sets the size.
   * 
   * @param width
   *          the width
   * @param height
   *          the height
   */
  void setSize(int width, int height);

  /**
   * Go next.
   */
  void goNext();

  /**
   * Inc ticks.
   */
  void incTicks();

  /**
   * Gets the ticks.
   * 
   * @return the ticks
   */
  long getTicks();

  /**
   * Gets the tick rate.
   * 
   * @return the tick rate
   */
  short getTickRate();

  /**
   * Adds the scene.
   * 
   * @param scene
   *          the scene
   */
  void addScene(AbstractScene scene);

  /**
   * Inc time.
   * 
   * @param delta
   *          the delta
   */
  void incTime(float delta);

  /**
   * getHeight of game.
   * 
   * @return game height ( float )
   */
  float getHeight();

  /**
   * getWidth of game.
   * 
   * @return game width ( float )
   */
  float getWidth();

  void build();

  void preBuild();

  void postBuild();

}