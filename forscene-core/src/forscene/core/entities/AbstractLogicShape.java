package forscene.core.entities;

public abstract class AbstractLogicShape implements ILogicShape{

	public float getWidth() {
		return getMaxX()-getMinX();		
	}

	public float getHeight() {
		return getMaxY()-getMinY();		
	}

	public boolean contains(float x, float y) {		
		if ((x<getMaxX()) 
			&& (x>getMinX()) 
			&& (y<getMaxY()) 
			&& (y>getMinY())) return true;
		else return false;
	}

	public float getCenterX() {
		return (getMaxX()+getMinX()/2);		
	}
	
	public float getCenterY() {
		return (getMaxY()+getMinY()/2);
	}
	
}