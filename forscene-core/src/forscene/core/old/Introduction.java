package forscene.core.old;

import playn.core.Font;
import playn.core.Layer;
import playn.core.TextFormat;
import playn.core.TextFormat.Effect;
import forscene.core.util.GraphicFactory;



//Scena 1: Logo TommyNick
//Scena 2: Prodotto, sviluppato, disegnato, ideato e musicato da: Scuderi Giovanni Luca aka Lebby
//Scena 3: Fatto con: GWT, Forplay
//Scena 4: Musiche fatte con: , Grafica realizzata in Gimp

public class Introduction extends SceneGroup{
	
	public Introduction()
	{
		Scene scene1, scene2,scene3,scene4;
		scene1 = createScene1();
		scene2 = createScene2();
		scene3 = createScene3();
		scene4 = createScene4();		
		this.addScene(scene1);
		this.addScene(scene2);
		this.addScene(scene3);
		this.addScene(scene4);
	
	}
	
	private Scene createScene1()
	{
		Scene scene = new Scene();
		scene.getRoot().add(GraphicFactory.loadImage("images/intro_bg.png"));
		scene.USE_TIMER = true;
		scene.setSeconds(2);
		return scene;
		
	}
	
	private Scene createScene2()
	{
		Scene scene = new Scene();
		Layer bg = GraphicFactory.loadImage("images/intro_bg.png");
		Layer inkscapeLogo = GraphicFactory.loadImage("images/intro_inkscape_logo.png");
		Layer gimpLogo = GraphicFactory.loadImage("images/intro_gimp_logo.png");
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
		scene.getRoot().add(bg);
		scene.getRoot().add(text1);
		scene.getRoot().add(text2);
		scene.getRoot().add(gimpLogo);
		scene.getRoot().add(inkscapeLogo);
		scene.USE_TIMER = true;
		scene.setSeconds(10);
		
		return scene;
	
	}
	private Scene createScene3()
	{
		Scene scene = new Scene();
		scene.getRoot().add(GraphicFactory.loadImage("images/intro_bg.png"));
		scene.USE_TIMER = true;
		scene.setSeconds(2);
		return scene;
	}
	private Scene createScene4()
	{
		Scene scene = new Scene();
		scene.getRoot().add(GraphicFactory.loadImage("images/intro_bg.png"));		
		scene.getRoot().add(GraphicFactory.loadImage("images/intro_playn_logo.png"));
		return scene;	
	}
	
}
