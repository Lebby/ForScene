package forscene.core.listener;


import static playn.core.PlayN.keyboard;
import playn.core.PlayN;
import playn.core.Keyboard.Adapter;
import playn.core.Keyboard.Event;
import playn.core.Keyboard.TypedEvent;

import forscene.core.events.input.keyboard.AbstractKeyEvent;
import forscene.core.events.input.keyboard.AbstractTypedEvent;
import forscene.system.managers.EventManager;

public class AbstractKeyboardListener extends Adapter implements IListener {	
	private AbstractKeyEvent keyDown;
	private AbstractKeyEvent keyUp;
	private AbstractTypedEvent keyTyped;
	
	/**
	 * @return the keyDown
	 */
	public AbstractKeyEvent getKeyDown() {
		return keyDown;
	}

	/**
	 * @param keyDown the keyDown to set
	 */
	public void setKeyDown(AbstractKeyEvent keyDown) {
		this.keyDown = keyDown;
	}

	/**
	 * @return the keyUp
	 */
	public AbstractKeyEvent getKeyUp() {
		return keyUp;
	}

	/**
	 * @param keyUp the keyUp to set
	 */
	public void setKeyUp(AbstractKeyEvent keyUp) {
		this.keyUp = keyUp;
	}

	/**
	 * @return the keyTyped
	 */
	public AbstractTypedEvent getKeyTyped() {
		return keyTyped;
	}

	/**
	 * @param keyTyped the keyTyped to set
	 */
	public void setKeyTyped(AbstractTypedEvent keyTyped) {
		this.keyTyped = keyTyped;
	}

	public AbstractKeyboardListener() {
		super();		
	}	
	
	public AbstractKeyboardListener(AbstractKeyEvent eventKeyDown,AbstractKeyEvent eventKeyUp)
	{
		this();
		this.keyDown = eventKeyDown;
		this.keyUp = eventKeyUp;
	}
	
	@Override
	public void onKeyDown(Event event) {
		PlayN.log().debug(" pressed " +  event.key());
		if (keyDown == null) return;
		keyDown.setEvent(event);
		EventManager.getInstance().push(this.keyDown);
		if (keyUp != null)
			keyUp.setDone(true);
	}
	
	@Override
	public void onKeyUp(Event event) {
		PlayN.log().debug(" pressed " +  event.key());
		if (keyUp == null) return;
		keyDown.setEvent(event);
		EventManager.getInstance().push(this.keyUp);
		if (keyDown != null) 
			keyDown.setDone(true);
	}
	
	@Override
	public void onKeyTyped(TypedEvent event) {
		PlayN.log().debug(" pressed " +  event.typedChar());
		if (keyTyped == null) return;		
		keyTyped.setEvent(event);
		EventManager.getInstance().push(this.keyTyped);
		keyTyped.setDone(true);
	}

	public void register() {
		keyboard().setListener(this);		
	}
	
	
	
}