/*
 * 
 */
package forscene.system.entities;

import playn.core.AbstractSound;
import playn.core.Image;
import playn.core.PlayN;
import playn.core.ResourceCallback;
import playn.core.Sound;
import forscene.system.ResourceState;
import forscene.system.managers.ResourceManager;

// TODO: Auto-generated Javadoc
/**
 * The Class Resource.
 * 
 * @param <T>
 *          the generic type
 */
public class Resource<T> implements Comparable<T> {

  /** The state. */
  private ResourceState state = ResourceState.TOLOAD;

  /** The _res. */
  private T             _res;

  // private ResourceCallback<T> _resCB;

  /**
   * Load.
   */
  public void load() {

    if (_res instanceof Image) {
      ((Image) (_res))
          .addCallback((ResourceCallback<? super Image>) new ResourceCallback<T>() {
            public void done(final T resource) {
              PlayN.log().debug("Resource" + resource + " Loaded DONE");
              _done();
            };

            public void error(final Throwable err) {
              PlayN.log().debug("Resource load error: " + err);
              _error();
            }
          });
    }

    if ((_res instanceof Sound) || (_res instanceof AbstractSound)) {
      ((Sound) (_res))
          .addCallback((ResourceCallback<? super Sound>) new ResourceCallback<T>() {
            public void done(final T resource) {
              PlayN.log().debug("Resource" + resource + " Loaded");
              _done();
            };

            public void error(final Throwable err) {
              PlayN.log().debug("Resource load error: " + err);
              _error();
            }
          });
    }

  }

  /**
   * Sets the resource.
   * 
   * @param resource
   *          the new resource
   */
  public void setResource(T resource) {
    _res = resource;
  }

  /**
   * Gets the resource.
   */
  public T getResource() {
    return _res;
  }

  /**
   * _done.
   */
  private void _done() {
    setState(ResourceState.DONE);
    ResourceManager.getInstance().addDone(this);
  }

  /**
   * _error.
   */
  private void _error() {
    setState(ResourceState.ERROR);
    ResourceManager.getInstance().addError(this);
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  public int compareTo(T o) {
    if (_res == o) {
      return 0;
    } else {
      return 1;
    }
  }

  /**
   * Gets the state.
   * 
   * @return the state
   */
  public ResourceState getState() {
    return state;
  }

  /**
   * Sets the state.
   * 
   * @param state
   *          the state to set
   */
  public void setState(ResourceState state) {
    this.state = state;
  }
}