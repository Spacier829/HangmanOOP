import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Dictionary {
  private final String PATHNAME;
  private final int WORDS_COUNT;

  public Dictionary(String pathName){
    this.PATHNAME = pathName;
    this.WORDS_COUNT = calculateWordsCount();
  }

  private int calculateWordsCount() {
    int count = 0;
    try (Scanner scanner = new Scanner(new File(PATHNAME))) {
      while (scanner.hasNextLine()) {
        scanner.nextLine();
        count++;
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    return count;
  }

  public String getRandomWord() {
    String word = "";
    try (Scanner scanner = new Scanner(new File(PATHNAME))) {
      int wordID = new Random().nextInt(WORDS_COUNT);
      for (int i = 0; i < wordID; i++) {
        scanner.nextLine();
      }
      word = scanner.nextLine().toLowerCase();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    return word;
  }
}
