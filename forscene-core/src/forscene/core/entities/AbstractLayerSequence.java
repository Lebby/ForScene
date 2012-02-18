package forscene.core.entities;

import java.util.ArrayList;

import playn.core.Layer;
import playn.core.PlayN;
import forscene.core.util.GraphicFactory;
import static playn.core.PlayN.graphics;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractLayerSequence.
 */
public abstract class AbstractLayerSequence extends AbstractAnimation{
	
	/** The layers. */
	private ArrayList<Layer> layers;
	
	/** The next. */
	private int currentIndex= -1, prev= -1, next = -1;
	
	/** The current. */
	private Layer current = null;	
	
	/**
	 * Instantiates a new abstract layer sequence.
	 */
	public AbstractLayerSequence()
	{
		super();
		layers = new ArrayList<Layer>();
	}
	
	/**
	 * Adds the layer.
	 *
	 * @param layer the layer
	 */
	public void addLayer(Layer layer)
	{
		if (layers == null ) layers = new ArrayList<Layer>();
		layers.add(layer);
		PlayN.log().debug("ADDED LAYRESSSSSS : " + layers.size());
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.AbstractAnimation#goNext()
	 */
	@Override
	public void goNext()
	{
		prev = currentIndex;
		currentIndex = (currentIndex+1)%layers.size();;
		next = (currentIndex+1)%layers.size();
		PlayN.log().debug("GoNextAnim" + currentIndex);
		this.updateState();
	}
	
	/**
	 * Gets the prev frame.
	 *
	 * @return the prev frame
	 */
	public Layer getPrevFrame()
	{
		return layers.get(prev);
	}
	
	/**
	 * Gets the next frame.
	 *
	 * @return the next frame
	 */
	public Layer getNextFrame()
	{
		return layers.get(next);
	}
	
	/**
	 * Go prev.
	 */
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
	

	/* (non-Javadoc)
	 * @see forscene.core.entities.AbstractAnimation#updateState()
	 */
	@Override
	public void updateState() {

		//goNext();	// <---- WRONG
		//GraphicFactory.refresh(getRoot());
		//draw();
		
		PlayN.log().debug("UPDATE STATE ANIMATION " + getRoot() + " systemroot " + graphics().rootLayer() + " current" + current );
	}
	
	/**
	 * Draw.

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
	 */
	
	/**
	 * Gets the layers.
	 *
	 * @return the layers
	 */
	public ArrayList<Layer> getLayers()
	{
		return layers;
	}
	
	/**
	 * Gets the current layer.
	 *
	 * @return the current layer
	 */
	public Layer getCurrentLayer()
	{
		current = layers.get((currentIndex%layers.size()));
		return current;
	}
	
}