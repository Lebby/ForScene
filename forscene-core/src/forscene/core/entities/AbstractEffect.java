package forscene.core.entities;

public abstract class AbstractEffect extends AbstractAnimation{
	
	public void build() {
		setRoot(getTarget().getRoot());		
	}	
	
}
