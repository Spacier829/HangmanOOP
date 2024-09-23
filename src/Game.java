import java.util.*;

public class Game {
  private int errorsCount;
  private static final int ERROR_MAX_COUNT = 6;
  private List<Character> wrongInputLetters;
  private final String secretWord;
  private MaskedWord maskedWord;

  public Game(Dictionary dictionary) {
    this.errorsCount = 0;
    this.wrongInputLetters = new ArrayList<>();
    this.secretWord = dictionary.getRandomWord();
    this.maskedWord = new MaskedWord(secretWord);
  }

  public void gameLoop() {
    do {
      System.out.println(secretWord);
      System.out.println(maskedWord.getMaskedWord());
      System.out.println(GallowsRenderer.values()[errorsCount].getDrawing());
      Character letter = userInput();
      identifyUserInput(letter);
    } while (errorsCount != ERROR_MAX_COUNT && !checkGameState());
    if (errorsCount == ERROR_MAX_COUNT) {
      System.out.println(GallowsRenderer.values()[errorsCount].getDrawing());
      System.out.println("К сожалению Вы проиграли.");
      System.out.println("Загаданное слово: " + secretWord);
    } else if (checkGameState()) {
      System.out.println("Поздравляем! Вы выиграли!");
    }
  }

  public Character userInput() {
    do {
      Scanner scanner = new Scanner(System.in);
      char[] letters = scanner.nextLine().toLowerCase().toCharArray();
      if (letters.length == 0) {
        System.out.println("Вы ничего не ввели, попробуйте еще раз.");
        continue;
      }
      else if (Character.isDigit(letters[0])) {
        System.out.println("Вы ввели число, а не букву, попробуйте еще раз.");
        continue;
      } else if (!Character.isAlphabetic(letters[0])) {
        System.out.println("Вы ввели не букву, попробуйте еще раз.");
        continue;
      }
      return letters[0];
    } while (true);
  }

  public void identifyUserInput(Character letter) {
    if (maskedWord.isLetterOpened(letter)) {
      System.out.println("Эта буква уже открыта, попробуйте еще раз.");
    } else if (wrongInputLetters.contains(letter)) {
      System.out.println("Вы уже вводили эту букву, она неверна.");
    } else if (secretWord.contains(letter.toString())) {
      maskedWord.openLetter(letter);
    } else {
      errorsCount++;
      wrongInputLetters.add(letter);
      System.out.println("Этой буквы в слове нет. У вас осталось попыток: " + (ERROR_MAX_COUNT - errorsCount));
    }
  }

  public boolean checkGameState() {
    return maskedWord.getMaskedWord().equals(secretWord);
  }
}
