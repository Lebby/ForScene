/**
 * 
 */
package forscene.core.entities;

import java.util.ArrayList;
import java.util.HashMap;

import playn.core.ImageLayer;
import playn.core.Layer;
import forscene.core.util.GraphicFactory;

/**
 * @author blackdevil
 * 
 */
public class SimpleScene extends AbstractScene {
  private HashMap<String, Layer> images;
  private ArrayList<Layer>       order;

  /*
   * (non-Javadoc)
   * 
   * @see forscene.system.ISceneObject#updateState()
   */
  public void updateState() {
    // TODO Auto-generated method stub

  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.entities.AbstractSceneObject#build()
   */
  @Override
  public void build() {
    images = new HashMap<String, Layer>();
    order = new ArrayList<Layer>();
    for (int i = 0; i < order.size(); i++) {
      getRoot().add(order.get(i));
    }
  }

  /**
   * @return the images
   */
  public HashMap<String, Layer> getImages() {
    return images;
  }

  /**
   * @param images
   *          the images to set
   */
  public void setImages(HashMap<String, Layer> images) {
    this.images = images;
  }

  public ImageLayer addImage(String url, float x, float y) {
    ImageLayer tmp = GraphicFactory.addImage(url, this);
    tmp.setTranslation(x, y);
    images.put(url, tmp);
    order.add(tmp);
    getRoot().add(tmp);
    setToUpdate(true);
    return tmp;
  }

  public void removeImage(String url) {
    Layer tmp = images.get(url);
    getRoot().remove(tmp);
    order.remove(order.indexOf(tmp));
    images.remove(url);
    setToUpdate(true);
  }

  public void toFront(String url) {
    Layer tmp = images.get(url);
    toFront(tmp);
    setToUpdate(true);
  }

  public void toBackground(String url) {
    Layer tmp = images.get(url);
    toBackground(tmp);
    setToUpdate(true);
  }

  public void pushUp(String url) {
    Layer tmp = images.get(url);
    pushUp(tmp);
    setToUpdate(true);
  }

  public void pushDown(String url) {
    Layer tmp = images.get(url);
    pushDown(tmp);
    setToUpdate(true);
  }

  public void toFront(Layer layer) {
    order.remove(order.indexOf(layer));
    getRoot().remove(layer);
    getRoot().add(layer);
    setToUpdate(true);
  }

  public void toBackground(Layer layer) {
    if (order.indexOf(layer) != -1) {
      order.remove(order.indexOf(layer));
    }
    order.add(0, layer);
    layer.setDepth(0);
    setToUpdate(true);
  }

  public void pushUp(Layer layer) {
    int index = order.indexOf(layer);
    if ((order.size() - 1) != index) {
      order.remove(index);
      index++;
      layer.setDepth(index);
      order.add(index, layer);
      setToUpdate(true);
    }

  }

  public void pushDown(Layer layer) {
    int index = order.indexOf(layer);
    if (index != 0) {
      order.remove(index);
      index--;
      layer.setDepth(index);
      order.add(index, layer);
      setToUpdate(true);
    }
  }

}
