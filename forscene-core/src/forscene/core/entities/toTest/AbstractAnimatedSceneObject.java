/**
 * 
 */
package forscene.core.entities.toTest;

import forscene.core.entities.AbstractSceneObject;
import playn.core.Image;
import playn.core.ImmediateLayer;
import playn.core.ImmediateLayer.Renderer;
import playn.core.Surface;
import static playn.core.PlayN.graphics;

/**
 * @author blackdevil
 *
 */
public abstract class AbstractAnimatedSceneObject extends
		AbstractSceneObject<ImmediateLayer> {	
	/**
	 * 
	 */
	private Surface surface;
	/**
	 * 
	 */
	private Image image;
	/**
	 * 
	 */
	boolean autodraw = true;
	/**
	 * 
	 */
	private float x = 0f;
	/**
	 * 
	 */
	private float y = 0f;

	
	/**
	 * 
	 */
	public AbstractAnimatedSceneObject() {
		ImmediateLayer imm = graphics().createImmediateLayer(new Renderer() {
			//default render ... 
			public void render(Surface surface) {
				if(!isBuilded())
				{
					setSurface(surface);					
					surface.clear();					
				}else
				{
					if(isAutoDraw())
					{
						surface.clear();
						innerDraw();
					}
					else
						//call user defined updateDraw
						updateDraw();
				}
			}
		});
		setRoot(imm);
		
	}
	
	/**
	 * 
	 */
	protected void setSurface(Surface surface)
	{
		this.surface = surface;
	}
	
	/**
	 * 
	 */
	public Surface getSurface()
	{
		return surface;
	}
	
	/**
	 * 
	 */
	public abstract void updateDraw();
	
	/**
	 * 
	 */
	public void updateDraw(Image image, float x, float y)
	{
		surface.drawImage(image, x, y);
	}
	
	/**
	 * 
	 */
	public void setX(float xPosition)
	{
		x=xPosition;
	}
	
	/**
	 * 
	 */
	public void setY(float yPosition)
	{
		y=yPosition;				
	}
	
	/**
	 * 
	 */
	public float getX()
	{
		return x;
	}
	
	/**
	 * 
	 */
	public float getY()
	{
		return y;
	}	
	
	/**
	 * 
	 */
	public void setImage(Image image)
	{
		this.image=image;
	}
	
	/**
	 * 
	 */
	public Image getImage()
	{
		return image;
	}
	
	/**
	 * 
	 */
	private void innerDraw()
	{
		surface.drawImage(image, x, y);
	}
	
	/**
	 * 
	 */
	public void setAutoDraw(boolean autodraw)
	{
		this.autodraw = autodraw;
	}
	
	/**
	 * 
	 */
	public boolean isAutoDraw()
	{
		return autodraw;
	}		
	
}
