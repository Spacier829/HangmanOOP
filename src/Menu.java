import java.io.File;
import java.util.Scanner;

public class Menu {
  private final static char START = '1';
  private final static char EXIT = '2';

  public static void printInfo() {
    System.out.println("===========================================================");
    System.out.println("|                      Игра Виселица                      |");
    System.out.println("===========================================================");
    System.out.println("В игре используются только слова на русском языке");
    System.out.printf("%s. Старт\n", START);
    System.out.printf("%s. Выход\n", EXIT);
  }

  public static void processSelection() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.printf("Введите '%s' чтобы начать новую игру или '%s', чтобы выйти: ", START, EXIT);
      String input = scanner.nextLine().toLowerCase();
      if (input.isEmpty()) {
        System.out.println("Вы ничего не ввели.");
      } else if (input.length() > 1) {
        System.out.println("Некорректный ввод, введите необходимое число:");
      } else {
        switch (input.charAt(0)) {
          case START -> {
            String fileName = "dictionary.txt";
            Dictionary dictionary = new Dictionary(fileName);
            Game game = new Game(dictionary.getRandomWord());
            game.loop();
          }
          case EXIT -> {
            scanner.close();
            return;
          }
          default -> System.out.println("Некорректный ввод, попробуйте еще раз");
        }
      }
    }
  }
}
