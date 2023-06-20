package bean.projects.Objects;

public class Ship {

  private String name;
  private String type;
  private Crew[] crew;

  public Ship(String name, String type, Crew[] crew) {
    this.name = name;
    this.type = type;
    this.crew = crew;
  }

  public String getName() {
    return this.name;
  }

  public Crew[] getCrew() {
    return this.crew;
  }

  @Override
  public String toString() {
    return String.format("\n\tName: %s\n\tType: %s\n\tCrew size: %d ", name, type, crew.length);
  }

}
