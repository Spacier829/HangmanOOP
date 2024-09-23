import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    String pathName = "./Dictionary/dictionary.txt";
    Dictionary dictionary = new Dictionary(pathName);

    if (dictionary.status()) {

      System.out.println("===========================================================");
      System.out.println("|                      Игра Виселица                      |");
      System.out.println("===========================================================");
      System.out.println("В игре используются только слова на русском языке");
      System.out.println("1. Старт");
      System.out.println("2. Выход");
      Scanner scanner = new Scanner(System.in);
      do {
        System.out.println("Введите '1' чтобы начать новую игру или '2', чтобы выйти:");
        int userChoice = scanner.nextInt();
        switch (userChoice) {
          case 1 -> {
            Game game = new Game(dictionary);
            game.gameLoop();
          }
          case 2 -> {
            scanner.close();
            return;
          }
          default -> System.out.println("Некорректный ввод, попробуйте еще раз");
        }
      } while (true);
    } else {
      System.out.println("Словарь со словами пустой.");
    }
  }
}