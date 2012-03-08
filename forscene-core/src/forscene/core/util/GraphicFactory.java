package forscene.core.util;

import java.util.ArrayList;

import forscene.core.entities.AbstractSceneObject;
import forscene.core.entities.AbstractSceneObjectGroup;

import playn.core.CanvasImage;
import playn.core.CanvasLayer;
import playn.core.Font;
import playn.core.Font.Style;
import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Layer;
import playn.core.PlayN;
import playn.core.SurfaceLayer;
import playn.core.TextFormat;
import playn.core.TextFormat.Alignment;
import playn.core.TextLayout;

import static playn.core.PlayN.graphics;



public class GraphicFactory {
	
	public static ImageLayer loadImage(String url)
	{
		Image bgImage = PlayN.assets().getImage(url);
	    ImageLayer bgLayer = graphics().createImageLayer(bgImage);
	    //PlayN.log().debug("TEST " + bgLayer);	    
	    return bgLayer;
	}
	
	public static ImageLayer addImage(String url,AbstractSceneObject scene)
	{
		ImageLayer image = loadImage(url);
		if (scene instanceof AbstractSceneObjectGroup)
			((AbstractSceneObjectGroup)scene).getRoot().add(image);
		else scene.setRoot(image);
		return image;
	}
	
	public static ImageLayer createText(String text, TextFormat format)
	{
	    // crea il font        :  Font font = graphics().createFont("Courier", Font.Style.PLAIN, 16);
		// crea il format      :  TextFormat txtFormat = new TextFormat();
		// crea il layout      :  TextLayout layout = graphics().layoutText(text, format);
		// crea il canvaslayer :  CanvasLayer layer = graphics().createCanvasLayer((int)Math.ceil(layout.width()), (int)Math.ceil(layout.height()));
		// scrivo il layer     :  layer.canvas().drawText(layout, 0, 0);		
		CanvasImage canvas;
		TextLayout layout = graphics().layoutText(text, format);		
		canvas = graphics().createImage((int)Math.ceil(layout.width()), (int)Math.ceil(layout.height()));
		canvas.canvas().drawText(layout, 0, 0);
		
		ImageLayer layer = PlayN.graphics().createImageLayer();
		layer.setImage(canvas);
		
	    return layer;
	}
	
	public static Layer setAlpha(int alpha, Layer layer)
	{
		return null;
	}
	
	public static TextFormat createTextFormat(Font font, int textColor )
	{
		TextFormat format = new TextFormat();
		format = format.withAlignment(Alignment.LEFT);
		format = format.withFont(font);
		format = format.withTextColor(textColor);		
		return format;
	}	
	
	public static Font createFont(String fontName,Style fontStyle,float size )
	{
		Font font = graphics().createFont(fontName, fontStyle, size);
		return font;
	}
	
	public static TextFormat createTextFormat()
	{
		Font font = GraphicFactory.createFont("Arial", Font.Style.PLAIN, 10f);
		TextFormat format= GraphicFactory.createTextFormat(font, 0xFFFF0000);
		return format;		
	}
	
	public static GroupLayer createGroupLayer()
	{
		GroupLayer gl = graphics().createGroupLayer();		
		PlayN.log().debug("GL *******  " + gl);
		return gl;
	}
	
	public static void refresh(GroupLayer root)
	{
		ArrayList<Layer> ls = new ArrayList<Layer>();
		for ( int i = 0 ; i < root.size() ; i++)
		{
			ls.add(	root.get(i));
			root.remove(ls.get(i));
			PlayN.log().debug("E---- : " + ls.get(i));
		}
		root.clear();
		for ( int i = 0 ; i < ls.size() ; i++)
		{
			root.add(ls.get(i));
		}	
	}
	
	public static GroupLayer drawBorder(Layer root)
	{
		GroupLayer border=null;
		
		if (root instanceof GroupLayer)
		{
			GroupLayer tmpborder= graphics().createGroupLayer();
			for (int i = 0; i < ((GroupLayer)root).size(); i++)
			tmpborder.add(drawBorder(((GroupLayer)root).get(i)));
			border=tmpborder;
		}
		else if ((root instanceof Layer.HasSize) ||
			(root instanceof ImageLayer) ||
			(root instanceof SurfaceLayer) ||
			(root instanceof CanvasLayer) )
		{
			Layer.HasSize tmp = ( Layer.HasSize)root;
			CanvasLayer canvas = graphics().createCanvasLayer((int)tmp.width(), (int)tmp.height());
			canvas.canvas().setStrokeColor(playn.core.Color.rgb(100, 100, 100));
			canvas.canvas().setFillColor(playn.core.Color.rgb(100, 100, 100));
			canvas.canvas().setStrokeWidth(2);
			canvas.canvas().drawLine(tmp.originX(), tmp.originY(), tmp.originX(), tmp.originY()+tmp.height());
			canvas.canvas().drawLine(tmp.originX(), tmp.originY()+tmp.height(), tmp.originX()+tmp.width(), tmp.originY()+tmp.height());
			canvas.canvas().drawLine(tmp.originX()+tmp.width(), tmp.originY()+tmp.height(), tmp.originX()+tmp.width(), tmp.originY());
			canvas.canvas().drawLine(tmp.originX()+tmp.width(), tmp.originY(),tmp.originX(), tmp.originY());
			border = graphics().createGroupLayer();
			border.add(canvas);
			PlayN.log().debug("BORDER " + border);
		}		
		return border;
	}

	
}
