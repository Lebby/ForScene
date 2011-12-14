package forscene.test.core;

import playn.core.Game;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Key;
import playn.core.Keyboard;
import playn.core.Keyboard.Adapter;
import playn.core.Keyboard.Event;
import playn.core.PlayN;
import static playn.core.PlayN.assetManager;
import static playn.core.PlayN.keyboard;
import static playn.core.PlayN.graphics;

public class TestKeyListener implements Game{

	 
	 int x=0,y=0;
	
	public void init() {
	
		keyboard().setListener(new Adapter(){
			@Override
			public void onKeyDown(Event event) {
				// TODO Auto-generated method stub
				//super.onKeyDown(event);
				if (event.key() == Key.SPACE)
				{
				PlayN.log().debug("KeyDown");
				
				graphics().rootLayer().clear();
	
				graphics().rootLayer().add(loadImage("images/walk/tommynickpirata_5.png"));
				graphics().rootLayer().setOrigin(graphics().rootLayer().originX()-1,graphics().rootLayer().originY()-1);
				}
				
			}
			
			@Override
			public void onKeyUp(Event event) {
				// TODO Auto-generated method stub
				if (event.key() == Key.SPACE)
				{
				//super.onKeyUp(event);
					PlayN.log().debug("KeyUp");				
					graphics().rootLayer().clear();	
					graphics().rootLayer().add(loadImage("images/walk/tommynickpirata_1.png"));
					graphics().rootLayer().setOrigin(graphics().rootLayer().originX()+1,graphics().rootLayer().originY()+1);
				}
			
			}
		});
		
	}
	
	

	
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	
	public void paint(float alpha) {
		
	}

	
	public int updateRate() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public ImageLayer loadImage(String url)
	{
		 
		Image bgImage = assetManager().getImage(url);
	    ImageLayer bgLayer = graphics().createImageLayer(bgImage);
	    PlayN.log().debug("TEST " + bgLayer);	    
	    return bgLayer;
	}

}
