package bean.projects;

public class SpellChecker {

  public static boolean checkNamesMatch(String name, String userInput) {
    return name.equals(userInput);
  }

  public static boolean checkCharsMatch(char c1, char c2) {
    return c1 == c2;
  }

}
