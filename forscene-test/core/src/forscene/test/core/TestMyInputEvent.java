package forscene.test.core;

import static playn.core.PlayN.assetManager;
import static playn.core.PlayN.graphics;

import java.util.ArrayList;

import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.PlayN;
import playn.core.Keyboard.Event;


import forscene.core.LoopController.AbstractGame;
import forscene.core.effects.Scroll;
import forscene.core.entities.AbstractScene;
import forscene.core.entities.AbstractSceneGroup;
import forscene.core.entities.AbstractSceneObject;
import forscene.core.events.input.EventKeyDown;
import forscene.core.events.input.EventKeyUp;
import forscene.core.listener.AbstractKeyboardListener;
import forscene.core.util.GraphicFactory;

public class TestMyInputEvent extends AbstractGame{

	
	public int updateRate() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void build() {
		this.setSize(600, 600);
		
		AbstractSceneGroup absg = 		new AbstractSceneGroup() {
			
			public ArrayList<AbstractScene> build() {
				ArrayList<AbstractScene> arl = new ArrayList<AbstractScene>();
				AbstractScene tmp = new AbstractScene() {
					
					public void updateState() {
						// TODO Auto-generated method stub
					}
					
					public void build() {
						graphics().rootLayer().add(loadImage("images/bg.png"));
						graphics().rootLayer().add(loadImage("images/walk/tommynickpirata_5.png"));
					}
				};
				
				
				EventKeyDown eventKeyDown = new EventKeyDown() {
					
					public void run(Event event) {
						graphics().rootLayer().setOrigin(graphics().rootLayer().originX()-10,graphics().rootLayer().originY()-10);
						PlayN.log().debug("KEYDOWN");
					}
				};
				EventKeyUp eventKeyUp = new EventKeyUp() {
					
					
					public void run(Event event) {
						graphics().rootLayer().setOrigin(graphics().rootLayer().originX()+10,graphics().rootLayer().originY()+10);
						PlayN.log().debug("KEYUP");
					}
				};
				
				tmp.setKeyboardListener(new AbstractKeyboardListener(eventKeyDown, eventKeyUp));
				arl.add(tmp);
				
				return arl;
			}
		};
		
		
		this.addSceneGroup(absg);
		
		
	}
	
	public ImageLayer loadImage(String url)
	{
		 
		Image bgImage = assetManager().getImage(url);
	    ImageLayer bgLayer = graphics().createImageLayer(bgImage);
	    PlayN.log().debug("TEST " + bgLayer);	    
	    return bgLayer;
	}
	
	


}
