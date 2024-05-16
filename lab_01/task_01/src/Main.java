import java.util.Scanner; //Імпорт класу Scanner зі стандартної бібліотеки Java для зчитування вводу з консолі.

public class Main {    //Оголошення класу Main та його методу main, який є точкою входу в програму.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Створення об'єкта Scanner для зчитування вводу з консолі.
        System.out.println("Введіть рядок:"); //Виведення на екран запрошення для введення рядка.
        String text = scanner.nextLine(); //Зчитування рядка з консолі та збереження його у змінній text.
        System.out.println("Hello, " + text); //Виведення на екран привітання, до якого додається введений рядок.
    }
}