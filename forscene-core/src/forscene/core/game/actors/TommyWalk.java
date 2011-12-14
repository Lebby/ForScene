package forscene.core.game.actors;

import forscene.core.entities.AbstractActorAnimation;

import forscene.core.util.GraphicFactory;

public class TommyWalk extends AbstractActorAnimation {

	@Override
	public void build() {		
		addLayer(GraphicFactory.loadImage("images/walk/tommynickpirata_1.png"));
		addLayer(GraphicFactory.loadImage("images/walk/tommynickpirata_2.png"));
		addLayer(GraphicFactory.loadImage("images/walk/tommynickpirata_3.png"));
		addLayer(GraphicFactory.loadImage("images/walk/tommynickpirata_4.png"));
		addLayer(GraphicFactory.loadImage("images/walk/tommynickpirata_5.png"));
		addLayer(GraphicFactory.loadImage("images/walk/tommynickpirata_6.png"));
		addLayer(GraphicFactory.loadImage("images/walk/tommynickpirata_7.png"));		
	}

	@Override
	public void run() {
	/*	if(isStarted())
		{			
			goNext();
		}*/		
	}	



}
