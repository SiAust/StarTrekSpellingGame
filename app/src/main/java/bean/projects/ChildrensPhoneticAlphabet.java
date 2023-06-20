package bean.projects;

import java.util.HashMap;
import java.util.Map;
import java.lang.Character;

public class ChildrensPhoneticAlphabet {

  private static Map<Character, String> lettersMap = new HashMap<>();

  static {
    lettersMap.put('a', "apple");
    lettersMap.put('b', "bus");
    lettersMap.put('c', "cat");
    lettersMap.put('d', "drum");
    lettersMap.put('e', "elephant");
    lettersMap.put('f', "flag");
    lettersMap.put('g', "goat");
    lettersMap.put('h', "home");
    lettersMap.put('i', "apple");
    lettersMap.put('j', "jam");
    lettersMap.put('k', "kid");
    lettersMap.put('l', "lamp");
    lettersMap.put('m', "mango");
    lettersMap.put('n', "night");
    lettersMap.put('o', "orange");
    lettersMap.put('p', "phone");
    lettersMap.put('q', "quiet");
    lettersMap.put('r', "rubbish");
    lettersMap.put('s', "sunny");
    lettersMap.put('t', "tiki");
    lettersMap.put('u', "umpire");
    lettersMap.put('v', "venice");
    lettersMap.put('w', "wand");
    lettersMap.put('x', "xenomorph");
    lettersMap.put('y', "yellow");
    lettersMap.put('z', "zingy");
  }

  public static String getPhoneticHint(char letter) {
    // To lowercase
    if (letter < 92) {
      letter += 32;
    }
    return lettersMap.get(letter);
  }

}
