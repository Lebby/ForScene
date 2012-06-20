package ${package}.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import ${package}.core.Test;

public class TestActivity extends GameActivity {

  @Override
  public void main(){
    platform().assets().setPathPrefix("${packageInPathFormat}/resources");
    PlayN.run(new Test());
  }
}
