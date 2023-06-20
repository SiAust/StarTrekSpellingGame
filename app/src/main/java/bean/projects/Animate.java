package bean.projects;

public class Animate {

  private static final String BLANK_LINE = "                                                                        ";
  private static final String WELL_DONE = "Well done!";

  public static void main(String[] args) {
    // redrawLine("Hello, world");
    successAnimation("James");
  }

  public static void successAnimation(String word) {
    try {

      phoneticWordAnimation(word);

      System.out.println("Now the complete name, ready?");
      Thread.sleep(3000);

      for (int i = 0; i < word.length(); i++) {
        System.out.print(word.charAt(i) + " ");
        Thread.sleep(2000);
      }
      System.out.println(); // temp

      wellDoneAnimation(5);

    } catch (Exception e) {
      System.err.println("Exception " + e);
    }
  }

  public static void phoneticWordAnimation(String word) {
    try {
      int i = 0;
      do {
        // blankLine();
        char current = word.charAt(i);
        System.out.println(String.format("%d. \"%s\" - Sounds like \"%s\"", i + 1, current,
            ChildrensPhoneticAlphabet.getPhoneticHint(current)));
        Thread.sleep(2000);
        i++;
      } while (i < word.length());
    } catch (Exception e) {
      System.err.println("Exception " + e);
    }
    newLine();
  }

  public static void wellDoneAnimation(int repeat) {

    try {

      for (int i = 0; i < repeat; i++) {
        // forwards
        for (int j = 0; j < WELL_DONE.length(); j++) {
          System.out.print(WELL_DONE.charAt(j));
          Thread.sleep(100);
        }
        // reverse
        for (int j = WELL_DONE.length(); j > -1; j--) {
          blankLine();
          System.out.print(WELL_DONE.substring(0, j));
          Thread.sleep(100);
        }
      }
      for (int j = 0; j < WELL_DONE.length(); j++) {
        System.out.print(WELL_DONE.charAt(j));
        Thread.sleep(100);
      }
      System.out.println();
    } catch (Exception e) {
      System.err.println("Exception " + e);
    }
  }

  private static void blankLine() {
    System.out.print("\r" + BLANK_LINE + "\r");
  }

  private static void newLine() {
    System.out.println();
  }
}
