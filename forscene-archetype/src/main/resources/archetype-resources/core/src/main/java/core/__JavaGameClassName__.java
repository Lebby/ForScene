#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core;

import forscene.core.LoopController.AbstractGame;
import forscene.core.entities.AbstractScene;
import forscene.core.util.GraphicFactory;

public class ${JavaGameClassName} implements AbstractGame {

	public int updateRate() 
	{
		return 25;
	}

	@Override
	public void build() 
	{
		//here you can do all, but i think is a best practice only manage scene here
		addScene(new SimpleScene());		
	}

  // You can do in a different file ... It's here to fast learning purpose.
	class SimpleScene extends AbstractScene{

	@Override
	public void build() 
	{
		GraphicFactory.addImage("images/bg.png",this);	
	}

	@Override
	public void updateState() {}

}
