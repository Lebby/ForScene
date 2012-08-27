/**
 * 
 */
package forscene.system.entities;

/**
 * @author blackdevil
 * 
 */
public class ForSceneConfigurator {
  /**
   * 
   */

  /* EventManager related settings */
  public static short         EVENT_MANAGER_PRIORITY_QUEUE_SIZE           = 7;
  public static short         EVENT_MANAGER_DEFAULT_EVENT_SYSTEM_PRIORITY = 2;
  public static short         EVENT_MANAGER_DEFAULT_EVENT_PRIORITY        = 5;

  /* Storage settings */
  private static final String FORSCENE_STORAGE                            = "forscene.storage";
  public static String        STORAGE_FILENAME                            = ForSceneConfigurator.FORSCENE_STORAGE;
}
