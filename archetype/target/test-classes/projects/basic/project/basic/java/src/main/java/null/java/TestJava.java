package ${package}.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import ${package}.core.Test;

public class TestJava {

  public static void main(String[] args) {
    JavaPlatform platform = JavaPlatform.register();
    platform.assets().setPathPrefix("${packageInPathFormat}/resources");
    PlayN.run(new Test());
  }
}
