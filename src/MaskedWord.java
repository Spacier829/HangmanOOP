public class MaskedWord {
  private String maskedWord;
  private final String secretWord;

  public MaskedWord(String secretWord) {
    this.secretWord = secretWord.toLowerCase();
    maskedWord = "_".repeat(secretWord.length());
  }

  public String getMaskedWord() {
    return maskedWord;
  }

  public void openLetter(Character letter) {
    int index = -1;
    do {
      index = secretWord.indexOf(letter, index + 1);
      if (index != -1) {
        StringBuilder maskedWordSB = new StringBuilder(maskedWord);
        maskedWordSB.setCharAt(index, letter);
        maskedWord = maskedWordSB.toString();
      }
    } while (index != -1);
  }

  public boolean isLetterOpened(Character letter) {
    return maskedWord.contains(letter.toString());
  }
}

