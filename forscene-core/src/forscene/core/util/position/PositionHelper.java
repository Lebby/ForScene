package forscene.core.util.position;

import playn.core.ImageLayer;
import forscene.core.entities.AbstractSceneObject;

public class PositionHelper {
	private AbstractSceneObject parent;
	private AbstractSceneObject target;
	
	
	
	public AbstractSceneObject getTarget() {
		return target;
	}
	public void setTarget(AbstractSceneObject target) {
		this.target = target;
	}
	/**
	 * @return the parent
	 */
	public AbstractSceneObject getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(AbstractSceneObject parent) {
		this.parent = parent;
	}
	
	public void center(Align align)
	{
		switch (align){
		case BOTTOM: break;
		case BOTTOM_CENTER: break;
		case BOTTOM_LEFT: break;
		case BOTTOM_RIGHT: break;
		case CENTER_LEFT: break;
		case CENTER_RIGHT: break;
		case HORIZONTAL_CENTER: break;
		case LEFT: break;
		case MIDDLE: break;
		case RIGHT: break;
		case TOP: break;
		case TOP_CENTER: break;
		case TOP_LEFT: break;
		case TOP_RIGHT: break;
		case VERTICAL_CENTER: break;
		
			
		}
	}
	
	public void horizontalAlign()
	{
	}
	
	public void verticalAlign()
	{
	}
	
	public static void align(AbstractSceneObject parent, AbstractSceneObject target, Align align)
	{
		
	}
	
	public static void verticalAlign(AbstractSceneObject parent, AbstractSceneObject target, Align align)
	{
		float containerHeight = ((ImageLayer)parent.getRoot()).height();
		float targetHeight = ((ImageLayer)target.getRoot()).height();
		//mid
		float position = containerHeight/2 - targetHeight/2 ;
		
	}
	
	public static void horizontalAlign(AbstractSceneObject parent, AbstractSceneObject target, Align align)
	{
		float containerWidth = ((ImageLayer)parent.getRoot()).width();
		float targetWidth = ((ImageLayer)target.getRoot()).width();
		//center
		float position = containerWidth/2 - targetWidth/2 ;
	}
}
