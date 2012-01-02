package forscene.core.entities;

public abstract class AbstractEffect extends AbstractAnimation{
	
	@Override
	public void build() {
		setRoot(getTarget().getRoot());		
	}	
	
}
