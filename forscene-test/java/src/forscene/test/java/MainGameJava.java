package forscene.test.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import forscene.test.core.MainGame;
import forscene.test.core.TestMyInputEvent;
import forscene.test.core.TestScroll;
import forscene.test.core.tomminick1;

public class MainGameJava {

  public static void main(String[] args) {
    JavaPlatform platform = JavaPlatform.register();
    platform.assetManager().setPathPrefix("forscene/test/resources");
    //PlayN.run(new MainGame());
    //PlayN.run(new TestMyInputEvent());
    PlayN.run(new TestScroll());
    //PlayN.run(new tomminick1());
  }
}
