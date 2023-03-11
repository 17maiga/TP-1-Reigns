package main.player;

public enum Gender {
  MALE("King"),
  FEMALE("Queen");

  private final String title;

  Gender(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }
}
