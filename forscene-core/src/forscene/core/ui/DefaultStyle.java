/**
 * 
 */
package forscene.core.ui;

import playn.core.Color;
import playn.core.Font;
import playn.core.Font.Style;
import playn.core.PlayN;
import playn.core.TextFormat;

/**
 * @author blackdevil
 * 
 */
public class DefaultStyle {
  public static String     fontName        = "Arial";
  public static int        fontSize        = 10;
  public static int        fontColor       = Color.argb(0xff, 0x0, 0x0, 0x0);
  public static Style      fontStyle       = Style.PLAIN;
  public static int        padding         = 1;
  public static Font       font            = PlayN.graphics().createFont(
                                               DefaultStyle.fontName,
                                               DefaultStyle.fontStyle,
                                               DefaultStyle.fontSize);
  public static TextFormat textFormat      = ((new TextFormat())
                                               .withFont(DefaultStyle.font));
  public static int        strokeColor     = Color.argb(0xff, 0x0, 0x0, 0x0);
  public static float      strokeWidth     = 1f;
  public static int        backgroundColor = Color.argb(0, 0xff, 0xff, 0xff);

  public static boolean    stroked         = false;
  public static boolean    filled          = true;

}
