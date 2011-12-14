package forscene.test.core;

import java.util.ArrayList;

import playn.core.Layer;
import playn.core.PlayN;
import playn.core.TextFormat;
import forscene.core.LoopController.AbstractGame;
import forscene.core.effects.Scroll;
import forscene.core.entities.AbstractScene;
import forscene.core.entities.AbstractSceneGroup;
import forscene.core.entities.AbstractSceneObject;
import forscene.core.util.GraphicFactory;

public class TestScroll  extends AbstractGame {
	Scroll scroll = new Scroll();
	public AbstractSceneObject text;
	

	@Override
	public void build() {
		AbstractScene target = new  AbstractScene() {
			
			@Override
			public void updateState() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void build() {
				getRoot().add(GraphicFactory.loadImage("images/oggetti/nuvole.png"));
				
			}
		};
		AbstractScene scene = new AbstractScene() {
			
			
			@Override
			public void updateState() {
				//scroll.goNext();
				if (scroll != null)
				{
				PlayN.log().debug("UPDATESCENE TEST SCROLL root size " + scroll.getRoot().size());
				PlayN.log().debug("UPDATESCENE TEST SCROLL target " + scroll.getTarget());
				PlayN.log().debug("UPDATESCENE TEST SCROLL target Size " + scroll.getTarget().getRoot().size());
				
				PlayN.log().debug("UPDATESCENE TEST SCROLL root origin "  + scroll.getRoot().originX() +  " : "+ scroll.getRoot().originY());				
				PlayN.log().debug("UPDATESCENE TEST SCROLL target origin " + scroll.getTarget().getRoot().originX() + " : "+ scroll.getTarget().getRoot().originY());
				
				
				PlayN.log().debug("Root "+ scroll.getTarget().getRoot() + " : Root scroll " + scroll.getRoot());
				//x--;
				//getRoot().setOrigin(x, -10);
				GraphicFactory.refresh(getRoot());
				}
				
			}
			
			@Override
			public void build() {
				PlayN.log().debug("BUILD" );
				getRoot().add(GraphicFactory.loadImage("images/background/bg.png"));
			}
			
		};
		text = new AbstractSceneObject() {
			
			@Override
			public void updateState() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void build() {
				Layer layer= GraphicFactory.createText("Turi", new TextFormat());
				getRoot().add(layer);				
			}
		};		
		
		scene.IS_CONDITIONAL=true;
		addScene(scene);
		target.getRoot().setOrigin(100, 100);
		scene.addSceneObject(target);
		//scroll=null;
		scroll.setTarget(target);
		scroll.setUpdateRate(1);
		
		//addScene(scroll);
		//getRoot().add(scroll.getRoot());
		
	}


	public int updateRate() {
		// TODO Auto-generated method stub
		return 100;
	}
	
	
	

}
