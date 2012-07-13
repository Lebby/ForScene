package forscene.core.ui.layout;

import java.util.ArrayList;

import playn.core.PlayN;
import forscene.core.entities.AbstractSceneObject;
import forscene.core.util.BasicShapeInfo;
import forscene.core.util.ShapeUtil;
import forscene.core.util.SizeInfo;
import forscene.system.managers.GameLoopManager;


public class DefautLayout extends AbstractStaticLayout{
	
	private ArrayList<ArrayList<SizeInfo>> elementMatrix;

	private float marginLeft = 1,
			marginRight = 1,
			marginTop = 1,
			marginBottom = 1;
	
	
	public void layout(AbstractSceneObject<?> object) {
		//calculate basic info
		BasicShapeInfo shapeInfo = ShapeUtil.calculateShapeInfoSceneObject(object);
		
		//no size? no layout!
		if (shapeInfo.getMaxX() <= 0 || shapeInfo.getMaxY() <= 0 ) return;
		
		int lastXMatrix = elementMatrix.size()-1;
		int lastYMatrix = 0;
		
		if (lastXMatrix != -1)
			lastYMatrix = elementMatrix.get(lastXMatrix).size()-1;
		
		//info store position x,y and size: height,width
		SizeInfo info = new SizeInfo();
		info.setHeight(shapeInfo.getMaxY()+marginTop+marginBottom);
		info.setWidth(shapeInfo.getMaxX()+marginRight+marginLeft);
		
		//last element added
		SizeInfo infoLast; 
		
		//setting position of last element to do a relative position
		if (lastXMatrix == -1 ) //we are first!!!
		{
			lastXMatrix=0;
			lastYMatrix=0;
			elementMatrix.add(new ArrayList<SizeInfo>());//0,0 is ready
			
			infoLast = new SizeInfo();
			infoLast.setX(marginLeft);
			infoLast.setY(marginTop);
			infoLast.setHeight(0);
			infoLast.setWidth(0);
			
		} else
		{
			infoLast = elementMatrix.get(lastXMatrix).get(lastYMatrix);			
		}
		
		//ok ... now we have last ... can we add on bottom or we must change column?
		// we have info of element that we want to add
		PlayN.log().debug(infoLast.getY() + infoLast.getHeight() + " > " + getHeight());
		if (infoLast.getY() + infoLast.getHeight() > getHeight()) // we must change column
		{
			//change column 
			lastXMatrix++;
			//reacalc Y
			infoLast.setY(marginTop);			
			
			//recalc X ...
			boolean finish = false;
			int i=0;
			while(!finish) //we must search to don't cover any element. Start scanning 
			{
				SizeInfo scannedElement = elementMatrix.get(lastXMatrix-1).get(i);
				float scannedHeight = scannedElement.getHeight();
				PlayN.log().debug( "**** "+ (scannedHeight + scannedElement.getY()) + " > " + info.getHeight());
				
				if ( scannedHeight + scannedElement.getY() > info.getHeight()  ) 
					// if our object is smaller then scanned element then we finished
				{
					info.setX(scannedElement.getX()+scannedElement.getWidth()+marginRight);
					finish = true;					
				}
				
				if ((i== elementMatrix.get(lastXMatrix-1).size()) && !finish) // last ...
				{			
					finish = true;
					info.setX(GameLoopManager.getInstance().getWidth()); // put outside ...
				}
				i++;
			}
			
			// end recalc x
			elementMatrix.add(new ArrayList<SizeInfo>());
			lastXMatrix = elementMatrix.size()-1;
			info.setX(infoLast.getX()+infoLast.getWidth()+marginLeft);
			info.setY(marginTop);
		}
		else
		{			
			info.setX(infoLast.getX());
			info.setY(infoLast.getY()+infoLast.getHeight()+marginTop);			
		}	
			
		//addd on matrix and positioning
		elementMatrix.get(lastXMatrix).add(info);
		object.getRoot().setTranslation(info.getX(), info.getY());		
		PlayN.log().debug("(X)(Y) " + lastXMatrix + " | " + lastYMatrix + " (posX,posY)" + info.getX() + " , " + info.getY() );
	}
	
	public DefautLayout() 
	{
		buildOnce(); //TODO:TO FIX
	}
	
	@Override
	public void build() 
	{
		if (getHeight()== 0 || getWidth() == 0)
		{
			setHeight(GameLoopManager.getInstance().getHeight());
			setWidth(GameLoopManager.getInstance().getWidth());
		}
		elementMatrix = new ArrayList<ArrayList<SizeInfo>>();		
	}	
	
	public void setMargin(float marginLeft,float marginRight,float marginTop,float marginBottom)
	{
		this.marginLeft = marginLeft;
		this.marginBottom = marginBottom;
		this.marginRight = marginRight;
		this.marginTop = marginTop;
	}
	
	public void setMargin(float margin)
	{
		marginLeft=marginBottom=marginRight=marginTop=margin;
	}
	
	public float getMarginLeft() {
		return marginLeft;
	}

	public void setMarginLeft(float marginLeft) {
		this.marginLeft = marginLeft;
	}

	public float getMarginRight() {
		return marginRight;
	}

	public void setMarginRight(float marginRight) {
		this.marginRight = marginRight;
	}

	public float getMarginTop() {
		return marginTop;
	}

	public void setMarginTop(float marginTop) {
		this.marginTop = marginTop;
	}

	public float getMarginBottom() {
		return marginBottom;
	}

	public void setMarginBottom(float marginBottom) {
		this.marginBottom = marginBottom;
	}

	public void updateState() {
		// TODO Auto-generated method stub
		
	}	
	
}