package forscene.core.game.actors;

import playn.core.Key;
import playn.core.Keyboard;
import playn.core.PlayN;
import playn.core.Keyboard.Event;
import forscene.core.entities.AbstractActorAnimation;
import forscene.core.entities.AbstractAnimation;
import forscene.core.entities.AbstractActor;
import forscene.core.events.input.EventKeyDown;
import forscene.core.events.input.EventKeyUp;
import forscene.core.listener.AbstractKeyboardListener;
import forscene.core.util.GraphicFactory;

public  class Tommy extends AbstractActor{
	public EventKeyUp eventKeyUp;
	public EventKeyDown eventKeyDown;
	public Tommy() {
		
			eventKeyDown = new EventKeyDown() {
				
				@Override
				public void run(Event event) {					
					if (event.key() ==  Key.DOWN) 
					{
						startAnim("down");
						down();
					}
					if (event.key() == Key.UP) 
					{
						startAnim("up");
						up();
					}
					if (event.key() == Key.LEFT) 
					{
						startAnim("left");
						left();
					}
					if (event.key() == Key.RIGHT) 
					{
						startAnim("right");
						right();
					}
				}
			};
			
			eventKeyUp = new EventKeyUp() {
				
				@Override
				public void run(Event event) {
					stoptAnim("up");
					PlayN.log().debug("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!STOP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				}
			};
			
			
			
	}
	
	public void up()
	{
		getRoot().setOrigin(getRoot().originX(), getRoot().originY()+1);
	}
	
	public void down()
	{
		getRoot().setOrigin(getRoot().originX(), getRoot().originY()-1);
	}

	public void left()
	{
		getRoot().setOrigin(getRoot().originX()+1, getRoot().originY());
	}
	
	public void right()
	{
		getRoot().setOrigin(getRoot().originX()-1, getRoot().originY());
	}

	@Override
	public void build() {
		AbstractActorAnimation walk = new TommyWalk();
		walk.setUpdateRate(25);
		walk.setTarget(this);
		getAnimations().put("up", walk);
		getAnimations().put("down", walk);
		getAnimations().put("left", walk);
		getAnimations().put("right", walk);
		getRoot().add( (GraphicFactory.loadImage("images/walk/tommynickpirata_1.png")));
		/*getRoot().add( (GraphicFactory.loadImage("images/walk/tommynickpirata_2.png")));
		getRoot().add( (GraphicFactory.loadImage("images/walk/tommynickpirata_3.png")));
		getRoot().add( (GraphicFactory.loadImage("images/walk/tommynickpirata_4.png")));
		getRoot().add( (GraphicFactory.loadImage("images/walk/tommynickpirata_5.png")));
		getRoot().add( (GraphicFactory.loadImage("images/walk/tommynickpirata_6.png")));
		getRoot().add( (GraphicFactory.loadImage("images/walk/tommynickpirata_7.png")));*/
	}

	@Override
	public void updateState() {
		/*setRoot(getAnimations().get ("up").getRoot()  );
		redraw();*/
	}
	
}
