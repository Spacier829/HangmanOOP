public class Main {
  public static void main(String[] args) {
    String pathName = "./Dictionary/dictionary.txt";
    Dictionary dictionary = new Dictionary(pathName);
//    String word = dictionary.getRandomWord();
//    MaskedWord maskedWord = new MaskedWord(word);
//    System.out.println(maskedWord.maskedWord);
    MaskedWord maskedWord = new MaskedWord("лопата");
    maskedWord.openLetter('а');
    int a = 123;
  }
}