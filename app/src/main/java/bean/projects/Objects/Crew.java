package bean.projects.Objects;

public class Crew {

  private String firstName;
  private String lastName;
  private String middleName;
  private String nickname;

  private String rank;
  private String ship;

  public Crew(String firstName, String lastName, String middleName, String nickname, String rank, String ship) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickname = nickname;
    this.ship = ship;
    this.rank = rank;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getNickname() {
    return nickname;
  }

  public String getRank() {
    return rank;
  }

  public String getShip() {
    return ship;
  }

  @Override
  public String toString() {
    return String.format("firstName: %s\nmiddleName: %s\nlastName: %s\nrank: %s\nship: %s\n", firstName, middleName,
        lastName, rank, ship);
  }

}
