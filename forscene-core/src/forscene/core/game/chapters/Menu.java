package forscene.core.game.chapters;

import java.util.ArrayList;

import playn.core.GroupLayer;
import playn.core.ImageLayer;

import forscene.core.effects.Scroll;
import forscene.core.effects.Scroll.ScrollType;
import forscene.core.entities.AbstractScene;
import forscene.core.entities.AbstractSceneGroup;
import forscene.core.util.GraphicFactory;

public class Menu extends AbstractSceneGroup{
	private String url ="";
	@Override
	
	public ArrayList<AbstractScene> build() {
		ArrayList<AbstractScene> scenes = new ArrayList<AbstractScene>();
		scenes.add(createMenuScene());
		
		return scenes;
	}
	
	private AbstractScene createMenuScene()
	{	
		AbstractScene scene= new AbstractScene() {
			ImageLayer sea;
			ImageLayer cloud;
			ImageLayer logo;
			ImageLayer iniziaButton;
			ImageLayer boat;
			ImageLayer bg;
			
		@Override
		public void updateState() {
						
		}
			
			@Override
			public void build() {
				logo=GraphicFactory.loadImage("images/logos/logo.png");
				iniziaButton=GraphicFactory.loadImage("images/scenes/menu/bottone_inizia.png");
				boat=GraphicFactory.loadImage("images/oggetti/barca.png");
				
				sea=GraphicFactory.loadImage("images/oggetti/mare_onde.png");
				
				cloud=GraphicFactory.loadImage("images/oggetti/nuvole.png");
				bg = GraphicFactory.loadImage("images/background/sfondomenu.png");
				getRoot().add(bg);
				//getRoot().add(sea);
				//getRoot().add(cloud);
				GroupLayer menu = GraphicFactory.createGroupLayer();
				//menu.add(boat);
				//menu.add(iniziaButton);
				getRoot().add(menu);
				Scroll scroll = new Scroll();
				AbstractScene seaScene = new AbstractScene() {
					
					@Override
					public void updateState() {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void build() {
						sea=GraphicFactory.loadImage("images/oggetti/mare_onde.png");
						getRoot().add(sea);
					}
				};
				scroll.setTarget(seaScene);
				scroll.setUpdateRate(25);
				scroll.setScrollType(ScrollType.LEFT);
				scroll.start();
				//addScene(seaScene);
				
			}
		}; 
		
		return scene;
	}
		
}
