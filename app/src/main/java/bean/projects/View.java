package bean.projects;

public class View {

  public View() {
  }

  public void print(String s) {
    System.out.println(s);
  }

  public void printf(String sentence, Object... strings) {
    System.out.printf(sentence + "\n", strings);

  }
}
