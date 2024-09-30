import java.io.*;
import java.util.List;
import java.util.Random;

public class Dictionary {
  private final String FILENAME;
  private List<String> wordList;

  public Dictionary(String fileName) {
    this.FILENAME = fileName;
    readWordListFromFile();
  }

  private void readWordListFromFile() {
    try (InputStream resource = this.getClass().getClassLoader().getResourceAsStream(FILENAME)) {
      assert resource != null;
      wordList = new BufferedReader(new InputStreamReader(resource)).lines().toList();
    } catch (IOException e) {
      throw new RuntimeException("File " + FILENAME + " not found");
    }
  }

  public String getRandomWord() {
    int wordID = new Random().nextInt(wordList.size());
    return wordList.get(wordID);
  }
}
