package forscene.core.events.input.mouse;

import forscene.core.entities.AbstractSceneObject;
import playn.core.Mouse.MotionEvent;

public class OnInMouseEvent extends OnMoveMouseEvent {

	private AbstractSceneObject aso;
	
	public OnInMouseEvent(AbstractSceneObject sceneObject) {
		aso = sceneObject;
	}
	
	@Override
	public void run(MotionEvent event) {
		
	}
	
	
}