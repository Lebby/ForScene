package forscene.system.managers;

import java.util.LinkedList;

import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.PlayN;
import playn.core.Sound;
import forscene.system.entities.Resource;

public class ResourceManager {

  private static ResourceManager  instance = null;

  private LinkedList<Resource<?>> done;

  private LinkedList<Resource<?>> error;

  private boolean                 ready    = false;

  private int                     retry    = 5;

  private LinkedList<Resource<?>> toLoad;

  /*
   * AssetWatcher watcher = new AssetWatcher(new Listener() { public void done()
   * { startGame(); } });
   * 
   * // Add assets to check. watcher.add(image1); watcher.add(image2); // ...
   * 
   * // Start the watching now. watcher.start();
   */

  public static ResourceManager getInstance() {
    if (ResourceManager.instance == null) {
      ResourceManager.instance = new ResourceManager();
    }
    return ResourceManager.instance;
  }

  public static Image loadImage(String url) {
    Image image = PlayN.assets().getImage(url);
    ResourceManager.getInstance().load(image);
    return image;
  }

  public static ImageLayer loadImageLayer(String url) {
    Image bgImage = PlayN.assets().getImage(url);
    ImageLayer bgLayer = PlayN.graphics().createImageLayer(bgImage);
    ResourceManager.getInstance().load(bgImage);
    return bgLayer;
  }

  public static Sound loadSound(String url) {
    Sound sound = PlayN.assets().getSound(url);
    ResourceManager.getInstance().load(sound);
    return sound;
  }

  private ResourceManager() {
    toLoad = new LinkedList<Resource<?>>();
    error = new LinkedList<Resource<?>>();
    done = new LinkedList<Resource<?>>();
  }

  private void add(Resource<?> res) {
    toLoad.add(res);
    ready = false;
  }

  public void addDone(Resource<?> resource) {
    done.add(resource);
  }

  public void addError(Resource<?> resource) {
    error.add(resource);
    ready = false;
  }

  public boolean isReady() {
    return ready;
  }

  public <T> void load(T resource) {
    Resource<T> res = new Resource<T>();
    res.setResource(resource);
    add(res);
  }

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