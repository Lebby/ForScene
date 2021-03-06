/*
 * 
 */
package forscene.core.listener;

import playn.core.Mouse.Adapter;
import playn.core.Mouse.ButtonEvent;
import playn.core.Mouse.MotionEvent;
import playn.core.Mouse.WheelEvent;
import playn.core.PlayN;
import forscene.core.events.input.AbstractMouseButtonEvent;
import forscene.core.events.input.AbstractMouseEvent;
import forscene.core.events.input.AbstractMouseMotionEvent;
import forscene.core.events.input.AbstractMouseWheelEvent;
import forscene.system.entities.ForSceneConfigurator;
import forscene.system.managers.EventManager;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving abstractMouse events. The class that is
 * interested in processing a abstractMouse event implements this interface, and
 * the object created with that class is registered with a component using the
 * component's <code>addAbstractMouseListener<code> method. When
 * the abstractMouse event occurs, that object's appropriate
 * method is invoked.
 * 
 * @see AbstractMouseEvent
 */
public class AbstractMouseListener extends Adapter implements IListener {

  /** The evt mouse down. */
  private AbstractMouseButtonEvent evtMouseDown;

  /** The evt mouse up. */
  private AbstractMouseButtonEvent evtMouseUp;

  /** The evt mouse wheel scroll. */
  private AbstractMouseWheelEvent  evtMouseWheelScroll;

  /** The evt mouse move. */
  private AbstractMouseMotionEvent evtMouseMove;

  /**
   * Instantiates a new abstract mouse listener.
   */
  public AbstractMouseListener() {
    super();
  }

  /**
   * Instantiates a new abstract mouse listener.
   * 
   * @param eventMouseDown
   *          the event mouse down
   * @param eventMouseUp
   *          the event mouse up
   */
  public AbstractMouseListener(AbstractMouseButtonEvent eventMouseDown,
      AbstractMouseButtonEvent eventMouseUp) {
    this();
    evtMouseDown = eventMouseDown;
    evtMouseUp = eventMouseUp;
  }

  /**
   * Instantiates a new abstract mouse listener.
   * 
   * @param eventMouseDown
   *          the event mouse down
   * @param eventMouseUp
   *          the event mouse up
   * @param eventMouseMove
   *          the event mouse move
   * @param eventMouseScroll
   *          the event mouse scroll
   */
  public AbstractMouseListener(AbstractMouseButtonEvent eventMouseDown,
      AbstractMouseButtonEvent eventMouseUp,
      AbstractMouseMotionEvent eventMouseMove,
      AbstractMouseWheelEvent eventMouseScroll) {
    this();
    evtMouseDown = eventMouseDown;
    evtMouseMove = eventMouseMove;
    evtMouseUp = eventMouseUp;
    evtMouseWheelScroll = eventMouseScroll;
  }

  /*
   * (non-Javadoc)
   * 
   * @see playn.core.Mouse.Adapter#onMouseDown(playn.core.Mouse.ButtonEvent)
   */
  @Override
  public void onMouseDown(ButtonEvent event) {
    if (evtMouseDown == null) {
      return;
    }
    evtMouseDown.setEvent(event);
    EventManager.getInstance().push(evtMouseDown,
        ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_SYSTEM_PRIORITY);
  }

  /*
   * (non-Javadoc)
   * 
   * @see playn.core.Mouse.Adapter#onMouseMove(playn.core.Mouse.MotionEvent)
   */
  @Override
  public void onMouseMove(MotionEvent event) {
    if (evtMouseMove == null) {
      return;
    }
    evtMouseMove.setEvent(event);
    EventManager.getInstance().push(evtMouseMove,
        ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_SYSTEM_PRIORITY);
  }

  /*
   * (non-Javadoc)
   * 
   * @see playn.core.Mouse.Adapter#onMouseUp(playn.core.Mouse.ButtonEvent)
   */
  @Override
  public void onMouseUp(ButtonEvent event) {
    if (evtMouseUp == null) {
      return;
    }
    evtMouseUp.setEvent(event);
    EventManager.getInstance().push(evtMouseUp,
        ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_SYSTEM_PRIORITY);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * playn.core.Mouse.Adapter#onMouseWheelScroll(playn.core.Mouse.WheelEvent)
   */
  @Override
  public void onMouseWheelScroll(WheelEvent event) {
    if (evtMouseWheelScroll == null) {
      return;
    }
    evtMouseWheelScroll.setEvent(event);
    EventManager.getInstance().push(evtMouseWheelScroll,
        ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_SYSTEM_PRIORITY);
  }

  /**
   * Gets the mouse down.
   * 
   * @return the evtMouseDown
   */
  public AbstractMouseButtonEvent getMouseDown() {
    return evtMouseDown;
  }

  /**
   * Sets the mouse down.
   * 
   * @param evtMouseDown
   *          the evtMouseDown to set
   */
  public void setMouseDown(AbstractMouseButtonEvent evtMouseDown) {
    this.evtMouseDown = evtMouseDown;
  }

  /**
   * Gets the mouse up.
   * 
   * @return the evtMouseUp
   */
  public AbstractMouseButtonEvent getMouseUp() {
    return evtMouseUp;
  }

  /**
   * Sets the mouse up.
   * 
   * @param evtMouseUp
   *          the evtMouseUp to set
   */
  public void setMouseUp(AbstractMouseButtonEvent evtMouseUp) {
    this.evtMouseUp = evtMouseUp;
  }

  /**
   * Gets the mouse wheel scroll.
   * 
   * @return the evtMouseWheelScroll
   */
  public AbstractMouseWheelEvent getMouseWheelScroll() {
    return evtMouseWheelScroll;
  }

  /**
   * Sets the mouse wheel scroll.
   * 
   * @param evtMouseWheelScroll
   *          the evtMouseWheelScroll to set
   */
  public void setMouseWheelScroll(AbstractMouseWheelEvent evtMouseWheelScroll) {
    this.evtMouseWheelScroll = evtMouseWheelScroll;
  }

  /**
   * Gets the mouse move.
   * 
   * @return the evtMouseMove
   */
  public AbstractMouseMotionEvent getMouseMove() {
    return evtMouseMove;
  }

  /**
   * Sets the mouse move.
   * 
   * @param evtMouseMove
   *          the evtMouseMove to set
   */
  public void setMouseMove(AbstractMouseMotionEvent evtMouseMove) {
    this.evtMouseMove = evtMouseMove;
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.listener.IListener#register()
   */
  public void register() {
    PlayN.mouse().setListener(this);
  }

}