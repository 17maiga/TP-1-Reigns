package main.utils;

/**
 * <b>Static class representing local operating system utils.</b>
 *
 * <p>Provides methods to access the config folder.
 *
 * @author Henri Saudubray / Clément Lardemelle
 */
public class OS {
  /**
   * <b>Gets the config folder path.</b>
   *
   * @return The config folder path.
   */
  public static String getConfigFolder() {
    return System.getProperty("user.home") + "/.reigns/";
  }
}
