/*
 * 
 */
package forscene.core.asolibrary;

// TODO: Auto-generated Javadoc
//TODO: NOT TESTED ... NOT USED
/**
 * The Class ASOType.
 */
public class ASOType {
	
	/** The type. */
	private String type="";
	
	/** The unique. */
	private boolean unique=false;
	
	/**
	 * Instantiates a new aSO type.
	 */
	private ASOType()
	{		
	}
	
	/**
	 * Instantiates a new aSO type.
	 *
	 * @param type the type
	 */
	public ASOType(String type)
	{
		this.type=type;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	private void setType(String type) {
		this.type = type;
	}

	/**
	 * Checks if is unique.
	 *
	 * @return true, if is unique
	 */
	public boolean isUnique() {
		return unique;
	}

	/**
	 * Sets the unique.
	 *
	 * @param unique the new unique
	 */
	public void setUnique(boolean unique) {
		this.unique = unique;
	}
	
}
