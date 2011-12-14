package forscene.test.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import forscene.test.core.MainGame;

public class MainGameActivity extends GameActivity {

  @Override
  public void main(){
    platform().assetManager().setPathPrefix("org/forscene/test/resources");
    PlayN.run(new MainGame());
  }
}
