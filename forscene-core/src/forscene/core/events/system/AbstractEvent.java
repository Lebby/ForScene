/*
 * 
 */
package forscene.core.events.system;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractEvent.
 */
public abstract class AbstractEvent implements IEvent {

  /** The priority. */
  private short       priority         = 0;

  /** The priority assigned from system */
  private short       assignedPriority = 0;

  /** The done. */
  private boolean     done             = false;

  /** The status. */
  private EventStatus status           = EventStatus.NONE;

  /** The name. */
  private String      name             = "";

  /**
   * Instantiates a new abstract event.
   */
  public AbstractEvent() {
    name = this.getClass().getName();
    if (name.lastIndexOf('.') > 0) {
      name = name.substring(name.lastIndexOf('.') + 1);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  public int compareTo(AbstractEvent o) {
    return (priority - o.priority);
  }

  /**
   * Gets the priority.
   * 
   * @return the priority
   */
  public short getPriority() {
    return priority;
  }

  /**
   * Sets the priority.
   * 
   * @param priority
   *          the new priority
   */
  public void setPriority(short priority) {
    this.priority = priority;
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.events.IEvent#isDone()
   */
  public boolean isDone() {
    return done;
  }

  /**
   * Sets the done.
   * 
   * @param done
   *          the done
   * @return true, if successful
   */
  public boolean setDone(boolean done) {
    return this.done = done;
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.events.IEvent#run()
   */
  public abstract void run();

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.events.system.IEvent#getStatus()
   */
  public EventStatus getStatus() {
    return status;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * forscene.core.events.system.IEvent#setStatus(forscene.core.events.system
   * .EventStatus)
   */
  public void setStatus(EventStatus status) {
    /* complex checking on status */
    switch (this.status) {
    case RUNNING:
    case ENDED:
      if (status == EventStatus.STARTED) {
        break;
      }
    case NONE:
    case ENQUEUED:
    case STARTED:
    case PAUSED:
    default:
      this.status = status;
      break;
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.events.system.IEvent#getName()
   */
  public String getName() {
    return name;
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.events.system.IEvent#setName(java.lang.String)
   */
  public void setName(String name) {
    this.name = name;
  }

}
