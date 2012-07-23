/*
 * 
 */
package forscene.system.managers;

import java.util.LinkedList;

import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.PlayN;
import playn.core.Sound;
import forscene.system.entities.Resource;

// TODO: Auto-generated Javadoc
/**
 * The Class ResourceManager.
 */
public class ResourceManager {

  /** The instance. */
  private static ResourceManager  instance = null;

  /** The done. */
  private LinkedList<Resource<?>> done;

  /** The error. */
  private LinkedList<Resource<?>> error;

  /** The ready. */
  private boolean                 ready    = false;

  /** The retry. */
  private int                     retry    = 5;

  /** The to load. */
  private LinkedList<Resource<?>> toLoad;

  /*
   * AssetWatcher watcher = new AssetWatcher(new Listener() { public void done()
   * { startGame(); } });
   * 
   * // Add assets to check. watcher.add(image1); watcher.add(image2); // ...
   * 
   * // Start the watching now. watcher.start();
   */

  /**
   * Gets the single instance of ResourceManager.
   *
   * @return single instance of ResourceManager
   */
  public static ResourceManager getInstance() {
    if (ResourceManager.instance == null) {
      ResourceManager.instance = new ResourceManager();
    }
    return ResourceManager.instance;
  }

  /**
   * Load image.
   *
   * @param url the url
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
   * @param url the url
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
   * @param url the url
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
    toLoad = new LinkedList<Resource<?>>();
    error = new LinkedList<Resource<?>>();
    done = new LinkedList<Resource<?>>();
  }

  /**
   * Adds the.
   *
   * @param res the res
   */
  private void add(Resource<?> res) {
    toLoad.add(res);
    ready = false;
  }

  /**
   * Adds the done.
   *
   * @param resource the resource
   */
  public void addDone(Resource<?> resource) {
    done.add(resource);
  }

  /**
   * Adds the error.
   *
   * @param resource the resource
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
    return ready;
  }

  /**
   * Load.
   *
   * @param <T> the generic type
   * @param resource the resource
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
      (toLoad.poll()).load();
    }

    int i = retry;
    while (!error.isEmpty() && (i != 0)) {
      (error.poll()).load();
      --i;
    }
    ready = true;
  }

}