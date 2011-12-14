package forscene.test.html;

import playn.core.PlayN;
import playn.html.HtmlGame;
import playn.html.HtmlPlatform;

import forscene.test.core.MainGame;

public class MainGameHtml extends HtmlGame {

  @Override
  public void start() {
    HtmlPlatform platform = HtmlPlatform.register();
    platform.assetManager().setPathPrefix("forscene-test/");
    PlayN.run(new MainGame());
  }
}
