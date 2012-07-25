/**
 * 
 */
package forscene.core.entities.toTest.sprites;

import playn.core.Image;

// TODO: Auto-generated Javadoc
/**
 * The Class SpriteImage.
 *
 * @author Scuderi Giovanni Luca {Lebby} mail:glscud@gmail.com
 */
/*
 * "frame": {"x":0,"y":194,"w":32,"h":44}, "rotated": false, "trimmed": true,
 * "spriteSourceSize": {"x":39,"y":121,"w":32,"h":44}, "sourceSize":
 * {"w":256,"h":192}
 */

public class SpriteImage {

  /** The image. */
  private final Image   image;  // ready for surface,canvas or object
  
  /** The x. */
  private final float   x;
  
  /** The y. */
  private final float   y;
  
  /** The width. */
  private final float   width;
  
  /** The height. */
  private final float   height;
  
  /** The rotated. */
  private final boolean rotated;
  
  /** The trimmed. */
  private final boolean trimmed;

  /**
   * Instantiates a new sprite image.
   */
  public SpriteImage() {
    image = null;
    x = y = width = height = 0;
    rotated = trimmed = false;

  }

  /**
   * Gets the image.
   *
   * @return the image
   */
  public Image getImage() {
    return image;
  }

  /**
   * Gets the x.
   *
   * @return the x
   */
  public float getX() {
    return x;
  }

  /**
   * Gets the y.
   *
   * @return the y
   */
  public float getY() {
    return y;
  }

  /**
   * Gets the width.
   *
   * @return the width
   */
  public float getWidth() {
    return width;
  }

  /**
   * Gets the height.
   *
   * @return the height
   */
  public float getHeight() {
    return height;
  }

  /**
   * Checks if is rotated.
   *
   * @return the rotated
   */
  public boolean isRotated() {
    return rotated;
  }

  /**
   * Checks if is trimmed.
   *
   * @return the trimmed
   */
  public boolean isTrimmed() {
    return trimmed;
  }

}
