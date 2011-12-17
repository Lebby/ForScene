package forscene.core.util;

import java.util.ArrayList;

import forscene.core.entities.AbstractScene;
import forscene.core.entities.AbstractSceneObject;

import playn.core.AssetManager;
import playn.core.CanvasLayer;
import playn.core.Font;
import playn.core.Font.Style;
import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Layer;
import playn.core.PlayN;
import playn.core.TextFormat;
import playn.core.TextFormat.Alignment;
import playn.core.TextFormat.Effect;
import playn.core.TextLayout;

import static playn.core.PlayN.assetManager;
import static playn.core.PlayN.graphics;
import static playn.core.PlayN.pointer;



public class GraphicFactory {
	
	public static ImageLayer loadImage(String url)
	{
		Image bgImage = assetManager().getImage(url);
	    ImageLayer bgLayer = graphics().createImageLayer(bgImage);
	    //PlayN.log().debug("TEST " + bgLayer);	    
	    return bgLayer;
	}
	
	public static ImageLayer addImage(String url,AbstractSceneObject scene)
	{
		ImageLayer image = loadImage(url);
		scene.getRoot().add(image);
		return image;
	}
	
	public static Layer createText(String text, TextFormat format)
	{
	    // crea il font        :  Font font = graphics().createFont("Courier", Font.Style.PLAIN, 16);
		// crea il format      :  TextFormat txtFormat = new TextFormat();
		// crea il layout      :  TextLayout layout = graphics().layoutText(text, format);
		// crea il canvaslayer :  CanvasLayer layer = graphics().createCanvasLayer((int)Math.ceil(layout.width()), (int)Math.ceil(layout.height()));
		// scrivo il layer     :  layer.canvas().drawText(layout, 0, 0);		
		CanvasLayer layer;
		TextLayout layout = graphics().layoutText(text, format);
		layer = graphics().createCanvasLayer((int)Math.ceil(layout.width()), (int)Math.ceil(layout.height()));
		layer.canvas().drawText(layout, 0, 0);
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
	

	
}
