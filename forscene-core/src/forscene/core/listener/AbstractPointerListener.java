/*
 * 
 */
package forscene.core.listener;

import playn.core.PlayN;
import playn.core.Pointer.Adapter;
import playn.core.Pointer.Event;
import forscene.core.events.input.AbstractPointerEvent;
import forscene.system.entities.ForSceneConfigurator;
import forscene.system.managers.EventManager;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving abstractPointer events. The class that
 * is interested in processing a abstractPointer event implements this
 * interface, and the object created with that class is registered with a
 * component using the component's
 * <code>addAbstractPointerListener<code> method. When
 * the abstractPointer event occurs, that object's appropriate
 * method is invoked.
 * 
 * @see AbstractPointerEvent
 */
public class AbstractPointerListener extends Adapter implements IListener {

  /** The on pointer drag. */
  private AbstractPointerEvent onPointerDrag;

  /** The on pointer end. */
  private AbstractPointerEvent onPointerEnd;

  /** The on pointer start. */
  private AbstractPointerEvent onPointerStart;

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.listener.IListener#register()
   */
  public void register() {
    PlayN.pointer().setListener(this);
  }

  /**
   * Instantiates a new abstract pointer listener.
   */
  public AbstractPointerListener() {
    super();
  }

  /*
   * (non-Javadoc)
   * 
   * @see playn.core.Pointer.Adapter#onPointerDrag(playn.core.Pointer.Event)
   */
  @Override
  public void onPointerDrag(Event event) {
    if (getPointerDrag() == null) {
      return;
    }
    getPointerDrag().setEvent(event);
    EventManager.getInstance().push(getPointerDrag(),
        ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_SYSTEM_PRIORITY);
  }

  /*
   * (non-Javadoc)
   * 
   * @see playn.core.Pointer.Adapter#onPointerEnd(playn.core.Pointer.Event)
   */
  @Override
  public void onPointerEnd(Event event) {
    if (getPointerEnd() == null) {
      return;
    }
    getPointerEnd().setEvent(event);
    EventManager.getInstance().push(getPointerEnd(),
        ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_SYSTEM_PRIORITY);
  }

  /*
   * (non-Javadoc)
   * 
   * @see playn.core.Pointer.Adapter#onPointerStart(playn.core.Pointer.Event)
   */
  @Override
  public void onPointerStart(Event event) {
    if (getPointerStart() == null) {
      return;
    }
    getPointerStart().setEvent(event);
    EventManager.getInstance().push(getPointerStart(),
        ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_SYSTEM_PRIORITY);
  }

  /**
   * Gets the pointer drag.
   * 
   * @return the onPointerDrag
   */
  public AbstractPointerEvent getPointerDrag() {
    return onPointerDrag;
  }

  /**
   * Sets the pointer drag.
   * 
   * @param onPointerDrag
   *          the onPointerDrag to set
   */
  public void setPointerDrag(AbstractPointerEvent onPointerDrag) {
    this.onPointerDrag = onPointerDrag;
  }

  /**
   * Gets the pointer end.
   * 
   * @return the onPointerEnd
   */
  public AbstractPointerEvent getPointerEnd() {
    return onPointerEnd;
  }

  /**
   * Sets the pointer end.
   * 
   * @param onPointerEnd
   *          the onPointerEnd to set
   */
  public void setPointerEnd(AbstractPointerEvent onPointerEnd) {
    this.onPointerEnd = onPointerEnd;
  }

  /**
   * Gets the pointer start.
   * 
   * @return the onPointerStart
   */
  public AbstractPointerEvent getPointerStart() {
    return onPointerStart;
  }

  /**
   * Sets the pointer start.
   * 
   * @param onPointerStart
   *          the onPointerStart to set
   */
  public void setPointerStart(AbstractPointerEvent onPointerStart) {
    this.onPointerStart = onPointerStart;
  }

}