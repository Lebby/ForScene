/**
 * 
 */
package forscene.core.ui;

import playn.core.Font;
import playn.core.Font.Style;
import playn.core.TextFormat;
import playn.core.TextLayout;

/**
 * @author blackdevil
 * 
 */
public class DefaultStyle {
  public static String     fontName   = "Comic";
  public static int        fontSize   = 10;
  public static int        fontColor  = -0xffffff;
  public static Style      fontStyle  = Style.PLAIN;
  public static int        padding    = 1;
  public static Font       font;
  public static TextFormat textFormat = new TextFormat();
  public static TextLayout textLayout;

  private String           text       = "default";

}
