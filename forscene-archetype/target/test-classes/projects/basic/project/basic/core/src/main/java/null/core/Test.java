
package ${package}.core;

import forscene.core.LoopController.AbstractGame;
import ${package}.scenes.FirstScene;


public class Test extends AbstractGame {
	
	@Override	
	public int updateRate() {
		return 25;
	}

	@Override
	public void build() {
		//It add a scene in your game
		addScene(new FirstScene());
	}

}
