#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package ${package}.objects;

import forscene.core.entities.AbstractSceneObject;
import forscene.core.util.GraphicFactory;

public class PlayNDefaultBackground extends AbstractSceneObject{

	@Override
	public void build() {
		//you can add your resource here in build or in costructor. If you
		//add here, it will be loaded only when it need this resource!
		GraphicFactory.addImage("images/bg.png", this );		
	}

	@Override
	public void updateState() {
		// This is a static background ... then nothing to update!		
	}
	

}
 