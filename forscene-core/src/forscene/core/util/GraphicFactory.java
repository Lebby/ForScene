/*
 * 
 */
package forscene.core.util;

import playn.core.CanvasImage;
import playn.core.CanvasLayer;
import playn.core.Font;
import playn.core.Font.Style;
import playn.core.GroupLayer;
import playn.core.ImageLayer;
import playn.core.Layer;
import playn.core.PlayN;
import playn.core.SurfaceLayer;
import playn.core.TextFormat;
import playn.core.TextFormat.Alignment;
import playn.core.TextLayout;
import forscene.core.entities.objects.AbstractSceneObject;
import forscene.core.entities.objects.AbstractSceneObjectGroup;
import forscene.system.managers.ResourceManager;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Graphic objects.
 */
public class GraphicFactory {

  /**
   * Adds the image.
   * 
   * @param url
   *          the url
   * @param scene
   *          the scene
   * @return the image layer
   */
  public static ImageLayer addImage(String url, AbstractSceneObject<?> scene) {
    ImageLayer image = ResourceManager.loadImageLayer(url);

    if (scene instanceof AbstractSceneObjectGroup) {
      ((AbstractSceneObjectGroup) scene).getRoot().add(image);
      ResourceManager.getInstance().load(image);
    } else if (scene instanceof AbstractSceneObject) {
      ((AbstractSceneObject<Layer.HasSize>) scene).setRoot(image);
    }

    return image;
  }

  /**
   * Creates a new Graphic object.
   * 
   * @param text
   *          the text
   * @param format
   *          the format
   * @return the image layer
   */
  public static ImageLayer createText(String text, TextFormat format) {
    // crea il font : Font font = graphics().createFont("Courier",
    // Font.Style.PLAIN, 16);
    // crea il format : TextFormat txtFormat = new TextFormat();
    // crea il layout : TextLayout layout = graphics().layoutText(text, format);
    // crea il canvaslayer : CanvasLayer layer =
    // graphics().createCanvasLayer((int)Math.ceil(layout.width()),
    // (int)Math.ceil(layout.height()));
    // scrivo il layer : layer.canvas().drawText(layout, 0, 0);

    TextLayout layout = PlayN.graphics().layoutText(text, format);
    // CanvasImage canvas =
    // graphics().createImage(((int)Math.ceil(layout.width())),
    // ((int)Math.ceil(layout.height())));
    /* CanvasImage canvas = */PlayN.graphics().createImage(layout.width(),
        layout.height());
    // canvas = graphics().createImage((int)Math.ceil(layout.width()),
    // (int)Math.ceil(layout.height()));
    // canvas.canvas().strokeText (layout, 0, 0);

    // ImageLayer layer = PlayN.graphics().createImageLayer();
    // layer.setImage(canvas);

    // return layer;
    ImageLayer image = PlayN.graphics().createImageLayer();
    image.setHeight(10);
    image.setWidth(10);
    return image;
  }

  /**
   * Creates a new Graphic object.
   * 
   * @param font
   *          the font
   * @param textColor
   *          the text color
   * @return the text format
   */
  public static TextFormat createTextFormat(Font font, int textColor) {
    TextFormat format = new TextFormat();
    format = format.withAlignment(Alignment.LEFT);
    format = format.withFont(font);
    // format = format.withTextColor(textColor);
    return format;
  }

  /**
   * Creates a new Graphic object.
   * 
   * @param fontName
   *          the font name
   * @param fontStyle
   *          the font style
   * @param size
   *          the size
   * @return the font
   */
  public static Font createFont(String fontName, Style fontStyle, float size) {
    Font font = PlayN.graphics().createFont(fontName, fontStyle, size);
    return font;
  }

  /**
   * Creates a new Graphic object.
   * 
   * @return the text format
   */
  public static TextFormat createTextFormat() {
    Font font = GraphicFactory.createFont("Arial", Font.Style.PLAIN, 10f);
    TextFormat format = GraphicFactory.createTextFormat(font, 0xFF000000);
    return format;
  }

  /**
   * Creates a new Graphic object.
   * 
   * @return the group layer
   */
  public static GroupLayer createGroupLayer() {
    GroupLayer gl = PlayN.graphics().createGroupLayer();
    return gl;
  }

  /*
   * public static void refresh(GroupLayer root) { ArrayList<Layer> ls = new
   * ArrayList<Layer>(); for ( int i = 0 ; i < root.size() ; i++) { ls.add(
   * root.get(i)); root.remove(ls.get(i)); PlayN.log().debug("E---- : " +
   * ls.get(i)); } root.clear(); for ( int i = 0 ; i < ls.size() ; i++) {
   * root.add(ls.get(i)); } }
   */

  /**
   * Draw border.
   * 
   * @param root
   *          the root
   * @return the group layer
   */
  public static GroupLayer drawBorder(Layer root) {
    GroupLayer border = null;
    try {
      if (root instanceof GroupLayer) {
        GroupLayer tmpborder = PlayN.graphics().createGroupLayer();
        for (int i = 0; i < ((GroupLayer) root).size(); i++) {
          tmpborder.add(GraphicFactory.drawBorder(((GroupLayer) root).get(i)));
        }
        border = tmpborder;
      } else if ((root instanceof Layer.HasSize)
          || (root instanceof ImageLayer) || (root instanceof SurfaceLayer)
          || (root instanceof CanvasLayer)) {
        Layer.HasSize tmp = (Layer.HasSize) root;
        CanvasImage canvas = PlayN.graphics().createImage((int) tmp.width(),
            (int) tmp.height());
        canvas.canvas().setStrokeColor(playn.core.Color.rgb(100, 100, 100));
        canvas.canvas().setFillColor(playn.core.Color.rgb(100, 100, 100));
        canvas.canvas().setStrokeWidth(2);
        canvas.canvas().drawLine(tmp.originX(), tmp.originY(), tmp.originX(),
            tmp.originY() + tmp.height());
        canvas.canvas().drawLine(tmp.originX(), tmp.originY() + tmp.height(),
            tmp.originX() + tmp.width(), tmp.originY() + tmp.height());
        canvas.canvas().drawLine(tmp.originX() + tmp.width(),
            tmp.originY() + tmp.height(), tmp.originX() + tmp.width(),
            tmp.originY());
        canvas.canvas().drawLine(tmp.originX() + tmp.width(), tmp.originY(),
            tmp.originX(), tmp.originY());
        border = PlayN.graphics().createGroupLayer();
        ImageLayer imageLayer = PlayN.graphics().createImageLayer(canvas);
        border.add(imageLayer);
      }
    } catch (Exception e) {
      PlayN.log().debug(e.toString());
    }
    return border;
  }
}