package forscene.core.entities.toTest;


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
		getTarget().buildOnce();
		setRoot(getTarget().getRoot());
	}
	
}
