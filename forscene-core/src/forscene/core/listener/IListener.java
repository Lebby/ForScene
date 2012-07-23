/*
 * 
 */
package forscene.core.listener;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving i events.
 * The class that is interested in processing a i
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addIListener<code> method. When
 * the i event occurs, that object's appropriate
 * method is invoked.
 *
 * @see IEvent
 */
public interface  IListener {
	
	/**
	 * Register.
	 */
	void register();	
}
