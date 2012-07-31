/*
 * 
 */
package forscene.core.listener;

import playn.core.Keyboard.Adapter;
import playn.core.Keyboard.Event;
import playn.core.Keyboard.TypedEvent;
import playn.core.PlayN;
import forscene.core.events.input.AbstractKeyEvent;
import forscene.core.events.input.AbstractKeyboardEvent;
import forscene.core.events.input.AbstractTypedEvent;
import forscene.system.entities.ForSceneConfigurator;
import forscene.system.managers.EventManager;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving abstractKeyboard events. The class that
 * is interested in processing a abstractKeyboard event implements this
 * interface, and the object created with that class is registered with a
 * component using the component's
 * <code>addAbstractKeyboardListener<code> method. When
 * the abstractKeyboard event occurs, that object's appropriate
 * method is invoked.
 * 
 * @see AbstractKeyboardEvent
 */
public class AbstractKeyboardListener extends Adapter implements IListener {

  /** The key down. */
  private AbstractKeyEvent   keyDown;

  /** The key up. */
  private AbstractKeyEvent   keyUp;

  /** The key typed. */
  private AbstractTypedEvent keyTyped;

  /**
   * Gets the key down.
   * 
   * @return the keyDown
   */
  public AbstractKeyEvent getKeyDown() {
    return keyDown;
  }

  /**
   * Sets the key down.
   * 
   * @param keyDown
   *          the keyDown to set
   */
  public void setKeyDown(AbstractKeyEvent keyDown) {
    this.keyDown = keyDown;
  }

  /**
   * Gets the key up.
   * 
   * @return the keyUp
   */
  public AbstractKeyEvent getKeyUp() {
    return keyUp;
  }

  /**
   * Sets the key up.
   * 
   * @param keyUp
   *          the keyUp to set
   */
  public void setKeyUp(AbstractKeyEvent keyUp) {
    this.keyUp = keyUp;
  }

  /**
   * Gets the key typed.
   * 
   * @return the keyTyped
   */
  public AbstractTypedEvent getKeyTyped() {
    return keyTyped;
  }

  /**
   * Sets the key typed.
   * 
   * @param keyTyped
   *          the keyTyped to set
   */
  public void setKeyTyped(AbstractTypedEvent keyTyped) {
    this.keyTyped = keyTyped;
  }

  /**
   * Instantiates a new abstract keyboard listener.
   */
  public AbstractKeyboardListener() {
    super();
  }

  /**
   * Instantiates a new abstract keyboard listener.
   * 
   * @param eventKeyDown
   *          the event key down
   * @param eventKeyUp
   *          the event key up
   */
  public AbstractKeyboardListener(AbstractKeyEvent eventKeyDown,
      AbstractKeyEvent eventKeyUp) {
    this();
    keyDown = eventKeyDown;
    keyUp = eventKeyUp;
  }

  /*
   * (non-Javadoc)
   * 
   * @see playn.core.Keyboard.Adapter#onKeyDown(playn.core.Keyboard.Event)
   */
  @Override
  public void onKeyDown(Event event) {
    if (keyDown == null) {
      return;
    }
    keyDown.setEvent(event);
    EventManager.getInstance().push(keyDown,
        ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_SYSTEM_PRIORITY);
    if (keyUp != null) {
      keyUp.setDone(true);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see playn.core.Keyboard.Adapter#onKeyUp(playn.core.Keyboard.Event)
   */
  @Override
  public void onKeyUp(Event event) {
    if (keyUp == null) {
      return;
    }
    keyDown.setEvent(event);
    EventManager.getInstance().push(keyUp,
        ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_SYSTEM_PRIORITY);
    if (keyDown != null) {
      keyDown.setDone(true);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see playn.core.Keyboard.Adapter#onKeyTyped(playn.core.Keyboard.TypedEvent)
   */
  @Override
  public void onKeyTyped(TypedEvent event) {
    if (keyTyped == null) {
      return;
    }
    keyTyped.setEvent(event);
    EventManager.getInstance().push(keyTyped,
        ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_SYSTEM_PRIORITY);
    keyTyped.setDone(true);
  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.listener.IListener#register()
   */
  public void register() {
    PlayN.keyboard().setListener(this);
  }

}