/**
 * 
 */
package forscene.system;

import playn.core.PlayN;

/**
 * @author blackdevil
 * 
 */
public class Asserts {
  private static boolean ENABLE = true;

  public boolean isEnable() {
    return Asserts.ENABLE;
  }

  public void setEnable(boolean enable) {
    Asserts.ENABLE = enable;
  }

  public static void check(boolean condition, String message, Object[] toPrint) {
    if (!Asserts.ENABLE) {
      return;
    }
    if (!condition) {
      if (toPrint != null) {
        for (Object element : toPrint) {
          message += " " + element;
        }
      }
      PlayN.log().debug(message);
      Exception e = new Exception(message);
      e.printStackTrace();
      System.exit(0);

    }
  }

  public static void check(boolean condition, String message) {
    Asserts.check(condition, message, null);
  }

  public static void check(boolean condition) {
    Asserts.check(condition, "Asserts error", null);

  }
}
