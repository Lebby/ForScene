package forscene.test.core;

import static playn.core.PlayN.*;

import playn.core.Game;
import playn.core.Image;
import playn.core.ImageLayer;

public class MainGame implements Game {
  
  public void init() {
    // create and add background image layer
    Image bgImage = assetManager().getImage("images/bg.png");
    ImageLayer bgLayer = graphics().createImageLayer(bgImage);
    graphics().rootLayer().add(bgLayer);
  }

  
  public void paint(float alpha) {
    // the background automatically paints itself, so no need to do anything here!
  }

  
  public void update(float delta) {
  }

  
  public int updateRate() {
    return 25;
  }
}
