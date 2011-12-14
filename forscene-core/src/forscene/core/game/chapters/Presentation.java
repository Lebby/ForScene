package forscene.core.game.chapters;


import java.util.ArrayList;

import playn.core.Font;
import playn.core.Keyboard.Event;
import playn.core.Mouse.MotionEvent;
import playn.core.Layer;
import playn.core.PlayN;
import playn.core.TextFormat;
import playn.core.TextFormat.Effect;
import forscene.core.entities.AbstractLayerSequence;
import forscene.core.entities.AbstractScene;
import forscene.core.entities.AbstractSceneGroup;
import forscene.core.entities.AbstractSceneObject;
import forscene.core.events.input.EventKeyDown;
import forscene.core.events.input.EventMouseMove;
import forscene.core.game.actors.Tommy;
import forscene.core.game.actors.TommyWalk;
import forscene.core.listener.AbstractKeyboardListener;
import forscene.core.listener.AbstractMouseListener;
import forscene.core.util.GraphicFactory;

public class Presentation extends AbstractSceneGroup{
	
	private AbstractScene createScene1()
	{
		AbstractScene scene = new AbstractScene()
		{
			public void build()
			{
				getRoot().add(GraphicFactory.loadImage("images/scenes/intro/intro_bg.png"));
				USE_TIMER = true;
				setSeconds(2);
			}

			@Override
			public void updateState() {
				// TODO Auto-generated method stub
				
			}
		
		};
		return scene;
	}
	
	private AbstractScene createScene2()
	{
		AbstractScene scene = new AbstractScene()
		{
			public void build()
			{
		//Layer bg = GraphicFactory.loadImage("images/intro_bg.png");
				Layer inkscapeLogo = GraphicFactory.loadImage("images/scenes/intro/intro_inkscape_logo.png");
				Layer gimpLogo = GraphicFactory.loadImage("images/scenes/intro/intro_gimp_logo.png");
				Font font = GraphicFactory.createFont("Lucida", Font.Style.BOLD, 20f);
				TextFormat format= GraphicFactory.createTextFormat(font, 0xFF660000);		
				Layer text1 = GraphicFactory.createText("Graphics by: Scuderi Giovanni Luca aka Lebby", format);
				format = format.withEffect(Effect.shadow(0, -2, -2));
				format = format.withTextColor(0xfffff000);
				Layer text2 = GraphicFactory.createText("Graphics is powered by: InkScape & GIMP", format);
		
				text1.setTranslation(100, 0);
				text2.setTranslation(100, 400);
				inkscapeLogo.setTranslation(100, 200);
				gimpLogo.setTranslation(300, 200);
				//	getRoot().add(bg);
				getRoot().add(text1);
				getRoot().add(text2);
				getRoot().add(gimpLogo);
				getRoot().add(inkscapeLogo);
				USE_TIMER = true;
				setSeconds(5);
			}

			@Override
			public void updateState() {
				// TODO Auto-generated method stub
				
			}};
		return scene;
	
	}
	private AbstractScene createScene3()
	{
		AbstractScene scene = new AbstractScene()
		{
			public void build()
			{
				getRoot().add(GraphicFactory.loadImage("images/scenes/intro/intro_bg.png"));
				USE_TIMER = true;
				setSeconds(2);
			}

			@Override
			public void updateState() {
				// TODO Auto-generated method stub
			}};
		return scene;
	}
	private AbstractScene createScene4()
	{
		AbstractScene scene = new AbstractScene()
		{
			public void build()
			{
				//getRoot().add(GraphicFactory.loadImage("images/intro_bg.png"));		
				getRoot().add(GraphicFactory.loadImage("images/scenes/intro/intro_playn_logo.png"));
				setSeconds(5);				
			}

			@Override
			public void updateState() {
				// TODO Auto-generated method stub
				
			}
		};
		return scene;	
	}
	
	private Tommy createTommy()
	{
		
		Tommy tommy = new  Tommy();		
		return tommy;
		//TommyWalk walk = new TommyWalk();
		//walk.stop();
		//return walk;
		
		//return seq;
	}

	@Override
	public ArrayList<AbstractScene> build() {
		AbstractScene scene1, scene2,scene3,scene4;
		Tommy tommy;
		scene1 = createScene1();
		scene2 = createScene2();
		scene3 = createScene3();
		scene4 = createScene4();
		tommy = createTommy();
		
		scene4.setKeyboardListener(new AbstractKeyboardListener(tommy.eventKeyDown, tommy.eventKeyUp));
		
		
		
		ArrayList<AbstractScene> tmp = new ArrayList<AbstractScene>();
		tmp.add(scene1);
		tmp.add(scene2);
		tmp.add(scene3);
		tmp.add(scene4);
		scene4.addSceneObject(tommy);
		
		PlayN.log().debug("SceneGroup Build" + tmp.size());		
		return tmp;
	}
	
}