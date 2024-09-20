import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
  private int errorsCount;
  private static final int ERROR_MAX_COUNT = 6;
  private List<Character> wrongInputLetters;
  private final static Scanner scanner = new Scanner(System.in);
  private String secretWord;

  public Game(Dictionary dictionary) {
    this.errorsCount = 0;
    this.wrongInputLetters = new ArrayList<>();
    this.secretWord = dictionary.getRandomWord();
  }

  public void gameLoop() {
    MaskedWord maskedWord = new MaskedWord(secretWord);
    System.out.println(GallowsRenderer.ZERO);
//    GallowsRenderer.
  }
}
