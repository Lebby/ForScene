package forscene.core.old;


import static playn.core.PlayN.graphics;
import playn.core.AbstractLayer;
import playn.core.GroupLayer;
import playn.core.GroupLayerImpl;
import playn.core.Layer;
import playn.core.Mouse;
import forscene.core.util.GraphicFactory;

public class Scene{
	private Mouse mouseListener;	
	private GroupLayer root;
	public boolean USE_TIMER = false;
	public boolean IS_READY_TO_SWITCH = false;
	public boolean IS_CONDITIONAL = false;
	private int seconds;
	
	
	
	public Scene()
	{
		root = GraphicFactory.createGroupLayer();
		root.clear();
	}
	
	public Mouse getMouseListener() {
		return mouseListener;
	}
	public void setMouseListener(Mouse mouseListener) {
		this.mouseListener = mouseListener;
	}
	
	public GroupLayer getRoot()
	{
		return root;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	public void updateState()
	{
		
	}
	
}
