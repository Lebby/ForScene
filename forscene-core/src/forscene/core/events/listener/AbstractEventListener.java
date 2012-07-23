/*
 * 
 */
package forscene.core.events.listener;

import forscene.core.events.system.AbstractEvent;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving abstractEvent events.
 * The class that is interested in processing a abstractEvent
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addAbstractEventListener<code> method. When
 * the abstractEvent event occurs, that object's appropriate
 * method is invoked.
 *
 * @see AbstractEventEvent
 */
public abstract class AbstractEventListener extends AbstractEvent{

	/**
	 * Check.
	 *
	 * @return true, if successful
	 */
	public abstract boolean check(); 
}
