import java.util.ArrayList;
import java.util.List;

public class MaskedWord {
  private String mask;
  private final String SECRET_WORD;
  private final String MASK_SYMBOL = "_";
  private final int NOT_FOUND_INDEX = -1;

  public MaskedWord(String secretWord) {
    this.SECRET_WORD = secretWord.toLowerCase();
    mask = MASK_SYMBOL.repeat(secretWord.length());
  }

  public String getMask() {
    return mask;
  }

  public String getSECRET_WORD() {
    return SECRET_WORD;
  }

  public boolean isSecretContainsLetter(Character letter) {
    return SECRET_WORD.contains(letter.toString());
  }

  private List<Integer> getLetterIndexes(char letter) {
    int index = NOT_FOUND_INDEX;
    List<Integer> indexes = new ArrayList<>();
    do {
      index = SECRET_WORD.indexOf(letter, index + 1);
      if (index != -1) {
        indexes.add(index);
      }
    } while (index != -1);
    return indexes;
  }

  public void openLetter(Character letter) {
    List<Integer> letterIndexes = getLetterIndexes(letter);
    StringBuilder maskSB = new StringBuilder(mask);
    for (int index : letterIndexes) {
      maskSB.setCharAt(index, letter);
    }
    mask = maskSB.toString();
  }

  public boolean equalsSecretWord() {
    return mask.equals(SECRET_WORD);
  }
}

