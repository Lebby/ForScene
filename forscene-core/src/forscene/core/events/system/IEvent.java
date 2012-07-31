/*
 * 
 */
package forscene.core.events.system;

// TODO: Auto-generated Javadoc
/**
 * The Interface IEvent.
 */
public interface IEvent extends Comparable<AbstractEvent> {

  /**
   * Run.
   */
  void run();

  /**
   * Checks if is done.
   * 
   * @return true, if is done
   */
  boolean isDone();

  /**
   * Gets the status.
   * 
   * @return the status
   */
  EventStatus getStatus();

  /**
   * Sets the status.
   * 
   * @param status
   *          the new status
   */
  void setStatus(EventStatus status);

  /**
   * Gets the name.
   * 
   * @return the name
   */
  String getName();

  /**
   * Sets the name.
   * 
   * @param name
   *          the new name
   */
  void setName(String name);

  short getPriority();

  void setPriority(short priority);

}