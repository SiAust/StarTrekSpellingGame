package bean.projects;

import java.io.FileReader;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import bean.projects.Objects.Crew;
import bean.projects.Objects.Fleet;
import bean.projects.Objects.Ship;

public class Game {

  private View view;
  private InputReader inputReader;

  Fleet fleet;

  private boolean easyMode = false; // TODO

  public Game(String[] args) {

    view = new View();

    if (args.length > 0) {
      if ("easy".equals(args[0])) {
        easyMode = true; // TODO setup logic for easy mode
      }
    }

    // Get Fleet info from fleet.json
    Gson gson = new Gson();
    try {
      JsonReader jsonReader = new JsonReader(new FileReader("./app/src/main/resources/fleet.json"));

      fleet = gson.fromJson(jsonReader, Fleet.class);

      // System.out.println(fleet);

    } catch (Exception e) {
      System.err.println("JSON exception: " + e);
    }

    inputReader = new InputReader();

    // Game loop
    start();
  }

  private void start() {

    int menuChoice = 0;
    while (true) {
      view.print("Please chose an option:");
      view.print("1. Spell test with a Star Trek crew member");
      view.print("2. Spelling help");
      view.print("3. Exit");

      menuChoice = inputReader.getMenuChoice();

      switch (menuChoice) {
        case 1:
          spellcheckMenu();
          break;
        case 2:
          // spellingHelp();
          break;
        default:
          view.print("Exiting...Thank you for playing :)");
          return;
      }
    }
  }

  private void spellcheckMenu() {
    // give ship choice
    Ship[] ships = fleet.getShips();
    Ship userShipChoice;
    while (true) {
      view.print("\nHere are the available ships. Choose your favourite!");
      for (int i = 0; i < ships.length; i++) {
        view.printf("%d. %s", i + 1, ships[i]);
      }
      int charsSizePlusOne = ships.length + 1;
      view.printf("%d. Exit", charsSizePlusOne);

      try {
        int menuChoice = inputReader.getMenuChoice();
        if (menuChoice == charsSizePlusOne) {
          return;
        }
        userShipChoice = ships[menuChoice - 1];
        break;
      } catch (Exception e) {
        view.print("There is no character for that choice, please try another.");
      }
    }

    while (true) {
      // give character choice
      view.printf("Here are the available characters for the %s! Choose your favourite!", userShipChoice.getName());
      Crew[] crew = userShipChoice.getCrew();
      for (int i = 0; i < crew.length; i++) {
        view.printf("%d. %s %s", i + 1, crew[i].getFirstName(), crew[i].getLastName());
      }
      int charsSizePlusOne = crew.length + 1;
      view.printf("%d. Exit", charsSizePlusOne);

      try {
        int menuChoice = inputReader.getMenuChoice();
        if (menuChoice == charsSizePlusOne) {
          return;
        }
        Crew userCharChoice = crew[menuChoice - 1];
        view.printf("Character %s spelling test about to begin! :)", userCharChoice.getLastName());
        spellTest(userCharChoice);
      } catch (Exception e) {
        view.print("There is no character for that choice, please try another.");
      }
    }
  }

  private void spellTest(Crew character) {
    view.printf("The characters name begins with %s, try to spell it a letter at a time!",
        character.getFirstName().charAt(0));
    char input;
    int firstNameLength = character.getFirstName().length();
    while (true) {
      for (int i = 0; i < firstNameLength; i++) {
        view.printf("Enter the letter in position %d:", i + 1);
        input = inputReader.getNextChar();
        if (SpellChecker.checkCharsMatch(character.getFirstName().charAt(i), input)) {
          if (i == firstNameLength - 1) {
            view.print("\nWell done! You got it correct! Your spelling is amazing!\n");
            Animate.successAnimation(character.getFirstName());
            break;
          }
          view.print(String.format("\"%s\"? Seems about right to me! Well done! Keep going...", input));
        } else {
          view.print(String.format("Sadly that's not quite right. Here's a hint..."));
          spellingHint(input);
          i--;
        }
      }
      // exit menu
      view.print("\n1. Play again \n2. Exit");
      if (inputReader.getMenuChoice() == 2) {
        return;
      }
    }

  }

  private void spellingHint(char c) {
    view.printf("Here's a hint! This word uses the same first letter: %s",
        ChildrensPhoneticAlphabet.getPhoneticHint(c));
  }
}
