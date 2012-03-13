package forscene.core.effects;

import forscene.core.entities.AbstractEffect;

public class Scroll extends AbstractEffect {
	private float startX;
	private float startY;
	private float tmpX,tmpY;
	private float step = 1;
	private boolean loop = false;
	
	
	public static  enum ScrollType{
		LEFT,RIGHT,UP,DOWN,UP_LEFT,UP_RIGHT,DOWN_LEFT,DOWN_RIGHT
	};
	private ScrollType scrollType = ScrollType.RIGHT;
	public ScrollType getScrollType() {
		return scrollType;
	}

	public void setScrollType(ScrollType scrollType) {
		this.scrollType = scrollType;
	}

	public float getStep() {
		return step;
	}

	public void setStep(float step) {
		this.step = step;
	}

	public boolean isLoop() {
		return loop;
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}

	@Override
	public void goNext() {		
		run();		
	}
	
	private  void scroll()
	{
		float x = getTarget().getRoot().originX();
		float y = getTarget().getRoot().originY();
		
		switch(scrollType)
		{
			case UP:
				getRoot().setTranslation(x , y-step); break;
			case DOWN:
				getRoot().setTranslation(x, y+step); break;
		
			case LEFT:
				tmpX--;				
				//getTarget().getRoot().setTranslation(tmpX , tmpY);
				getRoot().setTranslation(tmpX , tmpY);
				break;
			case RIGHT:
				tmpX++;
				//getTarget().getRoot().setTranslation(tmpX, tmpY);
				getRoot().setTranslation(tmpX , tmpY);
				break;
		
			case DOWN_LEFT:
				getTarget().getRoot().setTranslation(x-step , y+step); break;
			case UP_RIGHT:
				getTarget().getRoot().setTranslation(x+step , y-step); break;
		
			case DOWN_RIGHT:
				getTarget().getRoot().setTranslation(x+step , y+step); break;		 
			case UP_LEFT: 
				getTarget().getRoot().setTranslation(x-step , y-step); break;		
		}
		
	}
	
	@Override
	public void run() {	
		scroll();		
	}
	
	public float getStartX() {
		return startX;
	}

	public void setStartX(float startX) {
		this.startX = startX;
	}

	public float getStartY() {
		return startY;
	}

	public void setStartY(float startY) {
		this.startY = startY;
	}
	
	public float getPositionX()
	{
		return getTarget().getRoot().originX();
	}
	
	public float getPositionY()
	{
		return getTarget().getRoot().originY();
	}

}