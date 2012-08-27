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

  private String  text     = "default";
  private String  fontName = DefaultStyle.fontName;
  private float   fontSize;
  private int     fontColor;
  private Style   fontStyle;
  private int     padding;
  private int     strokeColor;
  private float   strokeWidth;
  private boolean stroked;
  private boolean filled;

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
    setStrokeColor(DefaultStyle.strokeColor);
    setStrokeWidth(DefaultStyle.strokeWidth);
    setStroked(DefaultStyle.stroked);
    setFilled(DefaultStyle.filled);
    write();
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.system.ISceneObject#updateState()
   */
  public void updateState() {
    write();
  }

  public void write() {
    getCanvas().clear();
    Font font = PlayN.graphics().createFont(fontName, fontStyle, fontSize);
    TextFormat fontFormat = ((new TextFormat()).withFont(font));
    TextLayout textlay = PlayN.graphics().layoutText(text, fontFormat);
    if (isFilled()) {
      getCanvas().fillText(textlay, 0, 0);
    }
    if (isStroked()) {
      getCanvas().strokeText(textlay, 0, 0);
    }

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
    getCanvas().setFillColor(fontColor);
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

  /**
   * @return the strokeColor
   */
  public int getStrokeColor() {
    return strokeColor;
  }

  /**
   * @param strokeColor
   *          the strokeColor to set
   */
  public void setStrokeColor(int strokeColor) {
    this.strokeColor = strokeColor;
    getCanvas().setStrokeColor(strokeColor);
    setToUpdate(true);
  }

  /**
   * @return the strokeWidth
   */
  public float getStrokeWidth() {
    return strokeWidth;
  }

  /**
   * @param strokeWidth
   *          the strokeWidth to set
   */
  public void setStrokeWidth(float strokeWidth) {
    this.strokeWidth = strokeWidth;
    getCanvas().setStrokeWidth(strokeWidth);
    setToUpdate(true);
  }

  /**
   * @return the stroked
   */
  public boolean isStroked() {
    return stroked;
  }

  /**
   * @param stroked
   *          the stroked to set
   */
  public void setStroked(boolean stroked) {
    this.stroked = stroked;
    setToUpdate(true);
  }

  /**
   * @return the filled
   */
  public boolean isFilled() {
    return filled;
  }

  /**
   * @param filled
   *          the filled to set
   */
  public void setFilled(boolean filled) {
    this.filled = filled;
    setToUpdate(true);
  }
}