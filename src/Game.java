import java.util.*;

public class Game {
  private int errorsCount;
  private static final int ERROR_MAX_COUNT = 6;
  private List<Character> wrongInputLetters;
  private final String secretWord;
  private MaskedWord maskedWord;

  public Game() {
    this.errorsCount = 0;
    this.wrongInputLetters = new ArrayList<>();
    this.secretWord = Dictionary.getRandomWord();
    this.maskedWord = new MaskedWord(secretWord);
  }

  public void gameLoop() {
    do {
      System.out.println(maskedWord.getMaskedWord());
      System.out.println(GallowsRenderer.values()[errorsCount].getDrawing());
      UserInput userInput = new UserInput(maskedWord, secretWord, wrongInputLetters);
      Character letter = userInput.letter();
      if (!userInput.identify(letter)) {
        errorsCount++;
        wrongInputLetters.add(letter);
        System.out.println("Этой буквы в слове нет. У вас осталось попыток: " + (ERROR_MAX_COUNT - errorsCount));
      }
    } while (errorsCount != ERROR_MAX_COUNT && !checkGameState());
    if (errorsCount == ERROR_MAX_COUNT) {
      System.out.println(GallowsRenderer.values()[errorsCount].getDrawing());
      System.out.println("К сожалению Вы проиграли.");
      System.out.println("Загаданное слово: " + secretWord);
    } else if (checkGameState()) {
      System.out.println("Поздравляем! Вы выиграли!");
    }
  }

  public boolean checkGameState() {
    return maskedWord.getMaskedWord().equals(secretWord);
  }
}
