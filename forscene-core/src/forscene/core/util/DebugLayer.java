package forscene.core.util;

import java.util.ArrayList;
import playn.core.GroupLayer;
import playn.core.Layer;
import playn.core.TextFormat;

public class DebugLayer {
	private GroupLayer root;
	private ArrayList<String> strings;
	private TextFormat format; 
	public DebugLayer()
	{	
		root = GraphicFactory.createGroupLayer();
		format = GraphicFactory.createTextFormat();
		format = format.withWrapWidth(200);
		strings = new ArrayList<String>();
	}
	
	public void write(String string)
	{	
		if (strings.size() == 0) strings.add(string);
		else
		{				
			this.strings.set(this.strings.size()-1, string);
		}
		render();
	}
	
	public void append(String string)
	{
		this.strings.add(string);
		//render();
	}
	
	private void render()
	{		 
		for(int i = 0 ; i < root.size(); i++)
		{
			root.get(0).destroy();
			//root.remove(root.get(i));
			root.clear();
			if (root.parent() != null)
			{
				GroupLayer parent = root.parent();
				parent.remove(getRoot());
				parent.add(root);
			}
				
		}
		String string="";
		for(int i = 0 ; i< strings.size(); i++)
		{
			string+=strings.get(i);
		}
		Layer l = GraphicFactory.createText(string, format);
		l.setTranslation(10, 10);
		
		root.add(l);
		//PlayN.log().debug("RENDER : " + root.size() + " strings " + strings.size());
	}
	
	public GroupLayer getRoot()
	{
		return root;
	}
	
	public void clear()
	{
		strings.clear();
	}
	
	public void setFormat(TextFormat format)
	{
		this.format = format;
	}
}
