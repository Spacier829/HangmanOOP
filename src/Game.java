import java.util.*;

public class Game {
  private int errorsCount;
  private List<Character> inputLetters;
  private static final int ERROR_MAX_COUNT = 6;
  private MaskedWord maskedWord;

  public Game(String secretWord) {
    this.errorsCount = 0;
    this.inputLetters = new ArrayList<>();
    this.maskedWord = new MaskedWord(secretWord);
  }

  public void loop() {
    while (errorsCount != ERROR_MAX_COUNT && !maskedWord.equalsSecretWord()) {
      System.out.println("Ниже представлена маска загаданного слова, введите букву, чтобы узнать есть ли она в слове " +
                         "или нет:");
      System.out.println(maskedWord.getMask() + '\n');
      if (!inputLetters.isEmpty()) {
        printInputLetters();
      }
      printGallows(errorsCount);
      UserInput userInput = new UserInput();
      char letter = userInput.letter();
      if (inputLetters.contains(letter)) {
        System.out.println("Вы уже вводили эту букву, введите другую.");
      } else {
        inputLetters.add(letter);
        if (maskedWord.isSecretContainsLetter(letter)) {
          System.out.println("Отлично! Эта буква есть в слове.");
          maskedWord.openLetter(letter);
        } else {
          errorsCount++;
          System.out.println("Этой буквы в слове нет.");
        }
        System.out.println("У вас осталось попыток: " + (ERROR_MAX_COUNT - errorsCount));
      }
    }
    if (errorsCount == ERROR_MAX_COUNT) {
      printLoseMessage();
    } else if (maskedWord.equalsSecretWord()) {
      printWinMessage();
    }
  }

  private void printGallows(int errorsCount) {
    GallowsForm[] gallowsForms = GallowsForm.values();
    GallowsForm gallowsForm = gallowsForms[errorsCount];
    System.out.println(gallowsForm.getDrawing());
  }

  private void printLoseMessage() {
    printGallows(errorsCount);
    System.out.println("К сожалению Вы проиграли.");
    System.out.println("Загаданное слово: " + maskedWord.getSECRET_WORD());
  }

  private void printWinMessage() {
    System.out.println("Поздравляем! Вы выиграли!");
    System.out.println("Загаданное слово: " + maskedWord.getSECRET_WORD());
  }

  private void printInputLetters() {
    System.out.print("Введенные буквы: ");
    for (char letter : inputLetters) {
      System.out.print(letter + ", ");
    }
    System.out.print('\n');
  }
}
