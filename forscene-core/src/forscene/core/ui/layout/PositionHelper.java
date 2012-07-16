package forscene.core.ui.layout;

import playn.core.PlayN;
import forscene.core.entities.AbstractSceneObject;
import forscene.core.util.ShapeUtil;


/*
 * alignment is relative to parent and refer on nearest object border.
 * Align left is relative to object left border ( x=0 )
 * Align right is relative to object right border ( x= width )
 * Align top is relative to object top border ( y=0 )
 * center is relative to object center ( x = width/2 or height/2 ) 
 * ... and so on 
 * 
 */
public class PositionHelper {
	public static void align(AbstractSceneObject parent, AbstractSceneObject target, Align align)
	{
		PlayN.log().debug("Align: " +  align);
		
		//horizontal component
		switch (align)
		{
			case HORIZONTAL_CENTER:				
			case LEFT: 
			case RIGHT: 
				horizontalAlign(parent,target,align); 
				break;
			case BOTTOM_CENTER:
			case MIDDLE:
			case TOP_CENTER:				
				horizontalAlign(parent,target,align.HORIZONTAL_CENTER);
				break;
			case BOTTOM_LEFT:
			case CENTER_LEFT:
			case TOP_LEFT:
				horizontalAlign(parent,target,align.LEFT);
				break;
			case BOTTOM_RIGHT:
			case CENTER_RIGHT:
			case TOP_RIGHT:				
				horizontalAlign(parent,target,align.RIGHT);				
				break;
		}
		
		//vertical component
		switch (align)
		{
	
			case TOP: 
			case BOTTOM: 
			case VERTICAL_CENTER:
				verticalAlign(parent,target,align);
				break;
			
			case BOTTOM_CENTER:
			case BOTTOM_LEFT:
			case BOTTOM_RIGHT:
				verticalAlign(parent,target,align.BOTTOM);
				break;
			
			case CENTER_LEFT:
			case CENTER_RIGHT:
			case MIDDLE:
				verticalAlign(parent,target,align.VERTICAL_CENTER);
				break;
				
			case TOP_CENTER:
			case TOP_LEFT:
			case TOP_RIGHT:				
				verticalAlign(parent,target,align.TOP);
				break;						
		}		
	}
	
	private static void verticalAlign(AbstractSceneObject parent, AbstractSceneObject target, Align align)
	{
		//PlayN.log().debug("VAlign: " +  align);
		//float containerHeight = ((Layer.HasSize)parent.getRoot()).height();
		float containerHeight = ShapeUtil.calculateShapeInfoSceneObject(parent).getMaxY();
		//float targetHeight = ((Layer.HasSize)target.getRoot()).height();
		float targetHeight = ShapeUtil.calculateShapeInfoSceneObject(target).getMaxY();
		float position = 0;
		
		switch(align)
		{
			case TOP:
				position = 0; 
				break;
			case BOTTOM: 
				position = containerHeight;
				position = position - targetHeight;
				break;
			case VERTICAL_CENTER: position = containerHeight/2 - targetHeight/2;
				break;
		}
		target.getRoot().setTranslation(target.getRoot().transform().tx(), position);
		
	}
	
	private static void horizontalAlign(AbstractSceneObject parent, AbstractSceneObject target, Align align)
	{
		//PlayN.log().debug("HAlign: " +  align);
		//float containerWidth = ((Layer.HasSize)parent.getRoot()).width();
		float containerWidth = ShapeUtil.calculateShapeInfoSceneObject(parent).getMaxX();
		//float targetWidth = ((Layer.HasSize)target.getRoot()).width();
		float targetWidth = ShapeUtil.calculateShapeInfoSceneObject(target).getMaxX();
		
		float position = 0;
		
		switch(align)
		{			
			case LEFT: 
				position = 0; break;
			case RIGHT:
				position = containerWidth;
				position = position - targetWidth;
				break;
			case HORIZONTAL_CENTER:
				position = containerWidth/2 - targetWidth/2 ; break;
		}
		target.getRoot().setTranslation(position,target.getRoot().transform().ty() );
	}
	
}