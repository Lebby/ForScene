package forscene.core.ui;

import java.util.ArrayList;
import forscene.core.entities.AbstractSceneObjectGroup;
import forscene.core.util.GraphicFactory;
import playn.core.ImageLayer;
import playn.core.TextFormat;

public class VisualLogger extends AbstractSceneObjectGroup {
	private ArrayList<ImageLayer> renderedTexts;
	private float translationX = 0f;
	private float translationY = 0f;
	private TextFormat defaultFormat;
	
	public VisualLogger() {
		renderedTexts = new ArrayList<ImageLayer>();
		defaultFormat = GraphicFactory.createTextFormat();
	}
	
	@Override
	public void build() {
		
	}
	
	
	public void updateState() {
		//TODO: Nothing to update?		
	}
	
	public void log(String message, TextFormat format)
	{
		ImageLayer layer = GraphicFactory.createText(message, format);
		renderedTexts.add(layer);
		layer.setTranslation(translationX, translationY);
		translationY+=layer.scaledHeight();
		getRoot().add(layer);
	}
	
	public void log(String message)
	{
		log(message,defaultFormat);
	}

}
