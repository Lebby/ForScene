package forscene.core.old;

import static playn.core.PlayN.*;

import playn.core.Game;
import playn.core.Image;
import playn.core.ImageLayer;
import forscene.core.util.GraphicFactory;

public class tommynick implements Game {
 /* @Override
  public void init() {
    // create and add background image layer
    Image bgImage = assetManager().getImage("images/bg.png");
    ImageLayer bgLayer = graphics().createImageLayer(bgImage);
    graphics().rootLayer().add(bgLayer);
  }*/
	
	GameController gameController;	
	Introduction intro = new Introduction();
	
	private int sec = 0;
//  @Override
  public void init() {
	  gameController = new GameController();
	  
	  gameController.setSize(800, 600);
	  GameController.loadSceneGroup(intro);	  
	  Scene scene = new Scene();
		scene.getRoot().add(GraphicFactory.loadImage("images/intro_bg.png"));
		scene.USE_TIMER = true;
		scene.setSeconds(2);		
	  GameController.loadScene(scene);  
  }

//  @Override
  public void paint(float alpha) {
    // the background automatically paints itself, so no need to do anything here!
	  GameController.updateScene();
  }

//  @Override
  public void update(float delta) {
	  //verify state
	  sec ++ ;
	  if (sec % 25 == 0)
	  {
		  GameController.incSeconds();		  
	  }	  
  }

//  @Override
  public int updateRate() {
    return 25;
  }

}
