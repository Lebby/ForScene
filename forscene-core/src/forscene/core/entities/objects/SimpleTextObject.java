/**
 * 
 */
package forscene.core.entities.objects;

import playn.core.Font;
import playn.core.Font.Style;
import playn.core.ImageLayer;
import playn.core.PlayN;
import playn.core.TextFormat;
import playn.core.TextFormat.Alignment;
import playn.core.TextLayout;
import forscene.core.ui.DefaultStyle;

/**
 * @author blackdevil
 * 
 */
public class SimpleTextObject extends AbstractPaintSceneObject {

  private String    text     = "default";
  private String    fontName = DefaultStyle.fontName;
  private float     fontSize;
  private int       fontColor;
  private Style     fontStyle;
  private int       padding;
  private int       strokeColor;
  private float     strokeWidth;
  private boolean   stroked;
  private boolean   filled;
  private int       backgroundColor;
  private Font      font;
  private Alignment align;

  // private ImageLayer imageLayer; root is ImageLayer
  /**
 * 
 * 
 */
  public SimpleTextObject() {
    setFontColor(DefaultStyle.fontColor);
    setFontName(DefaultStyle.fontName);
    setFontSize(DefaultStyle.fontSize);
    setFontStyle(DefaultStyle.fontStyle);
    setPadding(DefaultStyle.padding);
    setStrokeColor(DefaultStyle.strokeColor);
    setStrokeWidth(DefaultStyle.strokeWidth);
    setStroked(DefaultStyle.stroked);
    setFilled(DefaultStyle.filled);
    setBackgroundColor(DefaultStyle.backgroundColor);
    setAlignment(DefaultStyle.textAlign);
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.system.ISceneObject#updateState()
   */

  /**
   * @param textAlign
   */
  public void setAlignment(Alignment textAlign) {
    align = textAlign;
  }

  public void write() {
    if (isBuilded()) {
      getImageLayer().destroy();
      float width, height;
      float maxWidth = 0;
      String[] splittedText = text.split("\n");
      for (String element : splittedText) {
        if (maxWidth < element.length()) {
          maxWidth = element.length();
        }
      }
      width = (maxWidth * fontSize) / 1.8f;
      height = fontSize * splittedText.length * 1.4f;
      setCanvasImage(PlayN.graphics().createImage(width, height));
      setCanvas(getCanvasImage().canvas());
      getCanvas().clear();
      ImageLayer immLayer = PlayN.graphics().createImageLayer(getCanvasImage());
      setImageLayer(immLayer);
      getCanvas().clear();

      font = PlayN.graphics().createFont(fontName, fontStyle, fontSize);
      TextFormat fontFormat = ((new TextFormat()).withFont(font));
      fontFormat = fontFormat.withWrapWidth(width);
      fontFormat = fontFormat.withAlignment(align);

      TextLayout textlay = PlayN.graphics().layoutText(text, fontFormat);
      getCanvas().setFillColor(backgroundColor);
      getCanvas().fillRect(0, 0, getImageLayer().width(),
          getImageLayer().height());
      getCanvas().setFillColor(fontColor);
      if (isFilled()) {
        getCanvas().fillText(textlay, 0, 0);
      }
      if (isStroked()) {
        getCanvas().strokeText(textlay, 0, 0);
      }

      setToUpdate(false);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.entities.AbstractSceneObject#build()
   */
  @Override
  public void build() {
    write();
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
   * @return the font
   */
  public Font getFont() {
    return font;
  }

  /**
   * @param font
   *          the font to set
   */
  public void setFont(Font font) {
    this.font = font;
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

  /*
   * (non-Javadoc)
   * 
   * @see forscene.system.ISceneObject#updateState()
   */
  public void updateState() {
    if (isToUpdate()) {
      write();
    }

  }

  /**
   * @return the backgroundColor
   */
  public int getBackgroundColor() {
    return backgroundColor;
  }

  /**
   * @param backgroundColor
   *          the backgroundColor to set
   */
  public void setBackgroundColor(int backgroundColor) {
    this.backgroundColor = backgroundColor;
    setToUpdate(true);
  }
}