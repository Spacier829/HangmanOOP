import java.util.Scanner;

public class Menu {

  public static void show() {
    System.out.println("===========================================================");
    System.out.println("|                      Игра Виселица                      |");
    System.out.println("===========================================================");
    System.out.println("В игре используются только слова на русском языке");
    System.out.println("1. Старт");
    System.out.println("2. Выход");
  }

  public static void processSelection() {
    Scanner scanner = new Scanner(System.in);
    do {
      System.out.println("Введите '1' чтобы начать новую игру или '2', чтобы выйти:");
      char[] input = scanner.nextLine().toLowerCase().toCharArray();
      if (input.length < 1) {
        System.out.println("Вы ничего не ввели.");
      } else {
        switch (input[0]) {
          case '1' -> {
            Game game = new Game();
            game.gameLoop();
          }
          case '2' -> {
            scanner.close();
          }
          default -> System.out.println("Некорректный ввод, попробуйте еще раз");
        }
      }
    } while (true);
  }
}
