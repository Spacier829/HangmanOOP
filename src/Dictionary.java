import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Dictionary {
  private static String PATHNAME;
  private static int WORDS_COUNT;

  public static void init(String pathName) {
    PATHNAME = pathName;
    WORDS_COUNT = setWordsCount();
  }

  private static int setWordsCount() {
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

  public static String getRandomWord() {
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

  public static boolean status() {
    return WORDS_COUNT > 0;
  }
}
