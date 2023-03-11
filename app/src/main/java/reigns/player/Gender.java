package reigns.player;

/**
 * <b>Represents a player's gender and associated title.</b>
 *
 * @author Henri Saudubray / Clément Lardemelle
 */
public enum Gender {
  /** <b>King.</b> */
  MALE("King"),
  /** <b>Queen.</b> */
  FEMALE("Queen");

  /** <b>The gender's associated title.</b> */
  private final String title;

  Gender(String title) {
    this.title = title;
  }

  /**
   * <b>Gets the gender's associated title.</b>
   *
   * @return The gender's associated title.
   */
  public String getTitle() {
    return title;
  }
}
