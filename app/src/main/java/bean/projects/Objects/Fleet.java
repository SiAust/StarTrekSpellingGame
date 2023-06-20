package bean.projects.Objects;

import java.util.Arrays;

public class Fleet {

  private Ship[] ships;

  public Fleet(Ship[] ships) {
    this.ships = ships;
  }

  // public void setShips(Ship[] ships) {
  // this.ships = ships;
  // }

  public Ship[] getShips() {
    return ships;
  }

  @Override
  public String toString() {
    return "Fleet: " + Arrays.toString(ships);
  }

}
