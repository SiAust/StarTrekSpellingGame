package bean.projects;

import java.util.Scanner;

public class InputReader {

  private Scanner scanner;

  public InputReader() {
    scanner = new Scanner(System.in);
  }

  public String getNextLine() {
    return scanner.nextLine().trim();
  }

  public int getMenuChoice() {
    return scanner.nextInt();
  }

  public char getNextChar() {
    return scanner.next().charAt(0);
  }
}
