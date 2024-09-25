import java.util.Scanner;

public class UserInput {

  public char letter() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      char[] input = scanner.nextLine().toLowerCase().toCharArray();
      if (!isLetter(input)) {
        continue;
      }
      return input[0];
    }
  }

  public boolean isLetter(char[] input) {
    if (input.length == 0) {
      System.out.println("Вы ничего не ввели, попробуйте еще раз.");
      return false;
    }
    if (input.length > 1) {
      System.out.println("Вы ввели больше одной буквы, попробуйте еще раз");
      return false;
    }
    if (Character.isDigit(input[0])) {
      System.out.println("Вы ввели число, а не букву, попробуйте еще раз.");
      return false;
    }
    if (!Character.isAlphabetic(input[0])) {
      System.out.println("Вы ввели не букву, попробуйте еще раз.");
      return false;
    }
    return true;
  }
}
