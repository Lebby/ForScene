#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import ${package}.core.Main;

public class MainActivity extends GameActivity {

  @Override
  public void main(){
    platform().assets().setPathPrefix("${package}/resources");
    PlayN.run(new Main());
  }
}
