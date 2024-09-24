import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    String pathName = "./Dictionary/dictionary.txt";
    Dictionary.init(pathName);
    if (Dictionary.status()) {
      Menu.show();
      Menu.processSelection();
    } else {
      System.out.println("Словарь со словами пустой.");
    }
  }
}