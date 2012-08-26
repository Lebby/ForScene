/*
 * 
 */
package forscene.system.managers;

import java.util.ArrayList;

import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.PlayN;
import playn.core.Sound;
import forscene.system.ResourceState;
import forscene.system.entities.Resource;

/**
 * The Class ResourceManager.
 */
public class ResourceManager {

  /** The instance. */
  private static ResourceManager instance = null;

  /** The done. */
  public ArrayList<Resource<?>>  done;

  /** The error. */
  private ArrayList<Resource<?>> error;

  /** The ready. */
  private boolean                ready    = false;

  /** The retry. */
  private int                    retry    = 5;

  /** The to load. */
  private ArrayList<Resource<?>> toLoad;

  /**
   * AssetWatcher contains a listener that sets Assetwacher isDone when all
   * resources are loaded.
   */
  // private AssetWatcher watcher;

  /**
   * Gets the single instance of ResourceManager.
   * 
   * @return single instance of ResourceManager
   */
  public static ResourceManager getInstance() {
    if (ResourceManager.instance == null) {
      ResourceManager.instance = new ResourceManager();
      ResourceManager.instance.ready = false;
    }
    return ResourceManager.instance;
  }

  /**
   * Load image.
   * 
   * @param url
   *          the url
   * @return the image
   */
  public static Image loadImage(String url) {
    Image image = PlayN.assets().getImage(url);
    ResourceManager.getInstance().load(image);
    return image;
  }

  /**
   * Load image layer.
   * 
   * @param url
   *          the url
   * @return the image layer
   */
  public static ImageLayer loadImageLayer(String url) {
    Image bgImage = PlayN.assets().getImage(url);
    ImageLayer bgLayer = PlayN.graphics().createImageLayer(bgImage);
    ResourceManager.getInstance().load(bgImage);
    return bgLayer;
  }

  /**
   * Load sound.
   * 
   * @param url
   *          the url
   * @return the sound
   */
  public static Sound loadSound(String url) {
    Sound sound = PlayN.assets().getSound(url);
    ResourceManager.getInstance().load(sound);
    return sound;
  }

  /**
   * Instantiates a new resource manager.
   */
  private ResourceManager() {
    toLoad = new ArrayList<Resource<?>>();
    error = new ArrayList<Resource<?>>();
    done = new ArrayList<Resource<?>>();

    /*
     * watcher = new AssetWatcher(new AssetWatcher.Listener() {
     * 
     * public void error(Throwable e) { try { throw e; } catch (Throwable e1) {
     * e1.printStackTrace(); } }
     * 
     * public void done() { ResourceManager.getInstance().ready = true;
     * PlayN.log().debug("AssetsWatcher thumb up!"); } });
     */
  }

  /**
   * Adds the.
   * 
   * @param res
   *          the res
   */
  private void add(Resource<?> res) {
    toLoad.add(res);
    if (res.getResource() instanceof Image) {
      Image _res = (Image) res.getResource();
      // watcher.add(_res);
    }
    if (res.getResource() instanceof Sound) {
      Sound _res = (Sound) res.getResource();
      // watcher.add(_res);
    }
    loadResources();
    ready = false;
  }

  /**
   * Adds the done.
   * 
   * @param resource
   *          the resource
   */
  public void addDone(Resource<?> resource) {
    done.add(resource);
  }

  /**
   * Adds the error.
   * 
   * @param resource
   *          the resource
   */
  public void addError(Resource<?> resource) {
    error.add(resource);
    ready = false;
  }

  /**
   * Checks if is ready.
   * 
   * @return true, if is ready
   */
  public boolean isReady() {
    ready = (toLoad.isEmpty() && (toLoad.size() == 0)); // && watcher.isDone());
    if (!ready) {
      return false;
    }
    for (Object element : done) {
      Resource<?> el = (Resource<?>) element;
      ready = (ready && (el.getState() == ResourceState.DONE));
    }
    return ready;
  }

  /**
   * Load.
   * 
   * @param <T>
   *          the generic type
   * @param resource
   *          the resource
   */
  public <T> void load(T resource) {
    Resource<T> res = new Resource<T>();
    res.setResource(resource);
    add(res);
  }

  /**
   * Load resources.
   */
  public void loadResources() {
    while (!toLoad.isEmpty()) {
      (toLoad.get(0)).load();
      toLoad.remove(0);
      // watcher.start();
    }

    int i = retry;
    while (!error.isEmpty() && (i != 0)) {
      (error.get(0)).load();
      error.remove(0);
      --i;
    }
  }

}