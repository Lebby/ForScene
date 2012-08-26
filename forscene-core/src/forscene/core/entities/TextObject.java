/**
 * 
 */
package forscene.core.entities;

import playn.core.Font;
import playn.core.Font.Style;
import playn.core.PlayN;
import playn.core.TextFormat;
import playn.core.TextLayout;
import forscene.core.ui.DefaultStyle;

/**
 * @author blackdevil
 * 
 */
public class TextObject extends AbstractPaintSceneObject {

  private String text     = "default";
  private String fontName = DefaultStyle.fontName;
  private float  fontSize;
  private int    fontColor;
  private Style  fontStyle;
  private int    padding;

  // private ImageLayer imageLayer; root is ImageLayer
  /**
 * 
 * 
 */
  public TextObject() {

    setFontColor(DefaultStyle.fontColor);
    setFontName(DefaultStyle.fontName);
    setFontSize(DefaultStyle.fontSize);
    setFontStyle(DefaultStyle.fontStyle);
    setPadding(DefaultStyle.padding);

    Font font = PlayN.graphics().createFont(fontName, fontStyle, fontSize);
    TextFormat fontFormat = ((new TextFormat()).withFont(font));

    TextLayout textlay = PlayN.graphics().layoutText(text, fontFormat);
    getCanvas().setFillColor(fontColor);
    getCanvas().fillText(textlay, 0, 0);
    getCanvas().fillText(textlay, 0, 0);

  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.system.ISceneObject#updateState()
   */
  public void updateState() {
    getCanvas().clear();

    /*
     * TextLayout layout = PlayN.graphics().layoutText(text, fontFormat);
     * Integer width = (int) layout.width() + (padding * 2); Integer height =
     * (int) layout.height() + (padding * 2);
     * 
     * CanvasImage textImage = PlayN.graphics().createImage(width, height);
     * textImage.canvas().drawText(layout, padding, padding);
     */

    Font font = PlayN.graphics().createFont(fontName, fontStyle, fontSize);
    TextFormat fontFormat = ((new TextFormat()).withFont(font));

    TextLayout textlay = PlayN.graphics().layoutText(text, fontFormat);
    getCanvas().setFillColor(fontColor);
    fontColor++;
    getCanvas().fillText(textlay, 0, 0);

  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.entities.AbstractSceneObject#build()
   */
  @Override
  public void build() {

  }

  /**
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * @param text
   *          the text to set
   */
  public void setText(String text) {
    this.text = text;
    setToUpdate(true);
  }

  /**
   * @return the fontName
   */
  public String getFontName() {
    return fontName;
  }

  /**
   * @param fontName
   *          the fontName to set
   */
  public void setFontName(String fontName) {
    this.fontName = fontName;
    setToUpdate(true);
  }

  /**
   * @return the fontSize
   */
  public float getFontSize() {
    return fontSize;
  }

  /**
   * @param fontSize
   *          the fontSize to set
   */
  public void setFontSize(int fontSize) {
    this.fontSize = fontSize;
    setToUpdate(true);
  }

  /**
   * @return the fontColor
   */
  public int getFontColor() {
    return fontColor;
  }

  /**
   * @param fontColor
   *          the fontColor to set
   */
  public void setFontColor(int fontColor) {
    this.fontColor = fontColor;
    setToUpdate(true);
  }

  /**
   * @return the fontStyle
   */
  public Style getFontStyle() {
    return fontStyle;
  }

  /**
   * @param fontStyle
   *          the fontStyle to set
   */
  public void setFontStyle(Style fontStyle) {
    this.fontStyle = fontStyle;
    setToUpdate(true);
  }

  /**
   * @return the padding
   */
  public int getPadding() {
    return padding;
  }

  /**
   * @param padding
   *          the padding to set
   */
  public void setPadding(int padding) {
    this.padding = padding;
    setToUpdate(true);
  }
}