package forscene.system.managers;

import java.util.PriorityQueue;

import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.PlayN;
import playn.core.Sound;
import forscene.system.entities.Resource;

public class ResourceManager {

  private static ResourceManager     instance = null;

  private PriorityQueue<Resource<?>> done;

  private PriorityQueue<Resource<?>> error;

  private boolean                    ready    = false;

  private int                        retry    = 5;

  private PriorityQueue<Resource<?>> toLoad;

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
    toLoad = new PriorityQueue<Resource<?>>();
    error = new PriorityQueue<Resource<?>>();
    done = new PriorityQueue<Resource<?>>();
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