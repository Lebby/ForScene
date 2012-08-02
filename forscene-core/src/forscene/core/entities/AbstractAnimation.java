/*
 * 
 */
package forscene.core.entities;

import playn.core.Asserts;
import playn.core.Layer;
import playn.core.PlayN;
import forscene.core.events.system.AnimationUpdateEvent;
import forscene.system.entities.ForSceneConfigurator;
import forscene.system.managers.EventManager;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractAnimation.
 */
public abstract class AbstractAnimation {

  private AnimationUpdateEvent   eventUpdate;

  /** The started. */
  private boolean                started    = false;

  /** The init. */
  private boolean                init       = false;

  /** The target. */
  private AbstractSceneObject<?> target;

  /** The update rate. */
  private long                   updateRate = 0;

  /** The root. */
  private Layer                  root;

  /**
   * Builds the.
   */
  public abstract void build();

  /**
   * Init.
   */
  public abstract void init();

  /**
   * Start.
   */
  public void start() {
    PlayN.log().debug("ABSTRACT ANIMATION Start!");
    if (init == false) {
      init = true;
      init();

      if (target != null) {
        target.buildOnce();

      } else {
        PlayN.log().debug("ABSTRACT ANIMATION Target NULL ERROR!");
      }
      build();
    }
    started = true;
    eventUpdate = new AnimationUpdateEvent(this);
    EventManager.getInstance().push(eventUpdate,
        ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_SYSTEM_PRIORITY);
  };

  /**
   * Stop.
   */
  public void stop() {
    started = false;
    // #Debug
    PlayN.log().debug("ABSTRACT ANIMATION STOP!");
    if (eventUpdate != null) {
      eventUpdate.setDone(true);
    }
  };

  /**
   * Checks if is started.
   * 
   * @return true, if is started
   */
  public boolean isStarted() {
    return started;
  }

  /**
   * Checks if is stopped.
   * 
   * @return true, if is stopped
   */
  public boolean isStopped() {
    return !started;
  }

  /**
   * Go next.
   */
  public abstract void goNext(); // same of update state ...

  /**
   * Run.
   */
  public abstract void run();

  /**
   * Gets the target.
   * 
   * @return the target
   */
  public AbstractSceneObject<?> getTarget() {
    return target;
  }

  /**
   * Sets the target.
   * 
   * @param actor
   *          the new target
   */
  public void setTarget(AbstractSceneObject<?> target) {
    Asserts.check(target != null, "target can't be null");
    Asserts.check(target.getRoot() != null, "target is not builded");
    this.target = target;
    setRoot(target.getRoot());
  }

  // @Override
  /**
   * Update state.
   */
  public void updateState() {
    if (started) {
      Asserts.check(target != null, "target can't be null");
      run();
      target.setToUpdate(false);
    }
  }

  /**
   * Sets the update rate.
   * 
   * @param rate
   *          the new update rate
   */
  public void setUpdateRate(long rate) {
    Asserts.check(rate > 0, "rate must be >=0");
    updateRate = rate;
  }

  /**
   * Gets the update rate.
   * 
   * @return the update rate
   */
  public long getUpdateRate() {
    return updateRate;
  }

  /**
   * Gets the root.
   * 
   * @return the root
   */
  public Layer getRoot() {
    return root;
    // return getTarget().getRoot();
  }

  /**
   * Sets the root.
   * 
   * @param layer
   *          the new root
   */
  public void setRoot(Layer layer) {
    Asserts.check(layer != null, "layer can't be null");
    root = layer;
  }

  /**
   * @return the initialization state. If true, init is called and it will not
   *         be called anymore.
   */
  public boolean isInit() {
    return init;
  }

}