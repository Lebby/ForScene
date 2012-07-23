/*
 * 
 */
package forscene.core.ui;


import playn.core.ImageLayer;
import playn.core.TextFormat;
import forscene.core.util.GraphicFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class Label.
 */
public class Label extends UIComponent{
	
	/** The text. */
	private String text;	
	
	/** The format. */
	private TextFormat format = GraphicFactory.createTextFormat();

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
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 *
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;		
		setToUpdate(true);
		ImageLayer layer = GraphicFactory.createText(text, format);		
		setRoot(layer);
	}

	/**
	 * Gets the format.
	 *
	 * @return the format
	 */
	public TextFormat getFormat() {
		return format;
	}

	/**
	 * Sets the format.
	 *
	 * @param format the format to set
	 */
	public void setFormat(TextFormat format) {
		this.format = format;
		setToUpdate(true);
	}
}
