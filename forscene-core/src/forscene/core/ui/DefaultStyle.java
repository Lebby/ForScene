/**
 * 
 */
package forscene.core.ui;

import playn.core.Font;
import playn.core.Font.Style;
import playn.core.PlayN;
import playn.core.TextFormat;

/**
 * @author blackdevil
 * 
 */
public class DefaultStyle {
  public static String     fontName    = "Comic Sans";
  public static int        fontSize    = 10;
  public static int        fontColor   = -0xffffff;
  public static Style      fontStyle   = Style.PLAIN;
  public static int        padding     = 1;
  public static Font       font        = PlayN.graphics().createFont(
                                           DefaultStyle.fontName,
                                           DefaultStyle.fontStyle,
                                           DefaultStyle.fontSize);
  public static TextFormat textFormat  = ((new TextFormat())
                                           .withFont(DefaultStyle.font));
  public static int        strokeColor = -0xffffff;
  public static float      strokeWidth = 1f;
  public static boolean    stroked     = false;
  public static boolean    filled      = true;

}
