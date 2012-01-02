package forscene.core.entities;

import java.util.ArrayList;

import playn.core.Layer;
import playn.core.PlayN;
import forscene.core.util.GraphicFactory;
import static playn.core.PlayN.graphics;

public abstract class AbstractLayerSequence extends AbstractAnimation{
	private ArrayList<Layer> layers;
	private int currentIndex= -1, prev= -1, next = -1;
	private Layer current = null;	
	
	public AbstractLayerSequence()
	{
		super();
		layers = new ArrayList<Layer>();
	}
	
	public void addLayer(Layer layer)
	{
		if (layers == null ) layers = new ArrayList<Layer>();
		layers.add(layer);
		PlayN.log().debug("ADDED LAYRESSSSSS : " + layers.size());
	}
	
	@Override
	public void goNext()
	{
		prev = currentIndex;
		currentIndex = (currentIndex+1)%layers.size();;
		next = (currentIndex+1)%layers.size();
		PlayN.log().debug("GoNextAnim" + currentIndex);
		this.updateState();
	}
	
	public Layer getPrevFrame()
	{
		return layers.get(prev);
	}
	
	public Layer getNextFrame()
	{
		return layers.get(next);
	}
	
	public void goPrev()
	{
		next = currentIndex;
		currentIndex = (currentIndex-1)%layers.size();;
		if (currentIndex == 0)
		{
			prev = layers.size();
			return;
		}
		if (currentIndex < 0 )
		{
			currentIndex = layers.size();
			next = 0;		
		}
		prev = currentIndex -1;
		return;
		//prev = (currentIndex-1)%layers.size();
				
	}
	

	@Override
	public void updateState() {

		//goNext();	// <---- WRONG
		//GraphicFactory.refresh(getRoot());
		//draw();
		
		PlayN.log().debug("UPDATE STATE ANIMATION " + getRoot() + " systemroot " + graphics().rootLayer() + " current" + current );
	}
	
	public void draw()
	{
		//PlayN.log().debug("ROOT " + getRoot() + " systemroot " + graphics().rootLayer() + " current" + current );
		
		if (currentIndex == -1) return;
		if (current != null)
		{
			//getRoot().remove(getPrevFrame());
			//getRoot().remove(getNextFrame());
			getPrevFrame().setVisible(false);
			getNextFrame().setVisible(false);
			getRoot().clear();			
		}
		//getRoot().clear();
		GraphicFactory.refresh(getRoot());
		
		current = layers.get((currentIndex%layers.size()));
		//current.setScale(0.3f);
		
		current.setVisible(true);
		//PlayN.log().debug("SEq current : " + current);
		//PlayN.log().debug("SEq current : " + currentIndex%layers.size());
		getRoot().add(current);
		PlayN.log().debug("SEq root SIZE: " + getRoot().size());
		
	}
	
	public ArrayList<Layer> getLayers()
	{
		return layers;
	}
	
	public Layer getCurrentLayer()
	{
		current = layers.get((currentIndex%layers.size()));
		return current;
	}
	
}