package forscene.test.core;

import playn.core.Game;
import playn.core.PlayN;
import forscene.core.LoopController.AbstractGame;
import forscene.core.LoopController.GameLoopManager;
import forscene.core.LoopController.IGameLoopManager;

import forscene.core.game.chapters.Menu;
import forscene.core.game.chapters.Presentation;

public class tomminick1 extends AbstractGame  {
	//IGameLoopManager gameManager;	
	Presentation intro1 = new Presentation();
	Menu menu = new Menu();
	//Introduction1 intro2 = new Introduction1();
	
	/*
	@Override
	public void init() {
		
		//gameManager =  GameLoopManager.getInstance();
		//gameManager.setSize(800, 600);
		//gameManager.addSceneGroup(intro1);
		setSize(800, 600);
		addSceneGroup(intro1);
	}
*/
	

	public int updateRate() {
		// TODO Auto-generated method stub
		return 25;
	}



	@Override
	public void build() {
		// TODO Auto-generated method stub
		setSize(800, 600);
		addSceneGroup(intro1);
		addSceneGroup(menu);		
	}
	
	
}
