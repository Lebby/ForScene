/*
 * 
 */
package forscene.exceptions;

import playn.core.PlayN;

// TODO: Auto-generated Javadoc
/**
 * The Class IDAlreadyPresentException.
 */
public class IDAlreadyPresentException extends Exception {
  
  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 7211991940336337436L;

  /**
   * Instantiates a new iD already present exception.
   */
  public IDAlreadyPresentException() {
    System.err.print("ID is already present. (change name) \n");
    PlayN.log().error("ID is already present. (change name) \n");
  }
}
