import java.util.List;
import java.util.Scanner;

public class UserInput {
  private MaskedWord maskedWord;
  private String secretWord;
  private List<Character> wrongLetters;

  public UserInput(MaskedWord maskedWord, String secretWord, List<Character> wrongLetters) {
    this.maskedWord = maskedWord;
    this.secretWord = secretWord;
    this.wrongLetters = wrongLetters;
  }

  public Character letter() {
    do {
      Scanner scanner = new Scanner(System.in);
      char[] letters = scanner.nextLine().toLowerCase().toCharArray();
      if (letters.length == 0) {
        System.out.println("Вы ничего не ввели, попробуйте еще раз.");
        continue;
      } else if (Character.isDigit(letters[0])) {
        System.out.println("Вы ввели число, а не букву, попробуйте еще раз.");
        continue;
      } else if (!Character.isAlphabetic(letters[0])) {
        System.out.println("Вы ввели не букву, попробуйте еще раз.");
        continue;
      }
      return letters[0];
    } while (true);
  }

  public boolean identify(Character letter) {
    if (maskedWord.isLetterOpened(letter)) {
      System.out.println("Эта буква уже открыта, попробуйте еще раз.");
    } else if (wrongLetters.contains(letter)) {
      System.out.println("Вы уже вводили эту букву, она неверна.");
    } else if (secretWord.contains(letter.toString())) {
      maskedWord.openLetter(letter);
    } else {
      return false;
    }
    return true;
  }
}
