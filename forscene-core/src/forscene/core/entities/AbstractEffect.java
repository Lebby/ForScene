package forscene.core.entities;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractEffect.
 */
public abstract class AbstractEffect extends AbstractAnimation{
	
	/* (non-Javadoc)
	 * @see forscene.core.entities.AbstractAnimation#build()
	 */
	@Override
	public void build() {
		setRoot(getTarget().getRoot());		
	}	
	
}
