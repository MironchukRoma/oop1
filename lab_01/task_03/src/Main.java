import java.util.Scanner; //Імпорт класу Scanner зі стандартної бібліотеки Java для зчитування вводу з консолі.

public class Main { //Оголошення змінної password, яка містить захищений пароль.
    final static int password = 2222;
    public static void main(String[] args) { //Оголошення методу main, який є точкою входу в програму.
        Scanner scanner = new Scanner(System.in); //Створення об'єкта Scanner для зчитування вводу з консолі.
        System.out.println("Введіть пароль:"); //Виведення на екран запрошення для введення пароля.
        int input = scanner.nextInt(); //Зчитування пароля з консолі та збереження його у змінній input.

        if (input == password) { // Перевірка, чи введений пароль співпадає зі збереженим у програмі паролем.
            System.out.println("Hello, Agent");
        } else {
            System.out.println("Access denied");
        }
    }
}