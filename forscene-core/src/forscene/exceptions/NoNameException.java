/*
 * 
 */
package forscene.exceptions;

import playn.core.PlayN;

// TODO: Auto-generated Javadoc
/**
 * The Class NoNameException.
 */
public class NoNameException extends AbstractSceneObjectException {
  
  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -7964696907646854838L;

  /**
   * Instantiates a new no name exception.
   */
  public NoNameException() {
    System.err
        .print("Set a name to object by setName() or use a different method \n");
    System.err.print("Name is not setted at ");
    PlayN.log().error(
        "Set a name to object by setName() or use a different method \n"
            + "Name is not setted at ", this);

  }
}
