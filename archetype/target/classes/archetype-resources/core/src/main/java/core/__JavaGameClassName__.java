#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core;

import static playn.core.PlayN.*;

import ${package}.core.LoopController.AbstractGame;
import ${package}.core.entities.AbstractScene;
import ${package}.core.util.GraphicFactory;

public class Main extends AbstractGame {

	@Override	
	  public int updateRate() {
	    return 25;
	  }

	  @Override
	  public void build() {
		  AbstractScene scene = new SimpleScene();
		  addScene(scene);
	  }
	  
	  class SimpleScene extends AbstractScene{
      @Override
	    public void build() {
            // create and add background image layer
              GraphicFactory.addImage("images/bg.png",this);					
	    }

	    @Override
	    public void updateState() {
	    // TODO Auto-generated method stub
	    }
	  }
}
