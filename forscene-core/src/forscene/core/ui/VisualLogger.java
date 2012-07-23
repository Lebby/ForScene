/*
 * 
 */
package forscene.core.ui;

import java.util.ArrayList;
import forscene.core.entities.AbstractSceneObjectGroup;
import forscene.core.util.GraphicFactory;
import playn.core.ImageLayer;
import playn.core.TextFormat;

// TODO: Auto-generated Javadoc
/**
 * The Class VisualLogger.
 */
public class VisualLogger extends AbstractSceneObjectGroup {
	
	/** The rendered texts. */
	private ArrayList<ImageLayer> renderedTexts;
	
	/** The translation x. */
	private float translationX = 0f;
	
	/** The translation y. */
	private float translationY = 0f;
	
	/** The default format. */
	private TextFormat defaultFormat;
	
	/**
	 * Instantiates a new visual logger.
	 */
	public VisualLogger() {
		renderedTexts = new ArrayList<ImageLayer>();
		defaultFormat = GraphicFactory.createTextFormat();
	}
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.AbstractSceneObject#build()
	 */
	@Override
	public void build() {
		
	}
	
	
	/* (non-Javadoc)
	 * @see forscene.system.ISceneObject#updateState()
	 */
	public void updateState() {
		//TODO: Nothing to update?		
	}
	
	/**
	 * Log.
	 *
	 * @param message the message
	 * @param format the format
	 */
	public void log(String message, TextFormat format)
	{
		ImageLayer layer = GraphicFactory.createText(message, format);
		renderedTexts.add(layer);
		layer.setTranslation(translationX, translationY);
		translationY+=layer.scaledHeight();
		getRoot().add(layer);
	}
	
	/**
	 * Log.
	 *
	 * @param message the message
	 */
	public void log(String message)
	{
		log(message,defaultFormat);
	}

}
