package forscene.core.entities;

import forscene.core.asolibrary.ASOType;

/**
 * The Class ObjectID.
 */
public class ObjectID implements  Comparable<ObjectID> {	
	
	/** The ID. */
	private long ID;
	
	/** The instance. */
	private AbstractSceneObject instance;
	
	/** The type. */
	private ASOType type;
	
	/**
	 * Instantiates a new object id.
	 *
	 * @param instance the instance
	 */
	public ObjectID(AbstractSceneObject instance)
	{
		this.instance = instance;
		instance.setID(this);
		
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return instance.getName();
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		instance.setName(name);
	}	
	
	/**
	 * Gets the single instance of ObjectID.
	 *
	 * @return single instance of ObjectID
	 */
	public AbstractSceneObject getInstance() {
		return instance;
	}
	
	/**
	 * Sets the instance.
	 *
	 * @param instance the new instance
	 */
	public void setInstance(AbstractSceneObject instance) {
		this.instance = instance;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType()
	{
		return type.getType();
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(ObjectID arg0) {		
		return this.getName().compareTo(arg0.getName());		
	}	
	
}