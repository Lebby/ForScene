package forscene.core.entities;

public interface ILogicShape {	
	float getWidth();
	float getHeight();
	boolean contains(float x, float y);
	float getCenterX();
	float getCenterY();
	float getMaxX();
	float getMaxY();
	float getMinX();
	float getMinY();
}
