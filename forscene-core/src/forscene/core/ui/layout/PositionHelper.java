/*
 * 
 */
package forscene.core.ui.layout;

import forscene.core.entities.AbstractSceneObject;
import forscene.core.util.ShapeUtil;
import forscene.system.Asserts;

// TODO: Auto-generated Javadoc
/*
 * alignment is relative to parent and refer on nearest object border.
 * Align left is relative to object left border ( x=0 )
 * Align right is relative to object right border ( x= width )
 * Align top is relative to object top border ( y=0 )
 * center is relative to object center ( x = width/2 or height/2 ) 
 * ... and so on 
 * 
 */
/**
 * The Class PositionHelper.
 */
public class PositionHelper {

  /**
   * Align.
   * 
   * @param parent
   *          the parent
   * @param target
   *          the target
   * @param align
   *          the align
   */
  public static void align(AbstractSceneObject<?> parent,
      AbstractSceneObject<?> target, Align align) {
    Asserts.check(parent != null, "parent can't be null", new Object[0]);
    Asserts.check(align != null, "align can't be null", new Object[0]);
    Asserts.check(target != null, "align can't be null", new Object[0]);

    // horizontal component
    switch (align) {
    case HORIZONTAL_CENTER:
    case LEFT:
    case RIGHT:
      PositionHelper.horizontalAlign(parent, target, align);
      break;
    case BOTTOM_CENTER:
    case MIDDLE:
    case TOP_CENTER:
      PositionHelper.horizontalAlign(parent, target, Align.HORIZONTAL_CENTER);
      break;
    case BOTTOM_LEFT:
    case CENTER_LEFT:
    case TOP_LEFT:
      PositionHelper.horizontalAlign(parent, target, Align.LEFT);
      break;
    case BOTTOM_RIGHT:
    case CENTER_RIGHT:
    case TOP_RIGHT:
      PositionHelper.horizontalAlign(parent, target, Align.RIGHT);
      break;
    }

    // vertical component
    switch (align) {

    case TOP:
    case BOTTOM:
    case VERTICAL_CENTER:
      PositionHelper.verticalAlign(parent, target, align);
      break;

    case BOTTOM_CENTER:
    case BOTTOM_LEFT:
    case BOTTOM_RIGHT:
      PositionHelper.verticalAlign(parent, target, Align.BOTTOM);
      break;

    case CENTER_LEFT:
    case CENTER_RIGHT:
    case MIDDLE:
      PositionHelper.verticalAlign(parent, target, Align.VERTICAL_CENTER);
      break;

    case TOP_CENTER:
    case TOP_LEFT:
    case TOP_RIGHT:
      PositionHelper.verticalAlign(parent, target, Align.TOP);
      break;
    }
  }

  /**
   * Vertical align.
   * 
   * @param parent
   *          the parent
   * @param target
   *          the target
   * @param align
   *          the align
   */
  private static void verticalAlign(AbstractSceneObject<?> parent,
      AbstractSceneObject<?> target, Align align) {
    Asserts.check(parent != null, "parent can't be null", new Object[0]);
    Asserts.check(align != null, "align can't be null", new Object[0]);
    Asserts.check(target != null, "align can't be null", new Object[0]);

    float containerHeight = ShapeUtil.calculateShapeInfoSceneObject(parent)
        .getMaxY();
    float targetHeight = ShapeUtil.calculateShapeInfoSceneObject(target)
        .getMaxY();

    float position = 0;

    switch (align) {
    case TOP:
      position = 0;
      break;
    case BOTTOM:
      position = containerHeight;
      position = position - targetHeight;
      break;
    case VERTICAL_CENTER:
      position = (containerHeight / 2) - (targetHeight / 2);
      break;
    }
    if (target.getRoot() == null) {
      target.buildOnce();
    }
    target.getRoot()
        .setTranslation(target.getRoot().transform().tx(), position);

  }

  /**
   * Horizontal align.
   * 
   * @param parent
   *          the parent
   * @param target
   *          the target
   * @param align
   *          the align
   */
  private static void horizontalAlign(AbstractSceneObject<?> parent,
      AbstractSceneObject<?> target, Align align) {
    Asserts.check(parent != null, "parent can't be null", new Object[0]);
    Asserts.check(align != null, "align can't be null", new Object[0]);
    Asserts.check(target != null, "align can't be null", new Object[0]);

    float containerWidth = ShapeUtil.calculateShapeInfoSceneObject(parent)
        .getMaxX();

    float targetWidth = ShapeUtil.calculateShapeInfoSceneObject(target)
        .getMaxX();

    float position = 0;

    switch (align) {
    case LEFT:
      position = 0;
      break;
    case RIGHT:
      position = containerWidth;
      position = position - targetWidth;
      break;
    case HORIZONTAL_CENTER:
      position = (containerWidth / 2) - (targetWidth / 2);
      break;
    }

    if (target.getRoot() == null) {
      target.buildOnce();
    }
    target.getRoot()
        .setTranslation(position, target.getRoot().transform().ty());
  }

}
