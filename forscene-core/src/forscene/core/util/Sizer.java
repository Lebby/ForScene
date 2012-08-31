/*
 * 
 */
package forscene.core.util;

import playn.core.Layer;
import playn.core.PlayN;
import forscene.core.entities.objects.AbstractSceneObject;
import forscene.system.managers.AbstractGameLoopManager;

public class Sizer extends AbstractSceneObject<Layer.HasSize> {

  /** The sizer. */
  private Layer.HasSize sizer;

  /*
   * (non-Javadoc)
   * 
   * @see forscene.core.entities.AbstractSceneObject#build()
   */
  @Override
  public void build() {

    sizer = PlayN.graphics().createImmediateLayer(
        (int) AbstractGameLoopManager.getInstance().getWidth(),
        (int) AbstractGameLoopManager.getInstance().getHeight(), null);

    setRoot(sizer);
    sizer.setVisible(false);
    // getRoot().setVisible(false);
    PlayN.log().debug(
        "Width : " + getRoot().width() + "Height : " + getRoot().height());

  }

  /*
   * (non-Javadoc)
   * 
   * @see forscene.system.ISceneObject#updateState()
   */
  public void updateState() {
    // TODO Auto-generated method stub

  }

}
