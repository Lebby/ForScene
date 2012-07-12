package forscene.core.ui;


import playn.core.ImageLayer;
import playn.core.TextFormat;
import forscene.core.util.GraphicFactory;

public class Label extends UIComponent{
	private String text;	
	private TextFormat format = GraphicFactory.createTextFormat();

	@Override
	public void build() {
	}


	public void updateState() {		
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;		
		setToUpdate(true);
		ImageLayer layer = GraphicFactory.createText(text, format);		
		setRoot(layer);
	}

	/**
	 * @return the format
	 */
	public TextFormat getFormat() {
		return format;
	}

	/**
	 * @param format the format to set
	 */
	public void setFormat(TextFormat format) {
		this.format = format;
		setToUpdate(true);
	}
}
